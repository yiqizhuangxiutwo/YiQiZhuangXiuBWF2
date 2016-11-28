package aiyiqi.bwf.com.yiqizhuangxiu.http;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_IndependentOrder;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import okhttp3.Call;

/**
 * Created by Yishi on 2016/11/25.
 */

public class Http_IndependentOrder {

    /**
     * 自助下单的网络数据
     * @param
     * @return
     */
    public void getHttp() {

        OkHttpUtils.get().url(Apis.ZZXD).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (e!=null){
                    callback.HttpFailded(e);
                }
            }

            @Override
            public void onResponse(String response, int id) {
               Response_IndependentOrder response_independentOrder = JSON.parseObject(response,Response_IndependentOrder.class);
                callback.IndependentOrderCallback(response_independentOrder);
            }
        });
    }

    private Http_IndependentOrder.Callback callback;
    public void setCallback(Http_IndependentOrder.Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void IndependentOrderCallback(Response_IndependentOrder response_independentOrder);
        void HttpFailded(Exception e);
    }
}
