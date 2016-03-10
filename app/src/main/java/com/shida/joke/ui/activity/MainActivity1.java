package com.shida.joke.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.shida.joke.R;
import com.shida.joke.base.BaseActivity;
import com.shida.joke.ui.fragment.ChuanYueFragment;
import com.shida.joke.ui.fragment.JingHuaFragment;
import com.shida.joke.ui.fragment.XinTieFragment;
import com.shida.joke.ui.fragment.xintie.MineFragment;

import butterknife.Bind;
import cn.sharesdk.framework.ShareSDK;

/**
 * Created by Administrator on 2016/3/8 0008.
 */
public class MainActivity1 extends BaseActivity {
    @Bind(R.id.rbRoot)
    RadioGroup rbRoot;
    @Bind(R.id.rbJingHua)
    RadioButton rbJingHua;
    @Bind(R.id.rbXinTie)
    RadioButton rbXinTie;
    @Bind(R.id.rbChuanYue)
    RadioButton rbChuanYue;
    @Bind(R.id.rbMine)
    RadioButton rbMine;

    JingHuaFragment jingHuaFragment;
    XinTieFragment xinTieFragment;
    ChuanYueFragment chuanYueFragment;
    MineFragment mineFragment;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main1;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ShareSDK.initSDK(this);
        initTab();
    }

    private void initTab() {
        rbRoot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbJingHua:
                        setTabSelect(0);
                        break;
                    case R.id.rbXinTie:
                        setTabSelect(1);
                        break;
                    case R.id.rbChuanYue:
                        setTabSelect(2);
                        break;
                    case R.id.rbMine:
                        setTabSelect(3);
                        break;
//                    case R.id.rbMine:
//                        setTabSelect(4);
//                        break;
                }
            }

        });
        rbJingHua.performClick();
    }

    public void setTabSelect(int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        rbJingHua.setTextColor(getResources().getColor(R.color.grey_normal));
        rbXinTie.setTextColor(getResources().getColor(R.color.grey_normal));
        rbChuanYue.setTextColor(getResources().getColor(R.color.grey_normal));
        rbMine.setTextColor(getResources().getColor(R.color.grey_normal));

        switch (i) {
            case 0:
                rbJingHua.setTextColor(getResources().getColor(R.color.grey_press));
                jingHuaFragment = (JingHuaFragment) fragmentManager.findFragmentByTag("TAG1");
                hideTab(transaction);
                if (jingHuaFragment == null) {
                    jingHuaFragment = JingHuaFragment.newInstance();
                    transaction.add(R.id.content, jingHuaFragment, "TAG1");
                } else {
                    transaction.show(jingHuaFragment);
                }
                break;
            case 1:
                rbXinTie.setTextColor(getResources().getColor(R.color.grey_press));
                xinTieFragment = (XinTieFragment) fragmentManager.findFragmentByTag("TAG2");
                hideTab(transaction);
                if (xinTieFragment == null) {
                    xinTieFragment = XinTieFragment.newInstance();
                    transaction.add(R.id.content, xinTieFragment, "TAG2");
                } else {
                    transaction.show(xinTieFragment);
                }
                break;
            case 2:
                rbChuanYue.setTextColor(getResources().getColor(R.color.grey_press));
                chuanYueFragment = (ChuanYueFragment) fragmentManager.findFragmentByTag("TAG3");
                hideTab(transaction);
                if (chuanYueFragment == null) {
                    chuanYueFragment = ChuanYueFragment.newInstance();
                    transaction.add(R.id.content, chuanYueFragment, "TAG3");
                } else {
                    transaction.show(chuanYueFragment);
                }
                break;
            case 3:

                rbMine.setTextColor(getResources().getColor(R.color.grey_press));
                mineFragment = (MineFragment) fragmentManager.findFragmentByTag("TAG4");
                hideTab(transaction);
                if (mineFragment == null) {
                    mineFragment = MineFragment.newInstance();
                    transaction.add(R.id.content, mineFragment, "TAG4");
                } else {
                    transaction.show(mineFragment);

                }

                break;
//            case 4:
//                rbMine.setTextColor(getResources().getColor(R.color.red));
//                mineFragment = (MineFragment) fragmentManager.findFragmentByTag("TAG5");
//                hideTab(transaction);
//                if (mineFragment == null) {
//                    mineFragment = MineFragment.newInstance();
//                    transaction.add(R.id.content, mineFragment, "TAG5");
//                } else {
//                    transaction.show(mineFragment);
//                }
//                break;
        }
        transaction.commit();
    }

    private void hideTab(FragmentTransaction transaction) {
        if (jingHuaFragment != null) {
            transaction.hide(jingHuaFragment);
        }
        if (xinTieFragment != null) {
            transaction.hide(xinTieFragment);
        }
        if (chuanYueFragment != null) {
            transaction.hide(chuanYueFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
//        if (findFragment != null) {
//            transaction.hide(findFragment);
//        }
    }

    @Override
    protected void onDestroy() {
        ShareSDK.stopSDK(this);
        super.onDestroy();
    }
}
