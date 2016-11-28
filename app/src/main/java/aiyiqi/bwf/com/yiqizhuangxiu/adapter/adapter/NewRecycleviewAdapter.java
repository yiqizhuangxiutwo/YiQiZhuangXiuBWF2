package aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_New;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */

public class NewRecycleviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<Response_New.DataBean> dataBeens;
    public NewRecycleviewAdapter(Context context) {
        dataBeens = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }
    public void addDatas(List<Response_New.DataBean> dataBeens){
        this.dataBeens.addAll(dataBeens);
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.main_new, parent, false);
        return new NewViewHolder(view);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NewViewHolder newViewHolder = (NewViewHolder) holder;
        Response_New.DataBean dataBean = dataBeens.get(position);
        newViewHolder.imageViewAuthor.setImageURI(dataBean.getAvtUrl());
        newViewHolder.authorName.setText(dataBean.getSubject());
        newViewHolder.subjectName.setText(dataBean.getAuthor());
        newViewHolder.lookedtext.setText(dataBean.getViews()+"");
        newViewHolder.times.setText(dataBean.getDateline());
    }
    @Override
    public int getItemCount() {
        return dataBeens.size();
    }
    public static class NewViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.author_name)
        TextView authorName;
        @BindView(R.id.subject_name)
        TextView subjectName;
        @BindView(R.id.lookedtext)
        TextView lookedtext;
        @BindView(R.id.imageView_author)
        SimpleDraweeView imageViewAuthor;
        @BindView(R.id.times)
        TextView times;
        public NewViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
