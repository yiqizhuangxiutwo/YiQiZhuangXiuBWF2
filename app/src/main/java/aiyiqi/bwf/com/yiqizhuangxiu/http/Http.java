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
    public Response_home_viewpager getHttp(String url) {

        Log.d("msgnn", "方法开始运行");
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.d("msgnn", "网络访问错误");
            }

            @Override
            public void onResponse(String response, int id) {
                strresponse = response;
                Log.d("msgnn", strresponse);
            }
        });
        Response_home_viewpager response_home_viewpager = JSON.parseObject(strresponse,Response_home_viewpager.class);

        Log.d("msgnn", strresponse);
        Log.d("msgnn", "111response_home_viewpager:" + response_home_viewpager);

        return response_home_viewpager;
    }
}
