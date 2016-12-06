package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface SpeakModel {
     void loadNextPage(String url,LoadCallbak callbak);
    public interface LoadCallbak{
        void loadSuccsess(List<Response_Essence.DataBean> dataBeen);
        void loadFaild();
    }
}
