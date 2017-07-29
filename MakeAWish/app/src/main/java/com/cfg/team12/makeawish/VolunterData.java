package com.cfg.team12.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import info.hoang8f.widget.FButton;

public class VolunterData extends AppCompatActivity {


    @InjectView(R.id.input_name)
    TextView edtName;
    @InjectView(R.id.input_wish1) EditText wish1;
    @InjectView(R.id.input_wish1) EditText wish2;
    @InjectView(R.id.input_wish1) EditText wish3;

    @InjectView(R.id.input_wish_desc1) EditText wishdes1;
    @InjectView(R.id.input_wish_desc2) EditText wishdes2;
    @InjectView(R.id.input_wish_desc3) EditText wishdes3;


    @InjectView(R.id.btn_signup)
    FButton signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunter_data);

        ButterKnife.inject(this);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        String strwish1=wish1.getText().toString();
        String strwish2=wish2.getText().toString();
        String strwish3=wish3.getText().toString();
        String strwishdes1=wishdes1.getText().toString();
        String strwishdes2=wishdes2.getText().toString();
        String strwishdes3=wishdes3.getText().toString();

    }
}
