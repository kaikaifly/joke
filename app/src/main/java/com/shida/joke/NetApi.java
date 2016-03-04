package com.shida.joke;
import com.shida.joke.bean.Comment;
import com.shida.joke.bean.Picture;
import com.shida.joke.bean.Recommend;
import com.shida.joke.bean.Text;
import com.shida.joke.bean.Video;
import com.shida.joke.utils.OkHttpClientManager;
/**
 * Created by Administrator on 2016/2/29 0029.
 */
public class NetApi {
    // TODO: 2016/3/3 0003 推荐 http://s.budejie.com/topic/list/jingxuan/1/budejie-android-6.3.2/0-20.json
    public static void getRecommend(String timestamp, OkHttpClientManager.ResultCallback<Recommend> resultCallback){
        OkHttpClientManager.getAsyn("http://s.budejie.com/topic/list/jingxuan/1/budejie-android-6.3.2/"+timestamp+"-20.json", resultCallback);
    }
    // TODO: 2016/3/3 0003 图片 http://s.budejie.com/topic/list/zuixin/10/budejie-android-6.3.2/0-20.json
    public static void getPic(String timestamp, OkHttpClientManager.ResultCallback<Picture> resultCallback){
        OkHttpClientManager.getAsyn("http://s.budejie.com/topic/list/zuixin/10/budejie-android-6.3.2/"+timestamp+"-20.json", resultCallback);
    }
    // TODO: 2016/3/3 0003 段子  http://s.budejie.com/topic/list/zuixin/29/budejie-android-6.3.2/0-20.json
    public static void getText(String timestamp, OkHttpClientManager.ResultCallback<Text> resultCallback){
        OkHttpClientManager.getAsyn("http://s.budejie.com/topic/list/zuixin/29/budejie-android-6.3.2/" +timestamp+"-20.json", resultCallback);
    }
    // TODO: 2016/3/2 0002 视频 http://s.budejie.com/topic/list/zuixin/41/budejie-android-6.3.2/0-2.json
    public static void getVideo(String timestamp,  OkHttpClientManager.ResultCallback<Video> resultCallback){
        OkHttpClientManager.getAsyn("http://s.budejie.com/topic/list/zuixin/41/budejie-android-6.3.2/"+ timestamp +"-20.json", resultCallback);
    }
    // TODO: 2016/3/3 0003 评论  http://api.budejie.com/api/api_open.php?a=dataList&c=comment&hot=1&data_id=17435441&page=5&per=20
    public static void getComment(String dataId, String page,OkHttpClientManager.ResultCallback<Comment> resultCallback){
        OkHttpClientManager.getAsyn("http://api.budejie.com/api/api_open.php?a=dataList&c=comment&hot=1&data_id="+dataId+"&page="+ page +"&per=20", resultCallback);
    }
}
