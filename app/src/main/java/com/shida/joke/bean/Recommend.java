package com.shida.joke.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/3/3 0003.
 */
public class Recommend {
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
        @SerializedName("image")
        private ImageEntity image;
        @SerializedName("html")
        private HtmlEntity html;
        @SerializedName("gif")
        private GifEntity gif;
        @SerializedName("type")
        private String type;
        @SerializedName("id")
        private String id;
        /**
         * id : 55
         * name : 微视频
         */

        private List<TagsEntity> tags;


        public HtmlEntity getHtml() {
            return html;
        }

        public void setHtml(HtmlEntity html) {
            this.html = html;
        }

        public GifEntity getGif() {
            return gif;
        }

        public void setGif(GifEntity gif) {
            this.gif = gif;
        }

        public ImageEntity getImage() {
            return image;
        }

        public void setImage(ImageEntity image) {
            this.image = image;
        }


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

        public static class ImageEntity {
            @SerializedName("height")
            private int height;
            @SerializedName("width")
            private int width;
            private List<?> medium;
            @SerializedName("big")
            private List<String> big;
            @SerializedName("download_url")
            private List<String> download_url;
            @SerializedName("small")
            private List<String> small;

            public void setHeight(int height) {
                this.height = height;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public void setMedium(List<?> medium) {
                this.medium = medium;
            }

            public void setBig(List<String> big) {
                this.big = big;
            }

            public void setDownload_url(List<String> download_url) {
                this.download_url = download_url;
            }

            public void setSmall(List<String> small) {
                this.small = small;
            }

            public int getHeight() {
                return height;
            }

            public int getWidth() {
                return width;
            }

            public List<?> getMedium() {
                return medium;
            }

            public List<String> getBig() {
                return big;
            }

            public List<String> getDownload_url() {
                return download_url;
            }

            public List<?> getSmall() {
                return small;
            }
        }

        public static class HtmlEntity {

            /**
             * body :
             * title : 浴缸丸子头少女清纯可人
             * source_url : http://tu.budejie.com/ms/detail/971625?j_from=1?&pid=17408600
             * desc : 浴缸丸子头少女清纯可人
             * type : 1
             * thumbnail : ["http://wimg.spriteapp.cn/capture/random/img/20160229102237_3916.jpg","http://dimg.spriteapp.cn/capture/random/img/20160229102237_3916.jpg"]
             * view : {"playcount":0,"playfcount":351}
             */

            @SerializedName("body")
            private String body;
            @SerializedName("title")
            private String title;
            @SerializedName("source_url")
            private String source_url;
            @SerializedName("desc")
            private String desc;
            @SerializedName("type")
            private int type;
            /**
             * playcount : 0
             * playfcount : 351
             */


            private ViewEntity view;
            @SerializedName("thumbnail")
            private List<String> thumbnail;

            public void setBody(String body) {
                this.body = body;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setSource_url(String source_url) {
                this.source_url = source_url;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setView(ViewEntity view) {
                this.view = view;
            }

            public void setThumbnail(List<String> thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getBody() {
                return body;
            }

            public String getTitle() {
                return title;
            }

            public String getSource_url() {
                return source_url;
            }

            public String getDesc() {
                return desc;
            }

            public int getType() {
                return type;
            }

            public ViewEntity getView() {
                return view;
            }

            public List<String> getThumbnail() {
                return thumbnail;
            }

            public static class ViewEntity {
                private int playcount;
                private int playfcount;

                public void setPlaycount(int playcount) {
                    this.playcount = playcount;
                }

                public void setPlayfcount(int playfcount) {
                    this.playfcount = playfcount;
                }

                public int getPlaycount() {
                    return playcount;
                }

                public int getPlayfcount() {
                    return playfcount;
                }
            }
        }
        public static class GifEntity {

            /**
             * images : ["http://wimg.spriteapp.cn/ugc/2016/03/03/56d7daa268d7b.gif"]
             * width : 180
             * gif_thumbnail : ["http://wimg.spriteapp.cn/ugc/2016/03/03/56d7daa268d7b_a_1.jpg"]
             * download_url : ["http://wimg.spriteapp.cn/ugc/2016/03/03/56d7daa268d7b_d.jpg","http://wimg.spriteapp.cn/ugc/2016/03/03/56d7daa268d7b_a_1.jpg"]
             * height : 240
             */

            @SerializedName("width")
            private int width;
            @SerializedName("height")
            private int height;
            @SerializedName("images")
            private List<String> images;
            @SerializedName("gif_thumbnail")
            private List<String> gif_thumbnail;
            @SerializedName("download_url")
            private List<String> download_url;

            public void setWidth(int width) {
                this.width = width;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }

            public void setGif_thumbnail(List<String> gif_thumbnail) {
                this.gif_thumbnail = gif_thumbnail;
            }

            public void setDownload_url(List<String> download_url) {
                this.download_url = download_url;
            }

            public int getWidth() {
                return width;
            }

            public int getHeight() {
                return height;
            }

            public List<String> getImages() {
                return images;
            }

            public List<String> getGif_thumbnail() {
                return gif_thumbnail;
            }

            public List<String> getDownload_url() {
                return download_url;
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
