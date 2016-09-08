package app.company.com.a28_mediaplayer;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_play;
    private Button btn_pause;
    private Button btn_stop;
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_play = (Button) findViewById(R.id.btn_play);
        btn_pause = (Button) findViewById(R.id.btn_pause);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_play.setOnClickListener(this);
        btn_pause.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        mp = new MediaPlayer();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_play:
                mp.reset();
                AssetManager assetManager = getAssets();
                try {
                    AssetFileDescriptor assetFileDescriptor = assetManager.openFd("brave_making_future_more_beautiful.mp3");
                    mp.setDataSource(assetFileDescriptor.getFileDescriptor(),assetFileDescriptor.getStartOffset(),assetFileDescriptor.getLength());
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_pause:
                if (mp.isPlaying()){
                    mp.pause();
                    btn_pause.setText("暂停");
                }else {
                    btn_pause.setText("继续");
                    mp.start();
                }
                break;
            case R.id.btn_stop:
                if (mp.isPlaying()){
                    mp.stop();
                }
                break;
        }
    }
}
