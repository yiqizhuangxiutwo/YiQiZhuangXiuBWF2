package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.iml;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Detail;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_zan;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.DetailModel;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/30.
 */

public class DetailModelIml implements DetailModel{
    private String articleId;
    private DetailCallback detailCallback;
    @Override
    public void loadDatas(String articleId, DetailCallback detailCallback) {
        this.articleId = articleId;
        this.detailCallback = detailCallback;
        loadDetail();
        loadNextZan();
    }

    @Override
    public void loadDetail() {
        String urlDetail = "http://bbs.17house.com/motnt/index.php?a=viewThread&c=forumThread&imgwidth=330&uuid=86305803367590&tid="+articleId+"&m=forum&haspermission=yes&model=android&app_version=android_com.aiyiqi.galaxy_1.1";
        OkHttpUtils.get().url(urlDetail).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Response_Detail detail = JSON.parseObject(response,Response_Detail.class);
                        detailCallback.loadDetail(detail);
                    }
                });
    }

    @Override
    public void loadNextZan() {
        String urlZan = "http://bbs.17house.com/motnt/index.php?a=threadZan&c=forumThread&uuid=86305803367590&tid="+articleId+"&uid=1633055&m=forum&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
        OkHttpUtils.get().url(urlZan).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Response_zan zan = JSON.parseObject(response,Response_zan.class);
                        detailCallback.loadZan(zan);
                    }
                });
    }
}
