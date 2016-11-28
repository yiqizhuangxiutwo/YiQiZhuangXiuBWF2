package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Buide_Company_ViewPager;

/**
 * Created by Yishi on 2016/11/28.
 */
public class Build_Company_PagerAdapter extends PagerAdapter{
    private Response_Buide_Company_ViewPager response_buide_company_viewPager;
    private LayoutInflater inflater;

    public Build_Company_PagerAdapter(Context context, Response_Buide_Company_ViewPager response_buide_company_viewPager) {
        this.response_buide_company_viewPager = response_buide_company_viewPager;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
