package com.shida.joke.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Toast;


import com.shida.joke.event.BusProvider;
import com.shida.joke.utils.SoftInputUtils;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    protected Context context;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BusProvider.getInstance().register(this);
        context = this;
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        initView(savedInstanceState);
    }
    protected void showToast(String message) {
        if (toast != null) {
            toast.setText(message);
        } else {
            toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        }
        toast.show();
    }
    protected abstract int getLayoutResId();
    protected abstract void initView(Bundle savedInstanceState);

//
//    @Override
//    public void startActivity(Intent intent) {
//        super.startActivity(intent);
//        overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
//    }
//
//    @Override
//    public void startActivityForResult(Intent intent, int requestCode) {
//        super.startActivityForResult(intent, requestCode);N
//        overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
//    }


//    @Override
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.push_left_in, R.anim.push_right_out);
//    }
    public static Boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            SoftInputUtils.hideSoftInput(this);
        return super.onTouchEvent(event);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }

}