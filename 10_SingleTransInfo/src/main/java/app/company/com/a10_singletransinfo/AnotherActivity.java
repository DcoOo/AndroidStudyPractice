package app.company.com.a10_singletransinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {
    private TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        tv_text = (TextView) findViewById(R.id.tv_text);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        tv_text.setText(name);
    }
}
