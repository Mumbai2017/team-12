package com.cfg.team12.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Spinner stakeholder;
    String data[]=new String[]{"Donor","Volunteer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,data);

        stakeholder=(Spinner)findViewById(R.id.spinner_select);
        stakeholder.setAdapter(arrayAdapter);

    }
}
