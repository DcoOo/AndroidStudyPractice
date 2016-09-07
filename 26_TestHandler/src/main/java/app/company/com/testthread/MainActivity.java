package app.company.com.testthread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Handler main_handler;
    private TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_text = (TextView) findViewById(R.id.tv_num);

        main_handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                tv_text.setText((Integer) msg.obj+"");
            }
        };
        new Thread(new MyTask()).start();
    }

    class MyTask implements Runnable{
        private int num = 0;
        @Override
        public void run() {
            for (;num <= 100;){
                Message msg = main_handler.obtainMessage();
                msg.obj = num;
                num = num + 10;
                main_handler.sendMessage(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
