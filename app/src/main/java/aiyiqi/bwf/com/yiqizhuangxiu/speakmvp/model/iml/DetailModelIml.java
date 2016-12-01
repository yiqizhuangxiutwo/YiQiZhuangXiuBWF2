package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.iml;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Detail;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.DetailModel;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/30.
 */

public class DetailModelIml implements DetailModel{
    @Override
    public void loadNextDetail(String url, final DetailCallback detailCallback) {
        OkHttpUtils.get().url(url)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }
            @Override
            public void onResponse(String response, int id) {
                Log.d("DetailModelIml", response);
                Response_Detail detail = JSON.parseObject(response,Response_Detail.class);
                detailCallback.loadDetail(detail);
            }
        });
    }
}
