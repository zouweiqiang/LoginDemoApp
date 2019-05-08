package com.nd.zou.logindemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import com.nd.zou.logindemoapp.MainActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_login = findViewById(R.id.btn_logn);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = ((EditText) findViewById(R.id.et_1)).getText().toString();//获取用户名输入框中的信息
                String pwd = ((EditText) findViewById(R.id.et_2)).getText().toString();//获取密码输入框中的信息
                if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(pwd)) {
                    login(userName, pwd);
                } else {
                    Toast.makeText(MainActivity.this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void login(final String userName, final String pwd) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (userName.equals("17023149") && pwd.equals("password17023149")) {//判断用户名是否为17023148，密码是否为password17023148
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent();
                            intent.setClass(MainActivity.this, FirstActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent();
                            intent.setClass(MainActivity.this, FirstActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        }).start();
    }
}

