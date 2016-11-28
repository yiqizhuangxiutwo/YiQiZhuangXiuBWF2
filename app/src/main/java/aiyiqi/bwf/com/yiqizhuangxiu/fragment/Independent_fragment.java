package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.IndependentAdapter_RecyclerView;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_IndependentOrder;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/25.
 */

public class Independent_fragment extends BaseFragment {


    @BindView(R.id.independent_order_viewpager_item_recyclerview)
    RecyclerView independentOrderViewpagerItemRecyclerview;

    private List<Response_IndependentOrder.DataBeanX.DataBean> dataBeen;

    public Independent_fragment(List<Response_IndependentOrder.DataBeanX.DataBean> dataBeen) {
        this.dataBeen = dataBeen;
    }

    @Override
    protected int getContentViewResID() {
        return R.layout.independent_order_viewpager_item;
    }

    @Override
    protected void initViews() {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        independentOrderViewpagerItemRecyclerview.setLayoutManager(manager);
        IndependentAdapter_RecyclerView adapter = new IndependentAdapter_RecyclerView(getActivity(), dataBeen);
        independentOrderViewpagerItemRecyclerview.setAdapter(adapter);
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
