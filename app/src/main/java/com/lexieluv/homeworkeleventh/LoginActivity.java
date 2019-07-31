package com.lexieluv.homeworkeleventh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    protected Button mBtnRegister;
    protected Button mLogin;

    protected EditText username,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBtnRegister= (Button) this.findViewById(R.id.btn_register);
        mLogin = findViewById(R.id.btn_login);
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                LoginActivity.this.finish();
            }
        });

        username = findViewById(R.id.edt_username);
        pwd = findViewById(R.id.edt_pwd);
        String user = getIntent().getStringExtra(RegisterActivity.INFO_NAME);
        String pass = getIntent().getStringExtra(RegisterActivity.INFO_PASS);
        if(user != null&&pass != null){
            username.setText(user);
            pwd.setText(pass);
        }
        mLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                LoginActivity.this.finish();
            }
        });
    }
}
