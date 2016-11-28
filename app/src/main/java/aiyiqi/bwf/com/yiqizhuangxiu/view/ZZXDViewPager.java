package aiyiqi.bwf.com.yiqizhuangxiu.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by lenovo on 2016-11-27.
 */

public class ZZXDViewPager extends ViewPager{
    // 滑动距离及坐标
    private float yDistance, yLast;

    public ZZXDViewPager(Context context) {
        super(context);
    }

    public ZZXDViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                yDistance = 0f;
                yLast = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curY = ev.getY();
                yDistance += Math.abs(curY - yLast);
                yLast = curY;
                if(yDistance > 0){
                    return false;
                }
        }
        return super.onInterceptTouchEvent(ev);
    }
}
