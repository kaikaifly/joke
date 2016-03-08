package com.shida.joke.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;

import com.shida.joke.NetApi;
import com.shida.joke.R;
import com.shida.joke.adapter.CommentAdapter;
import com.shida.joke.base.BaseActivity;
import com.shida.joke.bean.Comment;
import com.shida.joke.utils.OkHttpClientManager;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/3/3 0003.
 */
public class CommentActivity extends BaseActivity {
    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.listView)
    ListView listView;

    CommentAdapter commentAdapter;
    List<Comment.DataEntity> commentList = new ArrayList<>();
    int page = 1;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_comment;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        getData();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                // 当不滚动时
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    // 判断是否滚动到底部
                    if (view.getLastVisiblePosition() == view.getCount() - 1) {
                        //加载更多功能的代码
                        page = page + 1;
                        getData();
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
    }

    private void getData(){
        NetApi.getComment(getIntent().getStringExtra("dataId"), String.valueOf(page), new OkHttpClientManager.ResultCallback<Comment>() {
            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Comment response) {
                if (response.getData() != null){
                    if (page == 1){
                        commentList.clear();
                        commentList = response.getData();
                        commentAdapter = new CommentAdapter(context, commentList);
                        listView.setAdapter(commentAdapter);
                    }else {
                        commentList.addAll(response.getData());
                        commentAdapter.notifyDataSetChanged();
                    }

                }
            }
        });
    }
}
