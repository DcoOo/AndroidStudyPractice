package app.company.com.a8_cyclelife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("CycleLife","OnCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CycleLife","OnPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CycleLife","OnResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("CycleLife","Restart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CycleLife","OnStop");

    }
}
