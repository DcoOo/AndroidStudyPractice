package app.company.com.a7_dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_alert;
    private Button btn_login;
    private TextView tv_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_alert = (Button) findViewById(R.id.btn_alert);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_click = (TextView) findViewById(R.id.tv_click_text);
        btn_alert.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final String[] data = {"确认", "取消"};
        switch (view.getId()){
            case R.id.btn_alert:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alert").setItems(data, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv_click.setText("User choosed"+data[i]);
                    }
                }).show();
                break;
            case R.id.btn_login:
                LayoutInflater inflater = getLayoutInflater().from(MainActivity.this);
                final View login_view = inflater.inflate(R.layout.login_layout,null);
                final AlertDialog.Builder alert_builder = new AlertDialog.Builder(this);
                alert_builder.setView(login_view).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        MainActivity.this.finish();
                    }
                }).setPositiveButton("登陆", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText et_username = (EditText) login_view.findViewById(R.id.et_username);
                        EditText et_password = (EditText) login_view.findViewById(R.id.et_password);
                        String username = et_username.getText().toString();
                        String password = et_password.getText().toString();
                        if (username.equals("abc") && password.equals("123")){
                            Toast.makeText(MainActivity.this, getString(R.string.login_success), LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, getString(R.string.login_faild), LENGTH_SHORT).show();
//                            MainActivity.this.finish();
                        }
                    }
                }).show();
                break;
        }
    }
}
