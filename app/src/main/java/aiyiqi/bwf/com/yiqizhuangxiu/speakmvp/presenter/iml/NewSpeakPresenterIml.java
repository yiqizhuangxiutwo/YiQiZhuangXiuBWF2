package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.iml;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_New;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.NewSpeakModel;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.iml.NewSpeakModelIml;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.NewSpeakPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view.NewSpeakView;

/**
 * Created by Administrator on 2016/11/25.
 */

public class NewSpeakPresenterIml implements NewSpeakPresenter {
    private NewSpeakModel model;
    private NewSpeakView view;
    private int nextPage=1;
    public NewSpeakPresenterIml(NewSpeakView view) {
        model = new NewSpeakModelIml();
        this.view = view;
    }
    @Override
    public void loadNewPage() {
        String url = "http://bbs.17house.com/motnt/index.php?a=allThread&c=forumThreadList&uuid=86305803367590&pageSize=10&cityName=%E6%88%90%E9%83%BD&m=forum&" +
                "page="+nextPage+"&haspermission=yes&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1";
        model.loadNextPage(url, new NewSpeakModel.LoadCallbak() {
            @Override
            public void loadSuccsess(List<Response_New.DataBean> dataBeen) {
                view.showPage(dataBeen);
            }

            @Override
            public void loadFaild() {

            }
        });
        nextPage++;
    }
}
