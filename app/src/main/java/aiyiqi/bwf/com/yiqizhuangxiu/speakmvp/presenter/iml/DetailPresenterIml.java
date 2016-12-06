package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.iml;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_CommitArticle;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Detail;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_zan;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.DetailModel;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.iml.DetailModelIml;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.DetailPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view.DetailView;

/**
 * Created by Administrator on 2016/11/30.
 */

public class DetailPresenterIml implements DetailPresenter {
    private DetailModel detailModel;
    private DetailView detailView;
    public DetailPresenterIml(DetailView detailView) {
        this.detailView = detailView;
        detailModel = new DetailModelIml();
    }

    @Override
    public void loadDetails(String acticleId) {
        detailModel.loadDatas(acticleId, new DetailModel.DetailCallback() {
            @Override
            public void loadDetail(Response_Detail response_detail) {
                detailView.showDetail(response_detail);
            }

            @Override
            public void loadZan(Response_zan response_zan) {
                detailView.showZan(response_zan);
            }

            @Override
            public void loadCommit(Response_CommitArticle commitArticle) {
                detailView.showCommit(commitArticle);
            }
        });
    }
}
