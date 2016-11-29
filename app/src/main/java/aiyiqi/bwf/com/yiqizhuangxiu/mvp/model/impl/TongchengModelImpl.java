package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTongcheng;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.TongchenghuodongModel;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/25.
 */

public class TongchengModelImpl implements TongchenghuodongModel{
    @Override
    public void showTongchengDatas(final Callback callback) {
        OkHttpUtils.get().url(Apis.HTTP_TONGCHENG)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseTongcheng tongcheng = JSON.parseObject(response, ResponseTongcheng.class);
                        Log.d("TongchengModelImpl", "tongcheng:" + tongcheng);
                        callback.loadDatasSuccess(tongcheng.getData().getForumlist());
                    }

                });
    }


}
