package aiyiqi.bwf.com.yiqizhuangxiu.activity.speakactivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.BaseActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Detail;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_zan;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.DetailPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.iml.DetailPresenterIml;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view.DetailView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.lankton.flowlayout.FlowLayout;

/**
 * Created by Administrator on 2016/11/30.
 */

public class ArticleActivity extends BaseActivity implements DetailView {
    @BindView(R.id.authorname)
    TextView authorname;
    @BindView(R.id.subjectname)
    TextView subjectname;
    @BindView(R.id.imageView_author)
    SimpleDraweeView imageViewAuthor;
    @BindView(R.id.textView_main_title)
    TextView textViewMainTitle;
    @BindView(R.id.textView_subtitle)
    TextView textViewSubtitle;
    @BindView(R.id.article_date)
    TextView articleDate;
    @BindView(R.id.article_detail)
    LinearLayout articleDetail;
    @BindView(R.id.article_tag)
    FlowLayout articleTag;
    @BindView(R.id.article_zan)
    LinearLayout articlezan;
    private DetailPresenter detailPresenter;
    String articleId;
    int zanShu;
    @Override
    public int getContentViewResID() {
        return R.layout.articleactivity;
    }

    @Override
    public void initViews() {

    }

    @Override
    protected void initDatas() {
        detailPresenter = new DetailPresenterIml(this);
        articleId = getIntent().getStringExtra("articleId");
        zanShu = getIntent().getIntExtra("zan",0);
        Toast.makeText(this, "articleId:" + articleId, Toast.LENGTH_SHORT).show();
        detailPresenter.loadDetails(articleId);
    }

    @Override
    public void showDetail(Response_Detail detail) {
        authorname.setText(detail.getData().getAuthor());
        imageViewAuthor.setImageURI(detail.getData().getAvtUrl());
        textViewMainTitle.setText(detail.getData().getTitle());
        textViewSubtitle.setText("精选自" + detail.getData().getFname());
        articleDate.setText(detail.getData().getDateline() + "");
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < detail.getData().getMessage().size(); i++) {
            View view = null;
            if (detail.getData().getMessage().get(i).getImgType() == 0) {
                view = inflater.inflate(R.layout.textviewitem, articleDetail, false);
                TextView textviewdetail = (TextView) view.findViewById(R.id.textviewdetail);
                textviewdetail.setText(detail.getData().getMessage().get(i).getMsg());
            } else if (detail.getData().getMessage().get(i).getImgType() == 1) {
                view = inflater.inflate(R.layout.simpledraweeview, articleDetail, false);
                SimpleDraweeView simple = (SimpleDraweeView) view.findViewById(R.id.iamgeView_subview_main_slide_page);
                simple.setImageURI(detail.getData().getMessage().get(i).getMsg());
            } else {
                view = inflater.inflate(R.layout.simpledraweei, articleDetail, false);
                SimpleDraweeView simple = (SimpleDraweeView) view.findViewById(R.id.iamgeView_subview_page);
                simple.setImageURI(detail.getData().getMessage().get(i).getMsg());
            }
            articleDetail.addView(view);
        }
        for (int i = 0; i < detail.getData().getTags().size(); i++) {
            View view = inflater.inflate(R.layout.articletag, articleTag, false);
            Button button = (Button) view.findViewById(R.id.btntag);
            button.setText(detail.getData().getTags().get(i).getTagname());
            articleTag.addView(view);
        }
    }
    @Override
    public void showZan(Response_zan zan) {
        if(zan.getData()!=null){
            articlezan.setVisibility(View.VISIBLE);
            TextView textView = new TextView(this);
            textView.setText("赞" +"("+zanShu+")");
            articlezan.addView(textView);
            for (int i = 0; i < zan.getData().size(); i++) {
                SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this);
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
                roundingParams.setRoundAsCircle(true);
                simpleDraweeView.getHierarchy().setRoundingParams(roundingParams);
                simpleDraweeView.setImageURI(zan.getData().get(i).getAvtUrl());
                simpleDraweeView.setMinimumHeight(100);
                simpleDraweeView.setMinimumWidth(100);
                simpleDraweeView.setPadding(5,5,5,5);
                articlezan.addView(simpleDraweeView);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
