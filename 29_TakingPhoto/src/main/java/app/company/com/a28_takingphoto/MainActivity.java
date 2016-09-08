package app.company.com.a28_takingphoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 0;
    private static final int SAVE_TO_PUBLIC = 1;
    private String current_photo_path = "";
    private Button btn_take;
    private Button btn_save;
    private ImageView iv_photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_take = (Button) findViewById(R.id.btn_take_photo);
        iv_photo = (ImageView) findViewById(R.id.iv_photo);
        btn_save = (Button) findViewById(R.id.btn_save_to_card);

        btn_take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePhoto();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (i.resolveActivity(getPackageManager())!=null){
                    File photo_file = null;
                    photo_file = createImageFile();
                    if (photo_file != null){
                        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo_file));
                        startActivityForResult(i,SAVE_TO_PUBLIC);
                    }
                }
            }
        });
    }

    private void addPicToExternalStorage(){
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(current_photo_path);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    private void takePhoto(){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (i.resolveActivity(getPackageManager())!=null){
            startActivityForResult(i,REQUEST_CODE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE == requestCode && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            iv_photo.setImageBitmap(imageBitmap);
            Log.d("Debug","get Photo");
        }
        if (requestCode == SAVE_TO_PUBLIC && resultCode == RESULT_OK){
            setPic();
            addPicToExternalStorage();
        }
    }

    private File createImageFile(){
        String img_name = "myimg.jpg";
        File storage_dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        if (!storage_dir.exists()){
            Log.v("Debug","创建目录");
            if(!storage_dir.mkdir()){
                Log.d("Debug","目录创建失败");
                return null;
            }
        }

        File img_file = new File(storage_dir,img_name);

        current_photo_path = img_file.getPath();
        Log.d("Debug","The photo path is "+current_photo_path);
        return img_file;
    }

    private void setPic(){
        int targetW = 200;
        int targetH = 200;

        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(current_photo_path, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        Bitmap bitmap = BitmapFactory.decodeFile(current_photo_path, bmOptions);
        iv_photo.setImageBitmap(bitmap);

    }
}
