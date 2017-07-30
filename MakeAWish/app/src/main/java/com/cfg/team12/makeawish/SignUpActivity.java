package com.cfg.team12.makeawish;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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

public class SignUpActivity extends AppCompatActivity {

    @InjectView(com.cfg.team12.makeawish.R.id.input_email)
    EditText email;
    @InjectView(com.cfg.team12.makeawish.R.id.input_password) EditText password;
    @InjectView(R.id.input_name) EditText name;
    @InjectView(R.id.input_aadhar)EditText aadhar;
    @InjectView(R.id.input_city)EditText location;
    RadioGroup radioGroup;
    String selection;

    String url="http://freeecommercewebsite.in/Cfg/volunterrreg.php";
    AlertDialog.Builder builder;

    @InjectView(R.id.btn_signup)
    FButton signUpButton;
   /* @InjectView(com.cfg.team12.makeawish.R.id.link_signup)
    TextView _signupLink;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        builder=new AlertDialog.Builder(SignUpActivity.this);
        ButterKnife.inject(this);
       radioGroup = (RadioGroup) findViewById(R.id.radio);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        final String email2 = email.getText().toString();
        final String password2 = password.getText().toString();
        final String aadhar2=aadhar.getText().toString();
        final String location2=location.getText().toString();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.equals())
               /* builder.setTitle("Server Response");
                builder.setMessage("Response"+response);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        edtEmail.setText("");
//                        edtPassword.setText("");
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SignUpActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if(radioGroup.getCheckedRadioButtonId()!=-1){
                    int id= radioGroup.getCheckedRadioButtonId();
                    View radioButton = radioGroup.findViewById(id);
                    int radioId = radioGroup.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) radioGroup.getChildAt(radioId);
                    selection = (String) btn.getText();
                }
                Map<String,String> params=new HashMap<String, String>();
                params.put("name",email2);
                params.put("area",location2);
                params.put("idno",aadhar2);
                params.put("password",password2);
                params.put("email",email2);
                params.put("govtid",selection);
               // params.put("location",location2);
               // params.put("hospital",)


                return params;
            }
        };
        MySingleton.getmInstance(SignUpActivity.this).addToRequestQueue(stringRequest);
    }

    }

