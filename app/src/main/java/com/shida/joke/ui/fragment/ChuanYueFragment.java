package com.shida.joke.ui.fragment;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.shida.joke.R;
import com.shida.joke.adapter.MainfragmentPagerAdapter;
import com.shida.joke.base.BaseFragment;
import com.shida.joke.ui.fragment.chuanyue.AllFragment;
import com.shida.joke.ui.fragment.chuanyue.PictureFragment;
import com.shida.joke.ui.fragment.chuanyue.TextFragment;
import com.shida.joke.ui.fragment.chuanyue.VideoFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/9 0009.
 */
public class ChuanYueFragment extends BaseFragment {
    PagerSlidingTabStrip tabs;
    ViewPager pager;

    ArrayList<Fragment> fragmentlist = new ArrayList<>();
    MainfragmentPagerAdapter pagerAdapter;

    public static ChuanYueFragment newInstance() {
        ChuanYueFragment chuanYueFragment = new ChuanYueFragment();
        return chuanYueFragment;
    }
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_chuanyue;
    }

    @Override
    protected void initView() {
        AllFragment allFragment = AllFragment.newInstance();
        VideoFragment videoFragment = VideoFragment.newInstance();
        PictureFragment pictureFragment = PictureFragment.newInstance();
        TextFragment textFragment = TextFragment.newInstance();


        fragmentlist.add(allFragment);
        fragmentlist.add(videoFragment);
        fragmentlist.add(pictureFragment);
        fragmentlist.add(textFragment);



        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setOffscreenPageLimit(8);

        tabs.setTextSize(40);
        tabs.setTextColor(getResources().getColor(R.color.tabs_black));
        tabs.setTypeface(Typeface.create(Typeface.SERIF, Typeface.NORMAL), Typeface.NORMAL);

        String[] title = { "全部","视频","图片", "段子"};
        pagerAdapter = new MainfragmentPagerAdapter(title,getChildFragmentManager(),fragmentlist);

        pager.setAdapter(pagerAdapter);
        tabs.setViewPager(pager);

    }
}
