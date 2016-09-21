package app.company.com.a25_bindservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MyBindService service;
    private Button btn_start;
    private Button btn_stop;
    private Button btn_use;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            service = (MyBindService) ((MyBindService.LocalBinder)binder).getService();
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
        switch (view.getId()){
            case R.id.btn_start:
                Intent intent=new Intent(MainActivity.this,MyBindService.class);
                bindService(intent,conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.btn_stop:
                unbindService(conn);
                break;
            case R.id.btn_use:
                if(service!=null){
                    Toast.makeText(this,service.add(10,20)+"",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
