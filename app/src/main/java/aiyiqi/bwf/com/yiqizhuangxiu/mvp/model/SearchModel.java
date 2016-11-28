package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseSearch;

/**
 * Created by Lee Vane.
 */

public interface SearchModel {
    void loadDatasSearch(String url, Callback callback);
    public interface Callback{
        void loadSuccess(List<ResponseSearch.DataBean> dataBeen);
        void loadNoMoreData();
        void loadError();
    }
}
