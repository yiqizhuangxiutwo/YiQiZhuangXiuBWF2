package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.BuildHomeAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseBuidingHome;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.BuildingHomePresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl.BuildingHomePresenterImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.BuildingHomeView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class JianCaiJiaJuActivity extends BaseActivity implements BuildingHomeView {

    @BindView(R.id.buid_home_recycleview)
    RecyclerView buidHomeRecycleview;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    private BuildingHomePresenter presenter;
    private BuildHomeAdapter adapter;
    private LinearLayoutManager manager;

    @Override
    public int getContentViewResID() {
        return R.layout.building_home;
    }

    @Override
    protected void initViews() {
        presenter = new BuildingHomePresenterImpl(this);
        loadDatas();
    }

    @Override
    protected void initDatas() {
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        buidHomeRecycleview.setLayoutManager(manager);
        adapter = new BuildHomeAdapter(this);
        buidHomeRecycleview.setAdapter(adapter);

        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                isload = true;
                loadDatas();
            }
        });
    }
    private boolean isload ;
    public void loadDatas(){
        isload = true;
        presenter.loadBuildingHomeDatas();
    }
    @Override
    public void showBuildingHomeViewSuccess(ResponseBuidingHome buidingHome) {
        Log.d("JianCaiJiaJuActivity", "buidingHome.getData().size():" + buidingHome.getData().size());
        refreshLayout.finishRefresh();
        adapter.addDatas(buidingHome.getData());
    }

    @Override
    public void showFailed() {
        Toast.makeText(this, "dashabi", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

    }
}
