package aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl;

import android.text.TextUtils;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseSearch;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.SearchModel;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl.SearchModelImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.SearchPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.SearchView;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.UrlHandler;

/**
 * Created by Lee Vane.
 */

public class SearchPresenterImpl implements SearchPresenter {

    private SearchModel model;
    private SearchView view;
    private int nextpage = 1;

    public SearchPresenterImpl(SearchView view) {
        this.view = view;
        model = new SearchModelImpl();
    }

    @Override
    public void loadDatas(String content) {
        if(!TextUtils.isEmpty(content)){
            try {
                content = URLEncoder.encode(content,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        String url = UrlHandler.handlUrl(Apis.SEARCH, nextpage, content);
        Log.d("test1111", url);
        model.loadDatasSearch(url, new SearchModel.Callback() {
            @Override
            public void loadSuccess(List<ResponseSearch.DataBean> dataBeen) {
                view.showPictureSuccess(nextpage, dataBeen);
                nextpage ++;
            }

            @Override
            public void loadNoMoreData() {
                view.showNoMoreData();
            }

            @Override
            public void loadError() {
                view.showFailed();
            }
        });

    }

    @Override
    public void refresh(String content) {

    }
}
