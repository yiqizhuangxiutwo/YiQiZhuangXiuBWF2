package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTie;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.TiePresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl.TiePresenterImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.TieView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 *
 */
    //TODO  Load is a web page, has not yet been modified
public class TieActivity extends BaseActivity implements TieView {


    @BindView(R.id.main_recycleview_tie_touxiang)
    SimpleDraweeView mainRecycleviewTieTouxiang;
    @BindView(R.id.auther)
    TextView auther;
    @BindView(R.id.fouces_button)
    LinearLayout foucesButton;
    @BindView(R.id.main_tie_title)
    TextView mainTieTitle;
    @BindView(R.id.tie_item_lianjie)
    TextView tieItemLianjie;
    @BindView(R.id.tie_item_time)
    TextView tieItemTime;
    @BindView(R.id.article_tie_webview)
    WebView articleTieWebview;
    @BindView(R.id.image_button_tag01)
    ImageButton imageButtonTag01;
    @BindView(R.id.image_button_tag02)
    ImageButton imageButtonTag02;
    @BindView(R.id.image_button_tag03)
    ImageButton imageButtonTag03;
    @BindView(R.id.linearlayout_tie)
    LinearLayout linearlayoutTie;
    private TiePresenter presenter;
    private String id;

    @Override
    public int getContentViewResID() {
        return R.layout.article_tie_activity;
    }

    @Override
    protected void initViews() {

        initWebView();

    }
    private void initWebView(){
        articleTieWebview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
        articleTieWebview.addJavascriptInterface(new JavascriptInterface(this), "BWF");
        articleTieWebview.getSettings().setJavaScriptEnabled(true);
    }

    private class JavascriptInterface{
        Context context;

        public JavascriptInterface(Context context) {
            super();
            this.context = context;
        }
    }
    @Override
    protected void initDatas() {
        id = getIntent().getStringExtra("tieId");
        Log.d("TieActivity", "id:" + id);
        presenter = new TiePresenterImpl(this);
        presenter.loadDatas(id);

    }

    @Override
    public void showTie(ResponseTie dataBeen) {
//        Log.d("TieActivity", dataBeen.getData().toString());
        if(dataBeen.getData() == null){
            Toast.makeText(this, "帖子不存在或已被删除", Toast.LENGTH_SHORT).show();
            return;
        }
        mainRecycleviewTieTouxiang.setImageURI(dataBeen.getData().getAvtUrl());
        auther.setText(dataBeen.getData().getAuthor());
        mainTieTitle.setText(dataBeen.getData().getTitle());
        tieItemTime.setText(dataBeen.getData().getDateline());
        articleTieWebview.loadUrl(dataBeen.getData().getUrls());
        tieItemLianjie.setText(R.string.text_06+dataBeen.getData().getFname()+">");
    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    public void showFailed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
