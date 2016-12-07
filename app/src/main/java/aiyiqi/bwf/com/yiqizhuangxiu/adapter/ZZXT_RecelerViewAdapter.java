package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.graphics.Color;
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
    private int state;
    private boolean isfirst = true;

    public ZZXT_RecelerViewAdapter(Context context, int state) {
        this.context = context;
        this.state = state;
        this.list_tags = new ArrayList<>();
        inflater = LayoutInflater.from(context);
        zzxt_fragment = new ZXXT_Fragment();
    }

    public void addDatas(List<String> list_tags) {
        this.list_tags.clear();
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

    private HeadTag currentHeadTag;
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final HeadTag headTag = (HeadTag) holder;
        if (position == 0){
            headTag.textView2.setText("全部");
        }else if (position != 0 && list_tags.size()!=0){
            headTag.textView2.setText(list_tags.get(position-1));
        }
        if (isfirst == true){
            zzxt_fragment.setDownNews(state,0,false);
            isfirst = false;
        }
        headTag.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentHeadTag!=null && currentHeadTag!=headTag){
                    currentHeadTag.textView2.setBackgroundResource(R.color.white);
                    currentHeadTag.textView2.setTextColor(Color.rgb(156,156,156));
                }
                headTag.textView2.setBackgroundResource(R.color.green);
                headTag.textView2.setTextColor(Color.WHITE);
                zzxt_fragment.setDownNews(state,position,false);
                currentHeadTag = headTag;
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
