package app.company.com.androidwriteandreadsdcard;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_write_SDCard;
    private Button btn_read_SDCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_write_SDCard = (Button) findViewById(R.id.btn_write_to_SD);
        btn_write_SDCard.setOnClickListener(this);
        btn_read_SDCard = (Button) findViewById(R.id.btn_read_from_SD);
        btn_read_SDCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_write_to_SD:
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    //存在SD卡，可读写
                    File directory = Environment.getExternalStorageDirectory();
                    File myfile = new File(directory.getPath() + "/myfile.txt");
                    try {
                        FileOutputStream fos = new FileOutputStream(myfile);
                        BufferedOutputStream bos = new BufferedOutputStream(fos);
                        bos.write("Duan Jinhao".getBytes());
                        bos.write("2014011451".getBytes());
                        bos.flush();
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.btn_read_from_SD:
                File dir = Environment.getExternalStorageDirectory();
                File file = new File(dir.getPath()+"/myfile.txt");
                Log.v("EE",file.getPath());
                try {
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    byte[] data_bytes = new byte[128];
                    bis.read(data_bytes);
                    bis.close();
                    String data = new String(data_bytes);
                    Toast.makeText(MainActivity.this,data, Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }


    }

}
