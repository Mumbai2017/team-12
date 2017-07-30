package com.cfg.team12.makeawish;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.cfg.team12.makeawish.model.MySingleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import info.hoang8f.widget.FButton;

public class LoginActivity extends AppCompatActivity {

    Spinner stakeholder;
    String data[] = new String[]{"Donor", "Volunteer", "Doctor"};
    String url = "http://freeecommercewebsite.in/Cfg/getvolunteer2.php";
    AlertDialog.Builder builder;

    @InjectView(com.cfg.team12.makeawish.R.id.input_email)
    EditText _emailText;
    @InjectView(com.cfg.team12.makeawish.R.id.input_password)
    EditText _passwordText;
    @InjectView(R.id.btn_login)
    FButton loginButton;
    @InjectView(com.cfg.team12.makeawish.R.id.link_signup)
    TextView _signupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.inject(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        builder = new AlertDialog.Builder(LoginActivity.this);
        stakeholder = (Spinner) findViewById(R.id.spinner_select);
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
        final String selected = stakeholder.getSelectedItem().toString();

        if (selected.equals("Donor")) {
            url = "http://freeecommercewebsite.in/Cfg/donerLogin.php";
        } else if (selected.equals("Doctor")) {
            url = "http://freeecommercewebsite.in/Cfg/doctorLogin.php";
        } else {
            url = "http://freeecommercewebsite.in/Cfg/getvolunteer2.php";
        }
        final String email = _emailText.getText().toString();
        final String password = _passwordText.getText().toString();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                if (response.equals("Login success")) {
                    if (selected.equals("Donor")) {
                        startActivity(new Intent(LoginActivity.this, DonorActivity.class));
                    } else if (selected.equals("Doctor")) {
                        startActivity(new Intent(LoginActivity.this, DoctorDashboard.class));
                    } else {
                        startActivity(new Intent(LoginActivity.this, VolunteerDashboardActivity.class));
                    }

                } else {
                    builder.setTitle("Server Response");

                    builder.setMessage("Invalid Credentials" + response);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                        edtEmail.setText("");
//                        edtPassword.setText("");
                            //startActivity(new Intent(LoginActivity.this,VolunteerDashboardActivity.class));
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("name", email);
                params.put("pass", password);

                // params.put("location",location2);
                // params.put("hospital",)


                return params;
            }
        };
        MySingleton.getmInstance(LoginActivity.this).addToRequestQueue(stringRequest);
    }


}
