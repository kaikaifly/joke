package com.shida.joke.ui.fragment.chuanyue;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.shida.joke.NetApi;
import com.shida.joke.R;
import com.shida.joke.adapter.RecommendAdapter;
import com.shida.joke.base.BaseFragment;
import com.shida.joke.bean.Recommend;
import com.shida.joke.event.BusProvider;
import com.shida.joke.event.ShowProgressBarEvent;
import com.shida.joke.event.StopProgressBarEvent;
import com.shida.joke.utils.OkHttpClientManager;
import com.shida.joke.utils.ToastUtils;
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
public class AllFragment extends BaseFragment {
    @Bind(R.id.rotate_header_list_view_frame)
    PtrClassicFrameLayout mPtrFrame;
    @Bind(R.id.listView)
    ListView listView;


    RecommendAdapter recommendAdapter;

    String timestamp = "0";
    List<Recommend.ListEntity> recommendList = new ArrayList<>();

    public static AllFragment newInstance() {
        AllFragment allFragment = new AllFragment();
        return allFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.listview_chuanyue_footerview, null);
        listView.addFooterView(view);
        TextView again = (TextView) view.findViewById(R.id.again);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData1();
            }
        });
        initRefreshView();
        mPtrFrame.autoRefresh();

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                // 当不滚动时
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    // 判断是否滚动到底部
                    if (view.getLastVisiblePosition() == view.getCount() - 1) {
                        //加载更多功能的代码

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
        NetApi.getAll_chuanyue(timestamp, new OkHttpClientManager.ResultCallback<Recommend>() {
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
            public void onResponse(Recommend response) {
                if (response != null) {
                    if (timestamp.equals("0")) {
                        recommendList.clear();
                        recommendList = response.getList();
                        timestamp = String.valueOf(response.getInfo().getNp());
                        recommendAdapter = new RecommendAdapter(getActivity(), recommendList);

                        listView.setAdapter(recommendAdapter);
                        mPtrFrame.refreshComplete();
                        if (mPtrFrame.isAutoRefresh()) {

                        } else {
                            ToastUtils.createToastConfig().ToastShow(getContext(), "随机穿越到" + response.getList().get(0).getPasstime().substring(0, 10));
                        }
                    }
                } else {
                    showToast("加载失败！");
                }
            }
        });
    }

    private void getData1() {
        NetApi.getAll_chuanyue(timestamp, new OkHttpClientManager.ResultCallback<Recommend>() {
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
                        ToastUtils.createToastConfig().ToastShow(getContext(), "随机穿越到" + response.getList().get(0).getPasstime().substring(0, 10));
                    }

                } else {
                    showToast("加载失败！");
                }

            }

        });
    }
}
