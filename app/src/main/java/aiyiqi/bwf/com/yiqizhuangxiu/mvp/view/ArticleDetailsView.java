package aiyiqi.bwf.com.yiqizhuangxiu.mvp.view;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseArticleDetails;

/**
 * Created by Lee Vane.
 */

public interface ArticleDetailsView {

    void showArticel(ResponseArticleDetails.DataBean.CurrentNewsBean currentNewsBeen);
    void showRelated(List<ResponseArticleDetails.DataBean.RelatedNewsBean> relatedNewsBeen);
    void showError();
}
