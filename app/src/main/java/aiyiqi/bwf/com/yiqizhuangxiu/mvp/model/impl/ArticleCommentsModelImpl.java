package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseArticleComments;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.ArticleCommentsModel;
import okhttp3.Call;

/**
 * Created by Lee Vane.
 */

public class ArticleCommentsModelImpl implements ArticleCommentsModel {
    @Override
    public void loadDatas(String url, final Callback callback) {
        OkHttpUtils.get().url(url).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.loadFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseArticleComments comments = JSON.parseObject(response, ResponseArticleComments.class);
                        if(comments.getData().getTotal().equals("0")){
                            callback.loadNoMoreDatas();
                            return;
                        }
                        callback.loadArticleCommentsDatas(comments.getData().getData());
                    }
                });
    }

    @Override
    public void loadNoMoreDatas() {

    }
}
