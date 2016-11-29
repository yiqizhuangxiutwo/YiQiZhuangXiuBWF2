package aiyiqi.bwf.com.yiqizhuangxiu.http;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_GDZB;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.UrlHandler;
import okhttp3.Call;

/**
 * Created by Yishi on 2016/11/29.
 */
public class Http_GDZB {

    /**
     * 工地直播基本信息获取
     * @param
     * @return
     */

    public void getHttp(String id) {
        String url = UrlHandler.handlUrl(Apis.HTTP_GDZB);
        OkHttpUtils
                .post().addParams("token","DAB088BA50C9405E84C789055D657614")
                .addParams("app_version","android_com.aiyiqi.galaxy_1.1")
                .addParams("buildingId",id)
                .url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Response_GDZB response_gdzb = JSON.parseObject(response,Response_GDZB.class);
                callback.RecyclerViewCallback(response_gdzb);
            }
        });
    }

    private Callback callback;
    public void setCallback(Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void RecyclerViewCallback( Response_GDZB response_gdzb);
    }
}
