package com.shida.joke.ui.fragment;

import com.shida.joke.R;
import com.shida.joke.base.BaseFragment;

/**
 * Created by Administrator on 2016/3/8 0008.
 */
public class MineFragment extends BaseFragment {


    public static MineFragment newInstance() {
        MineFragment mineFragment = new MineFragment();
        return mineFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

    }
}
