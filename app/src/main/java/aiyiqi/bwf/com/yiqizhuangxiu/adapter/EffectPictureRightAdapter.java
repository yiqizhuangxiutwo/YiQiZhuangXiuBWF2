package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectPictureRight;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class EffectPictureRightAdapter extends BaseMainListRecycleViewAdapter<ResponseEffectPictureRight.DataBean.ListBean> {

    private static final int TYPT_CONTENT = 0;
    private static final int TYPE_FOOTER = 1;

    public EffectPictureRightAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1)
            return getFooterCount();
        return getHeaderCount();
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
        if (viewType == TYPT_CONTENT)
            return new PictureViewHolder(inflaterView(R.layout.effect_picture_child, parent));
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

        PictureViewHolder mholder = (PictureViewHolder) holder;
        ResponseEffectPictureRight.DataBean.ListBean listBean = getItem(position);
        mholder.effectPictureRight.setImageURI(listBean.getUrl());
        mholder.mainArticleItemScan.setText(listBean.getCollected() + "");
        mholder.mainArticleItemLike.setText(listBean.getLike_num() + "");
    }

    static class PictureViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.effect_picture_right)
        SimpleDraweeView effectPictureRight;
        @BindView(R.id.main_article_item_scan)
        TextView mainArticleItemScan;
        @BindView(R.id.main_article_item_like)
        TextView mainArticleItemLike;

        public PictureViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
