package aiyiqi.bwf.com.yiqizhuangxiu.http;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_home_viewpager;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import okhttp3.Call;

/**
 * Created by Yishi on 2016/11/23.
 */

public class Http_Home_Viewpager {

    /**
     * Home界面头部Viewpager的网络访问数据
     * @param
     * @return
     */
    public void getHttp() {

        OkHttpUtils.get().url(Apis.HTTP_HOME_VIEWPAGER).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Response_home_viewpager response_home_viewpager = JSON.parseObject(response,Response_home_viewpager.class);
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
