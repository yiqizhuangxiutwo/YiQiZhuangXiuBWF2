package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_GDZB_ST;
import aiyiqi.bwf.com.yiqizhuangxiu.view.MyGridView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/12/1.
 */
public class RecycDownAdapter extends RecyclerView.Adapter {
    private static final int FOOTER = 1;
    private static final int BODY = 0;

    private Context context;
    private List<Response_GDZB_ST.DataBean> data;
    private LayoutInflater inflater;

    public RecycDownAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
        inflater = LayoutInflater.from(context);

    }

    public void addDatas(List<Response_GDZB_ST.DataBean> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void clearDatas() {
        this.data.clear();
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
        if (viewType == FOOTER) {
            return new Footer(inflater.inflate(R.layout.footer, parent, false));
        }
        return new ViewHolder(inflater.inflate(R.layout.innerview, parent, false));
    }


    private List<String> images = new ArrayList<>();
    private GDZB_inner_Grid gdzb_inner_grid;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == getItemCount() -1){
            Footer footer = (Footer) holder;
            if (data.size() == 0){
                footer.textfooter.setText("暂无工地内容");
            }else {
                footer.textfooter.setText("没有更多内容了");
            }
            return;
        }
        gdzb_inner_grid = new GDZB_inner_Grid(context);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.name.setText(data.get(position).getCreatorName() + "("
                + data.get(position).getCreatorRole() + ")");
        viewHolder.message.setText(data.get(position).getMessage());
        viewHolder.simple.setImageURI(data.get(position).getAvatar());
        //时间的转换
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format.format(new Date(data.get(position).getCreateTime()));
        viewHolder.time.setText(time);
        //获取gridView图片的信息
        String strimage = data.get(position).getImgSrc();
        images.clear();
        if (strimage != null) {
            String[] imagesSZ = strimage.split(",");
            for (int j = 0; j < imagesSZ.length; j++) {
                images.add(imagesSZ[j]);
            }
        }
        gdzb_inner_grid.addDatas(images);
        viewHolder.innergrid.setAdapter(gdzb_inner_grid);
    }

    @Override
    public int getItemCount() {
        return data.size()+1;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simple)
        SimpleDraweeView simple;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.message)
        TextView message;
        @BindView(R.id.innergrid)
        MyGridView innergrid;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.share)
        ImageView share;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class Footer extends RecyclerView.ViewHolder{
        @BindView(R.id.textfooter)
        TextView textfooter;

        Footer(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
