package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.ZXXT_Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/12/2.
 */
public class ZZXT_RecelerViewAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<String> list_tags;
    private LayoutInflater inflater;
    private ZXXT_Fragment zzxt_fragment;

    public ZZXT_RecelerViewAdapter(Context context) {
        this.context = context;
        this.list_tags = new ArrayList<>();
        inflater = LayoutInflater.from(context);
        zzxt_fragment = new ZXXT_Fragment();
    }

    public void addDatas(List<String> list_tags) {
        this.list_tags.addAll(list_tags);
        notifyDataSetChanged();
    }

    public void clearDatas() {
        this.list_tags.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HeadTag(inflater.inflate(R.layout.headtag, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        HeadTag headTag = (HeadTag) holder;
        if (position == 0){
            headTag.textView2.setText("全部");
        }else if (position != 0 && list_tags.size()!=0){
            headTag.textView2.setText(list_tags.get(position-1));
        }
        headTag.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zzxt_fragment.setDownNews(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1+list_tags.size();
    }

    static class HeadTag extends RecyclerView.ViewHolder{
        @BindView(R.id.textView2)
        TextView textView2;

        HeadTag(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}