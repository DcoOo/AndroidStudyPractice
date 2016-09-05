package app.company.com.a11_sendandreceive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_main;
    private TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_main = (Button) findViewById(R.id.btn_first);
        tv_text = (TextView) findViewById(R.id.tv_text);
        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AnotherActivity.class);
                i.putExtra("name","张三");
                startActivityForResult(i,0);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 0:
                String data_str = data.getStringExtra("class");
                tv_text.setText("Receive Data"+data_str);
                break;
        }
    }
}
