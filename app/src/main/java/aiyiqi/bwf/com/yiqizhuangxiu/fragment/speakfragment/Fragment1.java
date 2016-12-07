package aiyiqi.bwf.com.yiqizhuangxiu.fragment.speakfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter.MyRecyclecviewAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.BaseFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.SpeakPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.iml.SpeakPresenterIml;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view.SpeakView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/23.
 */

public class Fragment1 extends BaseFragment implements SpeakView {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;

    private MyRecyclecviewAdapter myadapter;
    private SpeakPresenter speakPresenter;
    private LinearLayoutManager manager;

    @Override
    protected int getContentViewResID() {
        return R.layout.fragment1;
    }

    @Override
    protected void initViews() {
        speakPresenter = new SpeakPresenterIml(this);
        speakPresenter.loadPage();
    }

    @Override
    protected void initDatas() {
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(manager);
        myadapter = new MyRecyclecviewAdapter(getActivity());
        recycleView.setAdapter(myadapter);
        recycleView.addOnScrollListener(onScrollListener);

        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                speakPresenter.loadPage();
            }
        });
    }

    private boolean isLoading;

    public void NextPageLoading() {
        speakPresenter.loadPage();
        isLoading = false;
    }

    private boolean isNoMoreData;

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (isNoMoreData) {
                return;
            }
            if (!isLoading && manager.findLastVisibleItemPosition() == manager.getItemCount() - 1) {
                isLoading = true;
                NextPageLoading();
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void showPage(List<Response_Essence.DataBean> dataBeen) {
        Log.d("Fragment1", "dataBeen:" + dataBeen);
        refreshLayout.finishRefresh();
        myadapter.addDatas(dataBeen);
    }

    @Override
    public void showFaild() {

    }
}
