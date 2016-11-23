package aiyiqi.bwf.com.yiqizhuangxiu.http;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_home_viewpager;
import okhttp3.Call;

/**
 * Created by Yishi on 2016/11/23.
 */

public class Http {
    public String strresponse = null;

    /**
     * Home界面头部Viewpager的网络访问数据
     * @param url
     * @return
     */
    public void getHttp(String url) {

        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                strresponse = response;
                Response_home_viewpager response_home_viewpager = JSON.parseObject(strresponse,Response_home_viewpager.class);
                callback.ViewPagerCallback(response_home_viewpager);
            }
        });
    }

    private Callback callback;
    public void setCallback(Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void ViewPagerCallback(Response_home_viewpager response_home_viewpager);
    }

}
