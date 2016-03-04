package com.shida.joke.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * http://msdx.github.io/AndroidSnippet/com/githang/android/snippet/app/LazyFragment.html
 */
public abstract class LazyFragment extends Fragment {
    protected final int RESULT_CANCELED   = Activity.RESULT_CANCELED;
    protected final int RESULT_OK         = Activity.RESULT_OK;
    protected final int RESULT_FIRST_USER = Activity.RESULT_FIRST_USER;

    protected boolean isVisible;
    protected boolean isPrepared;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
//            onInvisible();
        }
    }


    protected void onVisible() {
        lazyLoad();
    }

    protected abstract void lazyLoad();



//    protected boolean canFirstLoad() {
//        return true;
//    }
//
//    protected abstract void onFirstLoad();
//
//    protected void onInvisible() {
//    }
}
