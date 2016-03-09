package com.shida.joke.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.shida.joke.R;

/**
 * Created by Administrator on 2016/3/9 0009.
 */
public class ToastUtils {
    private static ToastUtils toastUtils;

    private Toast toast;

    private ToastUtils(){
    }

    public static ToastUtils createToastConfig(){
        if (toastUtils==null) {
            toastUtils = new ToastUtils();
        }
        return toastUtils;
    }

    /**
     * 显示Toast
     * @param context
     * @param tvString
     */

    public void ToastShow(Context context,String tvString){
        View layout = LayoutInflater.from(context).inflate(R.layout.toast,null);
        TextView textView = (TextView) layout.findViewById(R.id.tv);
        textView.setText(tvString);
        toast = new Toast(context);
        toast.setGravity(Gravity.TOP, 0, DensityUtil.dip2px(context,85));
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
