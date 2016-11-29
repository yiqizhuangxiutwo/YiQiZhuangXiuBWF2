package aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl;

import android.util.Log;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectTopicLeft;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.EffectTopicLeftModel;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl.EffectTopicLeftModelImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.EffectTopicLeftPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.EffectTopicLeftView;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.UrlHandler;

/**
 * Created by Lee Vane.
 */

public class EffectTopicLeftPresenterImpl implements EffectTopicLeftPresenter {

    private EffectTopicLeftModel model;
    private EffectTopicLeftView view;
    private int nextpage = 1;

    public EffectTopicLeftPresenterImpl(EffectTopicLeftView view) {
        this.view = view;
        model = new EffectTopicLeftModelImpl();
    }

    @Override
    public void loadDatas() {
        String url = UrlHandler.handlUrl(Apis.EFFECT_TOPIC_LEFT, nextpage);
        Log.d("EffectTopicLeftPresente", url.toString());
        model.loadTopicLeftDatas(url, new EffectTopicLeftModel.Callback() {
            @Override
            public void loadDatasSuccess(List<ResponseEffectTopicLeft.DataBean.ListBean> listBeen) {
                view.showEffectTopicLEft(listBeen);
            }

            @Override
            public void noMoreData() {
                view.showNoMoreData();
            }

            @Override
            public void loadError() {
                view.showFailed();
                nextpage --;
            }

        });
        nextpage ++;
    }
}
