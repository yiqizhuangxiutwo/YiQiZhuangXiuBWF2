package aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl;

import android.util.Log;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseArticleComments;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.ArticleCommentsModel;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl.ArticleCommentsModelImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.ArticleCommentsPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.ArticleCommentsView;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.UrlHandler;

/**
 * Created by Lee Vane.
 */

public class ArticleCommentsPresenterImpl implements ArticleCommentsPresenter {

    private ArticleCommentsModel model;
    private ArticleCommentsView view;
    private int nextpage = 1;

    public ArticleCommentsPresenterImpl(ArticleCommentsView view) {
        this.view = view;
        this.model = new ArticleCommentsModelImpl();
    }

    @Override
    public void loadDatas(String content) {
        String url = UrlHandler.handlUrl(Apis.ARTICLE_COMMENTS, nextpage, content);
        Log.d("ArticleCommentsPresente", url);

        model.loadDatas(url, new ArticleCommentsModel.Callback() {
            @Override
            public void loadArticleCommentsDatas(List<ResponseArticleComments.DataBean1.DataBean> dataBeen) {
                view.showArticelComments(dataBeen);
            }

            @Override
            public void loadNoMoreDatas() {
                view.showNoMoreDatas();
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
