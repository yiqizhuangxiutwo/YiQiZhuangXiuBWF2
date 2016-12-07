package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/12/1.
 */
public class GDZB_inner_Grid extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    public List<String> images;

    public GDZB_inner_Grid(Context context) {
        this.context = context;
        images = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        Log.d("GDZB_inner_Grid", "222222images:" + images.size());
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.grid_image, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.simple.setImageURI(images.get(position));
        return convertView;
    }

    public void addDatas(List<String> images) {
        this.images.clear();
        this.images.addAll(images);
        notifyDataSetChanged();
    }


    static class ViewHolder {
        @BindView(R.id.simple)
        SimpleDraweeView simple;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
