package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_ZXXT_DownNews;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.ZXXT_Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/12/2.
 */
public class ZZXT_Receler_Down_ViewAdapter extends RecyclerView.Adapter {
    private static final int FOOTER = 1;
    private static final int BODY = 0;
    private Context context;
    private List<Response_ZXXT_DownNews.DataBean.ListBean> list;
    private LayoutInflater inflater;
    private ZXXT_Fragment fragment;
    private int state;
    private int starposition;


    public ZZXT_Receler_Down_ViewAdapter(Context context,ZXXT_Fragment fragment) {
        this.context = context;
        this.list = new ArrayList<>();
        inflater = LayoutInflater.from(context);
        this.fragment = fragment;
    }

    public void addDatas(List<Response_ZXXT_DownNews.DataBean.ListBean> list, int state, int starposition) {
        this.state = state;
        this.starposition = starposition;
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void clearDatas() {
        this.list.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return FOOTER;
        }
        return BODY;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BODY) {
            return new NewsHolder(inflater.inflate(R.layout.newsholder, parent, false));
        }
        return new FooterHolder(inflater.inflate(R.layout.footer, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (position == getItemCount() -1){
            FooterHolder footerHolder = (FooterHolder) holder;
            footerHolder.textfooter.setBackgroundResource(R.color.white);
            if (list.size() == 0){
                footerHolder.textfooter.setText("没有更多内容了");
            }else{
                footerHolder.textfooter.setText("加载更多");
                footerHolder.textfooter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("qqq", "点击了加载更多");
                        fragment.setDownNews(state,starposition,true);
                    }
                });
            }
            return;
        }
        NewsHolder newsHolder = (NewsHolder) holder;
        if (list.get(position) != null) {
            newsHolder.image.setImageURI(list.get(position).getImage());
            newsHolder.title.setText(list.get(position).getTitle());
            newsHolder.star.setText((int) (Math.random() * 100 + 30) + "");
        }else{
            newsHolder.ll.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    static class NewsHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.look)
        TextView look;
        @BindView(R.id.star)
        TextView star;
        @BindView(R.id.message)
        TextView message;
        @BindView(R.id.image)
        SimpleDraweeView image;
        @BindView(R.id.ll)
        LinearLayout ll;

        NewsHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    static class FooterHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.textfooter)
        TextView textfooter;

        FooterHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
