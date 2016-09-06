package app.company.com.sendandrecebroad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/6.
 */
public class MyReceive extends BroadcastReceiver{

    private Intent intent;
    @Override
    public void onReceive(Context context, Intent intent) {
        this.intent = intent;
        String data = intent.getStringExtra("broad");
        Toast.makeText(context,data,Toast.LENGTH_LONG).show();
    }
}
