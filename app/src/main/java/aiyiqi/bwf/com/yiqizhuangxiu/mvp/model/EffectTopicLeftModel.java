package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectTopicLeft;

/**
 * Created by Lee Vane.
 */

public interface EffectTopicLeftModel {

    void loadTopicLeftDatas(String url, Callback callback);

    public interface Callback{
        void loadDatasSuccess(List<ResponseEffectTopicLeft.DataBean.ListBean> listBeen);
        void noMoreData();
        void loadError();
    }
}
