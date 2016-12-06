package aiyiqi.bwf.com.yiqizhuangxiu.activity.speakactivity;

import android.graphics.LinearGradient;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.BaseActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_CommitArticle;
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
    @BindView(R.id.articl_cemmit)
    LinearLayout articlcemmit;
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
        zanShu = getIntent().getIntExtra("zan", 0);
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
                view = View.inflate(this, R.layout.textviewitem, null);
                TextView textviewdetail = (TextView) view.findViewById(R.id.textviewdetail);
                textviewdetail.setText(detail.getData().getMessage().get(i).getMsg());
                articleDetail.addView(view);
            } else if (detail.getData().getMessage().get(i).getImgType() == 1) {
                SimpleDraweeView simple = new SimpleDraweeView(ArticleActivity.this);
                simple.setImageURI(detail.getData().getMessage().get(i).getMsg());
                simple.setMinimumHeight(247);
                simple.setMinimumWidth(330);
                simple.setPadding(5, 5, 5, 5);
                articleDetail.addView(simple);
            } else {
                SimpleDraweeView simple = new SimpleDraweeView(ArticleActivity.this);
                simple.setImageURI(detail.getData().getMessage().get(i).getMsg());
                simple.setMinimumHeight(59);
                simple.setMinimumWidth(48);
                simple.setPadding(5, 5, 5, 5);
                articleDetail.addView(simple);
            }
        }
        for (int i = 0; i < detail.getData().getTags().size(); i++) {
            View view = inflater.inflate(R.layout.articletag, articleTag, false);
            Button button = (Button) view.findViewById(R.id.btntag);
            button.setText(detail.getData().getTags().get(i).getTagname());
            articleTag.addView(view);
        }
    }

    @Override
    public void showZan(final Response_zan zan) {

        if (zan.getData() != null) {
            articlezan.setVisibility(View.VISIBLE);
            TextView textView = new TextView(ArticleActivity.this);
            textView.setText("赞" + "(" + zanShu + ")");
            articlezan.addView(textView);
            for (int i = 0; i < zan.getData().size(); i++) {
                SimpleDraweeView simpleDraweeView = new SimpleDraweeView(ArticleActivity.this);
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
                roundingParams.setRoundAsCircle(true);
                simpleDraweeView.getHierarchy().setRoundingParams(roundingParams);
                simpleDraweeView.setImageURI(zan.getData().get(i).getAvtUrl());
                simpleDraweeView.setMinimumHeight(80);
                simpleDraweeView.setMinimumWidth(80);
                simpleDraweeView.setPadding(5, 5, 5, 5);
                articlezan.addView(simpleDraweeView);
            }
        }
    }

    @Override
    public void showCommit(Response_CommitArticle commitArticle) {
        articlcemmit.setVisibility(View.VISIBLE);
        articlcemmit.removeAllViews();
//        holder.commitCount.setText("回帖（"+commitArticle.getTotalCount()+")");
        for (int i = 0; i <commitArticle.getTotalCount(); i++) {
            LayoutInflater inflater = LayoutInflater.from(this);
            View view = inflater.inflate(R.layout.commitarticle, articlcemmit, false);
            CommitViewHolder holder = new CommitViewHolder(view);
            holder.commitName.setText(commitArticle.getData().get(i).getAuthor());
            holder.imageViewcommit.setImageURI(commitArticle.getData().get(i).getAvtUrl());
            for (int j = 0; j <commitArticle.getData().get(i).getMessage().size() ; j++) {
                LinearLayout linear = (LinearLayout) view.findViewById(R.id.linearcommit);
                if(commitArticle.getData().get(i).getMessage().get(j).getMsgType()==0){
                    TextView textView = new TextView(ArticleActivity.this);
                    textView.setText(commitArticle.getData().get(i).getMessage().get(j).getMsg());
                    linear.addView(textView);
                }else {
                    SimpleDraweeView simpleDraweeView = new SimpleDraweeView(ArticleActivity.this);
                    simpleDraweeView.setImageURI(commitArticle.getData().get(i).getMessage().get(j).getMsg());
                    simpleDraweeView.setMinimumHeight(59);
                    simpleDraweeView.setMinimumWidth(48);
                    simpleDraweeView.setPadding(5, 5, 5, 5);
                    linear.addView(simpleDraweeView);
                }
                if(commitArticle.getData().get(i).getBlock()!=null){
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.huitie);
                    linearLayout.setVisibility(View.VISIBLE);
                    TextView textView = new TextView(ArticleActivity.this);
                    textView.setText(commitArticle.getData().get(i).getBlock().toString());
                    linearLayout.addView(textView);
                }
            }
            holder.committime.setText(commitArticle.getData().get(i).getDateline());
            articlcemmit.addView(view);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    static class CommitViewHolder {
        @BindView(R.id.commit_count)
        TextView commitCount;
        @BindView(R.id.imageViewcommit)
        SimpleDraweeView imageViewcommit;
        @BindView(R.id.commit_name)
        TextView commitName;
        @BindView(R.id.committime)
        TextView committime;

        CommitViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
