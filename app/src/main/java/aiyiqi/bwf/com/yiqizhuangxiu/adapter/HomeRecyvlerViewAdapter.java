package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseRecycleViewList;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/24.
 */
public class HomeRecyvlerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ResponseRecycleViewList.DataBean> dataBeens;
    private LayoutInflater inflater;
    private int state;

    //item类型
    private static final int ITEM_TYPE_CONTENT_WENGZHANG = 1;
    private static final int ITEM_TYPE_CONTENT_TIEZI = 3;
    private static final int ITEM_TYPE_FOOTER = 0;

    //文章详情的类型
    private static final int TIEZI = 3;
    private static final int WENZHANG = 1;

    //脚的类型
    public static final int STATE_GONE = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_NO_MORE_DATA = 2;
    public static final int STATE_LOAD_FAILED = 3;

    public HomeRecyvlerViewAdapter(Context context, List<ResponseRecycleViewList.DataBean> dataBeens) {
        this.dataBeens = dataBeens;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return ITEM_TYPE_FOOTER;
        } else {
            if (dataBeens.get(position).getType() == WENZHANG) {
                return ITEM_TYPE_CONTENT_WENGZHANG;
            } else if (dataBeens.get(position).getType() == TIEZI) {
                return ITEM_TYPE_CONTENT_TIEZI;
            }
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //如果为身体
        if (viewType == ITEM_TYPE_CONTENT_WENGZHANG) {
            return new MyWenZhangHolder(inflater.inflate(R.layout.subview_main_article,parent,false));
        } else if (viewType == ITEM_TYPE_CONTENT_TIEZI) {
            return new MyTeiZiHolder(inflater.inflate(R.layout.subview_main_tie,parent,false));
        }
        //如果为脚
        return new FooterHolder(inflater.inflate(R.layout.subview_footer_loader,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ITEM_TYPE_CONTENT_WENGZHANG) {
            MyWenZhangHolder wenZhangHolder = (MyWenZhangHolder) holder;
            wenZhangHolder.mainArticleTitle.setText(dataBeens.get(position).getTitle());
            wenZhangHolder.mainArticleImage.setImageURI(dataBeens.get(position).getPath());
            wenZhangHolder.artcleItemTime.setText(dataBeens.get(position).getDateline());
            wenZhangHolder.mainArticleItemScan.setText(dataBeens.get(position).getViews());
            wenZhangHolder.mainArticleItemComments.setText(dataBeens.get(position).getReplies());
        } else if (getItemViewType(position) == ITEM_TYPE_CONTENT_TIEZI) {
            MyTeiZiHolder myTeiZiHolder = (MyTeiZiHolder) holder;
            myTeiZiHolder.auther.setText(dataBeens.get(position).getAuthor());
            myTeiZiHolder.autherTime.setText(dataBeens.get(position).getDateline());
            myTeiZiHolder.mainRecycleviewTieTouxiang.setImageURI(dataBeens.get(position).getAvtUrl());
            myTeiZiHolder.mainTieTitle.setText(dataBeens.get(position).getTitle());
            myTeiZiHolder.mainTieImage.setImageURI(dataBeens.get(position).getPath());
            myTeiZiHolder.tieItemTime.setText("精简至"+dataBeens.get(position).getForum().getName());
        } else if (getItemViewType(position) == ITEM_TYPE_FOOTER) {
            bindFooterViewHolder(holder, position);
        }
        return;
    }

    @Override
    public int getItemCount() {
        return dataBeens.size();
    }


    /**
     * 文章ID
     */
    class MyWenZhangHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.main_article_title)
        TextView mainArticleTitle;
        @BindView(R.id.main_article_image)
        SimpleDraweeView mainArticleImage;
        @BindView(R.id.artcle_item_time)
        TextView artcleItemTime;
        @BindView(R.id.main_article_item_scan)
        TextView mainArticleItemScan;
        @BindView(R.id.main_article_item_comments)
        TextView mainArticleItemComments;
        @BindView(R.id.main_recycleview_item)
        LinearLayout mainRecycleviewItem;

        MyWenZhangHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    /**
     * 帖子的ID
     */
    class MyTeiZiHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.main_recycleview_tie_touxiang)
        SimpleDraweeView mainRecycleviewTieTouxiang;
        @BindView(R.id.auther)
        TextView auther;
        @BindView(R.id.auther_time)
        TextView autherTime;
        @BindView(R.id.fouces_button)
        LinearLayout foucesButton;
        @BindView(R.id.main_tie_image)
        SimpleDraweeView mainTieImage;
        @BindView(R.id.tie_item_time)
        TextView tieItemTime;
        @BindView(R.id.main_tie_item_scan)
        TextView mainTieItemScan;
        @BindView(R.id.main_tie_item_comments)
        TextView mainTieItemComments;
        @BindView(R.id.main_recycleview_item)
        LinearLayout mainRecycleviewItem;
        @BindView(R.id.main_tie_title)
        TextView mainTieTitle;

        MyTeiZiHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 脚的ID
     */
    class FooterHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.progressbar_subview_recycleview_loadfooter)
        ProgressBar progressbarSubviewRecycleviewLoadfooter;
        @BindView(R.id.textview_subview_recycleview_loadfooter)
        TextView textviewSubviewRecycleviewLoadfooter;
        @BindView(R.id.layout_subview_recycleview_loadfooter)
        RelativeLayout layoutSubviewRecycleviewLoadfooter;
        FooterHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    protected void bindFooterViewHolder(RecyclerView.ViewHolder holder, int position) {
        FooterHolder mHolder = (FooterHolder) holder;
        switch (state) {
            case STATE_GONE:
                return;
            case STATE_LOADING:
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                break;
            case STATE_NO_MORE_DATA:
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setText("没有更多数据了");
                mHolder.textviewSubviewRecycleviewLoadfooter.setEnabled(false);
                break;
            case STATE_LOAD_FAILED:
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setText("加载失败");
                mHolder.textviewSubviewRecycleviewLoadfooter.setEnabled(true);
                break;
        }
        mHolder.layoutSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
    }

    public void updateFooterState(int state) {
        this.state = state;
        notifyItemChanged(getItemCount() - 1);
        Log.d("BaseMainRecycleViewAdap", "Adapter更新第" + (getItemCount() - 1) + "个View");
    }
}






//    private List<ResponseRecycleViewList.DataBean> dataBeens;
//    private LayoutInflater inflater;
//    //item类型
//    private static final int ITEM_TYPE_CONTENT_WENGZHANG = 1;
//    private static final int ITEM_TYPE_CONTENT_TIEZI = 3;
//    private static final int ITEM_TYPE_FOOTER = 0;
//
//    //文章详情的类型
//    private static final int TIEZI = 3;
//    private static final int WENZHANG = 1;
//
//    public HomeRecyvlerViewAdapter(Context context,List<ResponseRecycleViewList.DataBean> dataBeens) {
//        super(context);
//        inflater = LayoutInflater.from(context);
//        this.dataBeens = dataBeens;
//    }
//
//    @Override
//    protected int getHeaderItemCount() {
//        return 0;
//    }
//
//    @Override
//    protected int getFooterItemCount() {
//        return 1;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        if (position == getItemCount() - 1) {
//            return ITEM_TYPE_FOOTER;
//        } else {
//            if (dataBeens.get(position).getType() == WENZHANG) {
//                return ITEM_TYPE_CONTENT_WENGZHANG;
//            } else if (dataBeens.get(position).getType() == TIEZI) {
//                return ITEM_TYPE_CONTENT_TIEZI;
//            }
//        }
//        return -1;
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        //如果为身体
//        if (viewType == ITEM_TYPE_CONTENT_WENGZHANG) {
//            return new MyWenZhangHolder(inflaterView(R.layout.subview_main_article, parent));
//        } else if (viewType == ITEM_TYPE_CONTENT_TIEZI) {
//            return new MyTeiZiHolder(inflaterView(R.layout.subview_main_tie, parent));
//        }
//        //如果为脚
//        return createFooterHolder(parent);
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (getItemViewType(position) == ITEM_TYPE_CONTENT_WENGZHANG) {
//            MyWenZhangHolder wenZhangHolder = (MyWenZhangHolder) holder;
//            wenZhangHolder.mainArticleTitle.setText(dataBeens.get(position).getTitle());
//            wenZhangHolder.mainArticleImage.setImageURI(dataBeens.get(position).getPath());
//            wenZhangHolder.artcleItemTime.setText(dataBeens.get(position).getDateline());
//            wenZhangHolder.mainArticleItemScan.setText(dataBeens.get(position).getViews());
//            wenZhangHolder.mainArticleItemComments.setText(dataBeens.get(position).getReplies());
//        } else if (getItemViewType(position) == ITEM_TYPE_CONTENT_TIEZI) {
//            MyTeiZiHolder myTeiZiHolder = (MyTeiZiHolder) holder;
//            myTeiZiHolder.auther.setText(dataBeens.get(position).getAuthor());
//            myTeiZiHolder.autherTime.setText(dataBeens.get(position).getDateline());
//            myTeiZiHolder.mainRecycleviewTieTouxiang.setImageURI(dataBeens.get(position).getAvtUrl());
//            myTeiZiHolder.mainTieTitle.setText(dataBeens.get(position).getTitle());
//            myTeiZiHolder.mainTieImage.setImageURI(dataBeens.get(position).getPath());
//            myTeiZiHolder.tieItemTime.setText("精简至"+dataBeens.get(position).getForum().getName());
//        } else if (getItemViewType(position) == ITEM_TYPE_FOOTER) {
//            bindFooterViewHolder(holder, position);
//        }
//        return;
//    }
//
//
//    /**
//     * 文章ID
//     */
//    class MyWenZhangHolder extends BaseViewHolder {
//        @BindView(R.id.main_article_title)
//        TextView mainArticleTitle;
//        @BindView(R.id.main_article_image)
//        SimpleDraweeView mainArticleImage;
//        @BindView(R.id.artcle_item_time)
//        TextView artcleItemTime;
//        @BindView(R.id.main_article_item_scan)
//        TextView mainArticleItemScan;
//        @BindView(R.id.main_article_item_comments)
//        TextView mainArticleItemComments;
//        @BindView(R.id.main_recycleview_item)
//        LinearLayout mainRecycleviewItem;
//
//        MyWenZhangHolder(View view) {
//            super(view);
//            ButterKnife.bind(this, view);
//        }
//    }
//
//
//    /**
//     * 帖子的ID
//     */
//    class MyTeiZiHolder extends BaseViewHolder {
//        @BindView(R.id.main_recycleview_tie_touxiang)
//        SimpleDraweeView mainRecycleviewTieTouxiang;
//        @BindView(R.id.auther)
//        TextView auther;
//        @BindView(R.id.auther_time)
//        TextView autherTime;
//        @BindView(R.id.fouces_button)
//        LinearLayout foucesButton;
//        @BindView(R.id.main_tie_image)
//        SimpleDraweeView mainTieImage;
//        @BindView(R.id.tie_item_time)
//        TextView tieItemTime;
//        @BindView(R.id.main_tie_item_scan)
//        TextView mainTieItemScan;
//        @BindView(R.id.main_tie_item_comments)
//        TextView mainTieItemComments;
//        @BindView(R.id.main_recycleview_item)
//        LinearLayout mainRecycleviewItem;
//        @BindView(R.id.main_tie_title)
//        TextView mainTieTitle;
//
//        MyTeiZiHolder(View view) {
//            super(view);
//            ButterKnife.bind(this, view);
//        }
//    }

