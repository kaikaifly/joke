package com.shida.joke.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/3/3 0003.
 */
public class Picture {

    /**
     * count : 53024
     * np : 1456989153
     */

    @SerializedName("info")
    private InfoEntity info;
    /**
     * comment : 0
     * tags : [{"id":1,"name":"搞笑"}]
     * bookmark : 0
     * text : 灰指甲，传染俩，练成九阴白骨爪，灰指甲，爆菊花，大家用过喜欢它。
     * image : {"medium":[],"big":["http://wimg.spriteapp.cn/ugc/2016/03/03/56d7d8a929b30_1.jpg"],"download_url":["http://wimg.spriteapp.cn/ugc/2016/03/03/56d7d8a929b30_d.jpg","http://wimg.spriteapp.cn/ugc/2016/03/03/56d7d8a929b30.jpg"],"height":458,"width":510,"small":[]}
     * up : 93
     * share_url : http://a.f.winapp111.cn/budejie/land.php?pid=17452261&wx.qq.com
     * down : 37
     * forward : 0
     * u : {"header":["http://qzapp.qlogo.cn/qzapp/100336987/9438CAD51FA09109AB0EEA4016CD257A/100"],"is_v":false,"uid":"12414083","is_vip":false,"name":"流年渲染了谁の容颜321"}
     * passtime : 2016-03-03 15:21:09
     * type : image
     * id : 17452261
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
        @SerializedName("comment")
        private String comment;
        @SerializedName("bookmark")
        private String bookmark;
        @SerializedName("text")
        private String text;
        /**
         * medium : []
         * big : ["http://wimg.spriteapp.cn/ugc/2016/03/03/56d7d8a929b30_1.jpg"]
         * download_url : ["http://wimg.spriteapp.cn/ugc/2016/03/03/56d7d8a929b30_d.jpg","http://wimg.spriteapp.cn/ugc/2016/03/03/56d7d8a929b30.jpg"]
         * height : 458
         * width : 510
         * small : []
         */

        @SerializedName("image")
        private ImageEntity image;


        @SerializedName("gif")
        private GifEntity gif;
        @SerializedName("up")
        private String up;
        @SerializedName("share_url")
        private String share_url;
        @SerializedName("down")
        private int down;
        @SerializedName("forward")
        private String forward;
        /**
         * header : ["http://qzapp.qlogo.cn/qzapp/100336987/9438CAD51FA09109AB0EEA4016CD257A/100"]
         * is_v : false
         * uid : 12414083
         * is_vip : false
         * name : 流年渲染了谁の容颜321
         */

        @SerializedName("u")
        private UEntity u;
        @SerializedName("passtime")
        private String passtime;
        @SerializedName("type")
        private String type;
        @SerializedName("id")
        private String id;
        /**
         * id : 1
         * name : 搞笑
         */

        @SerializedName("tags")
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

        public void setImage(ImageEntity image) {
            this.image = image;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public GifEntity getGif() {
            return gif;
        }

        public void setGif(GifEntity gif) {
            this.gif = gif;
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

        public ImageEntity getImage() {
            return image;
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

        public String getType() {
            return type;
        }

        public String getId() {
            return id;
        }

        public List<TagsEntity> getTags() {
            return tags;
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
