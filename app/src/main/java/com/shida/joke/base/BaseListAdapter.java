package com.shida.joke.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by zhangpengfei on 15-8-5.
 */
public abstract class BaseListAdapter<T, V extends BaseListAdapter.ViewHolder> extends BaseAdapter {
    protected Context      context;
    protected List<T> datas;
    private int position = 0;
    public BaseListAdapter(Context context, List<T> datas) {
        this.context = context;
        this.datas = datas;
    }

    public static abstract class ViewHolder {
        public ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void setSelectItem(int position) {
        this.position = position;
    }

    public int getSelectItem() {
        return position;
    }
    protected abstract int getItemLayoutResId();

    protected abstract V onCreateVHolder(View view);

    protected abstract void onBindVHolder(V holder, final T data, final int position);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        T data = datas.get(position);
        V holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(getItemLayoutResId(), null);
            holder = onCreateVHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (V) convertView.getTag();
        }
        onBindVHolder(holder, data, position);
        return convertView;
    }

    public void setDatas(ArrayList<T> datas){
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    public void addAllDatas(ArrayList<T> datas) {
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }

    public void changeDatas(ArrayList<T> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            if (listItem instanceof ViewGroup) {
                listItem.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


}
