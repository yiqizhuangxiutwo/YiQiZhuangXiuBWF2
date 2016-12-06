package aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.iml;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponsePlate;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponsePlate1;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_New;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.NewSpeakModel;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.PlateSpeakModel;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.iml.NewSpeakModelIml;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.model.iml.PlateSpeakModelIml;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.NewSpeakPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.PlateSpeakPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view.NewSpeakView;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view.PlateSpeakView;

/**
 * Created by Administrator on 2016/11/25.
 */

public class PlateSpeakPresenterIml implements PlateSpeakPresenter {
    private PlateSpeakModel model;
    private PlateSpeakView view;

    public PlateSpeakPresenterIml(PlateSpeakView view) {
        this.view = view;
        model = new PlateSpeakModelIml();
    }

    @Override
    public void loadNewPage() {
        String url = "http://bbs.17house.com/motnt/index.php?a=miscForum&uuid=86305803367590&cityName=%E6%88%90%E9%83%BD&m=misc&haspermission=yes&cityId=2&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1";
        model.loadNextPage(url, new PlateSpeakModel.LoadCallbak() {
            @Override
            public void loadSuccsess(ResponsePlate dataBeen) {
                view.showPage(dataBeen);
            }

            @Override
            public void loadFaild() {

            }
        });
    }
}
