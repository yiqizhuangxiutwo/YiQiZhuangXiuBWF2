package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.HomeFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.MineFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.MsgFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.SpeakFragment;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * @return  首页
     */
    private List<Fragment> getFragments(){
        this.fragments =  new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new SpeakFragment());
        fragments.add(new MsgFragment());
        fragments.add(new MineFragment());
        return fragments;
    }
}
