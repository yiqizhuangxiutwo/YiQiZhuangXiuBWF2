package aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTongcheng;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.TongchenghuodongModel;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl.TongchengModelImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.TongchengPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.TongchengView;

/**
 * Created by Administrator on 2016/11/25.
 */

public class TongchengPresenterImpl implements TongchengPresenter {
    private TongchengView tongchengView;
    private TongchenghuodongModel tongchengModel;

    public TongchengPresenterImpl(TongchengView view) {
        this.tongchengView = view;
        tongchengModel =new TongchengModelImpl();
    }
    @Override
    public void loadTongchengDatas() {

        tongchengModel.showTongchengDatas(new TongchenghuodongModel.Callback() {
            @Override
            public void loadDatasSuccess(List<ResponseTongcheng.DataBean.ForumlistBean> tongcheng) {
                tongchengView.showTongchengSuccess(tongcheng);
            }

            @Override
            public void loadError() {

            }
        });

    }

}
