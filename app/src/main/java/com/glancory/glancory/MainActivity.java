package com.glancory.glancory;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.glancory.glancory.Utils.HttpConnectionUtils;
import com.glancory.glancory.Utils.StreamChangeStrUtils;
import com.glancory.glancory.receiver.BootReceiver;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    private Button loginBtn;
    private Button logupBtn;
    private EditText user_input;
    private EditText password_input;

    private BootReceiver mBootReveiver;

    private final static int RESPONSE_LOGIN_SUCCESS = 0;
    private final static int RESPONSE_LOGIN_FAIL = 1;
    private final static int RESPONSE_LOGIN_EXCEPTION = 2;
//    private final static int RESPONSE_LOGIN_SUCCESS = 0;

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

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case RESPONSE_LOGIN_SUCCESS:
                    Log.e("Login", "Login success ＝ " + msg.obj);
                    break;
                case RESPONSE_LOGIN_FAIL:
                    Log.e("Login", "Login success");
                    break;
                case RESPONSE_LOGIN_EXCEPTION:
                    Log.e("Login", "Login success");
                    break;
            }
            super.handleMessage(msg);
        }
    };

    public boolean login(final String userName, final String password) {

        new Thread(){
            private HttpURLConnection connection;

            @Override
            public void run() {
                try {
                    String request = "username=" + URLEncoder.encode(userName, "UTF-8") + "&password=" +
                            URLEncoder.encode(password, "utf-8");
                    connection = HttpConnectionUtils.getConnection(request);
                    int code = connection.getResponseCode();
                    if (code == 200) {
                        InputStream input = connection.getInputStream();
                        String response = StreamChangeStrUtils.toChange(input);
                        Message message = Message.obtain();
                        message.what = RESPONSE_LOGIN_SUCCESS;
                        message.obj = response;
                        handler.sendMessage(message);
                    } else {
                        Message message = Message.obtain();;
                        message.what = RESPONSE_LOGIN_FAIL;
                        message.obj = "登录失败，请稍后重试。";
                        handler.sendMessage(message);
                    }
                } catch (Exception e) {
                    Message message = Message.obtain();;
                    message.what = RESPONSE_LOGIN_EXCEPTION;
                    message.obj = "登录发生异常，请稍后重试。";
                    handler.sendMessage(message);
                }

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
