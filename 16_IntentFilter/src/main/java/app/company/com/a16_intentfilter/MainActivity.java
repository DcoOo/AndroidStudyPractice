package app.company.com.a16_intentfilter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_intent_filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_intent_filter = (Button) findViewById(R.id.btn_intent);
        btn_intent_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("Intent.ACTION_VIEW",Uri.parse("schemodemo://www.mathtop.com.cn"));
                startActivity(i);
            }
        });
    }
}
