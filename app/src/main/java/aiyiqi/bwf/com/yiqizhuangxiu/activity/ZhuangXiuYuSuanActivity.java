package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.WebViewFragmentPagerAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.WebFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/24.
 */
public class ZhuangXiuYuSuanActivity extends BaseActivity {
    @BindView(R.id.zxys_tablayout)
    TabLayout zxysTablayout;
    @BindView(R.id.zxys_viewpager)
    ViewPager zxysViewpager;
    @BindView(R.id.zxys_back)
    ImageView zxysBack;

    private List<Fragment> fragments;
    private String[] strings;

    @Override
    public int getContentViewResID() {
        return R.layout.activity_zhuangxiuyusuan;
    }

    @Override
    protected void initViews() {
        getFragments();
        strings = new String[]{"装修报价", "我的预算"};
        WebViewFragmentPagerAdapter adapter = new WebViewFragmentPagerAdapter(fragments, strings, getSupportFragmentManager());
        zxysViewpager.setAdapter(adapter);
        zxysTablayout.setupWithViewPager(zxysViewpager);
        zxysBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getFragments() {
        fragments = new ArrayList<>();
        fragments.add(new WebFragment(Apis.ZXYS_WEBVIEW));
        fragments.add(new WebFragment(Apis.ZXYS_WEBVIEW));
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
