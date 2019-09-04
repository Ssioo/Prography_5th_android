package com.pa1.prography_5th_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView detail_title;
    private TextView detail_description;
    private TextView detail_releasedate;
    private TextView detail_producer;
    private TextView detail_director;
    private TextView detail_rtscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /* findViewById */
        detail_title = findViewById(R.id.detail_title);
        detail_description = findViewById(R.id.detail_description);
        detail_director = findViewById(R.id.detail_director);
        detail_producer = findViewById(R.id.detail_producer);
        detail_releasedate = findViewById(R.id.detail_releasedate);
        detail_rtscore = findViewById(R.id.detail_rtscore);

        Intent newintent = getIntent();
        detail_title.setText(newintent.getExtras().getString("data_title"));
        detail_description.setText(newintent.getExtras().getString("data_description"));
        detail_director.setText("Directed By " + newintent.getExtras().getString("data_director"));
        detail_producer.setText("Produced By " + newintent.getExtras().getString("data_producer"));
        detail_releasedate.setText(newintent.getExtras().getString("data_releasedate"));
        detail_rtscore.setText("Score: " + String.valueOf(newintent.getExtras().getInt("data_rtscore")) + " / 100");
    }
}
