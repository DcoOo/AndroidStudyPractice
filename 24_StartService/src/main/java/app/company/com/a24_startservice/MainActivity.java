package app.company.com.a24_startservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start;
    private Button btn_stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = (Button) findViewById(R.id.btn_start_service);
        btn_stop = (Button) findViewById(R.id.btn_stop_service);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        switch (view.getId()){
            case R.id.btn_start_service:
                intent.putExtra("data","100");
                startService(intent);
                break;
            case R.id.btn_stop_service:
                stopService(intent);
                break;
        }
    }
}
