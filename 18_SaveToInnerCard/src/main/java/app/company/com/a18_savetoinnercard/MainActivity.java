package app.company.com.a18_savetoinnercard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_write;
    private Button btn_read;
    private static final String FILE_NAME = "myfile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_write = (Button) findViewById(R.id.btn_write);
        btn_read = (Button) findViewById(R.id.btn_read);
        btn_write.setOnClickListener(this);
        btn_read.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_write:
                try {
                    FileOutputStream fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    bos.write("Duan Jinhao: Save data to file".getBytes());
                    bos.flush();
                    bos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_read:
                try {
                    FileInputStream fis = openFileInput(FILE_NAME);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    StringBuilder str_builder = new StringBuilder("");
                    byte[] read_data = new byte[512];
                    while (bis.read(read_data) != -1){
                        str_builder.append(new String(read_data));
                    }
                    bis.close();
                    Toast.makeText(this,str_builder.toString(),Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


}
