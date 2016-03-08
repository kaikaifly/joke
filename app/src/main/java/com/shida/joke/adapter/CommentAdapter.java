package com.shida.joke.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.shida.joke.R;
import com.shida.joke.base.BaseListAdapter;
import com.shida.joke.bean.Comment;
import com.shida.joke.ui.activity.UserInfoActivity;
import com.shida.joke.utils.GlideCircleTransform;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/3/3 0003.
 */
public class CommentAdapter extends BaseListAdapter<Comment.DataEntity, CommentAdapter.ViewHolder> {



    public CommentAdapter(Context context, List<Comment.DataEntity> datas) {
        super(context, datas);
    }

    @Override
    protected int getItemLayoutResId() {
        return R.layout.item_comment;
    }

    @Override
    protected ViewHolder onCreateVHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindVHolder(ViewHolder holder, final Comment.DataEntity data, int position) {
        Glide.with(context)
                .load(data.getUser().getProfile_image())
                .transform(new GlideCircleTransform(context))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.headPic);
        holder.headPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserInfoActivity.class);
                intent.putExtra("userid", data.getUser().getId());
                context.startActivity(intent);
            }
        });

        if (data.getUser().getSex().equals("m")){
            holder.sex.setText("♂");
        }else if (data.getUser().getSex().equals("f")){
            holder.sex.setText("♀");
            holder.sex.setTextColor(Color.rgb(123,189,233));
        }
        holder.name.setText(data.getUser().getUsername());
        holder.text.setText(data.getContent());
        holder.loveCount.setText(data.getLike_count());

    }


    class ViewHolder extends BaseListAdapter.ViewHolder {

        @Bind(R.id.headPic)
        ImageView headPic;
        @Bind(R.id.sex)
        TextView sex;
        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.text)
        TextView text;
        @Bind(R.id.loveCount)
        TextView loveCount;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
