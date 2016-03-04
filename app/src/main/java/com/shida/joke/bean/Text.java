package com.shida.joke.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/3/3 0003.
 */
public class Text {

    /**
     * count : 8731
     * np : 1456988291
     */

    @SerializedName("info")
    private InfoEntity info;
    /**
     * comment : 0
     * tags : [{"id":60,"name":"吐槽"},{"id":64,"name":"糗事"}]
     * bookmark : 0
     * text : 都说兔子不吃窝边草，可草不这么想，尤其给生脸吃还不如给熟脸吃呢
     * up : 36
     * share_url : http://c.f.winapp111.mobi/budejie/land.php?pid=17452653&wx.qq.com
     * down : 12
     * forward : 0
     * u : {"header":["http://qzapp.qlogo.cn/qzapp/100336987/2BC68D74FFF4CB8C0780D34A6DFCBDAD/100"],"is_v":false,"uid":"12107148","is_vip":false,"name":"迷途小伙子"}
     * passtime : 2016-03-03 15:38:33
     * type : text
     * id : 17452653
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
        @SerializedName("up")
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
        private String bookmark;
        @SerializedName("text")
        private String text;
        @SerializedName("up")
        private String up;
        @SerializedName("share_url")
        private String share_url;
        @SerializedName("dowm")
        private int down;
        private String forward;
        /**
         * header : ["http://qzapp.qlogo.cn/qzapp/100336987/2BC68D74FFF4CB8C0780D34A6DFCBDAD/100"]
         * is_v : false
         * uid : 12107148
         * is_vip : false
         * name : 迷途小伙子
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
         * id : 60
         * name : 吐槽
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
