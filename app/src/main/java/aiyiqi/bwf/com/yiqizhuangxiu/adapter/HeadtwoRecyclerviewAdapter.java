package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_GDZB;

/**
 * Created by Yishi on 2016/11/29.
 */
public class HeadtwoRecyclerviewAdapter extends RecyclerView.Adapter{
    private List<Response_GDZB.DataBean.ProgressBean> progress;
    private LayoutInflater inflater;
    private Context conntext;

    public HeadtwoRecyclerviewAdapter(Context conntext,List<Response_GDZB.DataBean.ProgressBean> progress) {
        this.conntext = conntext;
        this.progress = progress;
        inflater = LayoutInflater.from(conntext);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GridRecyclerView(inflater.inflate(R.layout.site_headertwo_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
