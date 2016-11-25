package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_New;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/25.
 */

public class NewSpeakModelIml implements NewSpeakModel{
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
                        Response_New response_new = JSON.parseObject(response,Response_New.class);
                        callbak.loadSuccsess(response_new.getData());
                    }
                });
    }
}
