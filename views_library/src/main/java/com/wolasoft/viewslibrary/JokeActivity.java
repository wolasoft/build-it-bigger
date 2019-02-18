package com.wolasoft.viewslibrary;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.wolasoft.viewslibrary.databinding.ActivityJokeBinding;

public class JokeActivity extends AppCompatActivity {

    public static String KEY_JOKE = "KEY_JOKE";
    private String jokeText;
    private ActivityJokeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_joke);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras.containsKey(KEY_JOKE)) {
            jokeText = extras.getString(KEY_JOKE, "");
            mBinding.jokeTV.setText(jokeText);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
