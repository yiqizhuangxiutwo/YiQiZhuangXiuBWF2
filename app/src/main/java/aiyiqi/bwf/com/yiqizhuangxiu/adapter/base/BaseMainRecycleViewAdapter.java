package aiyiqi.bwf.com.yiqizhuangxiu.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LG on 2016/10/23.
 * Tips:
 */

public abstract class BaseMainRecycleViewAdapter<T> extends BaseRecycleViewAdapter<T> {

    public BaseMainRecycleViewAdapter(Context context) {
        super(context);
    }

    public static final int STATE_GONE = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_NO_MORE_DATA = 2;
    public static final int STATE_LOAD_FAILED = 3;
    private int state;

    public void updateFooterState(int state) {
        this.state = state;
        notifyItemChanged(getItemCount() - 1);
        Log.d("BaseMainRecycleViewAdap", "Adapter更新第" + (getItemCount() - 1) + "个View");
    }

    class FooterHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.progressbar_subview_recycleview_loadfooter)
        ProgressBar progressbarSubviewRecycleviewLoadfooter;
        @BindView(R.id.textview_subview_recycleview_loadfooter)
        TextView textviewSubviewRecycleviewLoadfooter;
        @BindView(R.id.layout_subview_recycleview_loadfooter)
        RelativeLayout layoutSubviewRecycleviewLoadfooter;

        FooterHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            textviewSubviewRecycleviewLoadfooter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onRetryClick();
                    }
                }
            });
        }
    }

    protected void bindFooterViewHolder(RecyclerView.ViewHolder holder, int position) {
        FooterHolder mHolder = (FooterHolder) holder;
        Log.d("BaseMainRecycleViewAdap", "state:" + state);
        switch (state) {
            case STATE_GONE:
                return;
            case STATE_LOADING:
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                break;
            case STATE_NO_MORE_DATA:
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setText(getContext().getString(R.string.noMoreData));
                mHolder.textviewSubviewRecycleviewLoadfooter.setEnabled(false);
                break;
            case STATE_LOAD_FAILED:
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setText(getContext().getString(R.string.loadDataFailedAndClickRetry));
                mHolder.textviewSubviewRecycleviewLoadfooter.setEnabled(true);
                break;
        }
        mHolder.layoutSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
    }

    protected RecyclerView.ViewHolder createFooterHolder(ViewGroup parent) {
        return new FooterHolder(inflaterView(R.layout.subview_footer_loader, parent));
    }

    public interface OnRetryClickListener {
        void onRetryClick();
    }

    private OnRetryClickListener listener;

    public void setOnRetryClickListener(OnRetryClickListener listener) {
        this.listener = listener;
    }


    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public String parseDate(String dateTime) {
        try {
            String date = localSimpleDateFormat.parse(dateTime).toString().substring(4, 11);
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }


}
