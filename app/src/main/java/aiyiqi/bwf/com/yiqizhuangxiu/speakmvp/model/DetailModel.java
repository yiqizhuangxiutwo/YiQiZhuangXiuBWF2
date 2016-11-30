package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface DetailModel {
    void loadNextDetail(String url,DetailCallback detailCallback);
    public interface DetailCallback{
        void loadDetail(String url);
    }
}
