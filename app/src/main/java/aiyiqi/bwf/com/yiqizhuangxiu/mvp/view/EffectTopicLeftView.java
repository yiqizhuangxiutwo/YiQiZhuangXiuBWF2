package aiyiqi.bwf.com.yiqizhuangxiu.mvp.view;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectTopicLeft;

/**
 * Created by Lee Vane.
 */

public interface EffectTopicLeftView {
    void showEffectTopicLEft(List<ResponseEffectTopicLeft.DataBean.ListBean> listBeen);
    void showNoMoreData();
    void showFailed();
}
