package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.GDZB_Recycler_Adapter;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.RecycDownAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_GDZB;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_GDZB_ST;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_GDZB;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_GDZB_ST;
import aiyiqi.bwf.com.yiqizhuangxiu.view.CustomRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/29.
 */
public class GongDiZhiBoActivity extends BaseActivity{

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
    @BindView(R.id.linearlayout_yuye)
    LinearLayout linearlayoutYuye;
    @BindView(R.id.linearlayout_zixun)
    LinearLayout linearlayoutZixun;
    @BindView(R.id.decoration_bottom)
    LinearLayout decorationBottom;
    @BindView(R.id.scroll)
    ScrollView scroll;
    @BindView(R.id.recycdown)
    RecyclerView recycdown;

    @Override
    public int getContentViewResID() {
        return R.layout.decoration_company;
    }

    private static String id;
    private static GDZB_Recycler_Adapter adapter;
    private static RecycDownAdapter downAdapteradapte;

    @Override
    protected void initViews() {
        textTitleSubviewTitle.setText("工地直播");
        decorationBottom.setVisibility(View.VISIBLE);

        LinearLayoutManager manager = new LinearLayoutManager(GongDiZhiBoActivity.this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycleView.setLayoutManager(manager);
        adapter = new GDZB_Recycler_Adapter(GongDiZhiBoActivity.this);
        recycleView.setAdapter(adapter);

        LinearLayoutManager manager2 = new LinearLayoutManager(GongDiZhiBoActivity.this);
        manager2.setOrientation(LinearLayoutManager.VERTICAL);
        recycdown.setLayoutManager(manager2);
        downAdapteradapte = new RecycDownAdapter(GongDiZhiBoActivity.this);
        recycdown.setAdapter(downAdapteradapte);

        Intent intent = this.getIntent();
        id = intent.getStringExtra("id");
        getHttp_GDZB();
    }

    /**
     * 工地直播基本信息获取
     */
    private void getHttp_GDZB() {
        refreshLayout.finishRefresh();
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

                adapter.addDatas(response_gdzb.getData().getProgress());
            }
        });
    }

    protected void initDatas() {
        //设置何时可以刷新
        scroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        if (v.getScrollY() == 0){
                            refreshLayout.setCanPull(true);
                        }else{
                            refreshLayout.setCanPull(false);
                        }
                }
                return false;
            }
        });
        //刷新的监听
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

                adapter.clearDatas();
                downAdapteradapte.clearDatas();
                getHttp_GDZB();
            }
        });
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


    private static int currentProgressId = -1;


    public void setPosition(int progressId) {
        if (currentProgressId == progressId) {
            return;
        }
        currentProgressId = progressId;
        Http_GDZB_ST http_gdzb_st = new Http_GDZB_ST();
        http_gdzb_st.getHttp(progressId, id);
        http_gdzb_st.setCallback(new Http_GDZB_ST.Callback() {
            @Override
            public void RecyclerViewCallback(Response_GDZB_ST response_gdzb_st) {
                downAdapteradapte.addDatas(response_gdzb_st.getData());
            }
        });
    }
}
