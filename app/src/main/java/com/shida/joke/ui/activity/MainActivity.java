package com.shida.joke.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;
import com.shida.joke.R;
import com.shida.joke.adapter.MainfragmentPagerAdapter;
import com.shida.joke.ui.fragment.jinghua.BeautyFragment;
import com.shida.joke.ui.fragment.jinghua.GameFragment;
import com.shida.joke.ui.fragment.jinghua.PictureFragment;
import com.shida.joke.ui.fragment.jinghua.RankingFragment;
import com.shida.joke.ui.fragment.jinghua.RecommendFragment;
import com.shida.joke.ui.fragment.jinghua.SocietyFragment;
import com.shida.joke.ui.fragment.jinghua.TextFragment;
import com.shida.joke.ui.fragment.jinghua.VideoFragment;

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

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(8);

        String[] title = { "推荐","图片", "段子","视频","排行","社会","美女","游戏"};
        pagerAdapter = new MainfragmentPagerAdapter(title,getSupportFragmentManager(),fragmentlist);

        pager.setAdapter(pagerAdapter);
        tabs.setViewPager(pager);



    }
}
