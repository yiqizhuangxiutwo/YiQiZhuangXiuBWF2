package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/5.
 */

public class TeamTogetherGridViewPage extends BaseActivity {


    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.teamtogether_head)
    SimpleDraweeView teamtogetherHead;
    @BindView(R.id.teamtogether_name)
    TextView teamtogetherName;
    @BindView(R.id.teamtogether_num)
    TextView teamtogetherNum;
    @BindView(R.id.ratingbar)
    RatingBar ratingbar;

    private String image;
    private String name;
    private int caseNum;
    private int ratingbar1;
    private Intent intent;



    @Override
    public int getContentViewResID() {
        return R.layout.teamtogether_gridviewpage;
    }

    @Override
    protected void initViews() {

        title.setText("一起人");
        Intent intent = getIntent();
        image = intent.getStringExtra("image");
        name = intent.getStringExtra("name");
        caseNum = intent.getIntExtra("caseNum",0);
        ratingbar1 = intent.getIntExtra("ratingbar1",0);

        teamtogetherHead.setImageURI(image);
        teamtogetherName.setText(name);
        teamtogetherNum.setText("装修案例：" + caseNum);






    }

    @Override
    protected void initDatas() {
        back.setOnClickListener(new View.OnClickListener() {
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
