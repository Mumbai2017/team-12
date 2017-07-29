package com.cfg.team12.makeawish;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cfg.team12.makeawish.model.DoctorModel;

import java.math.BigInteger;
import java.util.ArrayList;

public class DoctorDashboard extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dashboard);

        recyclerView = (RecyclerView) findViewById(R.id.doctorRecyclerView);

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
            txtName = (TextView) itemView.findViewById(R.id.txt_name);

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
 