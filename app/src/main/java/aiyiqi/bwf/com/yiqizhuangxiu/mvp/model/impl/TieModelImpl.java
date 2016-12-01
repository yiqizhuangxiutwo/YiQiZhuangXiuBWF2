package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTie;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.TieModel;
import okhttp3.Call;

/**
 * Created by Lee Vane.
 */

public class TieModelImpl implements TieModel {
    @Override
    public void loadDatasSearch(String url, final Callback callback) {
        Log.d("TieModelImpl", url);
        OkHttpUtils.get().url(url).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("test", "cuole");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("ddd", response);
                        if(response == null){
                            return;
                        }
                        ResponseTie search = JSON.parseObject(response, ResponseTie.class);
                        Log.d("TieModelImpl", search.toString());
                        callback.loadSuccess(search);
                    }
                });
    }
}
