package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.EffectPictureRightAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectPictureRight;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.EffectPictureRightPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl.EffectPictureRightPresenterImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.EffectPictureRightView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class EffectPictureRight extends BaseFragment implements EffectPictureRightView {
    @BindView(R.id.effect_picture_tag01)
    LinearLayout effectPictureTag01;
    @BindView(R.id.effect_picture_tag02)
    LinearLayout effectPictureTag02;
    @BindView(R.id.effect_picture_tag03)
    LinearLayout effectPictureTag03;
    @BindView(R.id.effect_picture_tag04)
    LinearLayout effectPictureTag04;
    @BindView(R.id.buid_home_recycleview)
    RecyclerView buidHomeRecycleview;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    private EffectPictureRightAdapter adapter;
    private EffectPictureRightPresenter presenter;
    private LinearLayoutManager manager;
    private GridLayoutManager gridLayoutManager;
    @Override
    protected int getContentViewResID() {
        return R.layout.effect_picture_right;
    }

    @Override
    protected void initViews() {
        adapter = new EffectPictureRightAdapter(getActivity());
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        gridLayoutManager = new GridLayoutManager(buidHomeRecycleview.getContext(),
                2, GridLayoutManager.VERTICAL, false);
        buidHomeRecycleview.setLayoutManager(gridLayoutManager);
        buidHomeRecycleview.setAdapter(adapter);

        buidHomeRecycleview.addOnScrollListener(onScrollListener);

        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                loadNextDatas();
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
//            Log.d("EffectTopicLeft", "manager.findLastVisibleItemPosition():" + manager.findLastVisibleItemPosition());
//            Log.d("EffectTopicLeft", "manager.getItemCount():" + manager.getItemCount());

            if(!isLoading && gridLayoutManager.findLastVisibleItemPosition() == gridLayoutManager.getItemCount() - 1){
//                Log.d("EffectTopicLeft", "jinlaile");
                loadNextDatas();

            }
        }
    };
    @Override
    protected void initDatas() {
        presenter = new EffectPictureRightPresenterImpl(this);
        presenter.loadDatas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void showPictureSuccess(List<ResponseEffectPictureRight.DataBean.ListBean> listBeen) {
        Log.d("EffectPictureRight", "listBeen:" + listBeen.toString());
        refreshLayout.finishRefresh();
        adapter.addDatas(listBeen);
    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    public void showFailed() {

    }
}
