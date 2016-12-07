package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTeamtogether;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.TeamTogetherModel;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/1.
 */

public class TeamTogetherModelImpl implements TeamTogetherModel {
    @Override
    public void showTeamTogetherDatas(int bossId,int pageNo, final Callback callback){
        OkHttpUtils.post()
                .addParams("token","DAB088BA50C9405E84C789055D657614")
                .addParams("app_version ","android_com.aiyiqi.galaxy_1.1")
                .addParams("haspermission","yes")
                .addParams("bossId",bossId+"")
                .addParams("pageNo ","pageNo")
                .addParams("pageSize","10")
                .url(Apis.HTTP_BUILD_COMPANY_TEAMTOGETHER)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Log.d("TeamTogetherModelImpl", response);
                ResponseTeamtogether responseTeamtogether = JSON.parseObject(response,ResponseTeamtogether.class);
                callback.loadDatasSuccess(responseTeamtogether);
            }
        });
    }

}
