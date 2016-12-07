package aiyiqi.bwf.com.yiqizhuangxiu.mvp.view;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseArticleComments;

/**
 * Created by Lee Vane.
 */

public interface ArticleCommentsView {

    void showArticelComments(List<ResponseArticleComments.DataBean1.DataBean> dataBeen);
    void showNoMoreDatas();
    void showError();
}
