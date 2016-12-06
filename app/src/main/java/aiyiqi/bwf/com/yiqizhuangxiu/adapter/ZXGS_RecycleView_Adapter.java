package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.GongDiZhiBoActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.NewHouseBuild;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.OldHouseBuild;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.TeamTogether;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Buide_Company_ListView;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Buide_Company_ViewPager;
import aiyiqi.bwf.com.yiqizhuangxiu.view.AutoScrollViewPager;
import aiyiqi.bwf.com.yiqizhuangxiu.widget.PagerDotIndicator;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/28.
 */
public class ZXGS_RecycleView_Adapter extends RecyclerView.Adapter implements View.OnClickListener {

    private List<Response_Buide_Company_ViewPager.DataBean> dataBeen;
    private List<Response_Buide_Company_ListView.DataBean> dataBeanList;
    private Context context;
    private LayoutInflater inflater;

    private static final int HEADERVIEWPAGER = 0;
    private static final int HEADERTWO = 1;
    private static final int BODY = 2;
    private static final int FOOTER = 3;

    private PagerDotIndicator pagerDotIndicator;//ViewPager的指示器

    public ZXGS_RecycleView_Adapter(Context context) {
        this.context = context;
        dataBeen = new ArrayList<>();
        dataBeanList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }


    public void addViewPagerDatas(List<Response_Buide_Company_ViewPager.DataBean> dataBean) {
        this.dataBeen.addAll(dataBean);
        notifyDataSetChanged();
    }

    public void setViewPagerDatasClear() {
        this.dataBeen.clear();
    }


    public void addListViewDatas(List<Response_Buide_Company_ListView.DataBean> dataBeanList) {
        this.dataBeanList.addAll(dataBeanList);
        notifyDataSetChanged();
    }

    public void setListViewDatasClear() {
        this.dataBeanList.clear();
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADERVIEWPAGER;
        } else if (position == 1) {
            return HEADERTWO;
        } else if (position == getItemCount() - 1) {
            return FOOTER;
        } else {
            return BODY;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADERVIEWPAGER) {
            return new HeaderViewPager(inflater.inflate(R.layout.subview_viewpager, parent, false));
        } else if (viewType == HEADERTWO) {
            return new HeaderTwoViewHolder(inflater.inflate(R.layout.decoration_company_second, parent, false));
        } else if (viewType == FOOTER) {
            return new FooterViewHolder(inflater.inflate(R.layout.decoration_company_footer, parent, false));
        } else {
            return new BodyViewHolder(inflater.inflate(R.layout.listview_decoration_live, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (position == 0 && dataBeen.size() != 0) {
            HeaderViewPager headerViewPager = (HeaderViewPager) holder;
            ZXGS_RecycleView_ViewPager_Adapter adapter = new ZXGS_RecycleView_ViewPager_Adapter(context, dataBeen);
            headerViewPager.viewPagerMainListSlide.setAdapter(adapter);
            headerViewPager.viewPagerMainListSlide.setCurrentItem(dataBeen.size() * 10);
            if (pagerDotIndicator == null) {
                pagerDotIndicator = new PagerDotIndicator(context, headerViewPager.linearLayoutPagerIndicator, headerViewPager.viewPagerMainListSlide);
                pagerDotIndicator.setDotNums(dataBeen.size());
            }
            Log.d("ZXGS_RecycleView_Adapte", "dataBeen.size():" + dataBeen.size());
        } else if (position == 1) {
            HeaderTwoViewHolder viewholder = (HeaderTwoViewHolder) holder;
            viewholder.linearlayoutNewHouse.setOnClickListener(this);
            viewholder.linearlayoutOldHouse.setOnClickListener(this);
            viewholder.lookScene.setOnClickListener(this);
            viewholder.siteLive.setOnClickListener(this);
            viewholder.teamTogether.setOnClickListener(this);
        } else if (position == getItemCount() - 1) {
            FooterViewHolder footerholder = (FooterViewHolder) holder;
            if (position == 2) {
                footerholder.decorationCompanyFooterText.setVisibility(View.GONE);
                return;
            }
            footerholder.decorationCompanyFooterText.setVisibility(View.VISIBLE);
        } else {
            if (dataBeanList.size() != 0 && position != 0) {
                BodyViewHolder bodyholder = (BodyViewHolder) holder;
                bodyholder.decorationListviewSimpledrawee.setImageURI(dataBeanList.get(position - 2).getImageUrl());
                bodyholder.decorationListviewTextup.setText(dataBeanList.get(position - 2).getOrderHouse().getCommunity());
                bodyholder.decorationListviewTextdown.setText(dataBeanList.get(position - 2).getOrderHouse().getLayout());
                bodyholder.decorationFrame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(new Intent(context,GongDiZhiBoActivity.class));
                        intent.putExtra("id",dataBeanList.get(position-2).getBuildingSite().getBuildingId());
                        context.startActivity(intent);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return 3 + dataBeanList.size();
    }

    /**
     * 中间按钮的监听
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linearlayout_new_house:
                context.startActivity(new Intent(context, NewHouseBuild.class));
                break;
            case R.id.linearlayout_old_house:
                context.startActivity(new Intent(context, OldHouseBuild.class));
                break;
            case R.id.team_together:
                context.startActivity(new Intent(context, TeamTogether.class));
                break;
            case R.id.site_live:
                Intent intent = new Intent(new Intent(context,GongDiZhiBoActivity.class));
                intent.putExtra("id",dataBeanList.get(0).getBuildingSite().getBuildingId());
                context.startActivity(intent);
                break;
        }
    }

    /**
     * 上部ViewPager的ID
     */
    static class HeaderViewPager extends RecyclerView.ViewHolder {
        @BindView(R.id.viewPager_main_list_slide)
        AutoScrollViewPager viewPagerMainListSlide;
        @BindView(R.id.linearLayout_pager_indicator)
        LinearLayout linearLayoutPagerIndicator;

        HeaderViewPager(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 中间布局的ID
     */
    static class HeaderTwoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.linearlayout_new_house)
        LinearLayout linearlayoutNewHouse;
        @BindView(R.id.linearlayout_old_house)
        LinearLayout linearlayoutOldHouse;
        @BindView(R.id.look_scene)
        LinearLayout lookScene;
        @BindView(R.id.site_live)
        LinearLayout siteLive;
        @BindView(R.id.team_together)
        LinearLayout teamTogether;

        HeaderTwoViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 脚的ID
     */
    static class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.decoration_company_footer_text)
        TextView decorationCompanyFooterText;

        FooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 身体的ID
     */
    static class BodyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.decoration_listview_simpledrawee)
        SimpleDraweeView decorationListviewSimpledrawee;
        @BindView(R.id.decoration_listview_textup)
        TextView decorationListviewTextup;
        @BindView(R.id.decoration_listview_textdown)
        TextView decorationListviewTextdown;
        @BindView(R.id.decoration_frame)
        FrameLayout decorationFrame;

        BodyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
