package aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseBuidingHome;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.BuidingHomeModel;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl.BuildingHomeModelImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.BuildingHomePresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.BuildingHomeView;

/**
 * Created by Lee Vane.
 */

public class   BuildingHomePresenterImpl implements BuildingHomePresenter {

    private BuildingHomeModelImpl model;
    private BuildingHomeView view ;

    public BuildingHomePresenterImpl(BuildingHomeView view) {
        this.view = view;
        model = new BuildingHomeModelImpl() ;
    }

    @Override
    public void loadBuildingHomeDatas() {
        model.showBuidingHomeDatas(new BuidingHomeModel.Callback() {
            @Override
            public void loadDatasSuccess(ResponseBuidingHome buidingHome) {
                view.showBuildingHomeViewSuccess(buidingHome);
            }

            @Override
            public void loadError() {
                view.showFailed();
            }
        });
    }
}
