package com.shida.joke.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/3/4 0004.
 */
public class UserInfo {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"id":"9852969","username":"\u2026♀傻二蛋♀","sex":"f","introduction":"","profile_image":"http://wimg.spriteapp.cn/profile/large/2016/02/28/56d268933c2ba_mini.jpg","profile_image_large":"http://wimg.spriteapp.cn/profile/large/2016/02/28/56d268933c2ba_profile.jpg","background_image":"http://wimg.spriteapp.cn/background/2016/03/03/56d7d4c9198f6.jpg","follow_count":"0","fans_count":"296","praise_count":"3","sina_v":"0","jie_v":"0","v_desc":"","level":4,"is_vip":false,"relationship":"0","credit":1664,"experience":2024,"tiezi_count":105,"comment_count":"8","share_count":"0"}
     */

    private int code;
    private String msg;
    /**
     * id : 9852969
     * username : …♀傻二蛋♀
     * sex : f
     * introduction :
     * profile_image : http://wimg.spriteapp.cn/profile/large/2016/02/28/56d268933c2ba_mini.jpg
     * profile_image_large : http://wimg.spriteapp.cn/profile/large/2016/02/28/56d268933c2ba_profile.jpg
     * background_image : http://wimg.spriteapp.cn/background/2016/03/03/56d7d4c9198f6.jpg
     * follow_count : 0
     * fans_count : 296
     * praise_count : 3
     * sina_v : 0
     * jie_v : 0
     * v_desc :
     * level : 4
     * is_vip : false
     * relationship : 0
     * credit : 1664
     * experience : 2024
     * tiezi_count : 105
     * comment_count : 8
     * share_count : 0
     */

    @SerializedName("data")
    private DataEntity data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        @SerializedName("id")
        private String id;
        @SerializedName("username")
        private String username;
        @SerializedName("sex")
        private String sex;
        @SerializedName("introduction")
        private String introduction;
        @SerializedName("profile_image")
        private String profile_image;
        @SerializedName("profile_image_large")
        private String profile_image_large;
        @SerializedName("background_image")
        private String background_image;
        @SerializedName("follow_count")
        private String follow_count;
        @SerializedName("fans_count")
        private String fans_count;
        @SerializedName("praise_count")
        private String praise_count;
        @SerializedName("sina_v")
        private String sina_v;
        @SerializedName("jie_v")
        private String jie_v;
        @SerializedName("v_desc")
        private String v_desc;
        @SerializedName("level")
        private int level;
        @SerializedName("is_vip")
        private boolean is_vip;
        @SerializedName("relationship")
        private String relationship;
        @SerializedName("credit")
        private int credit;
        @SerializedName("experience")
        private int experience;
        @SerializedName("tiezi_count")
        private int tiezi_count;
        @SerializedName("comment_count")
        private String comment_count;
        @SerializedName("share_count")
        private String share_count;

        public void setId(String id) {
            this.id = id;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public void setProfile_image_large(String profile_image_large) {
            this.profile_image_large = profile_image_large;
        }

        public void setBackground_image(String background_image) {
            this.background_image = background_image;
        }

        public void setFollow_count(String follow_count) {
            this.follow_count = follow_count;
        }

        public void setFans_count(String fans_count) {
            this.fans_count = fans_count;
        }

        public void setPraise_count(String praise_count) {
            this.praise_count = praise_count;
        }

        public void setSina_v(String sina_v) {
            this.sina_v = sina_v;
        }

        public void setJie_v(String jie_v) {
            this.jie_v = jie_v;
        }

        public void setV_desc(String v_desc) {
            this.v_desc = v_desc;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void setIs_vip(boolean is_vip) {
            this.is_vip = is_vip;
        }

        public void setRelationship(String relationship) {
            this.relationship = relationship;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }

        public void setTiezi_count(int tiezi_count) {
            this.tiezi_count = tiezi_count;
        }

        public void setComment_count(String comment_count) {
            this.comment_count = comment_count;
        }

        public void setShare_count(String share_count) {
            this.share_count = share_count;
        }

        public String getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getSex() {
            return sex;
        }

        public String getIntroduction() {
            return introduction;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public String getProfile_image_large() {
            return profile_image_large;
        }

        public String getBackground_image() {
            return background_image;
        }

        public String getFollow_count() {
            return follow_count;
        }

        public String getFans_count() {
            return fans_count;
        }

        public String getPraise_count() {
            return praise_count;
        }

        public String getSina_v() {
            return sina_v;
        }

        public String getJie_v() {
            return jie_v;
        }

        public String getV_desc() {
            return v_desc;
        }

        public int getLevel() {
            return level;
        }

        public boolean isIs_vip() {
            return is_vip;
        }

        public String getRelationship() {
            return relationship;
        }

        public int getCredit() {
            return credit;
        }

        public int getExperience() {
            return experience;
        }

        public int getTiezi_count() {
            return tiezi_count;
        }

        public String getComment_count() {
            return comment_count;
        }

        public String getShare_count() {
            return share_count;
        }
    }
}
