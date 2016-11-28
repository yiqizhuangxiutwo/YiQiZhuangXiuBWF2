package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/25.
 */

public class WebFragment extends BaseFragment {
    @BindView(R.id.fragment_webview)
    WebView fragmentWebview;

    private String webFragmentUrl;

    public WebFragment(String webFragmentUrl) {
        this.webFragmentUrl = webFragmentUrl;
    }

    @Override
    protected int getContentViewResID() {
        return R.layout.fragment_webview;
    }

    @Override
    protected void initViews() {
        fragmentWebview.getSettings().setJavaScriptEnabled(true);
        fragmentWebview.loadUrl(webFragmentUrl);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
