package aiyiqi.bwf.com.yiqizhuangxiu.http;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_PostDetails;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/28.
 */

public class Http_SearchPostDetails {
    /**
     * 装修学堂头部的tag数据
     * @param
     * @return
     */
    public void getHttp() {

        OkHttpUtils.get().url(Apis.SEARCH_POSTD_EATAILS).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (e!=null){
                    callback.HttpFailded(e);
                }
            }

            @Override
            public void onResponse(String response, int id) {
                Response_PostDetails response_postDetails = JSON.parseObject(response, Response_PostDetails.class);
                callback.PostDetails(response_postDetails);
            }
        });
    }

    private Http_SearchPostDetails.Callback callback;
    public void setCallback(Http_SearchPostDetails.Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void PostDetails(Response_PostDetails response_postDetails);
        void HttpFailded(Exception e);
    }
}
