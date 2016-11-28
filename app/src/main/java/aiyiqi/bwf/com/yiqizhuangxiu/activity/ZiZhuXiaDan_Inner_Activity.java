package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.WebViewFragmentPagerAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.ZiZhuXiaDan_Inner_Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/28.
 */

public class ZiZhuXiaDan_Inner_Activity extends BaseActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.zzxd_inner_title_image)
    SimpleDraweeView zzxdInnerTitleImage;
    @BindView(R.id.zzxd_inner_title_title)
    TextView zzxdInnerTitleTitle;
    @BindView(R.id.zzxd_inner_title_rating)
    RatingBar zzxdInnerTitleRating;
    @BindView(R.id.zzxd_inner_message_shangjia)
    TextView zzxdInnerMessageShangjia;
    @BindView(R.id.zzxd_inner_message_right)
    ImageView zzxdInnerMessageRight;
    @BindView(R.id.zzxd_inner_message_dizhi)
    TextView zzxdInnerMessageDizhi;
    @BindView(R.id.zzxd_inner_message_right2)
    ImageView zzxdInnerMessageRight2;
    @BindView(R.id.activity_zzxd_inner_message)
    LinearLayout activityZzxdInnerMessage;
    @BindView(R.id.zzxd_inner_tablayou)
    TabLayout zzxdInnerTablayou;
    @BindView(R.id.zzxd_inner_viewpager)
    ViewPager zzxdInnerViewpager;

    @Override
    public int getContentViewResID() {
        return R.layout.activity_zzxd_inner;
    }

    @Override
    protected void initViews() {
        Intent intent = this.getIntent();
        String image = intent.getStringExtra("image");
        String name = intent.getStringExtra("name");
        String text = intent.getStringExtra("text");
        String[] tabStrs = new String[]{"折扣","帖子","评价"};
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragments.add(new ZiZhuXiaDan_Inner_Fragment(text));
        }
        title.setText("自助下单");
        zzxdInnerTitleImage.setImageURI(image);
        zzxdInnerTitleTitle.setText(name);
        WebViewFragmentPagerAdapter adapter = new WebViewFragmentPagerAdapter(fragments, tabStrs, getSupportFragmentManager());
        zzxdInnerViewpager.setAdapter(adapter);
        zzxdInnerTablayou.setupWithViewPager(zzxdInnerViewpager);


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

    @OnClick({R.id.back, R.id.zzxd_inner_message_right, R.id.zzxd_inner_message_right2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.zzxd_inner_message_right:
                break;
            case R.id.zzxd_inner_message_right2:
                break;
        }
    }
}
