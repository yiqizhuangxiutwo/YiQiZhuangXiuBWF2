package aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.speakactivity.ArticleActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MyRecyclecviewAdapter extends BaseMainRecycleViewAdapter<Response_Essence.DataBean> {

    private static final int TYPE_CONTENT = 0;
    private static final int TYPE_FOOTER = 1;

    private Context context;
    public MyRecyclecviewAdapter(Context context) {
        super(context);
        this.context =context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1)
            return TYPE_FOOTER;
        return TYPE_CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT)
            return new MyViewHolder(inflaterView(R.layout.main_essence, parent));
        return new FooterHolder(inflaterView(R.layout.subview_footer_loader, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if(position < getHeaderItemCount())
            return;
        if(position >= getItemCount() - getFooterItemCount()){
            bindFooterViewHolder(holder, position);
            return;
        }


        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final Response_Essence.DataBean dataBean = getItem(position);
        myViewHolder.imageViewAuthor.setImageURI(dataBean.getAvtUrl());
        myViewHolder.authorname.setText(dataBean.getAuthor());
        myViewHolder.textViewFrontMainTitle.setText(dataBean.getSubject());
        myViewHolder.commentcount.setText(dataBean.getReplies()+"");
        if(dataBean.getAttachments()!=null){
            myViewHolder.imageViewFrontTopImage.setImageURI(dataBean.getAttachments().get(0));
        }else{
            myViewHolder.imageViewFrontTopImage.setVisibility(View.GONE);
        }
        myViewHolder.textViewFrontSubtitle.setText("精选自"+dataBean.getFname());
        myViewHolder.timeArtticle.setText(dataBean.getDateline());
        if(dataBean.getTags()!=null){
            for (int i = 0; i <dataBean.getTags().size(); i++) {
                myViewHolder.explaintext.setText(dataBean.getTags().get(i).getTagname());
            }
        }
        myViewHolder.linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ArticleActivity.class);
                intent.putExtra("articleId",dataBean.getTid());
                intent.putExtra("zan",dataBean.getZan());
                context.startActivity(intent);
            }
        });
    }

    @Override
    protected int getHeaderItemCount() {
        return 0;
    }

    @Override
    protected int getFooterItemCount() {
        return 1;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageView_author)
        SimpleDraweeView imageViewAuthor;
        @BindView(R.id.textView_front_main_title)
        TextView textViewFrontMainTitle;
        @BindView(R.id.imageView_front_top_image)
        SimpleDraweeView imageViewFrontTopImage;
        @BindView(R.id.textView_front_subtitle)
        TextView textViewFrontSubtitle;
        @BindView(R.id.time_artticle)
        TextView timeArtticle;
        @BindView(R.id.liked_count)
        ImageView likedCount;
        @BindView(R.id.article_comment)
        ImageView articleComment;
        @BindView(R.id.artcle_share)
        ImageView artcleShare;
        @BindView(R.id.comment_count)
        TextView commentcount;
        @BindView(R.id.author_name)
        TextView authorname;
        @BindView(R.id.subject_name)
        TextView subjectname;
        @BindView(R.id.explain_text)
        TextView explaintext;
        @BindView(R.id.linear1)
        LinearLayout linear1;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
