package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_New;

/**
 * Created by Administrator on 2016/11/25.
 */

public interface NewSpeakView {
    void showPage(List<Response_New.DataBean> dataBeen);
    void showFaild();
}
