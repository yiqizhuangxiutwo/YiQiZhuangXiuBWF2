package aiyiqi.bwf.com.yiqizhuangxiu.fragment.speakfragment;

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
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter.NewRecycleviewAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_New;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.BaseFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.NewSpeakPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.iml.NewSpeakPresenterIml;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view.NewSpeakView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */

public class Fragment2 extends BaseFragment implements NewSpeakView {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    private NewRecycleviewAdapter newRecycleviewAdapter;
    private NewSpeakPresenter newSpeakPresenter;
    private LinearLayoutManager manager;

    @Override
    protected int getContentViewResID() {
        return R.layout.fragment1;
    }

    @Override
    protected void initViews() {
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(manager);
        newRecycleviewAdapter = new NewRecycleviewAdapter(getActivity());
        recycleView.setAdapter(newRecycleviewAdapter);
        recycleView.addOnScrollListener(onScrollListener);

        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                newSpeakPresenter.loadNewPage();
            }
        });

    }
    private boolean isLoading;

    public void NextPageLoading() {
        newSpeakPresenter.loadNewPage();
        isLoading = false;
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (!isLoading && manager.findLastVisibleItemPosition() == manager.getItemCount() - 1) {
                isLoading = true;
                NextPageLoading();
            }
        }
    };

    @Override
    protected void initDatas() {
        newSpeakPresenter = new NewSpeakPresenterIml(this);
        newSpeakPresenter.loadNewPage();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void showPage(List<Response_New.DataBean> dataBeen) {
        refreshLayout.finishRefresh();
        newRecycleviewAdapter.addDatas(dataBeen);
    }

    @Override
    public void showFaild() {

    }
}
