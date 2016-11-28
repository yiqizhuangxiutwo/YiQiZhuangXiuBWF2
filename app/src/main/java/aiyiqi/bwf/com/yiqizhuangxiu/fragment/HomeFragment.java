package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.JianCaiJiaJuActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.SearchActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.SheJiLiangFangActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.TongChengHuoDongActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.XiaoGuoTuActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.ZhuangXiuGongSiActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.ZhuangXiuXueTangActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.ZhuangXiuYuSuanActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.ZiZhuXiaDanActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.HomeRecyvlerViewAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.MainViewPagerAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseRecycleViewList;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_home_viewpager;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_Home_RecyclerView;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_Home_Viewpager;
import aiyiqi.bwf.com.yiqizhuangxiu.view.FullyLinearLayoutManager;
import aiyiqi.bwf.com.yiqizhuangxiu.widget.PagerDotIndicator;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.home_recyclerview)
    RecyclerView homeRecyclerview;

    /**
     * 管理指示器的对象
     **/
    private PagerDotIndicator pagerDotIndicator;public static final int STATE_GONE = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_NO_MORE_DATA = 2;
    public static final int STATE_LOAD_FAILED = 3;


    @Override
    protected int getContentViewResID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViews() {
        home_ViewPagerHttp();
        home_RecyclerViewHttp();

        mainTitleSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });
    }

    /**
     * Home下部的ViewPager的网络数据访问
     */
    private void home_RecyclerViewHttp() {
        Http_Home_RecyclerView http = new Http_Home_RecyclerView();
        http.getHttp();
        http.setCallback(new Http_Home_RecyclerView.Callback() {
            @Override
            public void RecyclerViewCallback(ResponseRecycleViewList responseRecycleViewList) {
                FullyLinearLayoutManager manager = new FullyLinearLayoutManager(getActivity());
                manager.setOrientation(FullyLinearLayoutManager.VERTICAL);
                homeRecyclerview.setLayoutManager(manager);
                HomeRecyvlerViewAdapter homerecyvlerviewadapter = new HomeRecyvlerViewAdapter(getActivity(),responseRecycleViewList.getData());
                homerecyvlerviewadapter.updateFooterState(STATE_LOADING);
                homeRecyclerview.setAdapter(homerecyvlerviewadapter);
            }
        });
    }


    /**
     * Home上部的ViewPager的网络数据访问
     */
    private void home_ViewPagerHttp() {
        Http_Home_Viewpager http = new Http_Home_Viewpager();
        http.getHttp();
        http.setCallback(new Http_Home_Viewpager.Callback() {
            @Override
            public void ViewPagerCallback(Response_home_viewpager response_home_viewpager) {
                MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getActivity(), response_home_viewpager);
                pagerDotIndicator = new PagerDotIndicator(getActivity(), linearLayoutPagerIndicator, viewPagerMainListSlide);
                viewPagerMainListSlide.setAdapter(mainViewPagerAdapter);
                viewPagerMainListSlide.setCurrentItem(response_home_viewpager.getData().size() * 10);
                pagerDotIndicator.setDotNums(response_home_viewpager.getData().size());
            }

            @Override
            public void HttpFailded(Exception e) {
                Toast.makeText(getActivity(), "e:" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initDatas() {
        //判定到最后进行下一页的数据加载

    }

    /**
     * Home界面八个按钮的跳转
     *
     * @param view
     */
    @OnClick({R.id.zhuangxiugonsi, R.id.tongchenghuodong, R.id.zhuangxiuxuetang, R.id.zhuangxiuyusuan, R.id.jiancaijiaju, R.id.xiaoguotu, R.id.zizhuxiadan, R.id.shejiliangfang})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zhuangxiugonsi:
                startActivity(new Intent(getActivity(), ZhuangXiuGongSiActivity.class));
                break;
            case R.id.tongchenghuodong:
                startActivity(new Intent(getActivity(), TongChengHuoDongActivity.class));
                break;
            case R.id.zhuangxiuxuetang:
                startActivity(new Intent(getActivity(), ZhuangXiuXueTangActivity.class));
                break;
            case R.id.zhuangxiuyusuan:
                startActivity(new Intent(getActivity(), ZhuangXiuYuSuanActivity.class));
                break;
            case R.id.jiancaijiaju:
                startActivity(new Intent(getActivity(), JianCaiJiaJuActivity.class));
                break;
            case R.id.xiaoguotu:
                startActivity(new Intent(getActivity(), XiaoGuoTuActivity.class));
                break;
            case R.id.zizhuxiadan:
                startActivity(new Intent(getActivity(), ZiZhuXiaDanActivity.class));
                break;
            case R.id.shejiliangfang:
                startActivity(new Intent(getActivity(), SheJiLiangFangActivity.class));
                break;

        }
    }

    //绑定黄油刀
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
