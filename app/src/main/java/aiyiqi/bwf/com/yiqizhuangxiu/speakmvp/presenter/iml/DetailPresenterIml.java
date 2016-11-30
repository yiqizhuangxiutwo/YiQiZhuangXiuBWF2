package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.iml;

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
    public void loadDetails(int acticleId) {
        String url = "http://bbs.17house.com/forum.php?mod=viewthread&tid="+acticleId+"&extra=page=1";
        detailModel.loadNextDetail(url, new DetailModel.DetailCallback() {
            @Override
            public void loadDetail(String url) {
                detailView.showDetail(url);
            }
        });
    }
}
