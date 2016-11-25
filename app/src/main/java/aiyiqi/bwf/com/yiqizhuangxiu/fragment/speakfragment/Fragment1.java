package aiyiqi.bwf.com.yiqizhuangxiu.fragment.speakfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter.MyRecyclecviewAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.BaseFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_Essence;
import aiyiqi.bwf.com.yiqizhuangxiu.view.FullyLinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/23.
 */

public class Fragment1 extends BaseFragment implements View.OnTouchListener {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    private ImageButton button;
    private MyRecyclecviewAdapter myadapter;
    @Override
    protected int getContentViewResID() {
        return R.layout.fragment1;
    }

    @Override
    protected void initViews() {
        button = (ImageButton) getView().findViewById(R.id.imgbnt);
        button.setOnTouchListener(this);
        httpgetDatas();
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(manager);
        myadapter = new MyRecyclecviewAdapter(getActivity());
        recycleView.setAdapter(myadapter);
    }

    @Override
    protected void initDatas() {
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //重新设置按下时的背景图片
            ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.float_layer_menu_close));
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            //再修改为抬起时的正常图片
            ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.float_layer_menu_normal));
        }
        return false;
    }

    public void httpgetDatas() {
        Http_Essence http = new Http_Essence();
        http.getHttp();
        http.setCallback(new Http_Essence.Callback() {
            @Override
            public void ViewPagerCallback(List<Response_Essence.DataBean> dataBean) {
                myadapter.addDtas(dataBean);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
