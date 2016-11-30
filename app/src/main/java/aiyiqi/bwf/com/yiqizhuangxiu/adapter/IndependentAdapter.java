package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_IndependentOrder;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/25.
 */
public class IndependentAdapter extends BaseAdapter {
    private List<Response_IndependentOrder.DataBeanX.DataBean> dataBeen;
    private LayoutInflater inflater;

    public IndependentAdapter(Context context, List<Response_IndependentOrder.DataBeanX.DataBean> dataBeen) {
        this.dataBeen = dataBeen;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.independent_order_viewpager_item_image, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.independentOrderViewpagerItemImage.setImageURI(dataBeen.get(position).getLogo());
        holder.independentOrderViewpagerItemText.setText(dataBeen.get(position).getBusiness_name());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.independent_order_viewpager_item_image)
        SimpleDraweeView independentOrderViewpagerItemImage;
        @BindView(R.id.independent_order_viewpager_item_text)
        TextView independentOrderViewpagerItemText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
