package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.iml;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponsePlate;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponsePlate1;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.PlateSpeakModel;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/25.
 */

public class PlateSpeakModelIml implements PlateSpeakModel{
    @Override
    public void loadNextPage(String url, final LoadCallbak callbak) {

        OkHttpUtils.get().url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callbak.loadFaild();
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("SpeakModelIml1111", response);
                        ResponsePlate responsePlate = JSON.parseObject(response,ResponsePlate.class);
                        callbak.loadSuccsess(responsePlate);
                    }
                });
    }
}
