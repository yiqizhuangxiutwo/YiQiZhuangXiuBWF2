package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.ArticleRelatedAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseArticleComments;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseArticleDetails;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.ArticleCommentsPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.ArticleDetailsPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl.ArticleCommentsPresenterImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl.ArticleDetailsPresenterImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.ArticleCommentsView;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.ArticleDetailsView;
import aiyiqi.bwf.com.yiqizhuangxiu.widget.FlowLayout;
import aiyiqi.bwf.com.yiqizhuangxiu.widget.MyListView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class ArticleDetailsActivity extends BaseActivity implements ArticleDetailsView, ArticleCommentsView {


    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    @BindView(R.id.article_title)
    TextView articleTitle;
    @BindView(R.id.article_details_text_image)
    LinearLayout articleDetailsTextImage;
    @BindView(R.id.articel_details_related)
    MyListView articelDetailsRelated;
    @BindView(R.id.scrollview_tag)
    ScrollView scrollviewTag;
    @BindView(R.id.articel_details_comments)
    LinearLayout articelDetailsComments;
    @BindView(R.id.comment_footer)
    LinearLayout commentFooter;
    @BindView(R.id.flowLayout)
    FlowLayout flowLayout;
    @BindView(R.id.image_button_tag02)
    ImageButton imageButtonTag02;
    @BindView(R.id.image_button_tag03)
    ImageButton imageButtonTag03;


    private String articleId;
    private ArticleDetailsPresenter presenter;
    private ArticleCommentsPresenter commentsPresenter;

    @Override
    public int getContentViewResID() {
        return R.layout.article_details;
    }

    @Override
    protected void initViews() {

        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                //重新加载数据
                presenter.loadDatas(articleId);
            }
        });
    }

    @Override
    protected void initDatas() {
        articleId = getIntent().getStringExtra("articleId");
        presenter = new ArticleDetailsPresenterImpl(this);
        presenter.loadDatas(articleId);

        commentsPresenter = new ArticleCommentsPresenterImpl(this);
        commentsPresenter.loadDatas(articleId);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void showArticel(ResponseArticleDetails.DataBean.CurrentNewsBean currentNewsBeen) {
        scrollviewTag.scrollTo(0, 0);
        refreshLayout.finishRefresh();
        articleTitle.setText(currentNewsBeen.getTitle());
        LayoutInflater inflater = LayoutInflater.from(this);
        articleDetailsTextImage.setVisibility(View.VISIBLE);
        for (int i = 0; i < currentNewsBeen.getContent().size(); i++) {
            Log.d("ArticleDetailsActivity", "currentNewsBeen.getContent().size():" + currentNewsBeen.getContent().size());
            View view = null;
            if (currentNewsBeen.getContent().get(i).startsWith("http")) {
                view = inflater.inflate(R.layout.article_image, articleDetailsTextImage, false);
                ImageViewHolder imageHolder = new ImageViewHolder(view);
                imageHolder.articleChildrenImage.setImageURI(currentNewsBeen.getContent().get(i));
            } else {
                view = inflater.inflate(R.layout.article_textview, articleDetailsTextImage, false);
                TextViewHolder textHolder = new TextViewHolder(view);
                textHolder.articleChildrenText.setText(currentNewsBeen.getContent().get(i));
            }
            articleDetailsTextImage.addView(view);
        }
    }

    @Override
    public void showRelated(List<ResponseArticleDetails.DataBean.RelatedNewsBean> relatedNewsBeen) {
//        refreshLayout.finishRefresh();
        ArticleRelatedAdapter adapter = new ArticleRelatedAdapter(this, relatedNewsBeen);
        articelDetailsRelated.setAdapter(adapter);
    }
    private boolean isLoad ;
    public boolean flowlayoutBoolen(){
        return isLoad = true;
    }
    @Override
    public void showTags(String dateBean) {
        refreshLayout.finishRefresh();
        TextView tv = null;
        String[] ss = StringGetString(dateBean);
        FlowLayout flowLayout = (FlowLayout) findViewById(R.id.flowLayout);
       if(!isLoad) {
           for (int i = 0; i < ss.length; i++) {
               tv = (TextView) LayoutInflater.from(this).inflate(R.layout.flowlayout_children, flowLayout, false);
               tv.setText(ss[i]);
               flowLayout.addView(tv);
           }
           flowlayoutBoolen();
       }
    }

    @Override
    public void showArticelComments(List<ResponseArticleComments.DataBean1.DataBean> dataBeens) {
        LayoutInflater inflater = LayoutInflater.from(this);
        articelDetailsComments.setVisibility(View.VISIBLE);
        articelDetailsComments.removeAllViews();
        for (ResponseArticleComments.DataBean1.DataBean dataBean : dataBeens) {
            View view = inflater.inflate(R.layout.article_comments, articelDetailsComments, false);
            CommentsViewHolder holder = new CommentsViewHolder(view);
            holder.imageviewAuthorAvaterComments.setImageURI(dataBean.getUserheadimage());
            holder.commentAuthor.setText(dataBean.getComment_user_name());
            holder.commentContent.setText(dataBean.getComment_content());
//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = format.format(new Date(dataBeen.get(position).getComment_time()));
            holder.commentTime.setText(dataBean.getComment_time());
            articelDetailsComments.addView(view);
        }
        footer();
    }

    @Override
    public void showNoMoreDatas() {
        footer();
    }

    @Override
    public void showError() {

    }

    static class ImageViewHolder {
        @BindView(R.id.article_children_image)
        SimpleDraweeView articleChildrenImage;

        ImageViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class TextViewHolder {
        @BindView(R.id.article_children_text)
        TextView articleChildrenText;

        TextViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class CommentsViewHolder {
        @BindView(R.id.imageview_author_avater_comments)
        SimpleDraweeView imageviewAuthorAvaterComments;
        @BindView(R.id.comment_author)
        TextView commentAuthor;
        @BindView(R.id.comment_time)
        TextView commentTime;
        @BindView(R.id.comment_content)
        TextView commentContent;

        CommentsViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public void footer() {
        LayoutInflater inflater = LayoutInflater.from(this);
        commentFooter.setVisibility(View.VISIBLE);
        View view = inflater.inflate(R.layout.comments_nomore_data, commentFooter, false);
        commentFooter.addView(view);
    }


    public String[] StringGetString(String response){
        String str = response.substring(response.indexOf("\"tags\":{"), response.indexOf(",\"relatedNews\":"));
        String s1 = str.replace("\"tags\":{", "{\"tags\":{");
        String s2 = s1.replace("\"}}", "\"}}}");
        Log.i("www", "s2:"+s2);

        Map<String, String> map = new HashMap<>();
        JSONObject jsonObject = JSON.parseObject(s2);
        Set<String> keys = jsonObject.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            map.put(key, jsonObject.getString(key));
        }
        Log.d("www", "map:" + map);
        String ss = map.toString();

        String des = ",\"create_time\"";
        int cunt = 0;
        int offset = 0;
        while ((offset = ss.indexOf(des,offset))!= -1){
            offset = offset + des.length();
            cunt ++;
        }
        Log.d("www", "cunt:" + cunt);
        List<String> ll = new ArrayList<>();
        for (int i = 0; i < cunt; i++) {
            int aa = ss.indexOf("ate_time\"");
            String s3 = ss.substring(ss.indexOf("\"name\":"), ss.indexOf(",\"create_time\""));
            String s4 = ss.substring(aa+1+i);
            ss = s4;
            ll.add(s3);
            Log.d("www", "ss:" + ss.toString());
            Log.d("www", "s3:"+s3);
        }
        Log.d("www", "ll:"+ll.toString());
        List<String> sll = new ArrayList<>();
        for (int i = 0; i < ll.size(); i++) {
            String[] sl1 = ll.get(i).split("\"");
            sll.add(sl1[3]);
        }
        Log.d("www", "sll:"+sll.toString());
        String[] data = new String[sll.size()];
        for (int i = 0; i < sll.size(); i++) {
            data[i] = sll.get(i);
        }
        for (int i = 0; i < data.length; i++) {
            Log.d("www", "data:"+data[i]);
        }
        return data;
    }
}
