package aiyiqi.bwf.com.yiqizhuangxiu.fragment.speakfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter.NewRecycleviewAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_New;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.BaseFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.NewSpeakPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.NewSpeakPresenterIml;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view.NewSpeakView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */

public class Fragment2 extends BaseFragment implements NewSpeakView {

    @BindView(R.id.newrecycler)
    RecyclerView newrecycler;
    private NewRecycleviewAdapter newRecycleviewAdapter;
    private NewSpeakPresenter newSpeakPresenter;
    private LinearLayoutManager manager;
    @Override
    protected int getContentViewResID() {
        return R.layout.fragment2;
    }

    @Override
    protected void initViews() {
        newrecycler = (RecyclerView) getView().findViewById(R.id.newrecycler);
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        newrecycler.setLayoutManager(manager);
        newRecycleviewAdapter = new NewRecycleviewAdapter(getActivity());
        newrecycler.setAdapter(newRecycleviewAdapter);
        newrecycler.addOnScrollListener(onScrollListener);
        newSpeakPresenter = new NewSpeakPresenterIml(this);
        newSpeakPresenter.loadNewPage();
    }
    public boolean isLoad;
    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if(!isLoad&&manager.findLastVisibleItemPosition()==manager.getItemCount()-1){
                isLoad = true;
                newSpeakPresenter.loadNewPage();
            }
        }
    };
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
    @Override
    public void showPage(List<Response_New.DataBean> dataBeen) {
        newRecycleviewAdapter.addDatas(dataBeen);
        isLoad = false;
    }
    @Override
    public void showFaild() {

    }
}
