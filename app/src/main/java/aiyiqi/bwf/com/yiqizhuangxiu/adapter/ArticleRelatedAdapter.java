package aiyiqi.bwf.com.yiqizhuangxiu.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseArticleDetails;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class ArticleRelatedAdapter extends BaseAdapter {

    private List<ResponseArticleDetails.DataBean.RelatedNewsBean> relatedNewsBeen;
    private Context context;
    private LayoutInflater inflater;
    public ArticleRelatedAdapter(Context context, List<ResponseArticleDetails.DataBean.RelatedNewsBean> relatedNewsBeen) {
        this.context = context;
        this.relatedNewsBeen = relatedNewsBeen;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return relatedNewsBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return relatedNewsBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelatedViewHolder mholder = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.related_article_children, null);
            mholder = new RelatedViewHolder(convertView);
            convertView.setTag(mholder);
        } else {
            mholder = (RelatedViewHolder) convertView.getTag();
        }
        Log.d("articletest", relatedNewsBeen.get(position).getNews_id() +"");
        mholder.relatedDetailsTitle.setText(relatedNewsBeen.get(position).getTitle());
        mholder.mainArticleItemScan.setText(relatedNewsBeen.get(position).getClick() + "");
        mholder.mainArticleItemStar.setText(relatedNewsBeen.get(position).getFavNums() + "");
        mholder.mainArticleItemComments.setText(relatedNewsBeen.get(position).getComment_count() + "");
        mholder.articleDetailsIamgeTag.setImageURI(relatedNewsBeen.get(position).getThumb());
        return convertView;
    }

    static class RelatedViewHolder {
        @BindView(R.id.related_details_title)
        TextView relatedDetailsTitle;
        @BindView(R.id.main_article_item_scan)
        TextView mainArticleItemScan;
        @BindView(R.id.main_article_item_star)
        TextView mainArticleItemStar;
        @BindView(R.id.main_article_item_comments)
        TextView mainArticleItemComments;
        @BindView(R.id.article_details_iamge_tag)
        SimpleDraweeView articleDetailsIamgeTag;
        @BindView(R.id.related_details_article_tag)
        LinearLayout relatedDetailsArticleTag;

        RelatedViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }

}
