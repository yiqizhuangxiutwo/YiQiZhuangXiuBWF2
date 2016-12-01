package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Buide_Company_ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2016-11-28.
 */
public class ZXGS_RecycleView_ViewPager_Adapter extends PagerAdapter {
    private List<Response_Buide_Company_ViewPager.DataBean> dataBeen;
    private LayoutInflater inflater;

    public ZXGS_RecycleView_ViewPager_Adapter(Context context, List<Response_Buide_Company_ViewPager.DataBean> dataBeen) {
        inflater = LayoutInflater.from(context);
        this.dataBeen = dataBeen;
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
        holder.homeViewpagerSimpledrawee.setImageURI(dataBeen.get(position%dataBeen.size()).getImagesrc());
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
