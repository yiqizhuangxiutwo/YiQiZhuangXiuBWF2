package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/12/2.
 */
public class ZZXT_Receler_Down_ViewAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Response_ZXXT_DownNews.DataBean.ListBean> list;
    private LayoutInflater inflater;


    public ZZXT_Receler_Down_ViewAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void addDatas(List<Response_ZXXT_DownNews.DataBean.ListBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void clearDatas() {
        this.list.clear();
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsHolder(inflater.inflate(R.layout.newsholder, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NewsHolder newsHolder = (NewsHolder) holder;
        if (list.get(position) !=null){
            newsHolder.image.setImageURI(list.get(position).getImage());
            newsHolder.title.setText(list.get(position).getTitle());
            newsHolder.star.setText((int) (Math.random()*100+30)+"");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class NewsHolder extends RecyclerView.ViewHolder{
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
}
