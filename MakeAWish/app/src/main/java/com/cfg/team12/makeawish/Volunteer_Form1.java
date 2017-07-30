package com.cfg.team12.makeawish;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.cfg.team12.makeawish.model.MySingleton;

import java.util.HashMap;
import java.util.Map;

public class Volunteer_Form1 extends AppCompatActivity {

    EditText aboutFamily, aboutFriends, color, game, food, music, hobby, tv_show, actor, trip, describePlan;
    RadioGroup parentIdbtn;
    String url="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer__form1);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        aboutFamily = (EditText) findViewById(R.id.aboutFamily);
        aboutFriends = (EditText) findViewById(R.id.aboutFriends);
        parentIdbtn = (RadioGroup) findViewById(R.id.parentId);
        int parentId = parentIdbtn.getCheckedRadioButtonId();
        color = (EditText) findViewById(R.id.favColor);
        game = (EditText) findViewById(R.id.game);
        food = (EditText) findViewById(R.id.food);
        music = (EditText) findViewById(R.id.musicMovie);
        hobby = (EditText) findViewById(R.id.hobby);
        tv_show = (EditText) findViewById(R.id.tvShow);
        actor = (EditText) findViewById(R.id.actorActoress);
        trip = (EditText) findViewById(R.id.tripDescription);
        describePlan = (EditText) findViewById(R.id.DescribePlan);
    }

    private void register() {



        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.equals("Registered")){
                    startActivity(new Intent(Volunteer_Form1.this,VolunteerDashboardActivity.class));
                }else{
                    Toast.makeText(Volunteer_Form1.this, "Registeration failed", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(Volunteer_Form1.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String strfamily = aboutFamily.getText().toString();
                String strfriends = aboutFriends.getText().toString();
                String selection="";
                if (parentIdbtn.getCheckedRadioButtonId() != -1) {
                    int id = parentIdbtn.getCheckedRadioButtonId();
                    View radioButton = parentIdbtn.findViewById(id);
                    int radioId = parentIdbtn.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) parentIdbtn.getChildAt(radioId);
                    selection = (String) btn.getText();
                }
                String strcolor = color.getText().toString();
                String strgame = game.getText().toString();
                String strfood = food.getText().toString();
                String strmusic = music.getText().toString();
                String strhobby = hobby.getText().toString();
                String strtv_show = tv_show.getText().toString();
                String stractor = actor.getText().toString();
                String strtrip = trip.getText().toString();
                String strplan = describePlan.getText().toString();
                Map<String,String> params=new HashMap<String, String>();
                params.put("aboutfamily",strfamily);
                params.put("aboutfriends",strfriends);
                params.put("parentId",selection);
                params.put("idno",aadhar2);
                params.put("password",password2);
                params.put("email",email2);
                params.put("govtid",selection);
                // params.put("location",location2);
                // params.put("hospital",)


                return params;
            }
        };
        MySingleton.getmInstance(Volunteer_Form1.this).addToRequestQueue(stringRequest);
    }


}



