package aiyiqi.bwf.com.yiqizhuangxiu.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Lee Vane on 2016/11/24.
 */

public class NestingGridView extends GridView {
    public NestingGridView(Context context) {
        super(context);
    }

    public NestingGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NestingGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
