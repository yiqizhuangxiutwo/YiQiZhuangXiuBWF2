package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.ZXGS_RecycleView_Adapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Buide_Company_ViewPager;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_Build_Company_ViewPager;
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

    private ZXGS_RecycleView_Adapter adapter;

    @Override
    public int getContentViewResID() {
        return R.layout.decoration_company;
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
                adapter.addViewPagerDatas(response_home_viewpager.getData());
            }

            @Override
            public void HttpFailded(Exception e) {

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
