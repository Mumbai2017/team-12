package com.cfg.team12.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

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
    }
}
