package aiyiqi.bwf.com.yiqizhuangxiu.mvp.view;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseSearch;

/**
 * Created by Lee Vane.
 */

public interface SearchView {
    void showPictureSuccess(int page, List<ResponseSearch.DataBean> dataBeen);
    void showNoMoreData();
    void showFailed();
}
