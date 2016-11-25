package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/25.
 */

public class SpeakModelIml implements SpeakModel{
    @Override
    public void loadNextPage(String url,final LoadCallbak callbak) {

        OkHttpUtils.get().url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callbak.loadFaild();
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("SpeakModelIml", response);
                        Response_Essence response_essence = JSON.parseObject(response,Response_Essence.class);
                        callbak.loadSuccsess(response_essence.getData());
                    }
                });
    }
}
