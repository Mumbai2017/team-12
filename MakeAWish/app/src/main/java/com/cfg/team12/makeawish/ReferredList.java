package com.cfg.team12.makeawish;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
import java.util.Date;

public class ReferredList extends AppCompatActivity {

    //for displaying data in card view
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<ReferredData> arraylist = new ArrayList<>();
    String url = "http://freeecommercewebsite.in/Cfg/getvolunteer2.php";
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referred_list);

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


    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

        ArrayList<ReferredData> referredDatas = new ArrayList<>();
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
            Toast.makeText(ReferredList.this, "" + rf.getName(), Toast.LENGTH_SHORT).show();
            holder.txtAddress.setText(referredDatas.get(position).getAddress());
            holder.txtName.setText(referredDatas.get(position).getAddress());
            BigInteger number = referredDatas.get(position).getPhone();


        }


        @Override
        public int getItemCount() {
            return referredDatas.size();
        }

        class RecyclerViewHolder extends RecyclerView.ViewHolder {

            protected TextView txtName, txtAddress;
            protected ImageView imageView;

            public RecyclerViewHolder(View itemView, final Context context) {
                super(itemView);
                txtName = (TextView) itemView.findViewById(R.id.txt_name);

                txtAddress = (TextView) itemView.findViewById(R.id.txt_address);


                RelativeLayout relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rel_list);
                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

            }
        }
    }
}
