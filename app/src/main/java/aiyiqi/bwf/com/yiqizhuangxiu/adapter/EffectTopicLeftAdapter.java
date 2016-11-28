package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.ArticleDetailsActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectTopicLeft;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class EffectTopicLeftAdapter extends BaseMainListRecycleViewAdapter<ResponseEffectTopicLeft.DataBean.ListBean> {

    private static final int TYPE_CONTENT = 0;
    private static final int TYPE_FOOTER = 1;
    private Context context;

    public EffectTopicLeftAdapter(Context context) {
        super(context);
        this.context = context;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1)
            return TYPE_FOOTER;
        return TYPE_CONTENT;
    }

    @Override
    protected int getFooterCount() {
        return 1;
    }

    @Override
    protected int getHeaderCount() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT)
            return new TopicViewHolder(inflaterView(R.layout.effect_picture_topic, parent));
        return new FooterViewHoder(inflaterView(R.layout.subview_footer_loader, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position < getHeaderCount())
            return;
        if(position >= getItemCount() - getFooterCount()){
            onBindFooterViewHolder(holder, position);
            return;
        }

        TopicViewHolder mholder = (TopicViewHolder) holder;
        final ResponseEffectTopicLeft.DataBean.ListBean listBean = getItem(position);
        mholder.effectTopicImage.setImageURI(listBean.getUrl());
        mholder.topicTitel.setText(listBean.getTitle());
        mholder.mainArticleItemScan.setText(listBean.getCollected() + "");
        mholder.mainArticleItemLike.setText(listBean.getLike_num() + "");
        mholder.topicTextContent.setText(listBean.getDesc());

        mholder.effectFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ArticleDetailsActivity.class);
                intent.putExtra("articleId", listBean.getId());
                context.startActivity(intent);
            }
        });
    }

    static class TopicViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.effect_framelayout)
        FrameLayout effectFrameLayout;
        @BindView(R.id.effect_topic_image)
        SimpleDraweeView effectTopicImage;
        @BindView(R.id.topic_titel)
        TextView topicTitel;
        @BindView(R.id.main_article_item_scan)
        TextView mainArticleItemScan;
        @BindView(R.id.main_article_item_like)
        TextView mainArticleItemLike;
        @BindView(R.id.topic_text_content)
        TextView topicTextContent;

        public TopicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
