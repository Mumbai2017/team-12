package com.cfg.team12.makeawish;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cfg.team12.makeawish.model.ReferredData;

import java.math.BigInteger;
import java.util.ArrayList;

public class Vouchers extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VolunteerDashboardActivity.RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<ReferredData> arraylist = new ArrayList<>();
    //String url = "http://freeecommercewebsite.in/Cfg/getvolunteer2.php";
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vouchers);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ArrayList<ReferredData> data = new ArrayList<>();
        BigInteger bigInteger = new BigInteger("543534535");
        ReferredData referredData = new ReferredData("BookMyShow", "Get 20% off!*", bigInteger);
        data.add(referredData);
        bigInteger = new BigInteger("543534535");
        referredData = new ReferredData("BookMyShow", "Get 20% off!*", bigInteger);
        data.add(referredData);
        bigInteger = new BigInteger("543534535");
        referredData = new ReferredData("BookMyShow", "Get 20% off!*", bigInteger);
        data.add(referredData);
        bigInteger = new BigInteger("543534535");
        referredData = new ReferredData("BookMyShow", "Get 20% off!*", bigInteger);
        data.add(referredData);
       RecyclerViewAdapter2 recyclerViewAdapter = new RecyclerViewAdapter2(data);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewHolder2> {

        ArrayList<ReferredData> referredDatas = new ArrayList<>();
        //  ArrayList<Bitmap> forecasrArrayList = new ArrayList<>();


        RecyclerViewAdapter2(ArrayList<ReferredData> referredDataArrayList) {
            referredDatas = referredDataArrayList;

        }

        @Override
        public RecyclerViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_referral, parent, false);
            return new RecyclerViewHolder2(view, parent.getContext());
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder2 holder, int position) {

            ReferredData rf = referredDatas.get(position);
            Toast.makeText(Vouchers.this, "" + rf.getName(), Toast.LENGTH_SHORT).show();
            holder.txtAddress.setText(referredDatas.get(position).getAddress());
            holder.txtName.setText(referredDatas.get(position).getName());
            BigInteger number = referredDatas.get(position).getPhone();


        }


        @Override
        public int getItemCount() {
            return referredDatas.size();
        }
    }

    class RecyclerViewHolder2 extends RecyclerView.ViewHolder {

        protected TextView txtName, txtAddress;
        protected ImageView imageView;

        public RecyclerViewHolder2(View itemView, final Context context) {
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
