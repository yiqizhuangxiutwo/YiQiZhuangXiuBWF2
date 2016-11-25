package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_ZXXT_Up_Tag;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_ZXXT_Tag;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/24.
 */
public class ZhuangXiuXueTangActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.zxxt_tablayout)
    TabLayout zxxtTablayout;
    @BindView(R.id.school_tab)
    ImageButton schoolTab;
    @BindView(R.id.zxxt_viewpager)
    ViewPager zxxtViewpager;

    @Override
    public int getContentViewResID() {
        return R.layout.activity_zxxt;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        getHttpTag();
    }

    /**
     * 获得上部TAG的数据星信息
     */
    private void getHttpTag() {
        Http_ZXXT_Tag zxxt_tag = new Http_ZXXT_Tag();
        zxxt_tag.getHttp();
        zxxt_tag.setCallback(new Http_ZXXT_Tag.Callback() {
            @Override
            public void ZXXTTagCallback(Response_ZXXT_Up_Tag response_zxxt_up_tag) {
                Toast.makeText(ZhuangXiuXueTangActivity.this, response_zxxt_up_tag.getData().getValue899(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void HttpFailded(Exception e) {
                Toast.makeText(ZhuangXiuXueTangActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_back, R.id.school_tab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.school_tab:
                //TODO
                break;
        }
    }
}
