package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseBuidingHome;
import aiyiqi.bwf.com.yiqizhuangxiu.widget.NestingGridView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class BuildHomeAdapter extends BaseRecycleView<ResponseBuidingHome.DataBean> {

    private List<ResponseBuidingHome.DataBean.ChildrenBean> dataBeen;
    private Context context;
    private BuidingHomeChildrenAdapter adapter;

    public BuildHomeAdapter(Context context) {
        super(context);
        this.context = context;

    }

    @Override
    protected int getFooterCount() {
        return 0;
    }

    @Override
    protected int getHeaderCount() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("BuildHomeAdapter", "hun222");
        View view = inflaterView(R.layout.subview_buiding_home_child_item, parent);
        return new ItemViewHolder(view);
    }
    private List<ResponseBuidingHome.DataBean> datas = new ArrayList<>();
    @Override
    public void addDatas(List<ResponseBuidingHome.DataBean> datas) {
        super.addDatas(datas);
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("BuildHomeAdapter", "hun");
        ResponseBuidingHome.DataBean buidingHome = getItem(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.buidHomeItemImage.setImageURI(buidingHome.getIcon());
        itemViewHolder.jiancaijiajuTitle1.setText(buidingHome.getTitle());

        adapter = new BuidingHomeChildrenAdapter(context);
        adapter.setChildrenBeen(buidingHome.getChildren());
        itemViewHolder.jiancaijiajuChild1.setAdapter(adapter);
    }

     class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.buid_home_item_image)
        SimpleDraweeView buidHomeItemImage;
        @BindView(R.id.jiancaijiaju_title1)
        TextView jiancaijiajuTitle1;
         @BindView(R.id.jiancaijiaju_child1)
         NestingGridView jiancaijiajuChild1;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
