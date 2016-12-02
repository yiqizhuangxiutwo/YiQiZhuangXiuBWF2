package aiyiqi.bwf.com.yiqizhuangxiu.mvp.view;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTie;

/**
 * Created by Lee Vane.
 */

public interface TieView {

    void showTie(ResponseTie dataBeen);
    void showNoMoreData();
    void showFailed();
}
