package com.shida.joke.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.shida.joke.R;
import com.shida.joke.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/2/29 0029.
 */
public class WelcomeActivity extends BaseActivity {
    @Bind(R.id.wel)
    ImageView wel;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        wel.postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        }, 1);

    }
}
