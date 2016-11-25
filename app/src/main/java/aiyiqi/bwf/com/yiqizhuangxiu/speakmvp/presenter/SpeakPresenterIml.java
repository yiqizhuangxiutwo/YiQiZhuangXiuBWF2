package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.SpeakModel;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.SpeakModelIml;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view.SpeakView;

/**
 * Created by Administrator on 2016/11/25.
 */

public class SpeakPresenterIml implements SpeakPresenter{
    private SpeakModel model;
    private SpeakView view;
    private int nextPage=1;
    public SpeakPresenterIml(SpeakView view) {
        model = new SpeakModelIml();
        this.view = view;
    }
    @Override
    public void loadPage() {
        String url = "http://bbs.17house.com/motnt/index.php?a=allThread&c=forumThreadList&mode=digest&uuid=86305803367590&pageSize=10&m=forum&" +
                "page="+nextPage+"&haspermission=yes&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1";
        model.loadNextPage(url,new SpeakModel.LoadCallbak() {
            @Override
            public void loadSuccsess(List<Response_Essence.DataBean> dataBeen) {
                view.showPage(dataBeen);
            }

            @Override
            public void loadFaild() {
                view.showFaild();
            }
        });
        nextPage++;
    }
}
