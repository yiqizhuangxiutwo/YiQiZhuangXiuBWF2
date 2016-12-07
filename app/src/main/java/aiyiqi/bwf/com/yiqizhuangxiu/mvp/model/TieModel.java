package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTie;

/**
 * Created by Lee Vane.
 */

public interface TieModel {
    void loadDatasSearch(String url, Callback callback);
    public interface Callback{
        void loadSuccess(ResponseTie dataBeen);
        void loadNoMoreData();
        void loadError();
    }
}
