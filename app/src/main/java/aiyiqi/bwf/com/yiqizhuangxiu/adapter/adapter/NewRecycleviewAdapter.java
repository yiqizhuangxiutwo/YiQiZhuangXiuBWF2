package aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_New;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */

public class NewRecycleviewAdapter extends BaseMainRecycleViewAdapter<Response_New.DataBean> {

    private static final int TYPE_CONTENT = 0;
    private static final int TYPE_FOOTER = 1;

    private Context context;

    public NewRecycleviewAdapter(Context context) {
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT)
            return new NewViewHolder(inflaterView(R.layout.fragment2_new, parent));
        return new FooterHolder(inflaterView(R.layout.subview_footer_loader, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (position < getHeaderItemCount())
            return;
        if (position >= getItemCount() - getFooterItemCount()) {
            bindFooterViewHolder(holder, position);
            return;
        }

        NewViewHolder newViewHolder = (NewViewHolder) holder;
        Response_New.DataBean dataBean = getItem(position);
        newViewHolder.imageViewAuthor.setImageURI(dataBean.getAvtUrl());
        newViewHolder.authorName.setText(dataBean.getSubject());
        newViewHolder.subjectName.setText(dataBean.getAuthor());
        newViewHolder.lookedtext.setText(dataBean.getViews() + "");
        newViewHolder.times.setText(dataBean.getDateline());
    }

    @Override
    protected int getHeaderItemCount() {
        return 0;
    }

    @Override
    protected int getFooterItemCount() {
        return 1;
    }

    public static class NewViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.author_name)
        TextView authorName;
        @BindView(R.id.subject_name)
        TextView subjectName;
        @BindView(R.id.lookedtext)
        TextView lookedtext;
        @BindView(R.id.imageView_author)
        SimpleDraweeView imageViewAuthor;
        @BindView(R.id.times)
        TextView times;
        @BindView(R.id.image_framgent)
        ImageView imageFramgent;

        public NewViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
