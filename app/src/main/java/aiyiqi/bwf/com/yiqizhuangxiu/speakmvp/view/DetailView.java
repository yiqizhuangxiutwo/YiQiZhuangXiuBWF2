package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_CommitArticle;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Detail;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_zan;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface DetailView {
    void showDetail(Response_Detail detail);
    void showZan(Response_zan zan);
    void showCommit(Response_CommitArticle commitArticle);
}
