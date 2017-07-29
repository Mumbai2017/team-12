package com.cfg.team12.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {

    Spinner stakeholder;
    String data[]=new String[]{"Donor","Volunteer"};
    Button loginButton;

    @InjectView(com.cfg.team12.makeawish.R.id.input_email) EditText _emailText;
    @InjectView(com.cfg.team12.makeawish.R.id.input_password) EditText _passwordText;
    @InjectView(com.cfg.team12.makeawish.R.id.btn_login)      Button _loginButton;
    @InjectView(com.cfg.team12.makeawish.R.id.link_signup)
    TextView _signupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,data);

        stakeholder=(Spinner)findViewById(R.id.spinner_select);
        stakeholder.setAdapter(arrayAdapter);



        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            login();
               // Toast.makeText(mContext, "Hello moto!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void login() {
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

    }
}
