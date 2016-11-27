package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2016-11-27.
 */
public class IndependentAllAdapter_RecyclerView extends RecyclerView.Adapter {

    private List<String> strings;
    private List<String> ids;
    private List<String> names;
    private Context context;
    private LayoutInflater inflater;

    public IndependentAllAdapter_RecyclerView(Context context, List<String> strings, List<String> ids, List<String> names) {
        this.strings = strings;
        this.ids = ids;
        this.names = names;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.independent_order_viewpager_item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewholder = null;
        if (viewholder == null) {
            viewholder = (ViewHolder) holder;
        }
        viewholder.independentOrderViewpagerItemImage.setImageURI(strings.get(position));
        viewholder.independentOrderViewpagerItemText.setText(names.get(position));
        viewholder.independentOrderViewpagerItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击了"+names.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        return;
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.independent_order_viewpager_item_image)
        SimpleDraweeView independentOrderViewpagerItemImage;
        @BindView(R.id.independent_order_viewpager_item_text)
        TextView independentOrderViewpagerItemText;
        @BindView(R.id.independent_order_viewpager_item)
        LinearLayout independentOrderViewpagerItem;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
