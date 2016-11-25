package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/24.
 */

public class ZXYS_Fragment_Left extends BaseFragment {
    @BindView(R.id.zxys_webview)
    WebView zxysWebview;

    @Override
    protected int getContentViewResID() {
        return R.layout.zxys_fragment_left;
    }

    @Override
    protected void initViews() {
        zxysWebview.getSettings().setJavaScriptEnabled(true);
        zxysWebview.loadUrl(Apis.ZXYS_WEBVIEW);
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
