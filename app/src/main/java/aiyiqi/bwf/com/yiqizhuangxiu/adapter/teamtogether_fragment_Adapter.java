package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.TeamTogetherGridViewPage;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTeamtogether;

/**
 * Created by Administrator on 2016/12/1.
 */

public class teamtogether_fragment_Adapter extends BaseAdapter {

    private List<ResponseTeamtogether.DataBean> teamtogether;
    private LayoutInflater inflater;
    private Context context;


    public teamtogether_fragment_Adapter(Context context) {
        this.teamtogether = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    //为了设置跳转
    public Context getContext() {
        return context;
    }

    //清空数据
    public void clearData() {
        this.teamtogether.clear();
        notifyDataSetChanged();
    }

    //添加数据
    public void addDatas(List<ResponseTeamtogether.DataBean> teamtogether) {
        this.teamtogether.addAll(teamtogether);
        notifyDataSetChanged();
    }

    //设置数据
    public void setDatas(List<ResponseTeamtogether.DataBean> teamtogether) {
        this.teamtogether.clear();
        this.teamtogether.addAll(teamtogether);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return teamtogether.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.team_together_item, parent, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.gridview_botton);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.teamtogether_head);
        TextView textView = (TextView) view.findViewById(R.id.teamtogether_name);
        TextView textView1 = (TextView) view.findViewById(R.id.teamtogether_num);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingbar);

        Log.d("teamtogether_fragment_A", teamtogether.get(position).getAvatar());
        simpleDraweeView.setImageURI(teamtogether.get(position).getAvatar());
        textView.setText(teamtogether.get(position).getRealName());
        textView1.setText("装修案例：" + teamtogether.get(position).getCaseNumber());
        ratingBar.setRating(teamtogether.get(position).getRating());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TeamTogetherGridViewPage.class);
                intent.putExtra("image",teamtogether.get(position).getAvatar());
                intent.putExtra("name",teamtogether.get(position).getRealName());
                intent.putExtra("caseNum",teamtogether.get(position).getCaseNumber());
                intent.putExtra("ratingbar",teamtogether.get(position).getRating());
                context.startActivity(intent);

            }
        });

        return view;

    }

}
