package com.cfg.team12.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ReferActivity extends AppCompatActivity {

    @InjectView(com.cfg.team12.makeawish.R.id.input_email)
    EditText email;
    @InjectView(R.id.input_phone)
    EditText phone;
    @InjectView(R.id.input_address)
    EditText location;


    @InjectView(R.id.btn_login)
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer);

        ButterKnife.inject(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        String email2 = email.getText().toString();
        String phone2 = phone.getText().toString();
        String location2 = location.getText().toString();

    }
}
