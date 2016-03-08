package com.shida.joke.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.shida.joke.R;
import com.shida.joke.base.BaseActivity;
import com.shida.joke.ui.fragment.JingHuaFragment;
import com.shida.joke.ui.fragment.XinTieFragment;

import butterknife.Bind;

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
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main1;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
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
//                    case R.id.rbXinTie:
//                        setTabSelect(2);
//                        break;
//                    case R.id.rbShopCart:
//                        setTabSelect(3);
//                        break;
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
//        rbHome.setTextColor(getResources().getColor(R.color.white));
//        rbClass.setTextColor(getResources().getColor(R.color.white));
//        rbFind.setTextColor(getResources().getColor(R.color.white));
//        rbShopCart.setTextColor(getResources().getColor(R.color.white));
//        rbMine.setTextColor(getResources().getColor(R.color.white));

        switch (i) {
            case 0:
//                rbHome.setTextColor(getResources().getColor(R.color.red));
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
//                rbClass.setTextColor(getResources().getColor(R.color.red));
                xinTieFragment = (XinTieFragment) fragmentManager.findFragmentByTag("TAG2");
                hideTab(transaction);
                if (xinTieFragment == null) {
                    xinTieFragment = XinTieFragment.newInstance();
                    transaction.add(R.id.content, xinTieFragment, "TAG2");
                } else {
                    transaction.show(xinTieFragment);
                }
                break;
//            case 2:
//                rbFind.setTextColor(getResources().getColor(R.color.red));
//                findFragment = (FindFragment) fragmentManager.findFragmentByTag("TAG3");
//                hideTab(transaction);
//                if (findFragment == null) {
//                    findFragment = FindFragment.newInstance();
//                    transaction.add(R.id.content, findFragment, "TAG3");
//                } else {
//                    transaction.show(findFragment);
//                }
//                break;
//            case 3:
//
//                rbShopCart.setTextColor(getResources().getColor(R.color.red));
//                shopCartFragment = (ShopCartFragment) fragmentManager.findFragmentByTag("TAG4");
//                hideTab(transaction);
//                if (shopCartFragment == null) {
//                    shopCartFragment = ShopCartFragment.newInstance();
//                    transaction.add(R.id.content, shopCartFragment, "TAG4");
//                } else {
//                    BusProvider.getInstance().post(new RefreshShopCartEvent());//// TODO: 2015/12/18 0018 刷新购物车数据
//                    transaction.show(shopCartFragment);
//
//                }
//
//                break;
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
//        if (shopCartFragment != null) {
//            transaction.hide(shopCartFragment);
//        }
//        if (mineFragment != null) {
//            transaction.hide(mineFragment);
//        }
//        if (findFragment != null) {
//            transaction.hide(findFragment);
//        }
    }
}