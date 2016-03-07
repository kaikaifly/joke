package com.shida.joke;
import com.shida.joke.bean.Comment;
import com.shida.joke.bean.Picture;
import com.shida.joke.bean.Recommend;
import com.shida.joke.bean.Text;
import com.shida.joke.bean.UserInfo;
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
    // TODO: 2016/3/7 0007 用户信息 http://api.budejie.com/api/api_open.php
    //    a=profile
    //    c=user
    //    userid=9852969

    public static void getUserInfo(String userId, OkHttpClientManager.ResultCallback<UserInfo> resultCallback){
        OkHttpClientManager.postAsyn("http://api.budejie.com/api/api_open.php",
                new OkHttpClientManager.Param[]{
                        new OkHttpClientManager.Param("a","profile"),
                        new OkHttpClientManager.Param("c","user"),
                        new OkHttpClientManager.Param("userid",userId)
                },resultCallback);
    }


    // TODO: 2016/3/7 0007  用户—帖子 http://s.budejie.com/topic/user-topic/15603305/1/desc/budejie-android-6.3.2/0-20.json
    public static void  getUserTiezi(String timestamp, String uid,  OkHttpClientManager.ResultCallback<Recommend> resultCallback){
        OkHttpClientManager.getAsyn("http://s.budejie.com/topic/user-topic/" + uid + "/1/desc/budejie-android-6.3.2/" + timestamp + "-20.json", resultCallback);
    }
    // TODO: 2016/3/7 0007  用户—分享 http://s.budejie.com/topic/share-topic/15603305/budejie-android-6.3.2/0-20.json
    public static void  getUserShared(String timestamp, String uid,  OkHttpClientManager.ResultCallback<Recommend> resultCallback){
        OkHttpClientManager.getAsyn("http://s.budejie.com/topic/share-topic/" + uid + "/budejie-android-6.3.2/"+timestamp+ "-20.json", resultCallback);
    }
    // TODO: 2016/3/7 0007  用户—评论 http://s.budejie.com/comment/user-comment/15603305/budejie-android-6.3.2/0-20.json
    public static void  getUserComment(String timestamp, String uid,  OkHttpClientManager.ResultCallback<Recommend> resultCallback){
        OkHttpClientManager.getAsyn("http://s.budejie.com/comment/user-comment/"+uid+"/budejie-android-6.3.2/"+timestamp+"-20.json", resultCallback);
    }
}
