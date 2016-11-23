package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.MainViewPagerAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_home_viewpager;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/23.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.viewPager_main_list_slide)
    ViewPager viewPagerMainListSlide;
    @BindView(R.id.linearLayout_pager_indicator)
    LinearLayout linearLayoutPagerIndicator;
    @BindView(R.id.main_title_zxing)
    ImageButton mainTitleZxing;
    @BindView(R.id.main_title_search)
    LinearLayout mainTitleSearch;
    @BindView(R.id.main_title_place)
    LinearLayout mainTitlePlace;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.zhuangxiugonsi)
    LinearLayout zhuangxiugonsi;
    @BindView(R.id.tongchenghuodong)
    LinearLayout tongchenghuodong;
    @BindView(R.id.zhuangxiuxuetang)
    LinearLayout zhuangxiuxuetang;
    @BindView(R.id.zhuangxiuyusuan)
    LinearLayout zhuangxiuyusuan;
    @BindView(R.id.jiancaijiaju)
    LinearLayout jiancaijiaju;
    @BindView(R.id.xiaoguotu)
    LinearLayout xiaoguotu;
    @BindView(R.id.zizhuxiadan)
    LinearLayout zizhuxiadan;
    @BindView(R.id.shejiliangfang)
    LinearLayout shejiliangfang;

    private Response_home_viewpager home_viewpager;

    @Override
    protected int getContentViewResID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViews() {
        Http http = new Http();
        home_viewpager = new Response_home_viewpager();

        Log.d("msgnn", "222home_viewpager:" + home_viewpager);

        home_viewpager = http.getHttp("http://118.178.142.34/YiQiHouse/HomeAD");
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getActivity(),home_viewpager);
        viewPagerMainListSlide.setAdapter(mainViewPagerAdapter);
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
