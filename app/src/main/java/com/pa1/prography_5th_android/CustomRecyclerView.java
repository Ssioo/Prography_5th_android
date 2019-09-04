package com.pa1.prography_5th_android;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomRecyclerView extends RecyclerView.Adapter<CustomRecyclerView.CustomItemViewHolder> {

    private ArrayList<JSONData> jsondata;
    private boolean delayEnterAnimation = true;
    private boolean animationsLocked = false;

    public CustomRecyclerView(ArrayList<JSONData> jsondata) {
        this.jsondata = jsondata;
    }

    @NonNull
    @Override
    public CustomItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);

        /* 리스트 드로우 Animation */
        if (!animationsLocked) {
            view.setTranslationY(100);
            view.setAlpha(0.f);
            view.animate().translationY(0).alpha(1.f).setStartDelay(delayEnterAnimation ? 20 * (i) : 0)
                    .setInterpolator(new DecelerateInterpolator(2.f))
                    .setDuration(300)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            animationsLocked = true;
                        }
                    })
                    .start();
        }
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


        public CustomItemViewHolder(@NonNull final View itemView) {
            super(itemView);

            num = itemView.findViewById(R.id.item_num);
            title = itemView.findViewById(R.id.item_title);
            director = itemView.findViewById(R.id.item_director);
            release_date = itemView.findViewById(R.id.item_releasedate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /* DetailActivity intent 호출 */
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    int pos = getAdapterPosition();
                    intent.putExtra("data_num", jsondata.get(pos).getNum());
                    intent.putExtra("data_title", jsondata.get(pos).getTitle());
                    intent.putExtra("data_description", jsondata.get(pos).getDescription());
                    intent.putExtra("data_director", jsondata.get(pos).getDirector());
                    intent.putExtra("data_producer", jsondata.get(pos).getProducer());
                    intent.putExtra("data_releasedate", jsondata.get(pos).getRelease_date());
                    intent.putExtra("data_rtscore", jsondata.get(pos).getRt_score());
                    itemView.getContext().startActivity(intent);
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
