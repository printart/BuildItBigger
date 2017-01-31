package com.example.nx.androidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.TextView;


public class AndroidLibActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_lib);
        TextView showJokeTextView = (TextView) findViewById(R.id.lib_show_joke_text_view);
        String joke = getIntent().getStringExtra("joke_data");
        if (TextUtils.isEmpty(joke)){
            showJokeTextView.setText(getString(R.string.error_message));
        }else {
            showJokeTextView.setText(joke);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
