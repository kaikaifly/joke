package com.shida.joke.ui.fragment.jinghua;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.shida.joke.NetApi;
import com.shida.joke.R;
import com.shida.joke.adapter.VideoAdapter;
import com.shida.joke.base.BaseFragment;
import com.shida.joke.bean.Video;
import com.shida.joke.event.BusProvider;
import com.shida.joke.event.ShowProgressBarEvent;
import com.shida.joke.event.StopProgressBarEvent;
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
 * Created by Administrator on 2016/2/29 0029.
 */
public class VideoFragment extends BaseFragment {

    @Bind(R.id.rotate_header_list_view_frame)
    PtrClassicFrameLayout mPtrFrame;
    @Bind(R.id.listView)
    ListView listView;
    VideoAdapter videoAdapter;


    String timestamp = "0";
    List<Video.ListEntity> videoList = new ArrayList<>();


    public static VideoFragment newInstance() {
        VideoFragment textFragment = new VideoFragment();
        return textFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        initRefreshView();
        getData();

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
//
//                // TODO: 2015/12/21 0021 加载更多
//                if (firstVisibleItem + visibleItemCount == totalItemCount - 6) {
//
//                }
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
        NetApi.getVideo(timestamp, new OkHttpClientManager.ResultCallback<Video>() {
            @Override
            public void onBefore(Request request) {
                BusProvider.getInstance().post(new ShowProgressBarEvent());
            }
            @Override
            public void onAfter() {
                BusProvider.getInstance().post(new StopProgressBarEvent());
            }
            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
                BusProvider.getInstance().post(new StopProgressBarEvent());
                mPtrFrame.refreshComplete();
                showToast("请求超时，请检查网络！");
            }
            @Override
            public void onResponse(Video response) {
                if (response != null) {
                    if (timestamp.equals("0")){
                        videoList.clear();
                        videoList = response.getList();
                        timestamp = String.valueOf(response.getInfo().getNp());
                        videoAdapter = new VideoAdapter(getActivity(), videoList);
                        listView.setAdapter(videoAdapter);
                        mPtrFrame.refreshComplete();
                    }else {
                        videoList.addAll(response.getList());
                        videoAdapter.notifyDataSetChanged();
                        timestamp = String.valueOf(response.getInfo().getNp());
                    }

                } else {
                    showToast("加载失败！");
                }


            }

        });
    }

}
