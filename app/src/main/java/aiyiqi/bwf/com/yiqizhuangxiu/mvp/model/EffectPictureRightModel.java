package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectPictureRight;

/**
 * Created by Lee Vane.
 */

public interface EffectPictureRightModel {

    void loadEffectPictureRightDatas(String url, Callback callback);
    public interface Callback{
        void loadEffectPictureRightSuccess(List<ResponseEffectPictureRight.DataBean.ListBean> listBeen);
        void isNoMoreData();
        void loadError();
    }

}
