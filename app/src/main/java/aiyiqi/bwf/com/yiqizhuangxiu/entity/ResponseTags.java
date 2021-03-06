package aiyiqi.bwf.com.yiqizhuangxiu.entity;

import java.util.List;

/**
 * Created by Lee Vane.
 */

public class ResponseTags {


    /**
     * id : 51
     * appid : 1002
     * name : 墙面
     * pinyin : qiangmian
     * weight : 0
     * type : 4
     * hot : 0
     * sort : 0
     * user_id : 1766
     * create_time : 1458545219
     * is_hidden : 0
     * title : 墙面_墙面装修_墙面装修设计_墙面装修效果图大全_墙面背景墙,吊顶,灯,隔断,图片
     * keywords : 墙面,墙面装修,墙面装修设计,墙面装修效果图大全,墙面背景墙,吊顶,灯,隔断,图片
     * description : 一起装修网装修效果图专区,提供2015年国内外最新流行的墙面,墙面装修,墙面装修设计,墙面装修效果图大全,墙面背景墙
     */

    private List<TagsBean> tags;

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class TagsBean {
        private String id;
        private String appid;
        private String name;
        private String pinyin;
        private String weight;
        private String type;
        private String hot;
        private String sort;
        private String user_id;
        private String create_time;
        private String is_hidden;
        private String title;
        private String keywords;
        private String description;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getHot() {
            return hot;
        }

        public void setHot(String hot) {
            this.hot = hot;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getIs_hidden() {
            return is_hidden;
        }

        public void setIs_hidden(String is_hidden) {
            this.is_hidden = is_hidden;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
