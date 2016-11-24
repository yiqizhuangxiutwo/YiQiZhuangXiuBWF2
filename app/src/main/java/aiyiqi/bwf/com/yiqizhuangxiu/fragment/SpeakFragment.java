package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter.TabAdapter;
/**
 * Created by Yishi on 2016/11/23.
 */

public class SpeakFragment extends BaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabAdapter tabAdapter;
    private List<String> datas;
    @Override
    protected int getContentViewResID() {
        return R.layout.fragment_speak;
    }

    @Override
    protected void initViews() {
        tabLayout = (TabLayout) getView().findViewById(R.id.tabLayout_main);
        viewPager = (ViewPager) getView().findViewById(R.id.viewPager_main_fragment);
        tabLayout.setupWithViewPager(viewPager);
        datas = new ArrayList<>();
        datas.add("精华");
        datas.add("最新");
        datas.add("板块");
        tabAdapter = new TabAdapter(getFragmentManager(),datas);
        viewPager.setAdapter(tabAdapter);
    }
    @Override
    protected void initDatas() {

    }
}
