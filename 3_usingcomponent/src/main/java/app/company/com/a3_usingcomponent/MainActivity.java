package app.company.com.a3_usingcomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Debug";

    private Button btn_change_et;
    private EditText et_text;

    private TextView tv_text;

    private CheckBox cb_apple;
    private CheckBox cb_banana;

    private RadioButton rb_boy;
    private RadioButton rb_girl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_change_et = (Button) findViewById(R.id.btn_change_et);
        et_text  = (EditText) findViewById(R.id.et_text);
        btn_change_et.setOnClickListener(this);

        tv_text = (TextView) findViewById(R.id.tv_text);
        rb_boy = (RadioButton) findViewById(R.id.rb_boy);
        rb_girl = (RadioButton) findViewById(R.id.rb_girl);
        rb_boy.setOnClickListener(this);
        rb_girl.setOnClickListener(this);

        cb_apple = (CheckBox) findViewById(R.id.cb_apple);
        cb_banana = (CheckBox) findViewById(R.id.cb_banana);
        cb_apple.setOnClickListener(this);
        cb_banana.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_change_et:
                et_text.setText("Hia Hia Hia!!~");
                break;
            case R.id.cb_apple:
                if (((CheckBox)view).isChecked() && !cb_banana.isChecked())
                    tv_text.setText(((CheckBox)view).getText().toString()+"Choosed");
                else if(((CheckBox)view).isChecked() && cb_banana.isChecked())
                    tv_text.setText("Apple and Banana are all checked");
                else
                    tv_text.setText("There is nothing to show");
                break;
            case R.id.cb_banana:
                if (((CheckBox)view).isChecked() && !cb_apple.isChecked()) {
                    tv_text.setText(((CheckBox)view).getText().toString()+"Checked");
                }
                else if (((CheckBox)view).isChecked() && cb_apple.isChecked()){
                    tv_text.setText("Apple and Banana are all checked");
                } else
                    tv_text.setText("There is nothing to show");
                break;
            case R.id.rb_boy:
                tv_text.setText(((RadioButton)view).getText().toString());
                break;

            case R.id.rb_girl:
                tv_text.setText(((RadioButton)view).getText().toString());
                break;
        }
    }
}
