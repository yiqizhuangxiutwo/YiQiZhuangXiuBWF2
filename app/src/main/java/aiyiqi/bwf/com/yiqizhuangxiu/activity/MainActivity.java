package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.HomeFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.MineFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.MsgFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.SpeakFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.main_fragment)
    FrameLayout mainFragment;
    @BindView(R.id.toggleButton_home_home)
    CheckedTextView toggleButtonHomeHome;
    @BindView(R.id.tab_home)
    LinearLayout tabHome;
    @BindView(R.id.toggleButton_home_speak)
    CheckedTextView toggleButtonHomeSpeak;
    @BindView(R.id.tab_speak)
    LinearLayout tabSpeak;
    @BindView(R.id.toggleButton_home_message)
    CheckedTextView toggleButtonHomeMessage;
    @BindView(R.id.tab_message)
    LinearLayout tabMessage;
    @BindView(R.id.toggleButton_home_mine)
    CheckedTextView toggleButtonHomeMine;
    @BindView(R.id.tab_mine)
    LinearLayout tabMine;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.text_home_home)
    TextView textHomeHome;
    @BindView(R.id.text_home_speak)
    TextView textHomeSpeak;
    @BindView(R.id.text_home_message)
    TextView textHomeMessage;
    @BindView(R.id.text_home_mine)
    TextView textHomeMine;


    private List<Fragment> fragments;
    private CheckedTextView[] checkedTextViews;
    private TextView[] textViews;

    @Override
    public int getContentViewResID() {
        return R.layout.activity_main;
    }

    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void initViews() {
        fm = this.getSupportFragmentManager();
        fragments = getFragments();
        checkedTextViews = new CheckedTextView[]{toggleButtonHomeHome,toggleButtonHomeSpeak,toggleButtonHomeMessage,toggleButtonHomeMine};
        textViews = new TextView[]{textHomeHome,textHomeSpeak,textHomeMessage,textHomeMine};
        setCurrentFragment(0);
    }

    @Override
    protected void initDatas() {

    }

    private List<Fragment> getFragments() {
        this.fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new SpeakFragment());
        fragments.add(new MsgFragment());
        fragments.add(new MineFragment());
        return fragments;
    }


    @OnClick({R.id.tab_home, R.id.tab_speak, R.id.tab_message, R.id.tab_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_home:
                setCurrentFragment(0);
                break;
            case R.id.tab_speak:
                setCurrentFragment(1);
                break;
            case R.id.tab_message:
                setCurrentFragment(2);
                break;
            case R.id.tab_mine:
                setCurrentFragment(3);
                break;
        }
    }

    private Fragment currentFrag = null;
    private int currentIndex = -1;
    private HomeFragment home;
    private SpeakFragment speak;
    private MsgFragment msg;
    private MineFragment mine;

    private void setCurrentFragment(int index) {
        ft = fm.beginTransaction();
        if (currentIndex != -1){
            checkedTextViews[currentIndex].setChecked(false);
            textViews[currentIndex].setTextColor(Color.rgb(155,155,155));
        }
        checkedTextViews[index].setChecked(true);
        textViews[index].setTextColor(Color.rgb(0,160,81));
        if (currentIndex == index) {
            return;
        } else {
            currentIndex = index;
        }
        if (currentFrag != null) {
            ft.hide(currentFrag);
        }
        switch (index) {
            case 0:
                if (home == null) {
                    home = new HomeFragment();
                    ft.add(R.id.main_fragment, fragments.get(0));
                } else {
                    ft.show(fragments.get(0));
                }
                currentFrag = fragments.get(0);
                break;
            case 1:
                if (speak == null) {
                    speak = new SpeakFragment();
                    ft.add(R.id.main_fragment, fragments.get(1));
                } else {
                    ft.show(fragments.get(1));
                }
                currentFrag = fragments.get(1);
                break;
            case 2:
                if (msg == null) {
                    msg = new MsgFragment();
                    ft.add(R.id.main_fragment, fragments.get(2));
                } else {
                    ft.show(fragments.get(2));
                }
                currentFrag = fragments.get(2);
                break;
            case 3:
                if (mine == null) {
                    mine = new MineFragment();
                    ft.add(R.id.main_fragment, fragments.get(3));
                } else {
                    ft.show(fragments.get(3));
                }
                currentFrag = fragments.get(3);
                break;
        }
        ft.commit();
    }
}
