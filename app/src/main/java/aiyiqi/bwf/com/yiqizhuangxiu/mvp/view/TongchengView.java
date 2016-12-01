package aiyiqi.bwf.com.yiqizhuangxiu.mvp.view;


import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTongcheng;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface TongchengView {

    void showTongchengSuccess(List<ResponseTongcheng.DataBean.ForumlistBean> tongcheng);
    void showFailed();
}
