package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTongcheng;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */

public class Tongcheng_Adapter extends BaseRecycleView<ResponseTongcheng.DataBean.ForumlistBean> {




    public Tongcheng_Adapter(Context context) {
        super(context);
    }

    @Override
    protected int getFooterCount() {
        return 0;
    }

    @Override
    protected int getHeaderCount() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.samecity_fraglayout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        ResponseTongcheng.DataBean.ForumlistBean bean = getItem(position);
        itemViewHolder.tongchengRecyclerviewCover.setImageURI(bean.getAttachments());
                Log.d("Tongcheng_Adapter", bean.getAttachments());
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tongcheng_recyclerview_cover)
        SimpleDraweeView tongchengRecyclerviewCover;
        @BindView(R.id.tongcheng_img_hot)
        ImageView tongchengImgHot;
        @BindView(R.id.tongcheng_text_hot)
        TextView tongchengTextHot;
        @BindView(R.id.tongchenghuodong_fragment)
        FrameLayout tongchenghuodongFragment;
        @BindView(R.id.tongcheng_end_img_data)
        ImageView tongchengEndImgData;
        @BindView(R.id.tongcheng_end_text_data)
        TextView tongchengEndTextData;
        @BindView(R.id.samecity_fragment)
        LinearLayout samecityFragment;
        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
