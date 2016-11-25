package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.WebViewFragmentPagerAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.WebFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/24.
 */
public class SheJiLiangFangActivity extends BaseActivity {


    @BindView(R.id.sjlf_back)
    ImageView sjlfBack;
    @BindView(R.id.sjlf_tablayout)
    TabLayout sjlfTablayout;
    @BindView(R.id.call_image)
    ImageView callImage;
    @BindView(R.id.sjlf_ll)
    RelativeLayout sjlfLl;
    @BindView(R.id.sjlf_viewpager)
    ViewPager sjlfViewpager;
    @BindView(R.id.linearlayout_yuye)
    LinearLayout linearlayoutYuye;
    @BindView(R.id.linearlayout_zixun)
    LinearLayout linearlayoutZixun;
    private List<Fragment> fragments;
    private String[] strings;

    @Override
    public int getContentViewResID() {
        return R.layout.activity_sjlf;
    }

    @Override
    protected void initViews() {
        getFragments();
        strings = new String[]{"免费设计", "免费量房"};
        sjlfTablayout.addTab(sjlfTablayout.newTab().setText(strings[0]));
        sjlfTablayout.addTab(sjlfTablayout.newTab().setText(strings[1]));
        WebViewFragmentPagerAdapter adapter = new WebViewFragmentPagerAdapter(fragments, strings, getSupportFragmentManager());
        sjlfViewpager.setAdapter(adapter);
        sjlfTablayout.setupWithViewPager(sjlfViewpager);
        sjlfBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getFragments() {
        fragments = new ArrayList<>();
        fragments.add(new WebFragment(Apis.SJLF_LEFT));
        fragments.add(new WebFragment(Apis.SJLF_RIGHT));
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

    @OnClick({R.id.sjlf_back, R.id.call_image})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sjlf_back:
                finish();
                break;
            case R.id.call_image:
                break;
        }
    }
}
