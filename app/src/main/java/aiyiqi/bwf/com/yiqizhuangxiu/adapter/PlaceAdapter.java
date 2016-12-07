package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class PlaceAdapter extends BaseAdapter {

    private List<String> str;
    private Context context;
    private LayoutInflater inflater;

    public PlaceAdapter(Context context, List<String> str) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.str = str;
    }

    @Override
    public int getCount() {
        return str.size();
    }

    @Override
    public Object getItem(int position) {
        return str.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.main_title_place_children, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.placeTitle.setText(str.get(position));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.place_title)
        TextView placeTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
