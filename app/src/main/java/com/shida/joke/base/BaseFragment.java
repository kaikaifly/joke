package com.shida.joke.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.shida.joke.event.BusProvider;

import butterknife.ButterKnife;

/**
 * Created by zhangpengfei on 14-12-24.
 */
public abstract class BaseFragment extends Fragment {

    protected View view;
    Toast toast;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    protected abstract int getLayoutResId();

    protected abstract void initView();



    protected void showToast(String message) {
        if (toast != null) {
            toast.setText(message);
        } else {
            toast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
        }
        toast.show();
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        BusProvider.getInstance().register(this);
//    }


//    @Override
//    public void onPause() {
//        super.onPause();
//        BusProvider.getInstance().unregister(this);
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }



    public static Boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

    public static Boolean isEmpty(String... text) {
        for (String t : text) {
            if (isEmpty(t)) {
                return true;
            }
        }
        return false;
    }




}
