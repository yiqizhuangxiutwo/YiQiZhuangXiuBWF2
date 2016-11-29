package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Buide_Company_ViewPager;
import aiyiqi.bwf.com.yiqizhuangxiu.view.AutoScrollViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/28.
 */
public class ZXGS_RecycleView_Adapter extends RecyclerView.Adapter {

    private List<Response_Buide_Company_ViewPager.DataBean> dataBeen;
    private Context context;
    private LayoutInflater inflater;

    private static final int HEADERVIEWPAGER = 0;

    public ZXGS_RecycleView_Adapter(Context context) {
        this.context = context;
        dataBeen = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }


    public void addViewPagerDatas(List<Response_Buide_Company_ViewPager.DataBean> dataBean) {
        dataBeen.addAll(dataBean);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADERVIEWPAGER;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADERVIEWPAGER) {
            return new HeaderViewPager(inflater.inflate(R.layout.subview_viewpager, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0 && dataBeen.size()!=0){
            HeaderViewPager headerViewPager = (HeaderViewPager) holder;
            ZXGS_RecycleView_ViewPager_Adapter adapter = new ZXGS_RecycleView_ViewPager_Adapter(context,dataBeen);
            headerViewPager.viewPagerMainListSlide.setAdapter(adapter);
            headerViewPager.viewPagerMainListSlide.setCurrentItem(dataBeen.size()*10);
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    /**
     *上部ViewPager的ID
     */
    static class HeaderViewPager extends RecyclerView.ViewHolder{
        @BindView(R.id.viewPager_main_list_slide)
        AutoScrollViewPager viewPagerMainListSlide;
        @BindView(R.id.linearLayout_pager_indicator)
        LinearLayout linearLayoutPagerIndicator;

        HeaderViewPager(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
