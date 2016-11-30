package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectTopicLeft;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.EffectTopicLeftModel;
import okhttp3.Call;

/**
 * Created by Lee Vane.
 */

public class EffectTopicLeftModelImpl implements EffectTopicLeftModel {

    @Override
    public void loadTopicLeftDatas(String url, final Callback callback) {
        OkHttpUtils.get().url(url).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseEffectTopicLeft left = JSON.parseObject(response, ResponseEffectTopicLeft.class);
                        callback.loadDatasSuccess(left.getData().getList());
                    }
                });
    }
}
