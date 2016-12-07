package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_New;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface NewSpeakModel {
     void loadNextPage(String url, LoadCallbak callbak);
    public interface LoadCallbak{
        void loadSuccsess(List<Response_New.DataBean> dataBeen);
        void loadFaild();
    }
}
