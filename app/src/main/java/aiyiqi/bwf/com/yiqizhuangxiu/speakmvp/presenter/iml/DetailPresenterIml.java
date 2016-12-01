package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.iml;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Detail;
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
        String url = "http://bbs.17house.com/motnt/index.php?a=viewThread&c=forumThread&imgwidth=330&uuid=86305803367590&tid="+acticleId+"&m=forum&haspermission=yes&model=android&app_version=android_com.aiyiqi.galaxy_1.1";
        detailModel.loadNextDetail(url, new DetailModel.DetailCallback() {
            @Override
            public void loadDetail(Response_Detail response_detail) {
                detailView.showDetail(response_detail);
            }
        });
    }
}
