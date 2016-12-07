package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.ZXGS_RecycleView_Adapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Buide_Company_ListView;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Buide_Company_ViewPager;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_Build_Company_ListView;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_Build_Company_ViewPager;
import aiyiqi.bwf.com.yiqizhuangxiu.view.CustomRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/24.
 */
public class ZhuangXiuGongSiActivity extends BaseActivity {


    @BindView(R.id.text_title_subview_title)
    TextView textTitleSubviewTitle;
    @BindView(R.id.imageView_back_subview_title)
    ImageView imageViewBackSubviewTitle;
    @BindView(R.id.zxgs_recyclerview)
    RecyclerView zxgsRecyclerview;
    @BindView(R.id.linearlayout_yuye)
    LinearLayout linearlayoutYuye;
    @BindView(R.id.linearlayout_zixun)
    LinearLayout linearlayoutZixun;
    @BindView(R.id.decoration_bottom)
    LinearLayout decorationBottom;
    @BindView(R.id.refreshLayout)
    CustomRefreshLayout refreshLayout;
    private ZXGS_RecycleView_Adapter adapter;

    @Override
    public int getContentViewResID() {
        return R.layout.build_company;
    }

    @Override
    protected void initViews() {
        textTitleSubviewTitle.setText("装修公司");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        zxgsRecyclerview.setLayoutManager(manager);
        adapter = new ZXGS_RecycleView_Adapter(this);
        zxgsRecyclerview.setAdapter(adapter);
        getViewPager_Http();
        getListView_Http();

    }

    /**
     * 获得ListView的网络数据
     */
    private void getListView_Http() {
        Http_Build_Company_ListView http_build_company_listView = new Http_Build_Company_ListView();
        http_build_company_listView.getHttp();
        http_build_company_listView.setCallback(new Http_Build_Company_ListView.Callback() {
            @Override
            public void ViewPagerCallback(Response_Buide_Company_ListView response_buide_company_listView) {
                refreshLayout.finishRefresh();
                adapter.addListViewDatas(response_buide_company_listView.getData());
            }

            @Override
            public void HttpFailded(Exception e) {

            }
        });

    }

    /**
     * 获ViewPager的网络数据
     */
    private void getViewPager_Http() {
        Http_Build_Company_ViewPager http_build_company_viewPager = new Http_Build_Company_ViewPager();
        http_build_company_viewPager.getHttp();
        http_build_company_viewPager.setCallback(new Http_Build_Company_ViewPager.Callback() {
            @Override
            public void ViewPagerCallback(Response_Buide_Company_ViewPager response_home_viewpager) {
                refreshLayout.finishRefresh();
                adapter.addViewPagerDatas(response_home_viewpager.getData());
            }

            @Override
            public void HttpFailded(Exception e) {

            }
        });
    }

    private int offSetY = 0;
    @Override
    protected void initDatas() {
        //监听什么时候可以刷新
        zxgsRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                offSetY+=dy;
                if (offSetY == 0){
                    refreshLayout.setCanPull(true);
                }else{
                    refreshLayout.setCanPull(false);
                }
            }
        });
        //刷新的监听
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                adapter.setListViewDatasClear();
                adapter.setViewPagerDatasClear();
                getViewPager_Http();
                getListView_Http();
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


}
