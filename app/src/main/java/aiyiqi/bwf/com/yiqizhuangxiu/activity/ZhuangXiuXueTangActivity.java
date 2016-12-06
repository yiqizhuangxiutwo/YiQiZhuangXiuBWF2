package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
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

    @BindView(R.id.close)
    ImageView close;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.button7)
    Button button7;
    @BindView(R.id.button8)
    Button button8;
    @BindView(R.id.button9)
    Button button9;
    @BindView(R.id.button10)
    Button button10;
    @BindView(R.id.button11)
    Button button11;
    @BindView(R.id.button12)
    Button button12;
    @BindView(R.id.button13)
    Button button13;
    @BindView(R.id.button14)
    Button button14;
    @BindView(R.id.button15)
    Button button15;
    @BindView(R.id.button16)
    Button button16;
    @BindView(R.id.button17)
    Button button17;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.zxxt_tablayout)
    TabLayout zxxtTablayout;
    @BindView(R.id.school_tab)
    ImageButton schoolTab;
    @BindView(R.id.zxxt_viewpager)
    ViewPager zxxtViewpager;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;


    private String[] tags_up = new String[]{"验房收房", "装修公司", "量房设计", "辅材选购", "主材选购",
            "家具选购", "装修合同", "主体拆迁", "水电改造", "防水处理", "土木工程", "瓦工工程", "油工工程",
            "主材安装", "竣工验收", "软装配饰", "居家生活"};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    public int getContentViewResID() {
        return R.layout.activity_zxxt;
    }

    @Override
    protected void initViews() {
        getFragments();
        zxxtViewpager.setOffscreenPageLimit(0);
        WebViewFragmentPagerAdapter adapter = new WebViewFragmentPagerAdapter(fragments, tags_up, getSupportFragmentManager());
        zxxtViewpager.setAdapter(adapter);
        zxxtTablayout.setupWithViewPager(zxxtViewpager);
    }

    /**
     * 获得Fragment
     */
    private void getFragments() {
        for (int i = 0; i < tags_up.length; i++) {
            fragments.add(new ZXXT_Fragment(i + 1));
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


    @OnClick({R.id.btn_back, R.id.school_tab,R.id.close, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.school_tab:
                drawerlayout.openDrawer(Gravity.RIGHT);
                break;
            case R.id.close:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                break;
            case R.id.button1:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(1);
                break;
            case R.id.button2:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(2);
                break;
            case R.id.button3:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(3);
                break;
            case R.id.button4:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(4);
                break;
            case R.id.button5:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(5);
                break;
            case R.id.button6:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(6);
                break;
            case R.id.button7:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(7);
                break;
            case R.id.button8:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(8);
                break;
            case R.id.button9:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(9);
                break;
            case R.id.button10:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(10);
                break;
            case R.id.button11:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(11);
                break;
            case R.id.button12:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(12);
                break;
            case R.id.button13:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(13);
                break;
            case R.id.button14:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(14);
                break;
            case R.id.button15:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(15);
                break;
            case R.id.button16:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(16);
                break;
            case R.id.button17:
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtTablayout.setTag(17);
                break;
        }
    }
}
