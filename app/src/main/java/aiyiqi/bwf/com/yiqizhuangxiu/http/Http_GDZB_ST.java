package aiyiqi.bwf.com.yiqizhuangxiu.http;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_GDZB_ST;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import okhttp3.Call;

/**
 * Created by Yishi on 2016/11/30.
 */
public class Http_GDZB_ST {

    /**
     * 工地直播装修嗮图
     * @param
     * @return
     */

    public void getHttp(int progressId,String id) {

        Log.d("Http_GDZB_ST", "progressId:" + progressId);
        Log.d("Http_GDZB_ST", id);

        OkHttpUtils.post()
                .addParams("progressId",progressId+"")
                .addParams("app_version","android_com.aiyiqi.galaxy_1.1")
                .addParams("buildingId",id)
                .url(Apis.HTTP_GDZB_ST).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Response_GDZB_ST response_gdzb_st = JSON.parseObject(response,Response_GDZB_ST.class);
                        callback.RecyclerViewCallback(response_gdzb_st);
                    }
                });
    }

    private Callback callback;
    public void setCallback(Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void RecyclerViewCallback(Response_GDZB_ST response_gdzb_st);
    }
}
