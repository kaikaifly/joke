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
import com.shida.joke.bean.Picture;
import com.shida.joke.ui.activity.CommentActivity;
import com.shida.joke.ui.activity.PictureDetailActivity;
import com.shida.joke.ui.activity.UserInfoActivity;
import com.shida.joke.utils.GlideCircleTransform;
import com.shida.joke.utils.SharedUtils;

import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/2/29 0029.
 */
public class PictureAdapter extends BaseListAdapter<Picture.ListEntity, PictureAdapter.ViewHolder> {


    public PictureAdapter(Context context, List<Picture.ListEntity> datas) {
        super(context, datas);
    }

    @Override
    protected int getItemLayoutResId() {
        return R.layout.item_pic;
    }

    @Override
    protected ViewHolder onCreateVHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected void onBindVHolder(ViewHolder holder, final Picture.ListEntity data, int position) {

//        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
//        display.getWidth(); // to get width of the screen
//        display.getHeight(); // to get height of the Screen
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

        if (data.getType().equals("image")){
            Glide.with(context)
                    .load(data.getImage().getBig().get(0))
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imgae);
        }else if (data.getType().equals("gif")){

            Glide.with(context)
                    .load(data.getGif().getImages().get(0))
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imgae);
        }
        holder.imgae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PictureDetailActivity.class);

                if (data.getType().equals("image")) {
                    intent.putExtra("imagePath",data.getImage().getBig().get(0));
                } else if (data.getType().equals("gif")) {
                    intent.putExtra("gifPath",data.getGif().getImages().get(0));
                }
                context.startActivity(intent);
                }
            }
        );

            holder.nickName.setText(data.getU().

            getName()

            );
            holder.date.setText(data.getPasstime());
            holder.text.setText("\n"+data.getText()+"\n");
            holder.love.setText(data.getUp());
            holder.hate.setText(String.valueOf(data.getDown()));
            holder.comment.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                Intent intent = new Intent(context, CommentActivity.class);
                intent.putExtra("dataId", data.getId());
                context.startActivity(intent);
            }
            }

            );
            holder.commentCount.setText(data.getComment());

            String s = "";
            for(
            int i = 0;
            i<data.getTags().

            size();

            i++)

            {
                s = s + data.getTags().get(i).getName() + "   ";
            }

        holder.label.setText(s);

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
        @Bind(R.id.label)
        TextView label;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
