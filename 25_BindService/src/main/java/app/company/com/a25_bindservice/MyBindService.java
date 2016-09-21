package app.company.com.a25_bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBindService extends Service {

    private LocalBinder myBinder = new LocalBinder();

    public MyBindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Debug","onBind");
        return myBinder;
    }

    public class LocalBinder extends Binder {
        Service getService() {
            return MyBindService.this;
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("Debug","onUnbind");
        return super.onUnbind(intent);
    }

    public int add(int num1, int num2){
            return num1+num2;
        }





}
