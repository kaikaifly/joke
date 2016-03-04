package com.shida.joke.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;
import com.shida.joke.R;
import com.shida.joke.adapter.MainfragmentPagerAdapter;
import com.shida.joke.ui.fragment.PictureFragment;
import com.shida.joke.ui.fragment.RecommendFragment;
import com.shida.joke.ui.fragment.TextFragment;
import com.shida.joke.ui.fragment.VideoFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    @Bind(R.id.tabs)
    PagerSlidingTabStrip tabs;
//    @Bind(R.id.pager)
    ViewPager pager;

    ArrayList<Fragment>  fragmentlist = new ArrayList<>();
    MainfragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecommendFragment recommendFragment = RecommendFragment.newInstance();
        PictureFragment pictureFragment = PictureFragment.newInstance();
        TextFragment textFragment = TextFragment.newInstance();
        VideoFragment videoFragment = VideoFragment.newInstance();

        fragmentlist.add(recommendFragment);
        fragmentlist.add(pictureFragment);
        fragmentlist.add(textFragment);
        fragmentlist.add(videoFragment);

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        pagerAdapter = new MainfragmentPagerAdapter(getSupportFragmentManager(),fragmentlist);

        pager.setAdapter(pagerAdapter);
        tabs.setViewPager(pager);



    }
}
