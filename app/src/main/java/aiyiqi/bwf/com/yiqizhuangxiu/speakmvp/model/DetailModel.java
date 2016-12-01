package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Detail;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface DetailModel {
    void loadNextDetail(String url,DetailCallback detailCallback);
    public interface DetailCallback{
        void loadDetail(Response_Detail response_detail);
    }
}
