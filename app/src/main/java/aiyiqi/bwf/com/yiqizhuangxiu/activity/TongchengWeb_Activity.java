package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.Tongcheng_Adapter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.TongchengPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/29.
 */

public class TongchengWeb_Activity extends BaseActivity{
    @BindView(R.id.text_title_subview_title)
    TextView textTitleSubviewTitle;
    @BindView(R.id.imageView_back_subview_title)
    ImageView imageViewBackSubviewTitle;
    @BindView(R.id.tongcheng_webview)
    WebView tongchengWebview;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;


    private Tongcheng_Adapter tongchengAdapter;
    private TongchengPresenter tongchengPresenter;
    private LinearLayoutManager linearLayoutManager;


    @Override
    public int getContentViewResID() {
        return R.layout.samecity_web_page;
    }

    @Override
    protected void initViews() {
        Intent intent = this.getIntent();
        String web = intent.getStringExtra("web");
        String urls = intent.getStringExtra("urls");
        tongchengWebview.getSettings().setJavaScriptEnabled(true);
        if (web == null){
            tongchengWebview.loadUrl(urls);
        }else{
            tongchengWebview.loadUrl(web);
        }
        tongchengWebview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            { //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    protected void initDatas() {
        imageViewBackSubviewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
