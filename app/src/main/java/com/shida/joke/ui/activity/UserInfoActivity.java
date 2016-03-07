package com.shida.joke.ui.activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.shida.joke.NetApi;
import com.shida.joke.R;
import com.shida.joke.adapter.RecommendAdapter;
import com.shida.joke.base.BaseActivity;
import com.shida.joke.bean.Recommend;
import com.shida.joke.bean.UserInfo;
import com.shida.joke.utils.GlideCircleTransform;
import com.shida.joke.utils.OkHttpClientManager;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
/**
 * Created by Administrator on 2016/3/7 0007.
 */
public class UserInfoActivity extends BaseActivity {
    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.title_name)
    TextView title_name;
//    @Bind(R.id.background_image)
//    ImageView background_image;
//    @Bind(R.id.sex_bg)
//    ImageView sex_bg;
//    @Bind(R.id.headPic)
//    ImageView headPic;
//    @Bind(R.id.name)
//    TextView name;
//    @Bind(R.id.sex)
//    TextView sex;
//    @Bind(R.id.lv)
//    TextView lv;
//    @Bind(R.id.jifen)
//    TextView jifen;
//    @Bind(R.id.guanzhu_count)
//    TextView guanzhu_count;
//    @Bind(R.id.fans_count)
//    TextView fans_count;
//    @Bind(R.id.introduction)
//    TextView introduction;
//
//    @Bind(R.id.tiezi)
//    LinearLayout tiezi;
//    @Bind(R.id.shared)
//    LinearLayout shared;
//    @Bind(R.id.comment)
//    LinearLayout comment;
//
//    @Bind(R.id.tiezi_count)
//    TextView tiezi_count;
//    @Bind(R.id.shared_count)
//    TextView shared_count;
//    @Bind(R.id.comment_count)
//    TextView comment_count;
//
//    @Bind(R.id.tiezi_text)
//    TextView tiezi_text;
//    @Bind(R.id.shared_text)
//    TextView shared_text;
//    @Bind(R.id.comment_text)
//    TextView comment_text;
//
//    @Bind(R.id.tiezi_bg)
//    ImageView tiezi_bg;
//    @Bind(R.id.shared_bg)
//    ImageView shared_bg;
//    @Bind(R.id.comment_bg)
//    ImageView comment_bg;


    ImageView background_image;
    ImageView sex_bg;
    ImageView headPic;
    TextView name;
    TextView sex;
    TextView lv;
    TextView jifen;
    TextView guanzhu_count;
    TextView fans_count;
    TextView introduction;

    LinearLayout tiezi;
    LinearLayout shared;
    LinearLayout comment;

    TextView tiezi_count;
    TextView shared_count;
    TextView comment_count;

    TextView tiezi_text;
    TextView shared_text;
    TextView comment_text;

    ImageView tiezi_bg;
    ImageView shared_bg;
    ImageView comment_bg;

    View view;

    @Bind(R.id.listView)
    ListView listView;

//    @Bind(R.id.headView)
//    LinearLayout headView;

    private String userid;

    public String timestamp = "0";
    List<Recommend.ListEntity> recommendList = new ArrayList<>();
    RecommendAdapter recommendAdapter = new RecommendAdapter(context, recommendList);
    private int flag = 1;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_userinfo;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        view = LayoutInflater.from(context).inflate(R.layout.activity_userinfo_headview, null);

//        back = (ImageView) view.findViewById(R.id.back);
//        title_name = (TextView) view.findViewById(R.id.title_name);
        background_image = (ImageView) view.findViewById(R.id.background_image);
        sex_bg = (ImageView) view.findViewById(R.id.sex_bg);
        headPic = (ImageView) view.findViewById(R.id.headPic);
        name = (TextView) view.findViewById(R.id.name);
        sex = (TextView) view.findViewById(R.id.sex);
        lv = (TextView) view.findViewById(R.id.lv);
        jifen = (TextView) view.findViewById(R.id.jifen);
        guanzhu_count = (TextView) view.findViewById(R.id.guanzhu_count);
        fans_count  = (TextView) view.findViewById(R.id.fans_count);
        introduction = (TextView) view.findViewById(R.id.introduction);

        tiezi = (LinearLayout) view.findViewById(R.id.tiezi);
        shared = (LinearLayout) view.findViewById(R.id.shared);
        comment = (LinearLayout) view.findViewById(R.id.comment);

        tiezi_count = (TextView) view.findViewById(R.id.tiezi_count);
        shared_count= (TextView) view.findViewById(R.id.shared_count);
        comment_count = (TextView) view.findViewById(R.id.comment_count);

        tiezi_text = (TextView) view.findViewById(R.id.tiezi_text);
        shared_text = (TextView) view.findViewById(R.id.shared_text);
        comment_text = (TextView) view.findViewById(R.id.comment_text);

        tiezi_bg = (ImageView) view.findViewById(R.id.tiezi_bg);
        shared_bg = (ImageView) view.findViewById(R.id.shared_bg);
        comment_bg = (ImageView) view.findViewById(R.id.comment_bg);


        userid = getIntent().getStringExtra("userid");

        getUserTiezi();

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                // 当不滚动时
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    // 判断是否滚动到底部
                    if (view.getLastVisiblePosition() == view.getCount() - 1) {
                        //加载更多功能的代码

                        if (flag == 1){
                            getUserTiezi();
                        }else if (flag == 2){
                            getUserShared();
                        }else if (flag == 3){
                            getUserComment();
                        }
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        tiezi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag = 1;
                shared_text.setTextColor(getResources().getColor(R.color.grey));
                shared_count.setTextColor(getResources().getColor(R.color.grey));
                shared_bg.setBackgroundColor(getResources().getColor(R.color.white));

                comment_text.setTextColor(getResources().getColor(R.color.grey));
                comment_count.setTextColor(getResources().getColor(R.color.grey));
                comment_bg.setBackgroundColor(getResources().getColor(R.color.white));

                tiezi_text.setTextColor(getResources().getColor(R.color.red));
                tiezi_count.setTextColor(getResources().getColor(R.color.red));
                tiezi_bg.setBackgroundColor(getResources().getColor(R.color.red));

                recommendList.clear();
                recommendAdapter.notifyDataSetChanged();
                timestamp = "0";
                getUserTiezi();

            }
        });

        shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 2;

                comment_text.setTextColor(getResources().getColor(R.color.grey));
                comment_count.setTextColor(getResources().getColor(R.color.grey));
                comment_bg.setBackgroundColor(getResources().getColor(R.color.white));

                tiezi_text.setTextColor(getResources().getColor(R.color.grey));
                tiezi_count.setTextColor(getResources().getColor(R.color.grey));
                tiezi_bg.setBackgroundColor(getResources().getColor(R.color.white));

                shared_text.setTextColor(getResources().getColor(R.color.red));
                shared_count.setTextColor(getResources().getColor(R.color.red));
                shared_bg.setBackgroundColor(getResources().getColor(R.color.red));

                recommendList.clear();
                recommendAdapter.notifyDataSetChanged();
                timestamp = "0";
                getUserShared();
            }
        });

        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 3;

                tiezi_text.setTextColor(getResources().getColor(R.color.grey));
                tiezi_count.setTextColor(getResources().getColor(R.color.grey));
                tiezi_bg.setBackgroundColor(getResources().getColor(R.color.white));

                shared_text.setTextColor(getResources().getColor(R.color.grey));
                shared_count.setTextColor(getResources().getColor(R.color.grey));
                shared_bg.setBackgroundColor(getResources().getColor(R.color.white));

                comment_text.setTextColor(getResources().getColor(R.color.red));
                comment_count.setTextColor(getResources().getColor(R.color.red));
                comment_bg.setBackgroundColor(getResources().getColor(R.color.red));

                recommendList.clear();
                recommendAdapter.notifyDataSetChanged();
                timestamp = "0";
                getUserComment();
            }
        });












        NetApi.getUserInfo(userid, new OkHttpClientManager.ResultCallback<UserInfo>() {
            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(UserInfo response) {
                if (response != null) {
                    UserInfo.DataEntity dataEntity = response.getData();
                    Glide.with(context)
                            .load(dataEntity.getBackground_image())
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .placeholder(R.mipmap.ic_launcher)
                            .into(background_image);

                    Glide.with(context)
                            .load(dataEntity.getProfile_image_large())
                            .transform(new GlideCircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .placeholder(R.mipmap.ic_launcher)
                            .into(headPic);

                    Glide.with(context)
                            .load(R.drawable.sex_bg)
                            .transform(new GlideCircleTransform(context))
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .placeholder(R.mipmap.ic_launcher)
                            .into(sex_bg);
                    name.setText(dataEntity.getUsername());
                    title_name.setText(dataEntity.getUsername());
                    if (dataEntity.getSex().equals("f")) {
                        sex.setText("♀");
                    } else {
                        sex.setText("♂");
                    }

                    lv.setText("等级：LV" + String.valueOf(dataEntity.getLevel()) + "");
                    jifen.setText("积分：" + String.valueOf(dataEntity.getCredit()));
                    guanzhu_count.setText(String.valueOf(dataEntity.getFollow_count()));
                    fans_count.setText(String.valueOf(dataEntity.getFans_count()));
                    introduction.setText(dataEntity.getIntroduction());

                    tiezi_count.setText(String.valueOf(dataEntity.getTiezi_count()));
                    shared_count.setText(String.valueOf(dataEntity.getShare_count()));
                    comment_count.setText(String.valueOf(dataEntity.getComment_count()));
                }
            }
        });
    }

    private void getUserTiezi(){
        NetApi.getUserTiezi(timestamp, userid, new OkHttpClientManager.ResultCallback<Recommend>() {
            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Recommend response) {
                if (response != null){

                    if (timestamp.equals("0")) {
                        recommendList.clear();
                        recommendList = response.getList();
                        timestamp = String.valueOf(response.getInfo().getNp());
                        recommendAdapter = new RecommendAdapter(context, recommendList);
                        listView.removeHeaderView(view);
                        listView.addHeaderView(view);
                        listView.setAdapter(recommendAdapter);
                    } else {
                        recommendList.addAll(response.getList());
                        recommendAdapter.notifyDataSetChanged();
                        timestamp = String.valueOf(response.getInfo().getNp());
                    }
                }
            }
        });
    }


    private void getUserShared(){
        NetApi.getUserShared(timestamp, userid, new OkHttpClientManager.ResultCallback<Recommend>() {
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
                        recommendAdapter = new RecommendAdapter(context, recommendList);
                        listView.removeHeaderView(view);
                        listView.addHeaderView(view);
                        listView.setAdapter(recommendAdapter);
                    } else {
                        recommendList.addAll(response.getList());
                        recommendAdapter.notifyDataSetChanged();
                        timestamp = String.valueOf(response.getInfo().getNp());
                    }
                }
            }
        });
    }


    private void getUserComment() {
        NetApi.getUserComment(timestamp, userid, new OkHttpClientManager.ResultCallback<Recommend>() {
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
                        recommendAdapter = new RecommendAdapter(context, recommendList);
                        listView.removeHeaderView(view);
                        listView.addHeaderView(view);
                        listView.setAdapter(recommendAdapter);
                    } else {
                        recommendList.addAll(response.getList());
                        recommendAdapter.notifyDataSetChanged();
                        timestamp = String.valueOf(response.getInfo().getNp());
                    }
                }
            }
        });
    }
}
