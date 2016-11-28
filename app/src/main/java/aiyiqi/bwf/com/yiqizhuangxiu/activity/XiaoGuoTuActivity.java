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
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.EffectPictureRight;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.EffectTopicLeft;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/24.
 */
public class XiaoGuoTuActivity extends BaseActivity{
    @BindView(R.id.zxys_back)
    ImageView zxysBack;
    @BindView(R.id.zxys_tablayout)
    TabLayout zxysTablayout;
    @BindView(R.id.zxys_viewpager)
    ViewPager zxysViewpager;

    private List<Fragment> fragments;
    private String[] string;
    @Override
    public int getContentViewResID() {
        return R.layout.activity_zhuangxiuyusuan;
    }

    @Override
    protected void initViews() {
        getFragmetns();
        string = new String[]{"专题", "美图"};

        zxysTablayout.addTab(zxysTablayout.newTab().setText(string[0]));
        zxysTablayout.addTab(zxysTablayout.newTab().setText(string[1]));
        WebViewFragmentPagerAdapter adapter = new WebViewFragmentPagerAdapter(fragments, string, getSupportFragmentManager());
        zxysViewpager.setAdapter(adapter);
        zxysTablayout.setupWithViewPager(zxysViewpager);
        zxysBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getFragmetns() {
        fragments = new ArrayList<>();
        fragments.add(new EffectTopicLeft());
        fragments.add(new EffectPictureRight());
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
