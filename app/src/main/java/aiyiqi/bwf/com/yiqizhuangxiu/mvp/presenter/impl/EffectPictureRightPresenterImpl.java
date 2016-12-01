package aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl;

import android.util.Log;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectPictureRight;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.EffectPictureRightModel;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl.EffectPictureRightModelImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.EffectPictureRightPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.EffectPictureRightView;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.UrlHandler;

/**
 * Created by Lee Vane.
 */

public class
EffectPictureRightPresenterImpl implements EffectPictureRightPresenter {

    private EffectPictureRightModel model;
    private EffectPictureRightView view;
    private int nextpage = 1;
    public EffectPictureRightPresenterImpl(EffectPictureRightView view) {
        this.view = view;
        model = new EffectPictureRightModelImpl();
    }

    @Override
    public void loadDatas() {
        String url = UrlHandler.handlUrl(Apis.EFFECT_PICTURE_RIGHT, nextpage);
        Log.d("EffectPictureRightPrese", url.toString());
        model.loadEffectPictureRightDatas(url, new EffectPictureRightModel.Callback() {
            @Override
            public void loadEffectPictureRightSuccess(List<ResponseEffectPictureRight.DataBean.ListBean> listBeen) {
                view.showPictureSuccess(listBeen);
            }

            @Override
            public void isNoMoreData() {
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
