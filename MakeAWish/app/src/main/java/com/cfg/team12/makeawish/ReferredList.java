package com.cfg.team12.makeawish;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cfg.team12.makeawish.model.ReferredData;

import java.util.ArrayList;
import java.util.Date;

public class ReferredList extends AppCompatActivity {

    //for displaying data in card view
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referred_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ArrayList<ReferredData> data = new ArrayList<>();
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        for (int i = 0; i < 5; i++) {
            ReferredData referredData = new ReferredData("Rohit", "Mumbai", "8655156231");
            data.add(referredData);
            recyclerViewAdapter.notifyDataSetChanged();
        }

    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

        ArrayList<ReferredData> referredDatas = new ArrayList<>();
        //  ArrayList<Bitmap> forecasrArrayList = new ArrayList<>();


        RecyclerViewAdapter(ArrayList<ReferredData> referredDataArrayList, ArrayList<Bitmap> forecastList) {
            referredDatas = referredDataArrayList;

        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_referral, parent, false);
            return new RecyclerViewHolder(view, parent.getContext());
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {


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
