package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.IndependentAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_IndependentOrder;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/25.
 */

public class Independent_fragment extends BaseFragment {
    @BindView(R.id.independent_order_viewpager_item_gridview)
    GridView independentOrderViewpagerItemGridview;

    private List<Response_IndependentOrder.DataBeanX.DataBean> dataBeen;

    public Independent_fragment(List<Response_IndependentOrder.DataBeanX.DataBean> dataBeen) {
        this.dataBeen = dataBeen;
        Log.d("Independent_fragment", "得到了data"+dataBeen.get(0).getBrand_name());
    }

    @Override
    protected int getContentViewResID() {
        return R.layout.independent_order_viewpager_item;
    }

    @Override
    protected void initViews() {
        IndependentAdapter adapter = new IndependentAdapter(getActivity(),dataBeen);
        independentOrderViewpagerItemGridview.setAdapter(adapter);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        Log.d("Independent_fragment", "fragment  view创建了");
        return rootView;
    }
}
