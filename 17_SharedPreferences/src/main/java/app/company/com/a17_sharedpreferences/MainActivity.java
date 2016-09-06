package app.company.com.a17_sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_write;
    private Button btn_read;

    private static final String NAME = "name";
    private static final String STUDENT_ID = "studentID";
    private static final String SharedPreferencesFileName = "mysharedpreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_write = (Button) findViewById(R.id.btn_write);
        btn_read = (Button) findViewById(R.id.btn_read) ;
        btn_write.setOnClickListener(this);
        btn_read.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(SharedPreferencesFileName,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (view.getId()){
            case R.id.btn_write:
                editor.putString(NAME,"Duan Jinhao");
                editor.putString(STUDENT_ID,"2014011451");
                editor.apply();
                break;
            case R.id.btn_read:
                String name = sharedPreferences.getString(NAME,"Duane Jinhao");
                String student_id = sharedPreferences.getString(STUDENT_ID,"2014011451");
                Toast.makeText(this,name+" "+student_id,Toast.LENGTH_LONG).show();
                break;
        }
    }
}
