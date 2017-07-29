package com.cfg.team12.makeawish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Volunteer_Form1 extends AppCompatActivity {

    EditText aboutFamily,aboutFriends,color,game,food,music,hobby,tv_show,actor,trip,describePlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer__form1);

        aboutFamily= (EditText) findViewById(R.id.aboutFamily);
        aboutFriends= (EditText) findViewById(R.id.aboutFriends);
        parentIdbtn = (RadioGroup) findViewById(R.id.parentId);
        parentId = parentIdbtn.getCheckedRadioButtonId();
        color= (EditText) findViewById(R.id.favColor);
        game= (EditText) findViewById(R.id.game);
        food= (EditText) findViewById(R.id.food);
        music= (EditText) findViewById(R.id.musicMovie);
        hobby= (EditText) findViewById(R.id.hobby);
        tv_show= (EditText) findViewById(R.id.tvShow);
        actor= (EditText) findViewById(R.id.actorActoress);
        trip= (EditText) findViewById(R.id.tripDescription);
        describePlan= (EditText) findViewById(R.id.DescribePlan);

        private void register() {
            String strfamily=aboutFamily.getText().toString();
            String strfriends=aboutFriends.getText().toString();
            String strid=parentId.getText().toString();
            String strcolor=color.getText().toString();
            String strgame=game.getText().toString();
            String strfood=food.getText().toString();
            String strmusic=music.getText().toString();
            String strhobby=hobby.getText().toString();
            String strtv_show=tv_show.getText().toString();
            String stractor=actor.getText().toString();
            String strtrip=trip.getText().toString();
            String strplan=.getText().toString();

    }

    }
}
