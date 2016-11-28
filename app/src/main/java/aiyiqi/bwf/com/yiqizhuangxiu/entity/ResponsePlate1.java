package aiyiqi.bwf.com.yiqizhuangxiu.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class ResponsePlate1 {

    /**
     * data : [{"id":"4303","title":"成都装修论坛","icon":"http://bbs.17house.com/data/attachment/common/b0/common_4303_icon.png","threadsnum":"2685","postsnum":"10492"},{"id":"4304","title":"成都投诉表扬","icon":"http://bbs.17house.com/data/attachment/common/7e/common_4304_icon.png","threadsnum":"36","postsnum":"147"},{"id":"4608","title":"成都业主装修日记","icon":"http://bbs.17house.com/data/attachment/common/3c/common_4608_icon.png","threadsnum":"69","postsnum":"156"},{"id":"4306","title":"成都商家交流","icon":"http://bbs.17house.com/data/attachment/common/b0/common_4306_icon.png","threadsnum":"484","postsnum":"985"}]
     * error : 0
     * message : 成功
     */

    private String error;
    private String message;
    /**
     * id : 4303
     * title : 成都装修论坛
     * icon : http://bbs.17house.com/data/attachment/common/b0/common_4303_icon.png
     * threadsnum : 2685
     * postsnum : 10492
     */

    private List<DataBean> data;

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
        private String id;
        private String title;
        private String icon;
        private String threadsnum;
        private String postsnum;

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

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getThreadsnum() {
            return threadsnum;
        }

        public void setThreadsnum(String threadsnum) {
            this.threadsnum = threadsnum;
        }

        public String getPostsnum() {
            return postsnum;
        }

        public void setPostsnum(String postsnum) {
            this.postsnum = postsnum;
        }
    }
}
