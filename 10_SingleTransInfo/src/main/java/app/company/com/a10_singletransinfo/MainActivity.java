package app.company.com.a10_singletransinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_jump_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_jump_info = (Button) findViewById(R.id.btn_jump_info);
        btn_jump_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AnotherActivity.class);
                i.putExtra("name","张三");
                startActivity(i);
            }
        });
    }
}
