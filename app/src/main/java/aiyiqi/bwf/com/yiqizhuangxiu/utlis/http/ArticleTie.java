package aiyiqi.bwf.com.yiqizhuangxiu.utlis.http;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseRecycleViewList;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.APIUtils;
import okhttp3.Call;

/**
 * Created by Lee Vane.
 */

public class ArticleTie {

    public static void AT (String url, int page, int type, int id){
        HashMap<String, String> map = new HashMap<>();
        map.put("page", page + "");
        map.put("type", type + "");
        map.put("id", id + "");

        OkHttpUtils.get().url("http://118.178.142.34/YiQiHouse/HomeBBS?page=1")
                .addHeader("X-PASSPORT-APITOKEN", APIUtils.getXPassportApitoken(map))
                .params(map)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseRecycleViewList list = JSON.parseObject(response,ResponseRecycleViewList.class);
                        Log.d("ArticleTie", list.toString());
                    }
                });
    }
}
