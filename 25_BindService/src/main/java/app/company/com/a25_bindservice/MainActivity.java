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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MyBindService service;
    private Button btn_start;
    private Button btn_stop;
    private Button btn_use;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            service = (MyBindService) ((MyBindService.LocalBinder)binder).getService();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test();
                }
            }).start();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_use = (Button) findViewById(R.id.btn_use);

        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_use.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(MainActivity.this,MyBindService.class );
                bindService(i,conn, Service.BIND_AUTO_CREATE);
                Log.d("Debug",service == null?"Service null":"Service not null");

    }

    public void test(){
        Log.d("Debug",service == null?"*******Service null":"Service not null");
//        Toast.makeText(MainActivity.this,"The data is "+service.add(10,20),Toast.LENGTH_LONG).show();
        Log.d("Debug",service.add(10,20)+"******");
    }

}
