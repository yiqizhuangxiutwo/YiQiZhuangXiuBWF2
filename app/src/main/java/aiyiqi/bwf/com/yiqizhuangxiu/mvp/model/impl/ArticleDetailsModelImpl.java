package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseArticleDetails;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.ArticleDetailsModel;
import okhttp3.Call;

/**
 * Created by Lee Vane.
 */

public class ArticleDetailsModelImpl implements ArticleDetailsModel {
    @Override
    public void loadDatas(String url, final Callback callback) {

        OkHttpUtils.get().url(url).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseArticleDetails articleDetails = JSON.parseObject(response, ResponseArticleDetails.class);
                        callback.loadArticleDatas(articleDetails.getData().getCurrentNews());

                        callback.loadRelatedDatas(articleDetails.getData().getRelatedNews());

                        callback.loadTagsDatas(response);

                    }
                });
    }

    @Override
    public void loadRelatedDatas() {

    }

    @Override
    public void loadTagsDatas() {

    }

}
