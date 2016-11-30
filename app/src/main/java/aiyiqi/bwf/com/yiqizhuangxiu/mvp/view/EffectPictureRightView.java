package aiyiqi.bwf.com.yiqizhuangxiu.mvp.view;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectPictureRight;

/**
 * Created by Lee Vane.
 */

public interface EffectPictureRightView {
    void showPictureSuccess(List<ResponseEffectPictureRight.DataBean.ListBean> listBeen);
    void showNoMoreData();
    void showFailed();
}
