package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.teamtogether_fragment_Adapter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.TeamTogetherPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/30.
 */

public class teamtgether_fragment extends BaseFragment {


    @BindView(R.id.teamtogether_gridView)
    GridView teamtogetherGridView;
    @BindView(R.id.teamtogether_refreshLayout)
    MaterialRefreshLayout teamtogetherRefreshLayout;
    @BindView(R.id.teamtogether_fragment)
    FrameLayout teamtogetherFragment;

    private teamtogether_fragment_Adapter teamtogether_fragment_adapter;
    private TeamTogetherPresenter togetherPresenter;

    @Override
    protected int getContentViewResID() {
        return R.layout.teamtogether_fragment;
    }

    @Override
    protected void initViews() {

        teamtogether_fragment_adapter = new teamtogether_fragment_Adapter(getActivity());
        teamtogetherGridView.setAdapter(teamtogether_fragment_adapter);
        togetherPresenter.TeamTogetherDatas();
        teamtogetherRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                //去重新加载数据
                togetherPresenter.TeamTogetherDatas();
            }
        });

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
