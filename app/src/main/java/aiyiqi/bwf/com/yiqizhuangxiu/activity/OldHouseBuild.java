package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2016-11-24.
 */
public class OldHouseBuild extends BaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.newandold_webview)
    WebView newandoldWebview;

    @Override
    public int getContentViewResID() {
        return R.layout.newandold_housebuild;
    }

    @Override
    protected void initViews() {
        title.setText("老房整装");
        newandoldWebview.getSettings().setJavaScriptEnabled(true);
        newandoldWebview.loadUrl("http://hui.17house.com/svc/payment-facade/h5/activity177/index.html?model=android");
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
