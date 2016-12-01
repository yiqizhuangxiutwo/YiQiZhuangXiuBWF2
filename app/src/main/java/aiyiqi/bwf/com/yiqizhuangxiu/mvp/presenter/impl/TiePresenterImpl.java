package aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl;

import android.util.Log;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTie;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.TieModel;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl.TieModelImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.TiePresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.TieView;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.UrlHandler;

/**
 * Created by Lee Vane.
 */

public class TiePresenterImpl implements TiePresenter {

    private TieModel model;
    private TieView view;

    public TiePresenterImpl(TieView view) {
        this.view = view;
        model = new TieModelImpl();
    }

    @Override
    public void loadDatas(String id) {

        String url = UrlHandler.handlUrl(Apis.TIE, id);
        Log.d("test1111", url);
        model.loadDatasSearch(url, new TieModel.Callback() {
            @Override
            public void loadSuccess(ResponseTie dataBeen) {
                view.showTie(dataBeen);
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
    public void refresh(String id) {

    }


}
