package com.shida.joke.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.shida.joke.NetApi;
import com.shida.joke.R;
import com.shida.joke.adapter.CommentAdapter;
import com.shida.joke.base.BaseActivity;
import com.shida.joke.bean.Comment;
import com.shida.joke.utils.OkHttpClientManager;
import com.squareup.okhttp.Request;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/3/3 0003.
 */
public class CommentActivity extends BaseActivity {
    @Bind(R.id.listView)
    ListView listView;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_comment;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        Log.e(".......", getIntent().getStringExtra("dataId"));
        NetApi.getComment(getIntent().getStringExtra("dataId"), "1", new OkHttpClientManager.ResultCallback<Comment>() {
            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Comment response) {
                if (response != null){
                    CommentAdapter commentAdapter = new CommentAdapter(context, response.getData());
                    listView.setAdapter(commentAdapter);
                }
            }
        });

    }
}
