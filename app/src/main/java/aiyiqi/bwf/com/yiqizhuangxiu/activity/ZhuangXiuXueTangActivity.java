package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
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


    @OnClick({R.id.btn_back, R.id.school_tab, R.id.close, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17})
    public void onClick(View view) {
        Button buttons[] = new Button[]{button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17};
        int now = zxxtViewpager.getCurrentItem();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setTextColor(Color.BLACK);
        }
        buttons[now].setTextColor(Color.GREEN);
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
                button1.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(0);
                break;
            case R.id.button2:
                button2.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(1);
                break;
            case R.id.button3:
                button3.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(2);
                break;
            case R.id.button4:
                button4.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(3);
                break;
            case R.id.button5:
                button5.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(4);
                break;
            case R.id.button6:
                button6.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(5);
                break;
            case R.id.button7:
                button7.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(6);
                break;
            case R.id.button8:
                button8.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(7);
                break;
            case R.id.button9:
                button9.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(8);
                break;
            case R.id.button10:
                button10.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(9);
                break;
            case R.id.button11:
                button11.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(10);
                break;
            case R.id.button12:
                button12.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(11);
                break;
            case R.id.button13:
                button13.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(12);
                break;
            case R.id.button14:
                button14.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(13);
                break;
            case R.id.button15:
                button15.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(14);
                break;
            case R.id.button16:
                button16.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(15);
                break;
            case R.id.button17:
                button17.setTextColor(Color.GREEN);
                drawerlayout.closeDrawer(Gravity.RIGHT);
                zxxtViewpager.setCurrentItem(16);
                break;
        }
    }
}
