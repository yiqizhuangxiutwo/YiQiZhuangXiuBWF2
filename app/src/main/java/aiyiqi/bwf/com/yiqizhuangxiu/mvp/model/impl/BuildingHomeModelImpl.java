package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseBuidingHome;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.BuidingHomeModel;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import okhttp3.Call;

/**
 * Created by Lee Vane.
 */

public class BuildingHomeModelImpl implements BuidingHomeModel {

    @Override
    public void showBuidingHomeDatas(final Callback callback) {
        OkHttpUtils.get().url(Apis.HTTP_BUIDLING_HOME)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseBuidingHome home = JSON.parseObject(response, ResponseBuidingHome.class);
                        Log.d("BuildingHomeModelImpl", "home:" + home);
                        callback.loadDatasSuccess(home);
                    }
                });
    }
}
