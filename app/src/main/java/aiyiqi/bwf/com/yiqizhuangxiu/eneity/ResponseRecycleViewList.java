package aiyiqi.bwf.com.yiqizhuangxiu.eneity;

import java.util.List;

/**
 * Created by Lee Vane.
 */

public class ResponseRecycleViewList {

    /**
     * data : [{"type":3,"id":"1217851","title":"装修预算报价10大陷阱！装修必看","author":"张小雨","uid":"1425483","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1425483&size=big","dateline":"4小时前","sort":"1479886861","views":"36","replies":"0","like_num":0,"path":"http://static-news.17house.com/bbs/forum/201611/23/153954w8nppie2l6w68pi1.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1217787","title":"放大招！老房、二手房装修秘籍！","author":"burns","uid":"1513721","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1513721&size=big","dateline":"6小时前","sort":"1479880826","views":"50","replies":"0","like_num":0,"path":"http://static-news.17house.com/bbs/forum/201611/23/103106o3kbn5151n8pnssn.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":1,"id":"258864","title":"理想的单身女生卧室就这样温暖而美好","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/23/201611231109206914.jpg","views":239,"like_num":0,"replies":"0","dateline":"9小时前","sort":"1479870574","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/258864.html"},{"type":3,"id":"1217774","title":"巅峰对决，2016年度日记大赛总决赛粉丝总动员","author":"bujia","uid":"1490946","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1490946&size=big","dateline":"20小时前","sort":"1479831457","views":"352","replies":"1","like_num":3,"path":"http://static-news.17house.com/bbs/forum/201611/22/235830tpm9hu99wh5hooz9.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1217754","title":"干货！网友装修一年后的31条血泪总结","author":"张小雨","uid":"1425483","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1425483&size=big","dateline":"2天前","sort":"1479806631","views":"535","replies":"1","like_num":5,"path":"http://static-news.17house.com/bbs/forum/201611/22/171653r71s7m0dpoodxvvv.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":1,"id":"258780","title":"冬日之花 与暗色共舞","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/22/201611221526507209.jpg","views":199,"like_num":0,"replies":"0","dateline":"2天前","sort":"1479799620","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/258780.html"},{"type":1,"id":"258778","title":"异国风情 性感美家","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/22/201611221514031575.jpg","views":211,"like_num":0,"replies":"0","dateline":"2天前","sort":"1479798900","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/258778.html"},{"type":1,"id":"258764","title":"过来人的厨房装修经验，血泪总结你一定要看！","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/22/201611221450021155.jpg","views":315,"like_num":0,"replies":"0","dateline":"2天前","sort":"1479797520","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/258764.html"},{"type":3,"id":"1217663","title":"虫哥和猫猫的书窝搭建小记之五十五\u2014\u2014柏辉十三周年，弯弓射\u2026\u2026脱靶？拖把","author":"喝普洱的猫猫","uid":"1545248","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1545248&size=big","dateline":"2天前","sort":"1479785925","views":"523","replies":"17","like_num":11,"path":"http://static-news.17house.com/web/bbs/201611/22/1135272702.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":1,"id":"258707","title":"儿童房面积太小怎么破？","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/22/201611221112198180.jpg","views":403,"like_num":0,"replies":"1","dateline":"2天前","sort":"1479784364","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/258707.html"}]
     * newCount : 0
     * currentPage : 1
     * totalCount : 150
     * error : 0
     * message : 成功
     */

    private int newCount;
    private int currentPage;
    private int totalCount;
    private String error;
    private String message;
    /**
     * type : 3
     * id : 1217851
     * title : 装修预算报价10大陷阱！装修必看
     * author : 张小雨
     * uid : 1425483
     * avtUrl : http://bbs.17house.com/uc_server/avatar.php?uid=1425483&size=big
     * dateline : 4小时前
     * sort : 1479886861
     * views : 36
     * replies : 0
     * like_num : 0
     * path : http://static-news.17house.com/bbs/forum/201611/23/153954w8nppie2l6w68pi1.jpg!w720
     * forum : {"fid":"2","name":"北京装修论坛"}
     * followed : 0
     */

    private List<DataBean> data;

    public int getNewCount() {
        return newCount;
    }

    public void setNewCount(int newCount) {
        this.newCount = newCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int type;
        private String id;
        private String title;
        private String author;
        private String uid;
        private String avtUrl;
        private String dateline;
        private String sort;
        private String views;
        private String replies;
        private int like_num;
        private String path;
        /**
         * fid : 2
         * name : 北京装修论坛
         */

        private ForumBean forum;
        private int followed;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getAvtUrl() {
            return avtUrl;
        }

        public void setAvtUrl(String avtUrl) {
            this.avtUrl = avtUrl;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getReplies() {
            return replies;
        }

        public void setReplies(String replies) {
            this.replies = replies;
        }

        public int getLike_num() {
            return like_num;
        }

        public void setLike_num(int like_num) {
            this.like_num = like_num;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public ForumBean getForum() {
            return forum;
        }

        public void setForum(ForumBean forum) {
            this.forum = forum;
        }

        public int getFollowed() {
            return followed;
        }

        public void setFollowed(int followed) {
            this.followed = followed;
        }

        public static class ForumBean {
            private String fid;
            private String name;

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
