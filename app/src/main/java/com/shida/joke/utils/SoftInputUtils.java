package com.shida.joke.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by zhangpengfei on 15-4-2.
 */
public class SoftInputUtils {
    private static InputMethodManager mInputMethodManager;

    private static InputMethodManager getInputMethodManager(Context context) {
        if (mInputMethodManager == null)
            mInputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        return mInputMethodManager;
    }

    public static void hideSoftInput(Context context) {
        if (mInputMethodManager == null)
            mInputMethodManager = getInputMethodManager(context);
        View view;
        if ((mInputMethodManager != null) && (((Activity) context).getCurrentFocus() != null) &&
            (((Activity) context).getCurrentFocus().getWindowToken() != null)) {
            view = ((Activity) context).getCurrentFocus();
            if (view != null)
                mInputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void showSoftInput(Context context) {
        if (mInputMethodManager == null)
            mInputMethodManager = getInputMethodManager(context);
        mInputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
}
