package aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.fragment.speakfragment.Fragment1;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.speakfragment.Fragment2;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.speakfragment.Fragment3;

/**
 * Created by Administrator on 2016/11/23.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> datas;
    public TabAdapter(FragmentManager fm, List<String> datas) {
        super(fm);
        fragments = new ArrayList<>();
        this.datas = datas;
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    public CharSequence getPageTitle(int position) {
        return datas.get(position);
    }
}
