package com.cfg.team12.makeawish;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.cfg.team12.makeawish.model.MySingleton;
import com.cfg.team12.makeawish.model.staffModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ApprovedStaff extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<staffModel> arraylist = new ArrayList<>();
    String url="http://freeecommercewebsite.in/Cfg/staff_fetchdata_2.php";
    public static int flag = 11;
    public static String childName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approved_staff);
        recyclerView = (RecyclerView) findViewById(R.id.doctorRecyclerView);
        //recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
       /* ArrayList<ReferredData> data = new ArrayList<>();
        BigInteger bigInteger = new BigInteger("543534535");*/

        //ReferredData referredData = new ReferredData("Rohit", "Mumbai", bigInteger);
     /*   staffModel staffModel = new staffModel("name",
                "hospital", "status",
                "contact_no");*/
        //arraylist.add(staffModel);
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
        int id=1;
        Toast.makeText(this, "gfdgdgl", Toast.LENGTH_SHORT).show();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url+"?id="+id, null,
                new Response.Listener<org.json.JSONArray>() {

                    @Override
                    public void onResponse(org.json.JSONArray response) {
                        int count = 0;
                        Toast.makeText(ApprovedStaff.this, "called1"+response.length(), Toast.LENGTH_SHORT).show();
                        Log.d("TAG",""+response);
                        while (count < response.length()) {

                            Toast.makeText(ApprovedStaff.this, "dsad"+response.length(), Toast.LENGTH_SHORT).show();
                            try {
                                JSONObject jsoNobject = response.getJSONObject(count);
                                // BigInteger bigInteger = (BigInteger) jsoNobject.get("contact_no");
                                Toast.makeText(ApprovedStaff.this, "" + jsoNobject, Toast.LENGTH_SHORT).show();
                                staffModel staffModel = new staffModel(jsoNobject.getString("child_name"),
                                        jsoNobject.getInt("id")
                                        , jsoNobject.getString("hospital"),
                                        jsoNobject.getString("contact_no"),
                                        jsoNobject.getString("status"),
                                        jsoNobject.getString("doner")
                                        );
                             /*   ReferredData referredData = new ReferredData(jsoNobject.getString("child_name"),
                                        jsoNobject.getString("hospital"),
                                        bigInteger);*/
                                //Toast.makeText(context, "Name TEst:" + jsoNobject.getString("name"), Toast.LENGTH_SHORT).show();
                                // Toast.makeText(context, count+""+arrayList, Toast.LENGTH_SHORT).show();
                                arraylist.add(staffModel);

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
        recyclerViewAdapter.notifyDataSetChanged();

        Toast.makeText(getApplicationContext(), "Final :" + arraylist.size(), Toast.LENGTH_SHORT).show();
        // return arrayList;
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

        public ArrayList<staffModel> referredDatas = new ArrayList<>();
        //  ArrayList<Bitmap> forecasrArrayList = new ArrayList<>();


        RecyclerViewAdapter(ArrayList<staffModel> referredDataArrayList) {
            referredDatas = referredDataArrayList;

        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list__staffref, parent, false);
            return new RecyclerViewHolder(view, parent.getContext());
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {

            staffModel rf = referredDatas.get(position);
            // Toast.makeText(ApprovedStaff.this, "" + rf.get(position).get, Toast.LENGTH_SHORT).show();

            holder.txtName.setText(referredDatas.get(position).getChild_name());
            holder.txtAddress.setText(referredDatas.get(position).getHospital());
            //  holder.id = referredDatas.get(position).id;

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
                    // int itemPosition = recyclerView.getChildLayoutPosition(v);
                    //flag = id;

                    //  Toast.makeText(getApplicationContext(), "" + flag, Toast.LENGTH_LONG).show();
                    //startActivity(new Intent(VolunteerDashboardActivity.this, VolunterData.class));
                }
            });

        }
    }
}
