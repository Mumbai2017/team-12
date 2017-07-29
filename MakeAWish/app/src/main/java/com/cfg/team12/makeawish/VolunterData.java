package com.cfg.team12.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import info.hoang8f.widget.FButton;

public class VolunterData extends AppCompatActivity {


    @InjectView(R.id.input_name)
    TextView edtName;
    @InjectView(R.id.input_wish1) EditText wish1;
    @InjectView(R.id.input_wish2) EditText wish2;
    @InjectView(R.id.input_wish3) EditText wish3;

    @InjectView(R.id.input_wish_desc1) EditText wishdes1;
    @InjectView(R.id.input_wish_desc2) EditText wishdes2;
    @InjectView(R.id.input_wish_desc3) EditText wishdes3;


    @InjectView(R.id.btn_signup)
    FButton signUpButton;

    Spinner s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunter_data);

        ButterKnife.inject(this);

        s1 = (Spinner) findViewById(R.id.spinner_select1);
        s2 = (Spinner) findViewById(R.id.spinner_select2);
        s3 = (Spinner) findViewById(R.id.spinner_select3);

        List<String> list = new ArrayList<>();
        list.add("I wish to have");
        list.add("I wish to want");
        list.add("I wish to go");
        list.add("I wish to be");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);

        s1.setAdapter(adapter);
        s2.setAdapter(adapter);
        s3.setAdapter(adapter);


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

        String wish1type = s1.getSelectedItem().toString();
        String wish2type = s2.getSelectedItem().toString();
        String wish3type = s3.getSelectedItem().toString();
    }
}
