package aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTeamtogether;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.TeamTogetherModel;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.model.impl.TeamTogetherModelImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.TeamTogetherPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.TeamTogetherView;

/**
 * Created by Administrator on 2016/12/1.
 */

public class TeamTogetherPresenterImpl implements TeamTogetherPresenter,TeamTogetherModel.Callback{
    private TeamTogetherView view;
    private TeamTogetherModel model;
    private int pageNo=0;

    public TeamTogetherPresenterImpl(TeamTogetherView view) {
        this.view = view;
        model =new TeamTogetherModelImpl();
    }



    @Override
    public void loadDatasSuccess(ResponseTeamtogether teamtogether) {
            view.showTeamTogetherSuccess(teamtogether);
    }

    @Override
    public void loadError() {
        view.showFailed();
    }

    @Override
    public void TeamTogetherDatas(int bossId) {
        model.showTeamTogetherDatas(bossId,pageNo,this);
        pageNo ++;
    }
}
