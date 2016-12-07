package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.teamtogether_adapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/29.
 */
public class TeamTogether extends BaseActivity {
    @BindView(R.id.text_title_subview_title)
    TextView textTitleSubviewTitle;
    @BindView(R.id.imageView_back_subview_title)
    ImageView imageViewBackSubviewTitle;
    @BindView(R.id.tabLayout_teamtogether)
    TabLayout tabLayoutTeamtogether;
    @BindView(R.id.teamtogether_viewpager)
    ViewPager teamtogetherViewpager;

    private teamtogether_adapter teamtogetheradapter;

    @Override
    public int getContentViewResID() {
        return R.layout.team_together;
    }

    @Override
    protected void initViews() {

        textTitleSubviewTitle.setText("一起团队");

        imageViewBackSubviewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabLayoutTeamtogether.setupWithViewPager(teamtogetherViewpager);
        List<String> list = new ArrayList<>();
        list.add("设计师");
        list.add("工长");
        list.add("监理");
        teamtogetheradapter = new teamtogether_adapter(getSupportFragmentManager(),list);
        teamtogetherViewpager.setAdapter(teamtogetheradapter);

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
