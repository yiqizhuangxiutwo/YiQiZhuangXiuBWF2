package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponsePlate;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponsePlate1;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_New;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface PlateSpeakModel {
     void loadNextPage(String url, LoadCallbak callbak);
    public interface LoadCallbak{
        void loadSuccsess(ResponsePlate responsePlate);
        void loadFaild();
    }
}
