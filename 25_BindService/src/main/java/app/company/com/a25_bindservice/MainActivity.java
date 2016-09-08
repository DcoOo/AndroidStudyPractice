package app.company.com.a25_bindservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MyBindService service;
    private Button btn_start;
    private Button btn_stop;
    private Button btn_use;
    private ServiceConnection conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d("Debug","Get Service");
                service = (MyBindService) ((MyBindService.LocalBinder)iBinder).getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.d("Debug","ServiceDisconnected");
            }
        };
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_use = (Button) findViewById(R.id.btn_use);

        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_use.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(MainActivity.this,MyBindService.class);
        switch (view.getId()){
            case R.id.btn_start:
                bindService(i,conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.btn_stop:
                unbindService(conn);
                break;
            case R.id.btn_use:
                Toast.makeText(MainActivity.this,"The data is "+service.add(10,20),Toast.LENGTH_LONG).show();
                break;
        }
    }
}
