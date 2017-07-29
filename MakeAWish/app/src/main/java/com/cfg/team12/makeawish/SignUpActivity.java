package com.cfg.team12.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import info.hoang8f.widget.FButton;

public class SignUpActivity extends AppCompatActivity {

    @InjectView(com.cfg.team12.makeawish.R.id.input_email)
    EditText email;
    @InjectView(com.cfg.team12.makeawish.R.id.input_password) EditText password;
    @InjectView(R.id.input_name) EditText name;
    @InjectView(R.id.input_aadhar)EditText aadhar;
    @InjectView(R.id.input_city)EditText location;


    @InjectView(R.id.btn_signup)
    FButton signUpButton;
    @InjectView(com.cfg.team12.makeawish.R.id.link_signup)
    TextView _signupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        ButterKnife.inject(this);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        String email2 = email.getText().toString();
        String password2 = password.getText().toString();
        String aadhar2=aadhar.getText().toString();
        String location2=location.getText().toString();

    }
}
