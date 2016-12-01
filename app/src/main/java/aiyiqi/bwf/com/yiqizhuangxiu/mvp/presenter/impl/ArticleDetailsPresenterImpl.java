package aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl;

import android.util.Log;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseArticleDetails;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.ArticleDetailsModel;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl.ArticleDetailsModelImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.ArticleDetailsPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.ArticleDetailsView;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.UrlHandler;

/**
 * Created by Lee Vane.
 */

public class ArticleDetailsPresenterImpl implements ArticleDetailsPresenter {
    private ArticleDetailsModel model;
    private ArticleDetailsView view;
    private int nextpage = 1;
    public ArticleDetailsPresenterImpl(ArticleDetailsView view) {
        this.view = view;
        model = new ArticleDetailsModelImpl();
    }

    @Override
    public void loadDatas(String content) {
        String url = UrlHandler.handlUrl(Apis.ARTICLE, content, nextpage);
        Log.d("aaaa", url);
       model.loadDatas(url, new ArticleDetailsModel.Callback() {
           @Override
           public void loadArticleDatas(ResponseArticleDetails.DataBean.CurrentNewsBean currentNewsBean) {
               view.showArticel(currentNewsBean);
           }

           @Override
           public void loadRelatedDatas(List<ResponseArticleDetails.DataBean.RelatedNewsBean> relatedNewsBeen) {
                view.showRelated(relatedNewsBeen);
           }

           @Override
           public void loadFailed() {
                view.showError();
               nextpage --;
           }
       });
        nextpage ++;
    }

    @Override
    public void refresh(String content) {

    }
}
