package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_GDZB;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/29.
 */
public class GDZB_RecyclerView_Adapter extends RecyclerView.Adapter {
    private Context context;
    private List<Response_GDZB> response_gdzbs;
    private LayoutInflater inflater;
    private HeadtwoRecyclerviewAdapter adapter;

    private static final int HEADEONE = 0;
    private static final int HEADERTWO = 1;
    private static final int BODY = 2;
    private static final int FOOTER = 3;


    public GDZB_RecyclerView_Adapter(Context context) {
        this.context = context;
        response_gdzbs = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADEONE;
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
        if (viewType == HEADEONE) {
            return new HeaderOne(inflater.inflate(R.layout.acticity_zxgs_inner_head, parent, false));
        } else if (viewType == HEADERTWO) {
            return new HeaderTwoViewHolder(inflater.inflate(R.layout.decoration_progress, parent, false));
        }
//          else if (viewType == FOOTER) {
//            return new ZXGS_RecycleView_Adapter.FooterViewHolder(inflater.inflate(R.layout.decoration_company_footer, parent, false));
//        } else {
//            return new ZXGS_RecycleView_Adapter.BodyViewHolder(inflater.inflate(R.layout.listview_decoration_live, parent, false));
//        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0 && response_gdzbs.size() != 0) {
            HeaderOne headerOne = (HeaderOne) holder;
            headerOne.decorationListviewSimpledrawee.setImageURI(response_gdzbs.get(position).getData().getImageUrl());

            headerOne.siteLiveTitleDesigner.setImageURI(response_gdzbs.get(position).getData().getMembers().get(0).getAvatar());
            headerOne.siteLiveTitleSupervisor.setImageURI(response_gdzbs.get(position).getData().getMembers().get(1).getAvatar());
            headerOne.siteLiveTitleForeman.setImageURI(response_gdzbs.get(position).getData().getMembers().get(2).getAvatar());
            headerOne.siteLiveTitleAdviser.setImageURI(response_gdzbs.get(position).getData().getMembers().get(3).getAvatar());

            headerOne.siteLiveTitleDesignerText.setText(response_gdzbs.get(position).getData().getMembers().get(0).getVendorName());
            headerOne.siteLiveTitleSupervisorText.setText(response_gdzbs.get(position).getData().getMembers().get(1).getVendorName());
            headerOne.siteLiveTitleForemanText.setText(response_gdzbs.get(position).getData().getMembers().get(2).getVendorName());
            headerOne.siteLiveTitleAdviserText.setText(response_gdzbs.get(position).getData().getMembers().get(3).getVendorName());
        } else if (position == 1) {
            HeaderTwoViewHolder headerTwoViewHolder = (HeaderTwoViewHolder) holder;
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            headerTwoViewHolder.headtwoRecyclerview.setLayoutManager(manager);
            adapter = new HeadtwoRecyclerviewAdapter(context,response_gdzbs.get(position).getData().getProgress());
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public void addDatas(Response_GDZB response_gdzb) {
        this.response_gdzbs.add(response_gdzb);
        notifyDataSetChanged();
    }


    /**
     * 头1的ID
     */
    static class HeaderOne extends RecyclerView.ViewHolder {
        @BindView(R.id.decoration_listview_simpledrawee)
        SimpleDraweeView decorationListviewSimpledrawee;
        @BindView(R.id.decoration_listview_textup)
        TextView decorationListviewTextup;
        @BindView(R.id.decoration_listview_textdown)
        TextView decorationListviewTextdown;
        @BindView(R.id.decoration_frame)
        FrameLayout decorationFrame;
        @BindView(R.id.site_live_title_designer)
        SimpleDraweeView siteLiveTitleDesigner;
        @BindView(R.id.site_live_title_designer_text)
        TextView siteLiveTitleDesignerText;
        @BindView(R.id.site_live_title_supervisor)
        SimpleDraweeView siteLiveTitleSupervisor;
        @BindView(R.id.site_live_title_supervisor_text)
        TextView siteLiveTitleSupervisorText;
        @BindView(R.id.site_live_title_foreman)
        SimpleDraweeView siteLiveTitleForeman;
        @BindView(R.id.site_live_title_foreman_text)
        TextView siteLiveTitleForemanText;
        @BindView(R.id.site_live_title_adviser)
        SimpleDraweeView siteLiveTitleAdviser;
        @BindView(R.id.site_live_title_adviser_text)
        TextView siteLiveTitleAdviserText;
        @BindView(R.id.site_live_linearlayout)
        LinearLayout siteLiveLinearlayout;

        HeaderOne(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 头2的ID
     */
    static class HeaderTwoViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.headtwo_recyclerview)
        RecyclerView headtwoRecyclerview;

        HeaderTwoViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
