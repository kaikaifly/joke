package com.shida.joke.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.shida.joke.R;
import com.shida.joke.base.BaseListAdapter;
import com.shida.joke.bean.Recommend;
import com.shida.joke.ui.activity.CommentActivity;
import com.shida.joke.ui.activity.PlayVideoActivity;
import com.shida.joke.utils.GlideCircleTransform;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/3/3 0003.
 */
public class RecommendAdapter extends BaseListAdapter<Recommend.ListEntity, RecommendAdapter.ViewHolder> {

    public RecommendAdapter(Context context, List<Recommend.ListEntity> datas) {
        super(context, datas);
    }

    @Override
    protected int getItemLayoutResId() {
        return R.layout.item_recommend;
    }

    @Override
    protected ViewHolder onCreateVHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindVHolder(ViewHolder holder, final Recommend.ListEntity data, int position) {
        Glide.with(context)
                .load(data.getU().getHeader().get(0))
                .transform(new GlideCircleTransform(context))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.headPic);

        holder.nickName.setText(data.getU().getName());
        holder.date.setText(data.getPasstime());
        holder.text.setText("\n" + data.getText() + "\n");
        holder.love.setText(data.getUp());
        holder.hate.setText(String.valueOf(data.getDown()));
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CommentActivity.class);
                intent.putExtra("dataId", data.getId());
                context.startActivity(intent);
            }
        });
        holder.commentCount.setText(data.getComment());
        if (data.getType().equals("text")) {
            holder.playbutton.setVisibility(View.GONE);
            holder.playcountDuration.setVisibility(View.GONE);
            holder.imgae.setVisibility(View.GONE);
            holder.lookWebview.setVisibility(View.GONE);


        } else if (data.getType().equals("image")) {
            holder.playbutton.setVisibility(View.GONE);
            holder.playcountDuration.setVisibility(View.GONE);
            holder.imgae.setVisibility(View.VISIBLE);
            holder.lookWebview.setVisibility(View.GONE);
            Glide.with(context)
                    .load(data.getImage().getBig().get(0))
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imgae);
            holder.imgae.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(context, PlayVideoActivity.class);
//                    intent.putExtra("videoPath", data.getVideo().getVideo().get(0));
//                    context.startActivity(intent);
                }
            });
        } else if (data.getType().equals("gif")) {
            holder.playbutton.setVisibility(View.GONE);
            holder.playcountDuration.setVisibility(View.GONE);
            holder.imgae.setVisibility(View.VISIBLE);
            holder.lookWebview.setVisibility(View.GONE);
            Glide.with(context)
                    .load(data.getGif().getImages().get(0))
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imgae);
            holder.imgae.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(context, PlayVideoActivity.class);
//                    intent.putExtra("videoPath", data.getVideo().getVideo().get(0));
//                    context.startActivity(intent);
                }
            });

        } else if (data.getType().equals("html")) {
            holder.playbutton.setVisibility(View.GONE);
            holder.playcountDuration.setVisibility(View.GONE);
            holder.imgae.setVisibility(View.VISIBLE);
            holder.lookWebview.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(data.getHtml().getThumbnail().get(0))
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imgae);
            holder.text.setText(data.getHtml().getDesc());
            holder.lookWebview.setBackgroundColor(0x80000000);
            holder.imgae.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(context, PlayVideoActivity.class);
//                    intent.putExtra("videoPath", data.getVideo().getVideo().get(0));
//                    context.startActivity(intent);
                }
            });
        } else if (data.getType().equals("video")) {
            holder.imgae.setVisibility(View.VISIBLE);
            holder.lookWebview.setVisibility(View.GONE);
            Glide.with(context)
                    .load(data.getVideo().getThumbnail().get(0))
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imgae);

            holder.playbutton.setVisibility(View.VISIBLE);
            holder.playcountDuration.setVisibility(View.VISIBLE);

            holder.playcount.setText(String.valueOf(data.getVideo().getPlaycount()) + "次播放");
            int duration = data.getVideo().getDuration();
            int m = duration / 60;
            int s = duration % 60;
            if (m < 10 && s < 10) {
                holder.duration.setText("0" + String.valueOf(m) + ":0" + String.valueOf(s));
            }
            if (m < 10 && s >= 10) {
                holder.duration.setText("0" + String.valueOf(m) + ":" + String.valueOf(s));
            }
            if (m >= 10 && s < 10) {
                holder.duration.setText(String.valueOf(m) + ":0" + String.valueOf(s));
            }

            holder.imgae.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayVideoActivity.class);
                    intent.putExtra("videoPath", data.getVideo().getVideo().get(0));
                    context.startActivity(intent);
                }
            });
        }

    }

    class ViewHolder extends BaseListAdapter.ViewHolder {
        //        @Bind(R.id.headPic)
//        ImageView headPic;
//        @Bind(R.id.nickName)
//        TextView nickName;
//        @Bind(R.id.date)
//        TextView date;
//        @Bind(R.id.text)
//        TextView text;
//        @Bind(R.id.imgae)
//        ImageView imgae;
//        @Bind(R.id.love)
//        TextView love;
//        @Bind(R.id.hate)
//        TextView hate;
//        @Bind(R.id.shared)
//        ImageView shared;
//        @Bind(R.id.comment)
//        LinearLayout comment;
//        @Bind(R.id.commentCount)
//        TextView commentCount;
//        @Bind(R.id.playcount)
//        TextView playcount;
//        @Bind(R.id.duration)
//        TextView duration;
//        @Bind(R.id.playbutton)
//        ImageView playbutton;
//        @Bind(R.id.playcount_duration)
//        RelativeLayout playcount_duration;
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
        @Bind(R.id.playbutton)
        ImageView playbutton;
        @Bind(R.id.playcount)
        TextView playcount;
        @Bind(R.id.duration)
        TextView duration;
        @Bind(R.id.playcount_duration)
        RelativeLayout playcountDuration;
        @Bind(R.id.love)
        TextView love;
        @Bind(R.id.hate)
        TextView hate;
        @Bind(R.id.shared)
        ImageView shared;
        @Bind(R.id.comment)
        ImageView comment;
        @Bind(R.id.commentCount)
        TextView commentCount;
        @Bind(R.id.lookWebview)
        TextView lookWebview;


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
