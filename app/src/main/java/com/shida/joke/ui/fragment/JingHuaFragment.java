package com.shida.joke.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.shida.joke.R;
import com.shida.joke.adapter.MainfragmentPagerAdapter;
import com.shida.joke.base.BaseFragment;
import com.shida.joke.ui.fragment.jinghua.BeautyFragment;
import com.shida.joke.ui.fragment.jinghua.GameFragment;
import com.shida.joke.ui.fragment.jinghua.PictureFragment;
import com.shida.joke.ui.fragment.jinghua.RankingFragment;
import com.shida.joke.ui.fragment.jinghua.RecommendFragment;
import com.shida.joke.ui.fragment.jinghua.SocietyFragment;
import com.shida.joke.ui.fragment.jinghua.TextFragment;
import com.shida.joke.ui.fragment.jinghua.VideoFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/8 0008.
 */
public class JingHuaFragment extends BaseFragment {

    PagerSlidingTabStrip tabs;
    ViewPager pager;

    ArrayList<Fragment> fragmentlist = new ArrayList<>();
    MainfragmentPagerAdapter pagerAdapter;

    public static JingHuaFragment newInstance() {
        JingHuaFragment jingHuaFragment = new JingHuaFragment();
        return jingHuaFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_jinghua;
    }

    @Override
    protected void initView() {

        RecommendFragment recommendFragment = RecommendFragment.newInstance();
        PictureFragment pictureFragment = PictureFragment.newInstance();
        TextFragment textFragment = TextFragment.newInstance();
        VideoFragment videoFragment = VideoFragment.newInstance();

        RankingFragment rankingFragment = RankingFragment.newInstance();
        SocietyFragment societyFragment = SocietyFragment.newInstance();
        BeautyFragment beautyFragment = BeautyFragment.newInstance();
        GameFragment gameFragment = GameFragment.newInstance();
        fragmentlist.add(recommendFragment);
        fragmentlist.add(pictureFragment);
        fragmentlist.add(textFragment);
        fragmentlist.add(videoFragment);

        fragmentlist.add(rankingFragment);
        fragmentlist.add(societyFragment);
        fragmentlist.add(beautyFragment);
        fragmentlist.add(gameFragment);

        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setOffscreenPageLimit(8);

        String[] title = { "推荐","图片", "段子","视频","排行","社会","美女","游戏"};
        pagerAdapter = new MainfragmentPagerAdapter(title,getChildFragmentManager(),fragmentlist);

        pager.setAdapter(pagerAdapter);
        tabs.setViewPager(pager);

    }
}
