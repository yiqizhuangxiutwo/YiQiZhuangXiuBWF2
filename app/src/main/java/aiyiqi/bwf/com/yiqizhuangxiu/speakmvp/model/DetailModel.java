package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_CommitArticle;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Detail;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_zan;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface DetailModel {
    void loadDatas(String articleId,DetailCallback detailCallback);
    void loadDetail();
    void loadNextZan();
    void loadNexyCommit();
    public interface DetailCallback{
        void loadDetail(Response_Detail response_detail);
        void loadZan(Response_zan response_zan);
        void loadCommit(Response_CommitArticle commitArticle);
    }
}
