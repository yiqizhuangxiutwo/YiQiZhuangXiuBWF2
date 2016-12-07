package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter.TabAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/23.
 */

public class SpeakFragment extends BaseFragment {

    @BindView(R.id.search_new)
    ImageView searchNew;
    @BindView(R.id.tabLayout_main)
    TabLayout tabLayoutMain;
    @BindView(R.id.r1)
    RelativeLayout r1;
    @BindView(R.id.viewPager_main_fragment)
    ViewPager viewPagerMainFragment;
    @BindView(R.id.imgbtn2)
    SimpleDraweeView imgbtn2;
    @BindView(R.id.view)
    View view;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabAdapter tabAdapter;
    private List<String> datas;

    @Override
    protected int getContentViewResID() {
        return R.layout.fragment_speak;
    }

    @Override
    protected void initViews() {
        tabLayout = (TabLayout) getView().findViewById(R.id.tabLayout_main);
        viewPager = (ViewPager) getView().findViewById(R.id.viewPager_main_fragment);
        tabLayout.setupWithViewPager(viewPager);
        datas = new ArrayList<>();
        datas.add("精华");
        datas.add("最新");
        datas.add("板块");
        tabAdapter = new TabAdapter(getFragmentManager(), datas);
        viewPager.setAdapter(tabAdapter);

        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private boolean isNormal;
    private View popuview;
    private ViewHolder viewHolder;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(final Message msg) {
            //更新界面
            final ImageButton[] buttons = new ImageButton[]{viewHolder.button1,viewHolder.button2,viewHolder.button3,viewHolder.button4};
            AnimationSet set = new AnimationSet(true);
            TranslateAnimation translate = new TranslateAnimation(0, 0, 0, -1000);
            translate.setDuration(300);
            set.addAnimation(translate);
            set.setFillAfter(true);

            switch (msg.what){
                case 0:
                    buttons[0].startAnimation(set);
                    setAnimationListen(set,buttons[0]);
                    break;
                case 1:
                    buttons[1].startAnimation(set);
                    setAnimationListen(set,buttons[1]);
                    break;
                case 2:
                    buttons[2].startAnimation(set);
                    setAnimationListen(set,buttons[2]);
                    break;
                case 3:
                    buttons[3].startAnimation(set);
                    setAnimationListen(set,buttons[3]);
                    break;
            }
        }
    };

    private void setAnimationListen(AnimationSet set, final ImageButton button) {
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                AnimationSet set2 = new AnimationSet(true);
                TranslateAnimation translate2 = new TranslateAnimation(0, 0, -1000, -900);
                translate2.setDuration(100);
                set2.addAnimation(translate2);
                set2.setFillAfter(true);
                button.startAnimation(set2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    @OnClick(R.id.imgbtn2)
    public void onClick() {
        popuview = LayoutInflater.from(getActivity()).inflate(R.layout.anniu, null);
        final PopupWindow popupWindow = new PopupWindow(popuview, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));
        popupWindow.showAsDropDown(view);
        viewHolder = new ViewHolder(popuview);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <4; i++) {
                    try {
                        Thread.sleep(50);
                        Message msg = new Message();
                        msg.what = i;
                        handler.sendMessage(msg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        viewHolder.imgbtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }


    static class ViewHolder {
        @BindView(R.id.button1)
        ImageButton button1;
        @BindView(R.id.button2)
        ImageButton button2;
        @BindView(R.id.button3)
        ImageButton button3;
        @BindView(R.id.button4)
        ImageButton button4;
        @BindView(R.id.imgbtn_close)
        SimpleDraweeView imgbtnClose;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
