package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.WebViewFragmentPagerAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.ZXXT_Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/24.
 */
public class ZhuangXiuXueTangActivity extends BaseActivity {

    private String[] tags_up = new String[]{"验房收房","装修公司","量房设计","辅材选购","主材选购",
            "家具选购", "装修合同","主体拆迁","水电改造","防水处理","土木工程","瓦工工程","油工工程",
            "主材安装","竣工验收","软装配饰","居家生活"};
    private List<Fragment> fragments = new ArrayList<>();

    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.zxxt_tablayout)
    TabLayout zxxtTablayout;
    @BindView(R.id.school_tab)
    ImageButton schoolTab;
    @BindView(R.id.zxxt_viewpager)
    ViewPager zxxtViewpager;

    @Override
    public int getContentViewResID() {
        return R.layout.activity_zxxt;
    }

    @Override
    protected void initViews() {
        getFragments();
        zxxtViewpager.setOffscreenPageLimit(0);
        WebViewFragmentPagerAdapter adapter = new WebViewFragmentPagerAdapter(fragments,tags_up,getSupportFragmentManager());
        zxxtViewpager.setAdapter(adapter);
        zxxtTablayout.setupWithViewPager(zxxtViewpager);
    }

    /**
     * 获得Fragment
     */
    private void getFragments() {
        for (int i = 0; i < tags_up.length; i++) {
            fragments.add(new ZXXT_Fragment(i+1));
        }
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


    @OnClick({R.id.btn_back, R.id.school_tab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.school_tab:
                //TODO
                break;
        }
    }
}
