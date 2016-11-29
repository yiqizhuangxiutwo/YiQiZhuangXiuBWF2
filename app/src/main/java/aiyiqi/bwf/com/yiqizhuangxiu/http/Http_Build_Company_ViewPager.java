package aiyiqi.bwf.com.yiqizhuangxiu.http;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Buide_Company_ViewPager;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import okhttp3.Call;

/**
 * Created by Yishi on 2016/11/28.
 */

public class Http_Build_Company_ViewPager {

    /**
     * 装修公司界面头部Viewpager的网络访问数据
     * @param
     * @return
     */
    public void getHttp() {

        OkHttpUtils.get().url(Apis.HTTP_BUILD_COMPANY_VIEWPAGER).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (e!=null){
                    callback.HttpFailded(e);
                }
            }

            @Override
            public void onResponse(String response, int id) {

                Log.d("Http_Build_Company_View", response);

                Response_Buide_Company_ViewPager response_buide_company_viewPager = JSON.parseObject(response,Response_Buide_Company_ViewPager.class);
                callback.ViewPagerCallback(response_buide_company_viewPager);
            }
        });
    }

    private Callback callback;
    public void setCallback(Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void ViewPagerCallback( Response_Buide_Company_ViewPager response_home_viewpager);
        void HttpFailded(Exception e);
    }

}
