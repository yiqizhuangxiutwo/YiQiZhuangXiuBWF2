package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.GDZB_RecyclerView_Adapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_GDZB;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_GDZB;
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
    @BindView(R.id.zxgs_recyclerview)
    RecyclerView zxgsRecyclerview;
    @BindView(R.id.refreshLayout)
    CustomRefreshLayout refreshLayout;

    private GDZB_RecyclerView_Adapter adapter;


    @Override
    public int getContentViewResID() {
        return R.layout.decoration_company;
    }

    @Override
    protected void initViews() {
        textTitleSubviewTitle.setText("工地直播");
        Intent intent = this.getIntent();
        String id = intent.getStringExtra("id");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        zxgsRecyclerview.setLayoutManager(manager);
        adapter = new GDZB_RecyclerView_Adapter(this);
        zxgsRecyclerview.setAdapter(adapter);
        getHttp_GDZB(id);
    }

    /**
     * 工地直播基本信息获取
     */
    private void getHttp_GDZB(String id) {
        Http_GDZB http_gdzb = new Http_GDZB();
        http_gdzb.getHttp(id);
        http_gdzb.setCallback(new Http_GDZB.Callback() {
            @Override
            public void RecyclerViewCallback(Response_GDZB response_gdzb) {
                adapter.addDatas(response_gdzb);
            }
        });
    }

    @Override
    protected void initDatas() {

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
}
