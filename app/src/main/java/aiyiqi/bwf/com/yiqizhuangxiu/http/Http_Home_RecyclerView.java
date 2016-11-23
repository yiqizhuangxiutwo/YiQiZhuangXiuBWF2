package aiyiqi.bwf.com.yiqizhuangxiu.http;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_home_viewpager;
import okhttp3.Call;

/**
 * Created by lenovo on 2016-11-24.
 */

public class Http_Home_RecyclerView {
    public String strresponse = null;

    /**
     * Home界面下方的RecycleView的网络访问数据
     * @param url
     * @return
     */

    //TODO  还未完成


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

    private Http_Home_Viewpager.Callback callback;
    public void setCallback(Http_Home_Viewpager.Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void ViewPagerCallback(Response_home_viewpager response_home_viewpager);
    }
}
