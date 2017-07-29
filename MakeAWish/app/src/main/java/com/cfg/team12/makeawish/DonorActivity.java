package com.cfg.team12.makeawish;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DonorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);
    }



    class RecyclerViewHolder3 extends RecyclerView.ViewHolder {

        protected TextView txtName, txtAddress;
        protected ImageView imageView;

        public RecyclerViewHolder3(View itemView, final Context context) {
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
