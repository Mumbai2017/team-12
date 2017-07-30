package com.cfg.team12.makeawish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import info.hoang8f.widget.FButton;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.btn_refer)
    FButton btnRefer;

    @InjectView(R.id.btn_login)
    FButton btnLogin;

    @InjectView(R.id.btn_register)
    FButton btnReg;


    @InjectView(R.id.btn_loginstaff)
    FButton btnRegStaff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });

        btnRefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ReferActivity.class));
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });

        btnRegStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,StaffLogin.class));
            }
        });
    }
}
