package aiyiqi.bwf.com.yiqizhuangxiu.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_ZXXT_DownNews;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.UrlHandler;
import okhttp3.Call;

/**
 * Created by Yishi on 2016/12/2.
 */
public class Http_ZXXT_DownNews {
    /**
     * 装修学堂下部的新闻数据
     * @param
     * @return
     */
    public void getHttp(final int state, int page) {
        String url = UrlHandler.handlUrl(Apis.ZZXT_DOWNNEWS,state,page);
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
                String str = stringMap.get("data");
                Response_ZXXT_DownNews response_zxxt_downNews = JSON.parseObject(response,Response_ZXXT_DownNews.class);
                callback.ZXXTTagCallback(response_zxxt_downNews,str);
            }
        });
    }

    private Callback callback;
    public void setCallback(Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void ZXXTTagCallback(Response_ZXXT_DownNews response_zxxt_downNews,String str);
        void HttpFailded(Exception e);
    }

}
