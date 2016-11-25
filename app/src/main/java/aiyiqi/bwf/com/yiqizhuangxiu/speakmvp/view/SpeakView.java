package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface SpeakView {
    void showPage(List<Response_Essence.DataBean> dataBeen);
    void showFaild();
}
