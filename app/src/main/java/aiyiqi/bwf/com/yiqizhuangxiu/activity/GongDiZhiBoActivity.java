package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.GDZB_Recycler_Adapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_GDZB;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_GDZB_ST;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.Inner_Fragment;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_GDZB;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_GDZB_ST;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.TimeChange;
import aiyiqi.bwf.com.yiqizhuangxiu.view.CustomRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/29.
 */
public class GongDiZhiBoActivity extends BaseActivity {

    @BindView(R.id.text_title_subview_title)
    TextView textTitleSubviewTitle;
    @BindView(R.id.imageView_back_subview_title)
    ImageView imageViewBackSubviewTitle;
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
    @BindView(R.id.refreshLayout)
    CustomRefreshLayout refreshLayout;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    @Override
    public int getContentViewResID() {
        return R.layout.decoration_company;
    }

    private static String id;

    @Override
    protected void initViews() {
        ll = (LinearLayout) findViewById(R.id.ll);
        textTitleSubviewTitle.setText("工地直播");
        Intent intent = this.getIntent();
        id = intent.getStringExtra("id");
        getHttp_GDZB();
    }

    /**
     * 工地直播基本信息获取
     */
    private void getHttp_GDZB() {
        //基本信息的获取
        Http_GDZB http_gdzb = new Http_GDZB();
        http_gdzb.getHttp(id);
        http_gdzb.setCallback(new Http_GDZB.Callback() {
            @Override
            public void RecyclerViewCallback(Response_GDZB response_gdzb) {

                decorationListviewSimpledrawee.setImageURI(response_gdzb.getData().getImageUrl());
                decorationListviewTextup.setText(response_gdzb.getData().getOrderHouse().getCommunity());
                decorationListviewTextdown.setText(response_gdzb.getData().getOrderHouse().getLayout());

                siteLiveTitleDesigner.setImageURI(response_gdzb.getData().getMembers().get(0).getAvatar());
                siteLiveTitleSupervisor.setImageURI(response_gdzb.getData().getMembers().get(1).getAvatar());
                siteLiveTitleForeman.setImageURI(response_gdzb.getData().getMembers().get(2).getAvatar());
                siteLiveTitleAdviser.setImageURI(response_gdzb.getData().getMembers().get(3).getAvatar());
                siteLiveTitleDesignerText.setText(response_gdzb.getData().getMembers().get(0).getVendorName());
                siteLiveTitleSupervisorText.setText(response_gdzb.getData().getMembers().get(1).getVendorName());
                siteLiveTitleForemanText.setText(response_gdzb.getData().getMembers().get(2).getVendorName());
                siteLiveTitleAdviserText.setText(response_gdzb.getData().getMembers().get(3).getVendorName());

                LinearLayoutManager manager = new LinearLayoutManager(GongDiZhiBoActivity.this);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recycleView.setLayoutManager(manager);
                GDZB_Recycler_Adapter adapter = new GDZB_Recycler_Adapter(GongDiZhiBoActivity.this, response_gdzb.getData().getProgress());
                recycleView.setAdapter(adapter);

            }
        });

    }

    private  static LayoutInflater inflater;
    @Override
    protected void initDatas() {
        inflater = LayoutInflater.from(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.imageView_back_subview_title)
    public void onClick() {
        finish();
    }


    private static LinearLayout ll;
    private static int currentProgressId = -1;

    public void setPosition(int progressId) {
        if (currentProgressId == progressId){
            return;
        }
        Log.d("GongDiZhiBoActivity", "进来了");
        currentProgressId = progressId;
        ll.removeAllViews();
        Http_GDZB_ST http_gdzb_st = new Http_GDZB_ST();
        http_gdzb_st.getHttp(progressId, id);
        http_gdzb_st.setCallback(new Http_GDZB_ST.Callback() {
            @Override
            public void RecyclerViewCallback(Response_GDZB_ST response_gdzb_st) {

                for (int i = 0; i < response_gdzb_st.getData().size(); i++) {
                    View inner_view = inflater.inflate(R.layout.innerview,null);
                    Inner_ViewHolder holder = new Inner_ViewHolder(inner_view);
                    holder.name.setText(response_gdzb_st.getData().get(i).getCreatorName()+"("
                        +response_gdzb_st.getData().get(i).getCreatorRole()+")");
                    holder.message.setText(response_gdzb_st.getData().get(i).getMessage());
                    holder.simple.setImageURI(response_gdzb_st.getData().get(i).getAvatar());
                    String time = new TimeChange().formatDuring(response_gdzb_st.getData().get(i).getCreateTime());
                    holder.time.setText(time);
                    ll.addView(inner_view);
                }
            }
        });
    }

    static class Inner_ViewHolder {
        @BindView(R.id.simple)
        SimpleDraweeView simple;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.message)
        TextView message;
        @BindView(R.id.innergrid)
        GridView innergrid;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.share)
        ImageView share;


        Inner_ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
