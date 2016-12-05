package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseArticleDetails;

/**
 * Created by Lee Vane.
 */

public interface ArticleDetailsModel {

    void loadDatas(String url, Callback callback);
    void loadRelatedDatas();
    void loadTagsDatas();
    public interface Callback{
        void loadArticleDatas(ResponseArticleDetails.DataBean.CurrentNewsBean currentNewsBean);
        void loadRelatedDatas(List<ResponseArticleDetails.DataBean.RelatedNewsBean> relatedNewsBeen);
        void loadTagsDatas(String dateBean);
        void loadFailed();
    }
}
