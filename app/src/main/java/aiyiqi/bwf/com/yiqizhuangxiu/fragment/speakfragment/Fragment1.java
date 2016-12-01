package aiyiqi.bwf.com.yiqizhuangxiu.fragment.speakfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.speakactivity.ArticleActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.adapter.MyRecyclecviewAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Detail;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Essence;

import aiyiqi.bwf.com.yiqizhuangxiu.fragment.BaseFragment;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.SpeakPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.presenter.iml.SpeakPresenterIml;
import aiyiqi.bwf.com.yiqizhuangxiu.speakmvp.view.SpeakView;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.button;

/**
 * Created by Administrator on 2016/11/23.
 */

public class Fragment1 extends BaseFragment implements SpeakView {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
//    private ImageButton button;
    private MyRecyclecviewAdapter myadapter;
    private SpeakPresenter speakPresenter;
    private LinearLayoutManager manager;
    @Override
    protected int getContentViewResID() {
        return R.layout.fragment1;
    }

    @Override
    protected void initViews() {
        manager = new LinearLayoutManager(getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(manager);
        myadapter = new MyRecyclecviewAdapter(getActivity());
        recycleView.setAdapter(myadapter);
        recycleView.addOnScrollListener(onScrollListener);
        speakPresenter = new SpeakPresenterIml(this);
        speakPresenter.loadPage();
    }

    @Override
    protected void initDatas() {
    }
    private boolean isNoMoreData;
    private boolean isDatas;
    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if(isNoMoreData){
                return;
            }
            if(!isDatas&&manager.findLastVisibleItemPosition()==manager.getItemCount()-1){
                isDatas = true;
                speakPresenter.loadPage();
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void showPage(List<Response_Essence.DataBean> dataBeen) {
        Log.d("Fragment1", "dataBeen:" + dataBeen);
        myadapter.addDtas(dataBeen);
        isDatas = false;
    }

    @Override
    public void showFaild() {

    }
}
