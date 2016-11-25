package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseBuidingHome;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class BuidingHomeChildrenAdapter extends BaseAdapter {
    private List<ResponseBuidingHome.DataBean.ChildrenBean> childrenBeen;
    private LayoutInflater inflater;
    private Context context;

    public void setChildrenBeen(List<ResponseBuidingHome.DataBean.ChildrenBean> children) {
        this.childrenBeen.clear();
        this.childrenBeen.addAll(children);
        notifyDataSetChanged();
    }

    public BuidingHomeChildrenAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        childrenBeen = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return childrenBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return childrenBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.subview_buiding_home_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ResponseBuidingHome.DataBean.ChildrenBean childrenBean = (ResponseBuidingHome.DataBean.ChildrenBean) getItem(position);
        holder.chldren.setText(childrenBean.getTitle());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.chldren)
        TextView chldren;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
