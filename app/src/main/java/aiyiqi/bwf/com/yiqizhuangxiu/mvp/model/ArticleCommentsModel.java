package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseArticleComments;

/**
 * Created by Lee Vane.
 */

public interface ArticleCommentsModel {

    void loadDatas(String url, Callback callback);
    void loadNoMoreDatas();
    public interface Callback{
        void loadArticleCommentsDatas(List<ResponseArticleComments.DataBean1.DataBean> dataBeen);
        void loadNoMoreDatas();
        void loadFailed();
    }
}
