package com.cfg.team12.makeawish;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class ReferredList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referred_list);
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

        //ArrayList<Weather> weather = new ArrayList<>();
        ArrayList<Bitmap> forecasrArrayList = new ArrayList<>();


        RecyclerViewAdapter(ArrayList<Weather> weatherArrayList, ArrayList<Bitmap> forecastList) {
            weather = weatherArrayList;
            forecasrArrayList = forecastList;
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_weekly, parent, false);
            return new RecyclerViewHolder(view, parent.getContext());
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            //tomorrow needs an image
            if (position == 1) {
                MainActivity.tomorrowFragment.setImage(forecasrArrayList.get(position));
            }
            String date = (new Date(weather.get(position).getDate() * 1000L)).toString();
            //Log.e("TAG",date);
            date = date.substring(0, 3) + ", " + date.substring(4, 10);
            holder.txtDate.setText("" + date);
            if (MainActivity.temp) {
                holder.txtTemp.setText("" + Math.round(weather.get(position).temperature.getTemp() - 273.15) + "℃");


            } else {
                double a = (weather.get(position).temperature.getTemp() - 273.15) * 9 / 5;
                long val = Math.round((a + 32));
                holder.txtTemp.setText("" + (val + "°F"));


            }
            String str = weather.get(position).currentCondition.getDescr();
            String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
            holder.txtWeather.setText("" + cap);

            holder.imageView.setImageBitmap(forecasrArrayList.get(position));
        }


        @Override
        public int getItemCount() {
            return weather.size();
        }

        class RecyclerViewHolder extends RecyclerView.ViewHolder {

            protected TextView txtDate, txtWeather, txtTemp;
            protected ImageView imageView;

            public RecyclerViewHolder(View itemView, final Context context) {
                super(itemView);
                txtDate = (TextView) itemView.findViewById(R.id.txt_date);

                txtWeather = (TextView) itemView.findViewById(R.id.txt_weather);

                imageView = (ImageView) itemView.findViewById(R.id.img_dash);
                txtTemp = (TextView) itemView.findViewById(R.id.txt_temp);

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
