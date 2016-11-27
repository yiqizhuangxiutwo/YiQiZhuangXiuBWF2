package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by Yishi on 2016/11/24.
 */

public class WebViewFragmentPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;
    private String[] strings;

    public WebViewFragmentPagerAdapter(List<Fragment> fragments, String[] strings, FragmentManager fm) {
        super(fm);
        this.fragments = fragments;
        this.strings = strings;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
