package com.lexieluv.homeworkeleventh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private TextView tv_login;
    private Button btn_submit;
    private EditText reg_phone,reg_pwd;
    public static final String INFO_NAME = "INFO_NAME";
    public static final String INFO_PASS = "INFO_PASS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg_phone = findViewById(R.id.reg_phone);
        reg_pwd = findViewById(R.id.res_pwd);

        tv_login = findViewById(R.id.tv_login);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                RegisterActivity.this.finish();
            }
        });

        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                String user = reg_phone.getText().toString();
                String pass = reg_pwd.getText().toString();
                intent.putExtra(INFO_NAME,user);
                intent.putExtra(INFO_PASS,pass);
                startActivity(intent);
            }
        });
    }


}
