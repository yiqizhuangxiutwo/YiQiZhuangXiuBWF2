package aiyiqi.bwf.com.yiqizhuangxiu.http;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseRecycleViewList;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import okhttp3.Call;

/**
 * Created by lenovo on 2016-11-24.
 */

public class Http_Home_RecyclerView {
    public String strresponse = null;

    /**
     * Home界面下方的RecycleView的网络访问数据
     * @param
     * @return
     */


    public void getHttp() {

        OkHttpUtils.get().url(Apis.HTTP_HOME_RECYCLERVIEW).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                strresponse = response;
                ResponseRecycleViewList responseRecycleViewList = JSON.parseObject(strresponse,ResponseRecycleViewList.class);
                callback.RecyclerViewCallback(responseRecycleViewList);
            }
        });
    }

    private Http_Home_RecyclerView.Callback callback;
    public void setCallback(Http_Home_RecyclerView.Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void RecyclerViewCallback(ResponseRecycleViewList responseRecycleViewList);
    }
}
