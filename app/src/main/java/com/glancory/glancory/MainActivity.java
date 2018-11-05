package com.glancory.glancory;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.glancory.glancory.receiver.BootReceiver;

import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity {
    private Button loginBtn;
    private Button logupBtn;
    private EditText user_input;
    private EditText password_input;

    private BootReceiver mBootReveiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mBootReveiver = new BootReceiver();
        IntentFilter intent = new IntentFilter();
        intent.addAction("RestartSerivcesForSystemEventReceiver");
        registerReceiver(mBootReveiver, intent);

        sendBroadcast(new Intent("RestartSerivcesForSystemEventReceiver"));

        initLoginLayout();
    }

    public void initLoginLayout() {
        loginBtn = findViewById(R.id.login_btn);
        logupBtn = findViewById(R.id.logup_btn);
        user_input = findViewById(R.id.user_name);
        password_input = findViewById(R.id.user_password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = user_input.getText().toString().trim();
                String password = password_input.getText().toString().trim();

                if(userName == null || userName.equals("") || password == null || password.equals("")) {
                    Toast.makeText(MainActivity.this, "用户名和密码不能为空", Toast.LENGTH_SHORT);
                    return;
                }

                boolean ret = login(userName, password);
                if (!ret) {
                    Toast.makeText(MainActivity.this, "登录失败，请重新登录", Toast.LENGTH_SHORT);
                    return;
                } else {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean login(String userName, String password) {

        new Thread(){
            private HttpURLConnection httpConnect;

            @Override
            public void run() {
                super.run();
            }
        }.start();

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
