package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_PostDetails;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_SearchPostDetails;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/28.
 */

public class SearchPostDetailsActivity extends BaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.post_details_simpledrawweeview_author)
    SimpleDraweeView postDetailsSimpledrawweeviewAuthor;
    @BindView(R.id.post_details_tv_author)
    TextView postDetailsTvAuthor;
    @BindView(R.id.post_details_tv_follow)
    TextView postDetailsTvFollow;
    @BindView(R.id.post_details_tv_theme)
    TextView postDetailsTvTheme;
    @BindView(R.id.post_details_tv_theme_details)
    TextView postDetailsTvThemeDetails;
    @BindView(R.id.search_post_details_webview)
    WebView searchPostDetailsWebview;

    @Override
    public int getContentViewResID() {
        return R.layout.search_post_details;
    }

    @Override
    protected void initViews() {
        searchPostDetailsWebview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return true;

            }
        });
    }

    @Override
    protected void initDatas() {
        getHttpTag();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    private void getHttpTag(){
        Http_SearchPostDetails http_searchPostDetails = new Http_SearchPostDetails();
        http_searchPostDetails.getHttp();
        http_searchPostDetails.setCallback(new Http_SearchPostDetails.Callback() {
            @Override
            public void PostDetails(Response_PostDetails response_postDetails) {

            }

            @Override
            public void HttpFailded(Exception e) {
                Toast.makeText(SearchPostDetailsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @OnClick({R.id.back, R.id.post_details_simpledrawweeview_author, R.id.post_details_tv_follow, R.id.post_details_tv_theme_details})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
//                Intent intent1 = new Intent(this,SearchUserPostActivity.class);
//                startActivity(intent1);
//                finish();
                break;
            case R.id.post_details_simpledrawweeview_author:
                Intent intent2 = new Intent(this,PersonalNewsActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.post_details_tv_follow:
                Intent intent3 = new Intent(this,LoginRegisterActivity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.post_details_tv_theme_details:
                Intent intent4 = new Intent(this,PersonalNewsActivity.class);
                startActivity(intent4);
                finish();
                break;
        }
    }
}
