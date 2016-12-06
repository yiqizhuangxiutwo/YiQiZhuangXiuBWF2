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
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponsePlate;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponsePlate1;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_New;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 */

public class PlateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private ResponsePlate dataBeen;
    public PlateAdapter(Context context,ResponsePlate dataBeen) {
        this.dataBeen = dataBeen;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = inflater.inflate(R.layout.plateactivity, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
                viewHolder.authorName.setText(dataBeen.getData().get(0).get(position).getTitle());
                viewHolder.tipcount.setText(dataBeen.getData().get(0).get(position).getThreadsnum()+"");
                viewHolder.imageViewAuthor.setImageURI(dataBeen.getData().get(0).get(position).getIcon());
    }
    @Override
    public int getItemCount() {
        return dataBeen.getData().get(0).size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageView_author)
        SimpleDraweeView imageViewAuthor;
        @BindView(R.id.author_name)
        TextView authorName;
        @BindView(R.id.tipname)
        TextView tipname;
        @BindView(R.id.tipcount)
        TextView tipcount;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
