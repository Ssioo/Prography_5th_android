package com.pa1.prography_5th_android;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView detail_title;
    private TextView detail_description;
    private TextView detail_releasedate;
    private TextView detail_producer;
    private TextView detail_director;
    private TextView detail_rtscore;

    private Toolbar toolbar;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

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
        toolbar = findViewById(R.id.toolbar_detail);

        /* Intent 불러와서 Text Setting*/
        Intent newintent = getIntent();
        detail_title.setText(newintent.getExtras().getString("data_title"));
        detail_description.setText(newintent.getExtras().getString("data_description"));
        detail_director.setText("Directed By " + newintent.getExtras().getString("data_director"));
        detail_producer.setText("Produced By " + newintent.getExtras().getString("data_producer"));
        detail_releasedate.setText(newintent.getExtras().getString("data_releasedate"));
        detail_rtscore.setText("Score: " + String.valueOf(newintent.getExtras().getInt("data_rtscore")) + " / 100");

        /* ToolBar 구성 */
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(newintent.getExtras().getString("data_title"));



    }
}
