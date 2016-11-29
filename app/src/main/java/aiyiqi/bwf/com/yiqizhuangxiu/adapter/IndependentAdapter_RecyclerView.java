package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_IndependentOrder;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2016-11-27.
 */
public class IndependentAdapter_RecyclerView extends RecyclerView.Adapter {
    private List<Response_IndependentOrder.DataBeanX.DataBean> dataBeen;
    private LayoutInflater inflater;

    public IndependentAdapter_RecyclerView(Context context, List<Response_IndependentOrder.DataBeanX.DataBean> dataBeen) {
        this.dataBeen = dataBeen;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.independent_order_viewpager_item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewholder = null;
        if (viewholder == null) {
            viewholder = (ViewHolder) holder;
        }
        viewholder.independentOrderViewpagerItemImage.setImageURI(dataBeen.get(position).getLogo());
        viewholder.independentOrderViewpagerItemText.setText(dataBeen.get(position).getBusiness_name());
        return;
    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.independent_order_viewpager_item_image)
        SimpleDraweeView independentOrderViewpagerItemImage;
        @BindView(R.id.independent_order_viewpager_item_text)
        TextView independentOrderViewpagerItemText;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
