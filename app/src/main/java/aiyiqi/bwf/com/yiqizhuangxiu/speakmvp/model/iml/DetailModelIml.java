package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.iml;

import com.zhy.http.okhttp.OkHttpUtils;

import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.DetailModel;

/**
 * Created by Administrator on 2016/11/30.
 */

public class DetailModelIml implements DetailModel{
    @Override
    public void loadNextDetail(String url,DetailCallback detailCallback) {
        detailCallback.loadDetail(url);
    }
}
