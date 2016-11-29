package aiyiqi.bwf.com.yiqizhuangxiu.http;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_ZXXT_Up_Tag;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_home_viewpager;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import okhttp3.Call;

/**
 * Created by lenovo on 2016-11-24.
 */

public class Http_ZXXT_Tag {

    /**
     * 装修学堂头部的tag数据
     * @param
     * @return
     */
    public void getHttp() {

        OkHttpUtils.get().url(Apis.ZZXT_TAG).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (e!=null){
                    callback.HttpFailded(e);
                }
            }

            @Override
            public void onResponse(String response, int id) {
                Response_ZXXT_Up_Tag response_zxxt_up_tag = JSON.parseObject(response,Response_ZXXT_Up_Tag.class);
                callback.ZXXTTagCallback(response_zxxt_up_tag);
            }
        });
    }

    private Http_ZXXT_Tag.Callback callback;
    public void setCallback(Http_ZXXT_Tag.Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void ZXXTTagCallback(Response_ZXXT_Up_Tag response_zxxt_up_tag);
        void HttpFailded(Exception e);
    }

}
