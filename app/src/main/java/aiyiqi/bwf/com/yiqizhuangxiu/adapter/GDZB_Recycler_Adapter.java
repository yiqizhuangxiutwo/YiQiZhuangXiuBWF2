package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.GongDiZhiBoActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_GDZB;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/30.
 */
public class GDZB_Recycler_Adapter extends RecyclerView.Adapter {

    private Context context;
    private List<Response_GDZB.DataBean.ProgressBean> progress;
    private LayoutInflater inflater;


    public GDZB_Recycler_Adapter(Context context, List<Response_GDZB.DataBean.ProgressBean> progress) {
        this.context = context;
        this.progress = progress;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecViewHolder(inflater.inflate(R.layout.site_headertwo_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        RecViewHolder recViewHolder = (RecViewHolder) holder;
        recViewHolder.downText.setText(progress.get(position).getProgressName());
        if (progress.get(position).getProgressStatus() == 1) {
            recViewHolder.upText.setText("进行中");
            recViewHolder.upText.setBackgroundResource(R.color.green);
            recViewHolder.upText.setTextColor(Color.WHITE);
            recViewHolder.image.setBackgroundResource(R.drawable.working_icon);
        } else if (progress.get(position).getProgressStatus() == 2) {
            recViewHolder.upText.setText("已完成");
            recViewHolder.upText.setBackgroundResource(R.color.greens);
            recViewHolder.upText.setTextColor(Color.WHITE);
            recViewHolder.image.setBackgroundResource(R.drawable.finish_icon);
        }
        if (position == progress.size() - 1) {
            recViewHolder.view.setVisibility(View.GONE);
        }

        //点击监听
        recViewHolder.sitHeardtwoRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GongDiZhiBoActivity activity = new GongDiZhiBoActivity();
                activity.setPosition(progress.get(position).getProgressStatus());
            }
        });
    }



    @Override
    public int getItemCount() {
        return progress.size();
    }

    static class RecViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.up_text)
        TextView upText;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.down_text)
        TextView downText;
        @BindView(R.id.view)
        View view;
        @BindView(R.id.sit_heardtwo_recycler)
        LinearLayout sitHeardtwoRecycler;

        RecViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
