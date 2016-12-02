package aiyiqi.bwf.com.yiqizhuangxiu.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by Lee Vane.
 */

public class CustomLinearLayoutManager extends LinearLayoutManager {

    private boolean isScrollEnabled = true;
    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean scrollEnabled) {
        isScrollEnabled = scrollEnabled;
    }

    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled && super.canScrollVertically();
    }
}
