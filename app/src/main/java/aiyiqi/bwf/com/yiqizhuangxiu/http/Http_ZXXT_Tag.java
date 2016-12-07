package aiyiqi.bwf.com.yiqizhuangxiu.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.UrlHandler;
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
    public void getHttp(int state) {
        String url = UrlHandler.handlUrl(Apis.ZZXT_TAG,state);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (e != null) {
                    callback.HttpFailded(e);
                }
            }

            @Override
            public void onResponse(String response, int id) {
                Map<String, String> stringMap = new HashMap<>();
                JSONObject jsonObject = JSON.parseObject(response);
                Set<String> keys = jsonObject.keySet();
                Iterator iterator = keys.iterator();
                while (iterator.hasNext()) {
                    String key = (String) iterator.next();
                    stringMap.put(key,jsonObject.getString(key));
                }
                callback.ZXXTTagCallback(stringMap);
            }
        });
    }

    private Http_ZXXT_Tag.Callback callback;
    public void setCallback(Http_ZXXT_Tag.Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void ZXXTTagCallback(Map<String, String> stringMap);
        void HttpFailded(Exception e);
    }

}
