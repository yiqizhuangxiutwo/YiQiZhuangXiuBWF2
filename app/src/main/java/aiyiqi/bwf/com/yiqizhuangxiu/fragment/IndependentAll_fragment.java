package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.IndependentAllAdapter_RecyclerView;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_IndependentOrder;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2016-11-27.
 */
public class IndependentAll_fragment extends BaseFragment {

    @BindView(R.id.independent_order_viewpager_item_recyclerview)
    RecyclerView independentOrderViewpagerItemRecyclerview;

    private Response_IndependentOrder response_independentOrder;
    private List<String> strings;
    private List<String> ids;
    private List<String> names;
    private List<String> texts;

    public IndependentAll_fragment(Response_IndependentOrder response_independentOrder) {
        this.response_independentOrder = response_independentOrder;
    }

    @Override
    protected int getContentViewResID() {
        return R.layout.independent_order_viewpager_item;
    }

    @Override
    protected void initViews() {
        strings = getImages();
        ids = getIds();
        names = getNames();
        texts = getTexts();
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        independentOrderViewpagerItemRecyclerview.setLayoutManager(manager);
        IndependentAllAdapter_RecyclerView adapter = new IndependentAllAdapter_RecyclerView(getActivity(), strings, texts, names);
        independentOrderViewpagerItemRecyclerview.setAdapter(adapter);
    }

    /**
     * 得到传递过来的数据折扣文字，并放入String的集合
     */
    private List<String> getTexts() {
        texts = new ArrayList<>();
        for (int i = 0; i < response_independentOrder.getData().size(); i++) {
            for (int j = 0; j < response_independentOrder.getData().get(i).getData().size(); j++) {
                if (response_independentOrder.getData().get(i).getData().get(j).getDiscount_info() != null){
                    texts.add(response_independentOrder.getData().get(i).getData().get(j).getDiscount_info());
                }else{
                    texts.add("0");
                }
            }
        }
        return texts;
    }

    /**
     * 得到传递过来的数据的名字，并放入String的集合
     */
    private List<String> getNames() {
        names = new ArrayList<>();
        for (int i = 0; i < response_independentOrder.getData().size(); i++) {
            for (int j = 0; j < response_independentOrder.getData().get(i).getData().size(); j++) {
                names.add(response_independentOrder.getData().get(i).getData().get(j).getBusiness_name());
            }
        }
        return names;
    }

    /**
     * 得到传递过来的数据的Id，并放入String的集合
     */
    private List<String> getIds() {
        ids = new ArrayList<>();
        for (int i = 0; i < response_independentOrder.getData().size(); i++) {
            for (int j = 0; j < response_independentOrder.getData().get(i).getData().size(); j++) {
                ids.add(response_independentOrder.getData().get(i).getData().get(j).getBusiness_id());
            }
        }
        return ids;
    }

    /**
     * 得到传递过来的数据的图片地址，并放入String的集合
     */
    private List<String> getImages() {
        strings = new ArrayList<>();
        for (int i = 0; i < response_independentOrder.getData().size(); i++) {
            for (int j = 0; j < response_independentOrder.getData().get(i).getData().size(); j++) {
                strings.add(response_independentOrder.getData().get(i).getData().get(j).getLogo());
            }
        }
        return strings;
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
