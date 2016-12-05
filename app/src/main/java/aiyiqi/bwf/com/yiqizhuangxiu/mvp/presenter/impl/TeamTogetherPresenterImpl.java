package aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTeamtogether;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.TeamTogetherModel;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl.TeamTogetherModelImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.TeamTogetherPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.TeamTogetherView;

/**
 * Created by Administrator on 2016/12/1.
 */

public class TeamTogetherPresenterImpl implements TeamTogetherPresenter{
    private TeamTogetherView view;
    private TeamTogetherModel model;

    public TeamTogetherPresenterImpl(TeamTogetherView view) {
        this.view = view;
        model =new TeamTogetherModelImpl();
    }

    @Override
    public void TeamTogetherDatas() {
        model.showTeamTogetherDatas(new TeamTogetherModel.Callback() {
            @Override
            public void loadDatasSuccess(ResponseTeamtogether teamtogether) {
                view.showTeamTogetherSuccess(teamtogether);
            }

            @Override
            public void loadError() {

            }
        });

    }

}
