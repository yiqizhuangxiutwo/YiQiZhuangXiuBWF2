package aiyiqi.bwf.com.yiqizhuangxiu.fragment.speakfragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter.PlateAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter.PlateAdapter1;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponsePlate;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.BaseFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.PlateSpeakPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.iml.PlateSpeakPresenterIml;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view.PlateSpeakView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */

public class Fragment3 extends BaseFragment implements PlateSpeakView {


    @BindView(R.id.gridview)
    RecyclerView gridview;
    @BindView(R.id.gridview1)
    RecyclerView gridview1;
    private PlateAdapter plateAdapter;
    private PlateAdapter1 plateAdapter1;
    private PlateSpeakPresenter plateSpeakPresenter;

    @Override
    protected int getContentViewResID() {
        return R.layout.fragment3;
    }

    @Override
    protected void initViews() {
        GridLayoutManager grid = new GridLayoutManager(getActivity(), 2);
        GridLayoutManager grid1 = new GridLayoutManager(getActivity(), 2);
        grid.setOrientation(GridLayoutManager.VERTICAL);
        grid1.setOrientation(GridLayoutManager.VERTICAL);
        gridview.setLayoutManager(grid);
        gridview1.setLayoutManager(grid1);
//        gridview.addItemDecoration(new MyDecoration(getActivity(),MyDecoration.HORIZONTAL_LIST,50));
        plateSpeakPresenter = new PlateSpeakPresenterIml(this);
        plateSpeakPresenter.loadNewPage();
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

    @Override
    public void showPage(ResponsePlate dataBeen) {
        plateAdapter = new PlateAdapter(getActivity(), dataBeen);
        plateAdapter1 = new PlateAdapter1(getActivity(), dataBeen);
        gridview.setAdapter(plateAdapter);
        gridview1.setAdapter(plateAdapter1);
    }

    @Override
    public void showFaild() {

    }
}
