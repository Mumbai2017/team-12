package com.cfg.team12.makeawish;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.cfg.team12.makeawish.model.DoctorModel;
import com.cfg.team12.makeawish.model.MySingleton;
import com.cfg.team12.makeawish.model.ReferredData;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoctorDashboard extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<DoctorModel> arraylist = new ArrayList<>();
    String url = "http://freeecommercewebsite.in/Cfg/doctorRecycler.php";
    public static int flag = 11;
    public static String childName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dashboard);

        recyclerView = (RecyclerView) findViewById(R.id.doctorRecyclerView);
        //recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
       /* ArrayList<ReferredData> data = new ArrayList<>();
        BigInteger bigInteger = new BigInteger("543534535");*/

        //ReferredData referredData = new ReferredData("Rohit", "Mumbai", bigInteger);
        DoctorModel doctorModel = new DoctorModel("name",
                "hospital", "status",
                "contact_no");
         arraylist.add(doctorModel);
         RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(arraylist);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        getList();

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

                                DoctorModel doctorModel = new DoctorModel(jsoNobject.getString("name"),
                                        jsoNobject.getString("hospital"), jsoNobject.getString("status"),
                                        jsoNobject.getString("contact_no"));
                             /*   ReferredData referredData = new ReferredData(jsoNobject.getString("child_name"),
                                        jsoNobject.getString("hospital"),
                                        bigInteger);*/
                                //Toast.makeText(context, "Name TEst:" + jsoNobject.getString("name"), Toast.LENGTH_SHORT).show();
                                // Toast.makeText(context, count+""+arrayList, Toast.LENGTH_SHORT).show();
                                arraylist.add(doctorModel);

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
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("id", "1");
                //  params.put("pass", password);

                // params.put("location",location2);
                // params.put("hospital",)


                return params;
            }
        };
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

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

        public ArrayList<DoctorModel> referredDatas = new ArrayList<>();
        //  ArrayList<Bitmap> forecasrArrayList = new ArrayList<>();


        RecyclerViewAdapter(ArrayList<DoctorModel> referredDataArrayList) {
            referredDatas = referredDataArrayList;

        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_doctor_view, parent, false);
            return new RecyclerViewHolder(view, parent.getContext());
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {

            DoctorModel rf = referredDatas.get(position);
            // Toast.makeText(DoctorDashboard.this, "" + rf.get(position).get, Toast.LENGTH_SHORT).show();
            holder.txtHospital.setText(referredDatas.get(position).getHospital());
            holder.txtName.setText(referredDatas.get(position).getChildName());
            holder.txtContact.setText(referredDatas.get(position).getStatus());
            //  holder.id = referredDatas.get(position).id;

        }


        @Override
        public int getItemCount() {
            return referredDatas.size();
        }
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtName, txtHospital, txtContact;
        protected ImageView imageView;
        int id;

        public RecyclerViewHolder(View itemView, final Context context) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.childsName);

            txtHospital = (TextView) itemView.findViewById(R.id.nameOFHospital);
            txtContact = (TextView) itemView.findViewById(R.id.contact);


                /*RelativeLayout relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rel_list);*/


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = recyclerView.getChildLayoutPosition(v);
                    //flag = id;

                    //  Toast.makeText(getApplicationContext(), "" + flag, Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(VolunteerDashboardActivity.this, VolunterData.class));
                }
            });

        }
    }
}
 