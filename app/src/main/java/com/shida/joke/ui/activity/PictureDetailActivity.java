package com.shida.joke.ui.activity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.shida.joke.R;
import com.shida.joke.base.BaseActivity;

import butterknife.Bind;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by Administrator on 2016/3/7 0007.
 */
public class PictureDetailActivity extends BaseActivity{
    @Bind(R.id.image)
    PhotoView image;
    private String imageUrl;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_picture_details;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (!isEmpty(getIntent().getStringExtra("gifPath"))){
            imageUrl = getIntent().getStringExtra("gifPath");
        }else if (!isEmpty(getIntent().getStringExtra("imagePath"))){
            imageUrl = getIntent().getStringExtra("imagePath");
        }


        Glide
                .with(context)
                .load(imageUrl)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(image);

    }
}
