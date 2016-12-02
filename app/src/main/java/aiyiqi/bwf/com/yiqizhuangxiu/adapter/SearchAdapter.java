package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseSearch;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class SearchAdapter extends BaseMainListRecycleViewAdapter<ResponseSearch.DataBean> {

    private static final int TYPE_CONTENT = 0;
    private static final int TYPE_FOOTER = 1;
    public SearchAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("testb", "getItemCount():" + getItemCount());

        if (position == getItemCount() - 1) {
            return TYPE_FOOTER;
        }
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
        if (viewType == TYPE_FOOTER) {
            return new FooterViewHoder(inflaterView(R.layout.subview_footer_loader, parent));
        }

        return new SearchItemViewHolder(inflaterView(R.layout.search_recycle_content, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(position < getHeaderCount())
            return;
        if(position >= getItemCount() - getFooterCount()){
            onBindFooterViewHolder(holder, position);
            return;
        }

        final SearchItemViewHolder mholder = (SearchItemViewHolder) holder;
        ResponseSearch.DataBean dataBean = getItem(position);
        Log.d("test", dataBean.getAuthor());
        mholder.searchRecycleItemImageHeader.setImageURI(dataBean.getAvtUrl());
        mholder.searchRecycleUserName.setText(dataBean.getAuthor());
        mholder.searchRecycleTitle.setText(dataBean.getSubject());
        if (dataBean.getAttachments() == null) {
            mholder.searchRecycleImageContent.setVisibility(View.GONE);
        } else {
            mholder.searchRecycleImageContent.setImageURI(dataBean.getAttachments().get(0));
        }
//        mholder.searchRecycleBeizhu.setText(dataBean.  );
        mholder.searchTime.setText(dataBean.getDateline());
        mholder.searchRecycleItemZan.setText(dataBean.getZan() + "");
        mholder.searchRecycleItemComment.setText(dataBean.getAttachment() + "");
        mholder.searchRecycleItemShare.setText(dataBean.getSharetimes() + "");
    }

    static class HeadViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.search_recycle_children)
        SimpleDraweeView searchRecycleChildren;
        @BindView(R.id.search_recycle_children_textview)
        TextView searchRecycleChildrenTextview;

        HeadViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class SearchItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.search_recycle_item_image_header)
        SimpleDraweeView searchRecycleItemImageHeader;
        @BindView(R.id.search_recycle_user_name)
        TextView searchRecycleUserName;
        @BindView(R.id.search_recycle_title)
        TextView searchRecycleTitle;
        @BindView(R.id.search_recycle_image_content)
        SimpleDraweeView searchRecycleImageContent;
        @BindView(R.id.search_recycle_beizhu)
        TextView searchRecycleBeizhu;
        @BindView(R.id.search_recycle_item_zan)
        TextView searchRecycleItemZan;
        @BindView(R.id.search_recycle_tag_01)
        LinearLayout searchRecycleTag01;
        @BindView(R.id.search_recycle_item_comment)
        TextView searchRecycleItemComment;
        @BindView(R.id.search_recycle_tag_02)
        LinearLayout searchRecycleTag02;
        @BindView(R.id.search_recycle_item_share)
        TextView searchRecycleItemShare;
        @BindView(R.id.search_recycle_tag_03)
        LinearLayout searchRecycleTag03;
        @BindView(R.id.search_recycle_item)
        LinearLayout searchRecycleItem;
        @BindView(R.id.search_time)
        TextView searchTime;


        public SearchItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    static class FooterHolder2 extends RecyclerView.ViewHolder{
        @BindView(R.id.subview_bottom_footer2)
        LinearLayout subviewBottomFooter2;


        public FooterHolder2(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
