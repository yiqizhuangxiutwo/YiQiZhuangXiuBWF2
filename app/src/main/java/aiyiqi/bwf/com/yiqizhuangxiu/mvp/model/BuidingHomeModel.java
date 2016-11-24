package aiyiqi.bwf.com.yiqizhuangxiu.mvp.model;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseBuidingHome;

/**
 * Created by Lee Vane.
 */

public interface BuidingHomeModel {

    void showBuidingHomeDatas(Callback callback);

    public interface Callback{
        void loadDatasSuccess(ResponseBuidingHome buidingHome);
        void loadError();
    }
}
