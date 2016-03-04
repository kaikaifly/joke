package com.shida.joke.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/3/2 0002.
 */
public class Video {
    /**
     * count : 63002
     * np : 1456917399
     */

    @SerializedName("info")
    private InfoEntity info;
    /**
     * comment : 0
     * tags : [{"id":55,"name":"微视频"}]
     * bookmark : 0
     * text : 新计算器，来一发😂
     * up : 76
     * share_url : http://b.f.winapp111.com/budejie/land.php?pid=17439802&wx.qq.com
     * down : 36
     * forward : 0
     * u : {"header":["http://qzapp.qlogo.cn/qzapp/100336987/E0B16731FF6EAB195987D6EEB74BFA5D/100","http://qzapp.qlogo.cn/qzapp/100336987/E0B16731FF6EAB195987D6EEB74BFA5D/100"],"is_v":false,"uid":"16851864","is_vip":false,"name":"   1 、"}
     * passtime : 2016-03-02 19:17:10
     * video : {"playfcount":9,"height":480,"width":480,"video":["http://wvideo.spriteapp.cn/video/2016/0302/56d6a79735cac_wpd.mp4","http://dvideo.spriteapp.cn/video/2016/0302/56d6a79735cac_wpd.mp4","http://dv.spriteapp.cn/video/2016/0302/56d6a79735cac_wpd.mp4"],"duration":61,"playcount":215,"thumbnail":["http://wimg.spriteapp.cn/picture/2016/0302/56d6a79735cac_wpd.jpg","http://dimg.spriteapp.cn/picture/2016/0302/56d6a79735cac_wpd.jpg"],"download":["http://wvideo.spriteapp.cn/video/2016/0302/56d6a79735cac_wpc.mp4","http://dvideo.spriteapp.cn/video/2016/0302/56d6a79735cac_wpc.mp4","http://dv.spriteapp.cn/video/2016/0302/56d6a79735cac_wpc.mp4"]}
     * type : video
     * id : 17439802
     */

    @SerializedName("list")
    private List<ListEntity> list;

    public void setInfo(InfoEntity info) {
        this.info = info;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public InfoEntity getInfo() {
        return info;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public static class InfoEntity {
        @SerializedName("count")
        private int count;
        @SerializedName("np")
        private int np;

        public void setCount(int count) {
            this.count = count;
        }

        public void setNp(int np) {
            this.np = np;
        }

        public int getCount() {
            return count;
        }

        public int getNp() {
            return np;
        }
    }

    public static class ListEntity {

        private String comment;
        private String bookmark;
        @SerializedName("text")
        private String text;
        @SerializedName("up")
        private String up;
        @SerializedName("share_url")
        private String share_url;
        @SerializedName("down")
        private int down;
        @SerializedName("forward")
        private String forward;
        /**
         * header : ["http://qzapp.qlogo.cn/qzapp/100336987/E0B16731FF6EAB195987D6EEB74BFA5D/100","http://qzapp.qlogo.cn/qzapp/100336987/E0B16731FF6EAB195987D6EEB74BFA5D/100"]
         * is_v : false
         * uid : 16851864
         * is_vip : false
         * name :    1 、
         */

        @SerializedName("u")
        private UEntity u;
        @SerializedName("passtime")
        private String passtime;
        /**
         * playfcount : 9
         * height : 480
         * width : 480
         * video : ["http://wvideo.spriteapp.cn/video/2016/0302/56d6a79735cac_wpd.mp4","http://dvideo.spriteapp.cn/video/2016/0302/56d6a79735cac_wpd.mp4","http://dv.spriteapp.cn/video/2016/0302/56d6a79735cac_wpd.mp4"]
         * duration : 61
         * playcount : 215
         * thumbnail : ["http://wimg.spriteapp.cn/picture/2016/0302/56d6a79735cac_wpd.jpg","http://dimg.spriteapp.cn/picture/2016/0302/56d6a79735cac_wpd.jpg"]
         * download : ["http://wvideo.spriteapp.cn/video/2016/0302/56d6a79735cac_wpc.mp4","http://dvideo.spriteapp.cn/video/2016/0302/56d6a79735cac_wpc.mp4","http://dv.spriteapp.cn/video/2016/0302/56d6a79735cac_wpc.mp4"]
         */

        @SerializedName("video")
        private VideoEntity video;
        @SerializedName("type")
        private String type;
        @SerializedName("id")
        private String id;
        /**
         * id : 55
         * name : 微视频
         */

        private List<TagsEntity> tags;

        public void setComment(String comment) {
            this.comment = comment;
        }

        public void setBookmark(String bookmark) {
            this.bookmark = bookmark;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public void setDown(int down) {
            this.down = down;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public void setU(UEntity u) {
            this.u = u;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }

        public void setVideo(VideoEntity video) {
            this.video = video;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setTags(List<TagsEntity> tags) {
            this.tags = tags;
        }

        public String getComment() {
            return comment;
        }

        public String getBookmark() {
            return bookmark;
        }

        public String getText() {
            return text;
        }

        public String getUp() {
            return up;
        }

        public String getShare_url() {
            return share_url;
        }

        public int getDown() {
            return down;
        }

        public String getForward() {
            return forward;
        }

        public UEntity getU() {
            return u;
        }

        public String getPasstime() {
            return passtime;
        }

        public VideoEntity getVideo() {
            return video;
        }

        public String getType() {
            return type;
        }

        public String getId() {
            return id;
        }

        public List<TagsEntity> getTags() {
            return tags;
        }

        public static class UEntity {
            private boolean is_v;
            @SerializedName("uid")
            private String uid;
            private boolean is_vip;
            @SerializedName("name")
            private String name;
            @SerializedName("header")
            private List<String> header;

            public void setIs_v(boolean is_v) {
                this.is_v = is_v;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public void setIs_vip(boolean is_vip) {
                this.is_vip = is_vip;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setHeader(List<String> header) {
                this.header = header;
            }

            public boolean isIs_v() {
                return is_v;
            }

            public String getUid() {
                return uid;
            }

            public boolean isIs_vip() {
                return is_vip;
            }

            public String getName() {
                return name;
            }

            public List<String> getHeader() {
                return header;
            }
        }

        public static class VideoEntity {
            @SerializedName("playfcount")
            private int playfcount;
            @SerializedName("height")
            private int height;
            @SerializedName("width")
            private int width;
            @SerializedName("duration")
            private int duration;
            @SerializedName("playcount")
            private int playcount;
            @SerializedName("video")
            private List<String> video;
            @SerializedName("thumbnail")
            private List<String> thumbnail;
            @SerializedName("download")
            private List<String> download;

            public void setPlayfcount(int playfcount) {
                this.playfcount = playfcount;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public void setPlaycount(int playcount) {
                this.playcount = playcount;
            }

            public void setVideo(List<String> video) {
                this.video = video;
            }

            public void setThumbnail(List<String> thumbnail) {
                this.thumbnail = thumbnail;
            }

            public void setDownload(List<String> download) {
                this.download = download;
            }

            public int getPlayfcount() {
                return playfcount;
            }

            public int getHeight() {
                return height;
            }

            public int getWidth() {
                return width;
            }

            public int getDuration() {
                return duration;
            }

            public int getPlaycount() {
                return playcount;
            }

            public List<String> getVideo() {
                return video;
            }

            public List<String> getThumbnail() {
                return thumbnail;
            }

            public List<String> getDownload() {
                return download;
            }
        }

        public static class TagsEntity {
            private int id;
            @SerializedName("name")
            private String name;

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }
    }
}
