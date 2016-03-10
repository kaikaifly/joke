package com.shida.joke.ui.fragment;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.shida.joke.R;
import com.shida.joke.adapter.MainfragmentPagerAdapter;
import com.shida.joke.base.BaseFragment;
import com.shida.joke.ui.fragment.xintie.AllFragment;
import com.shida.joke.ui.fragment.xintie.BeautyFragment;
import com.shida.joke.ui.fragment.xintie.GameFragment;
import com.shida.joke.ui.fragment.xintie.PictureFragment;
import com.shida.joke.ui.fragment.xintie.SportsFragment;
import com.shida.joke.ui.fragment.xintie.TextFragment;
import com.shida.joke.ui.fragment.xintie.VideoFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/8 0008.
 */
public class XinTieFragment extends BaseFragment {

    PagerSlidingTabStrip tabs;
    ViewPager pager;

    ArrayList<Fragment> fragmentlist = new ArrayList<>();
    MainfragmentPagerAdapter pagerAdapter;

    public static XinTieFragment newInstance() {
        XinTieFragment xinTieFragment = new XinTieFragment();
        return xinTieFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_xintie;
    }

    @Override
    protected void initView() {
        AllFragment allFragment = AllFragment.newInstance();
        VideoFragment videoFragment = VideoFragment.newInstance();
        PictureFragment pictureFragment = PictureFragment.newInstance();
        TextFragment textFragment = TextFragment.newInstance();
        BeautyFragment beautyFragment = BeautyFragment.newInstance();
        GameFragment gameFragment = GameFragment.newInstance();
        SportsFragment sportsFragment = SportsFragment.newInstance();

        fragmentlist.add(allFragment);
        fragmentlist.add(videoFragment);
        fragmentlist.add(pictureFragment);
        fragmentlist.add(textFragment);
        fragmentlist.add(beautyFragment);
        fragmentlist.add(gameFragment);
        fragmentlist.add(sportsFragment);


        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setOffscreenPageLimit(8);
        tabs.setTextSize(40);
        tabs.setTextColor(getResources().getColor(R.color.tabs_black));
        tabs.setTypeface(Typeface.create(Typeface.SERIF, Typeface.NORMAL), Typeface.NORMAL);

        String[] title = {"全部", "视频", "图片", "段子", "美女", "游戏", "体育"};
        pagerAdapter = new MainfragmentPagerAdapter(title, getChildFragmentManager(), fragmentlist);

        pager.setAdapter(pagerAdapter);
        tabs.setViewPager(pager);

    }
}
