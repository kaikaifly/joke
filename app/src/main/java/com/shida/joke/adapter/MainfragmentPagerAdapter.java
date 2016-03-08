package com.shida.joke.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/2/29 0029.
 */
public class MainfragmentPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentList;
    private final String[] TITLES = { "推荐","图片", "段子","视频","排行","社会","美女","游戏"};
    Context context;

    public MainfragmentPagerAdapter(Context context,FragmentManager fm, ArrayList<Fragment> fragmentList) {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
