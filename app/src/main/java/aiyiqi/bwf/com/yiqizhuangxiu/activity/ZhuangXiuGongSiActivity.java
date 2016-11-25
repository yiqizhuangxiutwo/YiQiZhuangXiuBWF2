package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.MsgFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/24.
 */
public class ZhuangXiuGongSiActivity extends BaseActivity {
    @BindView(R.id.zxgs_viewpager)
    ViewPager zxgsViewpager;
    @BindView(R.id.look_scene)
    LinearLayout lookScene;
    @BindView(R.id.site_live)
    LinearLayout siteLive;
    @BindView(R.id.team_together)
    LinearLayout teamTogether;
    @BindView(R.id.listview_decoration_live)
    ListView listviewDecorationLive;
    @BindView(R.id.linearlayout_new_house)
    LinearLayout linearlayoutNewHouse;
    @BindView(R.id.linearlayout_old_house)
    LinearLayout linearlayoutOldHouse;
    @BindView(R.id.back)
    ImageView back;

    @Override
    public int getContentViewResID() {
        return R.layout.decoration_company;
    }

    @Override
    protected void initViews() {

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

    @OnClick({R.id.linearlayout_new_house, R.id.linearlayout_old_house,R.id.back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linearlayout_new_house:
                startActivity(new Intent(this, NewHouseBuild.class));
                break;
            case R.id.linearlayout_old_house:
                startActivity(new Intent(this, OldHouseBuild.class));
                break;
            case R.id.back:
                startActivity(new Intent(this, MsgFragment.class));
                break;
        }
    }
}
