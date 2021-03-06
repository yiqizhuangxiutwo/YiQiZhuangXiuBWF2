package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class PopuAdapter extends BaseAdapter {

    private List<String> str;
    private Context context;
    private LayoutInflater inflater;

    public PopuAdapter(Context context, List<String> str) {
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
    private ViewHolder holder = null;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.popu_children, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.popuChildren.setText(str.get(position));
        holder.popuChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.popuChildren.getText().toString(), Toast.LENGTH_SHORT).show();
                holder.popuChildren.setTextColor(Color.WHITE);
                holder.popuChildren.setBackgroundColor(Color.GREEN);
            }
        });
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.popu_children)
        TextView popuChildren;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
