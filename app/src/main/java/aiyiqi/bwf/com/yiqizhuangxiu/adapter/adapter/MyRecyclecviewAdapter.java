package aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.speakactivity.ArticleActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Commit;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Detail;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MyRecyclecviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Response_Essence.DataBean> datas;
    private LayoutInflater inflater;
    private List<Response_Detail.DataBean> dataBean1;
    private Context context;
    public MyRecyclecviewAdapter(Context context) {
        this.context =context;
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        Response_Essence.DataBean dataBean = datas.get(position);
        myViewHolder.imageViewAuthor.setImageURI(dataBean.getAvtUrl());
        myViewHolder.authorname.setText(dataBean.getAuthor());
        myViewHolder.textViewFrontMainTitle.setText(dataBean.getSubject());
        myViewHolder.commentcount.setText(dataBean.getReplies()+"");
        if(dataBean.getAttachments()!=null){
            myViewHolder.imageViewFrontTopImage.setImageURI(dataBean.getAttachments().get(0));
        }else{
            myViewHolder.imageViewFrontTopImage.setVisibility(View.GONE);
        }
        myViewHolder.textViewFrontSubtitle.setText("精选自"+dataBean.getFname());
        myViewHolder.timeArtticle.setText(dataBean.getDateline());
        if(dataBean.getTags()!=null){
            for (int i = 0; i <dataBean.getTags().size(); i++) {
                myViewHolder.explaintext.setText(dataBean.getTags().get(i).getTagname());
            }
        }
        myViewHolder.imageViewFrontTopImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dataBean1 = (List<Response_Detail.DataBean>) getIem(position);
                Intent intent = new Intent(context, ArticleActivity.class);
//                intent.putExtra("articleId",dataBean1.get(position).getTid());
                Toast.makeText(context, dataBean1.get(position).getTid(), Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });
        myViewHolder.textViewFrontSubtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myViewHolder.imageViewAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    public int getItemCount() {
        return datas.size();
    }

//    public Response_Detail.DataBean getIem(int positon){
//        return dataBean1.get(positon);
//    }
    public  class MyViewHolder extends RecyclerView.ViewHolder{
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
        @BindView(R.id.explain_text)
        TextView explaintext;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
