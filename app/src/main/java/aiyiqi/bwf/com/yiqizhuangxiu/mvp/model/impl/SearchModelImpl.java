package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseSearch;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.SearchModel;
import okhttp3.Call;

/**
 * Created by Lee Vane.
 */

public class SearchModelImpl implements SearchModel {
    @Override
    public void loadDatasSearch(String url, final Callback callback) {
        OkHttpUtils.get().url(url).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("test", "cuole");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if(response == null){
                            return;
                        }
                        ResponseSearch search = JSON.parseObject(response, ResponseSearch.class);
                        callback.loadSuccess(search.getData());
                    }
                });
    }
}
