package app.company.com.a11_sendandreceive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {
    private Button btn_another;
    private TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        btn_another = (Button) findViewById(R.id.btn_second);
        tv_text = (TextView) findViewById(R.id.tv_text);
        Intent i = getIntent();
        String receive = i.getStringExtra("name");
        tv_text.setText(receive);
        i.putExtra("class","class one");
        setResult(0,i);
        btn_another.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
