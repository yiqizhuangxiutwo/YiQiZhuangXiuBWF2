package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.EffectPictureRightAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.PopuAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseEffectPictureRight;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.EffectPictureRightPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl.EffectPictureRightPresenterImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.EffectPictureRightView;
import aiyiqi.bwf.com.yiqizhuangxiu.widget.NestingGridView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Lee Vane.
 */

public class EffectPictureRight extends BaseFragment implements EffectPictureRightView, View.OnClickListener {
    @BindView(R.id.effect_picture_tag01)
    LinearLayout effectPictureTag01;
    @BindView(R.id.effect_picture_tag02)
    LinearLayout effectPictureTag02;
    @BindView(R.id.effect_picture_tag03)
    LinearLayout effectPictureTag03;
    @BindView(R.id.effect_picture_tag04)
    LinearLayout effectPictureTag04;
    @BindView(R.id.buid_home_recycleview)
    RecyclerView buidHomeRecycleview;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    @BindView(R.id.textview_tag_01)
    TextView textviewTag01;
    @BindView(R.id.imageview_tag_01)
    ImageView imageviewTag01;
    @BindView(R.id.textview_tag_02)
    TextView textviewTag02;
    @BindView(R.id.imageview_tag_02)
    ImageView imageviewTag02;
    @BindView(R.id.textview_tag_03)
    TextView textviewTag03;
    @BindView(R.id.imageview_tag_03)
    ImageView imageviewTag03;
    @BindView(R.id.textview_tag_04)
    TextView textviewTag04;
    @BindView(R.id.imageview_tag_04)
    ImageView imageviewTag04;


    private EffectPictureRightAdapter adapter;
    private EffectPictureRightPresenter presenter;
    private LinearLayoutManager manager;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected int getContentViewResID() {
        return R.layout.effect_picture_right;
    }

    @Override
    protected void initViews() {
        adapter = new EffectPictureRightAdapter(getActivity());
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        gridLayoutManager = new GridLayoutManager(buidHomeRecycleview.getContext(),
                2, GridLayoutManager.VERTICAL, false);
        buidHomeRecycleview.setLayoutManager(gridLayoutManager);
        buidHomeRecycleview.setAdapter(adapter);

        buidHomeRecycleview.addOnScrollListener(onScrollListener);

        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                loadNextDatas();
            }
        });

    }

    private boolean isLoading;
    private boolean isNoMoreData;

    private void loadNextDatas() {
        presenter.loadDatas();
        isLoading = false;
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (isNoMoreData)
                return;
//            Log.d("EffectTopicLeft", "manager.findLastVisibleItemPosition():" + manager.findLastVisibleItemPosition());
//            Log.d("EffectTopicLeft", "manager.getItemCount():" + manager.getItemCount());

            if (!isLoading && gridLayoutManager.findLastVisibleItemPosition() == gridLayoutManager.getItemCount() - 1) {
//                Log.d("EffectTopicLeft", "jinlaile");
                loadNextDatas();

            }
        }
    };

    @Override
    protected void initDatas() {
        presenter = new EffectPictureRightPresenterImpl(this);
        presenter.loadDatas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void showPictureSuccess(List<ResponseEffectPictureRight.DataBean.ListBean> listBeen) {
        Log.d("EffectPictureRight", "listBeen:" + listBeen.toString());
        refreshLayout.finishRefresh();
        adapter.addDatas(listBeen);
    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    public void showFailed() {

    }

    private void showPopuWindow(View view) {

        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.effect_picture_popuwindow, null);

        final PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));

        PopuViewHolder holder = new PopuViewHolder(contentView);
        PopuAdapter popuAdapter = new PopuAdapter(getContext(), stringList());
        holder.popuwindowSelectedChild.setAdapter(popuAdapter);
        popupWindow.showAsDropDown(view);

    }

    @OnClick({R.id.effect_picture_tag01, R.id.effect_picture_tag02, R.id.effect_picture_tag03, R.id.effect_picture_tag04})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.effect_picture_tag01:
                fun(0);
                Toast.makeText(getContext(), "弹出PopupWindow", Toast.LENGTH_SHORT).show();
                showPopuWindow(view);
                break;
            case R.id.effect_picture_tag02:
                fun(1);
                Toast.makeText(getContext(), "弹出PopupWindow", Toast.LENGTH_SHORT).show();
                showPopuWindow(view);
                break;
            case R.id.effect_picture_tag03:
                fun(2);
                Toast.makeText(getContext(), "弹出PopupWindow", Toast.LENGTH_SHORT).show();
                showPopuWindow(view);
                break;
            case R.id.effect_picture_tag04:
                fun(3);
                Toast.makeText(getContext(), "弹出PopupWindow", Toast.LENGTH_SHORT).show();
                showPopuWindow(view);
                break;
        }
    }
    public void fun(int a){
        LinearLayout[] ll = new LinearLayout[]{effectPictureTag01, effectPictureTag02, effectPictureTag03, effectPictureTag04};
        TextView[] tv = new TextView[]{textviewTag01, textviewTag02, textviewTag03, textviewTag04};
        ImageView[] iv = new ImageView[]{imageviewTag01, imageviewTag02, imageviewTag03, imageviewTag04};
        for (int i = 0; i < 4; i++) {
            if(a == i){
                tv[i].setTextColor(Color.GREEN);
                iv[i].setImageResource(R.drawable.arrow_pic_tab_up);
            } else {
                tv[i].setTextColor(Color.DKGRAY);
                iv[i].setImageResource(R.drawable.arrow_pic_tab_down);
            }
        }
    }
    public List<String> stringList() {
        List<String> str = new ArrayList<>();
        for (int i = 0; i <= 15; i++) {
            String s = "Popu " + i;
            str.add(s);
        }
        return str;
    }

    static class PopuViewHolder {
        @BindView(R.id.jiancaijiaju_child1)
        NestingGridView popuwindowSelectedChild;

        PopuViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
