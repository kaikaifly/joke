package com.shida.joke.ui.fragment.xintie;

import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import com.shida.joke.NetApi;
import com.shida.joke.R;
import com.shida.joke.adapter.RecommendAdapter;
import com.shida.joke.base.BaseFragment;
import com.shida.joke.bean.Recommend;
import com.shida.joke.utils.OkHttpClientManager;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by Administrator on 2016/3/9 0009.
 */
public class VideoFragment extends BaseFragment {
    @Bind(R.id.rotate_header_list_view_frame)
    PtrClassicFrameLayout mPtrFrame;
    @Bind(R.id.listView)
    ListView listView;

    @Bind(R.id.button)
    Button button;
    RecommendAdapter recommendAdapter;

    String timestamp = "0";
    List<Recommend.ListEntity> recommendList = new ArrayList<>();

    public static VideoFragment newInstance() {
        VideoFragment videoFragment = new VideoFragment();
        return videoFragment;
    }
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {

        initRefreshView();
        mPtrFrame.autoRefresh();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPtrFrame.autoRefresh();
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
                        getData();
                    }
                }
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
    }

    private void initRefreshView() {
        mPtrFrame.setLastUpdateTimeRelateObject(this);
        mPtrFrame.setResistance(2.7f);
        mPtrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        mPtrFrame.setDurationToClose(200);
        mPtrFrame.setDurationToCloseHeader(1000);
        mPtrFrame.setPullToRefresh(false);
        mPtrFrame.setKeepHeaderWhenRefresh(true);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                timestamp = "0";
                getData();

            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });
    }


    private void getData() {
        NetApi.getVideo_xintie(timestamp, new OkHttpClientManager.ResultCallback<Recommend>() {
            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Recommend response) {
                if (response != null) {
                    if (timestamp.equals("0")) {
                        recommendList.clear();
                        recommendList = response.getList();
                        timestamp = String.valueOf(response.getInfo().getNp());
                        recommendAdapter = new RecommendAdapter(getActivity(), recommendList);
                        listView.setAdapter(recommendAdapter);
                        mPtrFrame.refreshComplete();

                    } else {
                        recommendList.addAll(response.getList());
                        recommendAdapter.notifyDataSetChanged();
                        timestamp = String.valueOf(response.getInfo().getNp());
                    }

                } else {
                    showToast("加载失败！");
                }


            }

        });
    }
}
