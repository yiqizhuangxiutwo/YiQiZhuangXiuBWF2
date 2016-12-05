package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.fragment.teamtgether_fragment;

/**
 * Created by Administrator on 2016/11/30.
 */

public class teamtogether_adapter extends FragmentPagerAdapter{

    private List<Fragment> fragments;
    private List<String> datas;

    public teamtogether_adapter(FragmentManager fm, List<String> datas) {
        super(fm);
        fragments = new ArrayList<>();
        this.datas = datas;
        for (int i = 0; i < datas.size(); i++) {
            fragments.add(new teamtgether_fragment());
        }
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
