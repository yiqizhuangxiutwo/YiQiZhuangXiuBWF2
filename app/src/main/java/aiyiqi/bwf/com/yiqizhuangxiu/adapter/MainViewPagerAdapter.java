package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_home_viewpager;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/23.
 */
public class MainViewPagerAdapter extends PagerAdapter {

    private Response_home_viewpager home_viewpager;
    private LayoutInflater inflater;

    public MainViewPagerAdapter(Context context, Response_home_viewpager home_viewpager) {
        this.home_viewpager = home_viewpager;
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
        View view = inflater.inflate(R.layout.subview_viewpager_item, null);
        ViewHolder holder = new ViewHolder(view);
        holder.homeViewpagerSimpledrawee.setImageURI(home_viewpager.getData().get(position%home_viewpager.getData().size()).getImagesrc2());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = inflater.inflate(R.layout.subview_viewpager_item, null);
        container.removeView(view);
    }

    static class ViewHolder {
        @BindView(R.id.home_viewpager_simpledrawee)
        SimpleDraweeView homeViewpagerSimpledrawee;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
