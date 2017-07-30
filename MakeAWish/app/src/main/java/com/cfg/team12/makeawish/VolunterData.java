package com.cfg.team12.makeawish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import info.hoang8f.widget.FButton;

public class VolunterData extends AppCompatActivity {

    String url = "http://freeecommercewebsite.in/Cfg/volunteer_form1.php";

    @InjectView(R.id.input_name)
    TextView edtName;
    @InjectView(R.id.input_wish1)
    EditText wish1;
    @InjectView(R.id.input_wish2)
    EditText wish2;
    @InjectView(R.id.input_wish3)
    EditText wish3;

    @InjectView(R.id.input_wish_desc1)
    EditText wishdes1;
    @InjectView(R.id.input_wish_desc2)
    EditText wishdes2;
    @InjectView(R.id.input_wish_desc3)
    EditText wishdes3;


    @InjectView(R.id.btn_signup)
    FButton signUpButton;

    Spinner s1, s2, s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunter_data);

        ButterKnife.inject(this);

        s1 = (Spinner) findViewById(R.id.spinner_select1);
        s2 = (Spinner) findViewById(R.id.spinner_select2);
        s3 = (Spinner) findViewById(R.id.spinner_select3);


        Toast.makeText(this, "vol" + VolunteerDashboardActivity.flag, Toast.LENGTH_SHORT).show();
        List<String> list = new ArrayList<>();
        list.add("I wish to have");
        list.add("I wish to want");
        list.add("I wish to go");
        list.add("I wish to be");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

        s1.setAdapter(adapter);
        s2.setAdapter(adapter);
        s3.setAdapter(adapter);


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // register();
            }
        });
    }

    private void register() {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("Registered")) {
                    startActivity(new Intent(VolunterData.this, VolunteerDashboardActivity.class));
                } else {
                    Toast.makeText(VolunterData.this, "Registeration failed", Toast.LENGTH_SHORT).show();
                }
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
                // Toast.makeText(Volunteer_Form1.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                String strwish1 = wish1.getText().toString();
                String strwish2 = wish2.getText().toString();
                String strwish3 = wish3.getText().toString();
                String strwishdes1 = wishdes1.getText().toString();
                String strwishdes2 = wishdes2.getText().toString();
                String strwishdes3 = wishdes3.getText().toString();

                String wish1type = s1.getSelectedItem().toString();
                String wish2type = s2.getSelectedItem().toString();
                String wish3type = s3.getSelectedItem().toString();


                Map<String, String> params = new HashMap<String, String>();
               /* params.put("strwish1",strfamily);
                params.put("strwish2",strfriends);
                params.put("strwish3",selection);
                params.put("color",strcolor);
                params.put("game",strgame);
                params.put("food",strfood);
                params.put("music",strmusic);
                params.put("hobby",strhobby);
                params.put("tv_show",strtv_show);
                params.put("actor",stractor);
                params.put("trip",strtrip);
                params.put("describePlan",strplan);*/


                //params.put("idno",aadhar2);
                //params.put("password",password2);
                //params.put("email",email2);
                // params.put("govtid",selection);
                // params.put("location",location2);
                // params.put("hospital",)


                return params;
            }
        };
        MySingleton.getmInstance(VolunterData.this).addToRequestQueue(stringRequest);

    }


}
