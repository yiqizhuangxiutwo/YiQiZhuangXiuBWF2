package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.EffectTopicLeftAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectTopicLeft;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.EffectTopicLeftPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl.EffectTopicLeftPresenterImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.EffectTopicLeftView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class EffectTopicLeft extends BaseFragment implements EffectTopicLeftView {

    @BindView(R.id.buid_home_recycleview)
    RecyclerView buidHomeRecycleview;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;

    private EffectTopicLeftPresenter presenter;
    private EffectTopicLeftAdapter adapter;
    private LinearLayoutManager manager;

    @Override
    protected int getContentViewResID() {
        return R.layout.recycleview_refreshlayout;
    }

    @Override
    protected void initViews() {
        presenter = new EffectTopicLeftPresenterImpl(this);
        presenter.loadDatas();
    }

    @Override
    protected void initDatas() {
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        buidHomeRecycleview.setLayoutManager(manager);
        adapter = new EffectTopicLeftAdapter(getActivity());
        buidHomeRecycleview.setAdapter(adapter);
        buidHomeRecycleview.addOnScrollListener(onScrollListener);

        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                presenter.loadDatas();
            }
        });
    }

    private boolean isLoading;
    private boolean isNoMoreData;
    private void loadNextDatas(){
        presenter.loadDatas();
        isLoading = false;
    }
    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if(isNoMoreData)
                return;
            if(!isLoading && manager.findLastVisibleItemPosition() == manager.getItemCount() - 1){
<<<<<<< HEAD
                isLoading =true;
=======
//                Log.d("EffectTopicLeft", "jinlaile");
                isLoading = true;
>>>>>>> 3f94e8245aa1b562e29aa5b9505b25530df35151
                loadNextDatas();
            }
        }
    };
    @Override
    public void showEffectTopicLEft(List<ResponseEffectTopicLeft.DataBean.ListBean> listBeen) {
        refreshLayout.finishRefresh();
        adapter.addDatas(listBeen);
    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    public void showFailed() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
