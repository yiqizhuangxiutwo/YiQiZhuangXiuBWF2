package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.WebViewFragmentPagerAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_IndependentOrder;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.IndependentAll_fragment;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.Independent_fragment;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_IndependentOrder;
import aiyiqi.bwf.com.yiqizhuangxiu.view.CustomRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/24.
 */
public class ZiZhuXiaDanActivity extends BaseActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.independent_order_guarantee)
    RelativeLayout independentOrderGuarantee;
    @BindView(R.id.independent_order_tablayout)
    TabLayout independentOrderTablayout;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.independent_order_viewpager)
    ViewPager independentOrderViewpager;
    @BindView(R.id.refreshLayout)
    CustomRefreshLayout refreshLayout;
    @BindView(R.id.imageView2)
    ImageView imageView2;


    private String[] strings;
    private List<Fragment> fragments;


    @Override
    public int getContentViewResID() {
        return R.layout.activity_zzxd;
    }

    @Override
    protected void initViews() {
        title.setText("自主下单");
        getHttps();
    }

    private void getHttps() {
        Http_IndependentOrder http = new Http_IndependentOrder();
        http.getHttp();
        http.setCallback(new Http_IndependentOrder.Callback() {
            @Override
            public void IndependentOrderCallback(Response_IndependentOrder response_independentOrder) {
                strings = new String[response_independentOrder.getData().size() + 1];
                strings[0] = "全部";
                for (int i = 0; i < response_independentOrder.getData().size(); i++) {
                    strings[i + 1] = response_independentOrder.getData().get(i).getName();
                }
                fragments = new ArrayList<>();
                for (int i = 0; i < response_independentOrder.getData().size() + 1; i++) {
                    if (i != 0) {
                        fragments.add(new Independent_fragment(response_independentOrder.getData().get(i - 1).getData()));
                    } else {
                        fragments.add(new IndependentAll_fragment(response_independentOrder));
                    }
                }
                WebViewFragmentPagerAdapter adapter = new WebViewFragmentPagerAdapter(fragments, strings, getSupportFragmentManager());
                independentOrderViewpager.setAdapter(adapter);
                independentOrderTablayout.setupWithViewPager(independentOrderViewpager);
            }

            @Override
            public void HttpFailded(Exception e) {

            }
        });
    }

    @Override
    protected void initDatas() {
        //监听APPBAR，确定什么时候可以下拉刷新
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    //RefreshLayout可以触发下拉
                    refreshLayout.setCanPull(true);
                } else {
                    //RefreshLayout不可以触发下拉
                    refreshLayout.setCanPull(false);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.independent_order_guarantee})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.independent_order_guarantee:
                break;
        }
    }
}
