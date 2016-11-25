package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectPictureRight;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.EffectPictureRightModel;
import okhttp3.Call;

/**
 * Created by Lee Vane.
 */

public class EffectPictureRightModelImpl implements EffectPictureRightModel {
    @Override
    public void loadEffectPictureRightDatas(String url, final Callback callback) {
        OkHttpUtils.get().url(url).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseEffectPictureRight responseEffectPictureRight = JSON.parseObject(response, ResponseEffectPictureRight.class);
                        callback.loadEffectPictureRightSuccess(responseEffectPictureRight.getData().getList());
                    }
                });
    }
}
