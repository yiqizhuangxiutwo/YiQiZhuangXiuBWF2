package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTeamtogether;

/**
 * Created by Administrator on 2016/12/1.
 */

public interface TeamTogetherModel {

    void showTeamTogetherDatas(int bossId,int pageNo,Callback callback);

    public interface Callback{
        void loadDatasSuccess(ResponseTeamtogether teamtogether);
        void loadError();


    }
}
