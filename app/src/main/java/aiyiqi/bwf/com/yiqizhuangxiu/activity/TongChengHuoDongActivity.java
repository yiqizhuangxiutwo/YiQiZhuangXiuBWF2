package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.Tongcheng_Adapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTongcheng;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.TongchengPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl.TongchengPresenterImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.TongchengView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/24.
 */
public class TongChengHuoDongActivity extends BaseActivity implements TongchengView{

    @BindView(R.id.text_title_subview_title)
    TextView textTitleSubviewTitle;
    @BindView(R.id.imageView_back_subview_title)
    ImageView imageViewBackSubviewTitle;
    @BindView(R.id.tongcheng_recyclerview)
    RecyclerView tongchengRecyclerview;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;


    private Tongcheng_Adapter tongchengAdapter;
    private TongchengPresenter tongchengPresenter;
    private LinearLayoutManager linearLayoutManager;


    @Override
    public int getContentViewResID() {
        return R.layout.activity_samecity_detail;
    }

    @Override
    protected void initViews() {

        linearLayoutManager =new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        tongchengRecyclerview.setLayoutManager(linearLayoutManager);

        tongchengAdapter = new Tongcheng_Adapter(this);
        tongchengRecyclerview.setAdapter(tongchengAdapter);
        tongchengPresenter = new TongchengPresenterImpl(this);

        tongchengPresenter.loadTongchengDatas();

        imageViewBackSubviewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
//            @Override
//            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
//                //去重新加载数据
//                tongchengPresenter.loadTongchengDatas();
//            }
//        });
    }

    @Override
    public void showTongchengSuccess(List<ResponseTongcheng.DataBean.ForumlistBean> tongcheng) {
        Log.d("TongChengHuoDongActivit", tongcheng.get(0).getAuthor());
                tongchengAdapter.addDatas(tongcheng);


    }
    @Override
    public void showFailed() {

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


}
