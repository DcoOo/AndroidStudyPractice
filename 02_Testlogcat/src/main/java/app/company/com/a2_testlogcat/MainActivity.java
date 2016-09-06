package app.company.com.a2_testlogcat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG1 = "Test_Logcat";
    private static final String TAG2 = "Logcat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tag表示只显示在filter中设置的tag
        Log.i(TAG1,"First to use Logcat");
        Log.e(TAG2,"This is tag2");
    }
}
