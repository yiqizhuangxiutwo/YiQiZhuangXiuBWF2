package aiyiqi.bwf.com.yiqizhuangxiu.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lenovo on 2016-11-23.
 */

public class AutoScrollViewPager extends ViewPager{
    private static final int DURATION = 1200;

    public AutoScrollViewPager(Context context) {
        super(context);
    }

    public AutoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(){
        try {
            Field filed = ViewPager.class.getDeclaredField("mScroller");
            filed.setAccessible(true);
            Scroller scroller = new Scroller(getContext()){
                @Override
                public void startScroll(int startX, int startY, int dx, int dy, int duration) {
                    super.startScroll(startX, startY, dx, dy, DURATION);
                }
            };
            filed.set(this,scroller);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAdapter(final PagerAdapter adapter) {
        super.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return adapter.getCount();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return adapter.isViewFromObject(view,object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                return adapter.instantiateItem(container,position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                adapter.destroyItem(container,position,object);
            }
        });
        setCurrentItem(Integer.MAX_VALUE/2 - (Integer.MAX_VALUE/2)%adapter.getCount());
        startAutoScroll();
    }

    private Timer timer = new Timer();
    private TimerTask task;

    /**
     * 开始自动滚动
     */
    private void startAutoScroll() {
        if (task == null){
            task = new TimerTask() {
                @Override
                public void run() {
                    nextPage();
                }
            };
            timer.schedule(task,2000,2000);
        }
    }

    /**
     * 切换到下一页
     */
    private void nextPage() {
        post(new Runnable() {
            @Override
            public void run() {
                setCurrentItem(getCurrentItem()+1);
            }
        });
    }

    /**
     * 停止自动滚动
     */
    private void stopAutoScroll(){
        if (task != null){
            task.cancel();
            task = null;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_MOVE:
                stopAutoScroll();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                startAutoScroll();
                break;

        }
        return super.onTouchEvent(ev);
    }
}
