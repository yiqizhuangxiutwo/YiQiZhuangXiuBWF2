package aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MyRecyclecviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Response_Essence.DataBean> datas;
    private LayoutInflater inflater;

    public MyRecyclecviewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.datas = new ArrayList<>();
    }

    public void addDtas(List<Response_Essence.DataBean> datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.main_essence, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        Response_Essence.DataBean dataBean = datas.get(position);
        myViewHolder.imageViewAuthor.setImageURI(dataBean.getAvtUrl());
        myViewHolder.authorname.setText(dataBean.getAuthor());
        myViewHolder.textViewFrontMainTitle.setText(dataBean.getSubject());
        myViewHolder.imageViewFrontTopImage.setImageURI(dataBean.getAttachments().get(0));
        myViewHolder.textViewFrontSubtitle.setText("精选自"+dataBean.getFname());
        myViewHolder.timeArtticle.setText(dataBean.getDateline());

    }
    @Override
    public int getItemCount() {
        return datas.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageView_author)
        SimpleDraweeView imageViewAuthor;
        @BindView(R.id.textView_front_main_title)
        TextView textViewFrontMainTitle;
        @BindView(R.id.imageView_front_top_image)
        SimpleDraweeView imageViewFrontTopImage;
        @BindView(R.id.textView_front_subtitle)
        TextView textViewFrontSubtitle;
        @BindView(R.id.time_artticle)
        TextView timeArtticle;
        @BindView(R.id.liked_count)
        ImageView likedCount;
        @BindView(R.id.article_comment)
        ImageView articleComment;
        @BindView(R.id.artcle_share)
        ImageView artcleShare;
        @BindView(R.id.comment_count)
        TextView commentcount;
        @BindView(R.id.author_name)
        TextView authorname;
        @BindView(R.id.subject_name)
        TextView subjectname;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
