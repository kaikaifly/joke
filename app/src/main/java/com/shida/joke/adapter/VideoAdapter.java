package com.shida.joke.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.shida.joke.R;
import com.shida.joke.base.BaseListAdapter;
import com.shida.joke.bean.Video;
import com.shida.joke.ui.activity.CommentActivity;
import com.shida.joke.ui.activity.PlayVideoActivity;
import com.shida.joke.ui.activity.UserInfoActivity;
import com.shida.joke.utils.GlideCircleTransform;
import com.shida.joke.utils.SharedUtils;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/2/29 0029.
 */
public class VideoAdapter extends BaseListAdapter<Video.ListEntity, VideoAdapter.ViewHolder> {


    public VideoAdapter(Context context, List<Video.ListEntity> datas) {
        super(context, datas);
    }

    @Override
    protected int getItemLayoutResId() {
        return R.layout.item_video;
    }

    @Override
    protected ViewHolder onCreateVHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindVHolder(ViewHolder holder, final Video.ListEntity data, int position) {
        holder.shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedUtils.showShare(context);
            }
        });

        Glide.with(context)
                .load(data.getU().getHeader().get(0))
                .transform(new GlideCircleTransform(context))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.headPic);
        holder.headPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserInfoActivity.class);
                intent.putExtra("userid", data.getU().getUid());
                context.startActivity(intent);
            }
        });
        Glide.with(context)
                .load(data.getVideo().getThumbnail().get(0))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgae);
        holder.imgae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayVideoActivity.class);
                intent.putExtra("videoPath", data.getVideo().getVideo().get(0));
                context.startActivity(intent);
            }
        });
        holder.nickName.setText(data.getU().getName());
        holder.date.setText(data.getPasstime());
        holder.text.setText("\n" +data.getText()+"\n");
        holder.love.setText(data.getUp());
        holder.hate.setText(String.valueOf(data.getDown()));
        holder.commentCount.setText(data.getComment());
        holder.playcount.setText(String.valueOf(data.getVideo().getPlaycount()) + "次播放");

        String ss = "";
        for (int i=0;i<data.getTags().size();i++){
            ss = ss + data.getTags().get(i).getName() + "   ";
        }
        holder.label.setText(ss);

        int duration = data.getVideo().getDuration();
        int m = duration/60;
        int s = duration%60;
        if (m<10 && s<10){
            holder.duration.setText("0" + String.valueOf(m)+ ":0" + String.valueOf(s));
        }
        if (m<10 && s>=10){
            holder.duration.setText("0" + String.valueOf(m)+ ":" + String.valueOf(s));
        }
        if (m>=10 && s<10){
            holder.duration.setText(String.valueOf(m)+ ":0" + String.valueOf(s));
        }

        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CommentActivity.class);
                intent.putExtra("dataId", data.getId());
                context.startActivity(intent);
            }
        });
    }

    class ViewHolder extends BaseListAdapter.ViewHolder {
        @Bind(R.id.headPic)
        ImageView headPic;
        @Bind(R.id.nickName)
        TextView nickName;
        @Bind(R.id.date)
        TextView date;
        @Bind(R.id.text)
        TextView text;
        @Bind(R.id.imgae)
        ImageView imgae;
        @Bind(R.id.love)
        TextView love;
        @Bind(R.id.hate)
        TextView hate;
        @Bind(R.id.shared)
        LinearLayout shared;
        @Bind(R.id.comment)
        LinearLayout comment;
        @Bind(R.id.commentCount)
        TextView commentCount;
        @Bind(R.id.playcount)
        TextView playcount;
        @Bind(R.id.duration)
        TextView duration;
        @Bind(R.id.label)
        TextView label;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
