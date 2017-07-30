package com.cfg.team12.makeawish;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.cfg.team12.makeawish.model.MySingleton;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import info.hoang8f.widget.FButton;

public class ReferActivity extends AppCompatActivity {

    @InjectView(com.cfg.team12.makeawish.R.id.input_name)
    EditText name;
    @InjectView(R.id.input_phone)
    EditText phone;
    @InjectView(R.id.input_address)
    EditText location;


    @InjectView(R.id.btn_login)
    FButton registerButton;

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
        final String email2 = name.getText().toString();
        final String phone2 = phone.getText().toString();
        final String location2 = location.getText().toString();
        String url="";
     //   String selected = stakeholder.getSelectedItem().toString();
/*
        if (selected.equals("Donor")) {
            url = "http://freeecommercewebsite.in/Cfg/getvolunteer2.php";
        } else if (selected.equals("Doctor")) {
            url = "http://freeecommercewebsite.in/Cfg/getvolunteer2.php";
        } else {
            url = "http://freeecommercewebsite.in/Cfg/getvolunteer2.php";
        }
       */

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                if (response.equals("Login success")) {
                    startActivity(new Intent(ReferActivity.this, VolunteerDashboardActivity.class));
                } else {
                  //  builder.setTitle("Server Response");

                   // builder.setMessage("Response" + response);
                   // builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        /*@Override
                        public void onClick(DialogInterface dialog, int which) {
//                        edtEmail.setText("");
//                        edtPassword.setText("");
                            //startActivity(new Intent(LoginActivity.this,VolunteerDashboardActivity.class));
                        }*/

                   // AlertDialog alertDialog = builder.create();
                    //alertDialog.show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ReferActivity.this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email2);
                params.put("phone", phone2);
            params.put("location",location2);

                // params.put("location",location2);
                // params.put("hospital",)


                return params;
            }
        };
        MySingleton.getmInstance(LoginActivity.this).addToRequestQueue(stringRequest);
    }


}
}
