package com.cfg.team12.makeawish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.cfg.team12.makeawish.model.MySingleton;
import com.cfg.team12.makeawish.model.ReferredData;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.util.ArrayList;

public class VolunteerDashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<ReferredData> arraylist = new ArrayList<>();
    String url = "http://freeecommercewebsite.in/Cfg/getvolunteer2.php";
    public static int flag = 11;
    public static String childName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volunteer_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ArrayList<ReferredData> data = new ArrayList<>();
        BigInteger bigInteger = new BigInteger("543534535");
        ReferredData referredData = new ReferredData("Rohit", "Mumbai", bigInteger);
        data.add(referredData);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(data);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);


        recyclerViewAdapter.notifyDataSetChanged();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public synchronized void getList() {


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<org.json.JSONArray>() {
                    @Override
                    public void onResponse(org.json.JSONArray response) {
                        int count = 0;
                        while (count < response.length()) {


                            try {
                                JSONObject jsoNobject = response.getJSONObject(count);
                                BigInteger bigInteger = (BigInteger) jsoNobject.get("contact_no");

                                ReferredData referredData = new ReferredData(jsoNobject.getString("child_name"),
                                        jsoNobject.getString("hospital"),
                                        bigInteger);
                                //Toast.makeText(context, "Name TEst:" + jsoNobject.getString("name"), Toast.LENGTH_SHORT).show();
                                // Toast.makeText(context, count+""+arrayList, Toast.LENGTH_SHORT).show();
                                arraylist.add(referredData);

                                //  Toast.makeText(context, count + " - count," + arrayList.get(0), Toast.LENGTH_SHORT).show();
                                count++;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        if (count == response.length()) {
                            Toast.makeText(getApplicationContext(), "response() :", Toast.LENGTH_SHORT).show();
                            onResponseRecieved();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getmInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);
        //    arrayList2 = arrayList;
        //  Toast.makeText(context, "BAckgroud: " + arrayList.size(), Toast.LENGTH_SHORT).show();
        //   Toast.makeText(context, "BAckgroud2: " + arrayList2.size(), Toast.LENGTH_SHORT).show();
        if (arraylist == null) {
            Toast.makeText(getApplicationContext(), "null hai bhai", Toast.LENGTH_SHORT).show();
        }


    }

    public void onResponseRecieved() {
        // flag=1;

        recyclerViewAdapter = new RecyclerViewAdapter(arraylist);
        recyclerView.setAdapter(recyclerViewAdapter);
        flag = 1;

        Toast.makeText(getApplicationContext(), "Final :" + arraylist.size(), Toast.LENGTH_SHORT).show();
        // return arrayList;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.volunteer_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

      /*  if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) { */

        if (id == R.id.nav_vouchers) {
            startActivity(new Intent(VolunteerDashboardActivity.this, Vouchers.class));

        } else {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

        public ArrayList<ReferredData> referredDatas = new ArrayList<>();
        //  ArrayList<Bitmap> forecasrArrayList = new ArrayList<>();


        RecyclerViewAdapter(ArrayList<ReferredData> referredDataArrayList) {
            referredDatas = referredDataArrayList;

        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_referral, parent, false);
            return new RecyclerViewHolder(view, parent.getContext());
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {

            ReferredData rf = referredDatas.get(position);
            Toast.makeText(VolunteerDashboardActivity.this, "" + rf.getName(), Toast.LENGTH_SHORT).show();
            holder.txtAddress.setText(referredDatas.get(position).getAddress());
            holder.txtName.setText(referredDatas.get(position).getName());
            BigInteger number = referredDatas.get(position).getPhone();
            holder.id = referredDatas.get(position).id;

        }


        @Override
        public int getItemCount() {
            return referredDatas.size();
        }
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtName, txtAddress;
        protected ImageView imageView;
        int id;

        public RecyclerViewHolder(View itemView, final Context context) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);

            txtAddress = (TextView) itemView.findViewById(R.id.txt_address);


                /*RelativeLayout relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rel_list);*/


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = recyclerView.getChildLayoutPosition(v);
                    flag = id;

                    Toast.makeText(getApplicationContext(), "" + flag, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(VolunteerDashboardActivity.this, VolunterData.class));
                }
            });

        }
    }
}

