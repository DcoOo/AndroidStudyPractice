package app.company.com.a15_dialnumber;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_num;
    private Button btn_dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_num = (EditText) findViewById(R.id.et_num_text);
        btn_dial = (Button) findViewById(R.id.btn_dial);
        btn_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.intent.action.DIAL", Uri.parse("tel:"+et_num.getText().toString()));
                startActivity(i);
            }
        });
    }
}
