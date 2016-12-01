package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTongcheng;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface TongchenghuodongModel {

    void showTongchengDatas(Callback callback);


    public interface Callback{
        void loadDatasSuccess(List<ResponseTongcheng.DataBean.ForumlistBean> tongcheng);
        void loadError();


    }

}
