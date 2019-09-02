package com.pa1.prography_5th_android;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomRecyclerView extends RecyclerView.Adapter<CustomRecyclerView.CustomItemViewHolder> {

    private ArrayList<JSONData> jsondata;

    public CustomRecyclerView(ArrayList<JSONData> jsondata) {
        this.jsondata = jsondata;
    }

    @NonNull
    @Override
    public CustomItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);
        return new CustomItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomItemViewHolder customItemViewHolder, int i) {
        customItemViewHolder.onBind(jsondata.get(i));
    }

    @Override
    public int getItemCount() {
        return jsondata.size();
    }

    public class CustomItemViewHolder extends RecyclerView.ViewHolder {
        private TextView num;
        private TextView title;
        private TextView director;
        private TextView release_date;


        public CustomItemViewHolder(@NonNull View itemView) {
            super(itemView);

            num = itemView.findViewById(R.id.item_num);
            title = itemView.findViewById(R.id.item_title);
            director = itemView.findViewById(R.id.item_director);
            release_date = itemView.findViewById(R.id.item_releasedate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /* intent 예정 */
                }
            });
        }

        public void onBind(JSONData data) {
            num.setText(String.valueOf(data.getNum()));
            title.setText(data.getTitle());
            director.setText(data.getDirector());
            release_date.setText(data.getRelease_date());
        }
    }
}
