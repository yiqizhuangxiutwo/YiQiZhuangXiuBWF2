package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.MyZxingActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.SearchActivity;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.HomeRecyvlerViewAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.MainViewPagerAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.PlaceAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseRecycleViewList;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_home_viewpager;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_Home_RecyclerView;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_Home_Viewpager;
import aiyiqi.bwf.com.yiqizhuangxiu.view.AutoScrollViewPager;
import aiyiqi.bwf.com.yiqizhuangxiu.view.CustomRefreshLayout;
import aiyiqi.bwf.com.yiqizhuangxiu.widget.PagerDotIndicator;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/23.
 */

public class HomeFragment extends BaseFragment {


    @BindView(R.id.viewPager_main_list_slide)
    AutoScrollViewPager viewPagerMainListSlide;
    @BindView(R.id.linearLayout_pager_indicator)
    LinearLayout linearLayoutPagerIndicator;
    @BindView(R.id.main_title_zxing)
    ImageButton mainTitleZxing;
    @BindView(R.id.main_title_search)
    LinearLayout mainTitleSearch;
    @BindView(R.id.main_title_place)
    LinearLayout mainTitlePlace;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;

    @BindView(R.id.refreshLayout)
    CustomRefreshLayout refreshLayout;
    @BindView(R.id.home_recyclerview)
    RecyclerView homeRecyclerview;

    /**
     * 管理指示器的对象
     **/
    private PagerDotIndicator pagerDotIndicator;

    public static final int STATE_GONE = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_NO_MORE_DATA = 2;
    public static final int STATE_LOAD_FAILED = 3;

    private LinearLayoutManager manager; //recycler
    private Http_Home_RecyclerView http;
    private int pager;
    private HomeRecyvlerViewAdapter homerecyvlerviewadapter;


    @Override
    protected int getContentViewResID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViews() {
        home_ViewPagerHttp();
        pager = 1;
        home_RecyclerViewHttp("1218226", 3, pager);
        homerecyvlerviewadapter = new HomeRecyvlerViewAdapter(getActivity());
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        homeRecyclerview.setLayoutManager(manager);
        homeRecyclerview.setAdapter(homerecyvlerviewadapter);

<<<<<<< HEAD
        mainTitleZxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyZxingActivity.class);
                getActivity().startActivityForResult(intent,1000);
            }
        });
=======
>>>>>>> eaf9974f2676506293b855560b68d027b81a1291
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /**
         * 处理二维码扫描结果
         */
        if (requestCode == 1000) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getContext(), "解析结果:" + result, Toast.LENGTH_LONG).show();

                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getContext(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private boolean isload;
    private boolean isrefresh;

    /**
     * Home下部的网络数据访问
     */
    private void home_RecyclerViewHttp(String id, int type, final int pager) {
        refreshLayout.finishRefresh();
        http = new Http_Home_RecyclerView();
        http.getHttp(id, type, pager);
        http.setCallback(new Http_Home_RecyclerView.Callback() {
            @Override
            public void RecyclerViewCallback(final ResponseRecycleViewList responseRecycleViewList) {
                isload = false;
                isrefresh = false;
                homerecyvlerviewadapter.addDatas(responseRecycleViewList.getData());
                homerecyvlerviewadapter.updateFooterState(STATE_LOADING);
                homeRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
<<<<<<< HEAD
                        if (!isrefresh && !isload && manager.findLastVisibleItemPosition() == manager.getItemCount() - 1) {
=======
                        if (!isrefresh && !isload && manager.findLastVisibleItemPosition() == manager.getItemCount()) {
>>>>>>> eaf9974f2676506293b855560b68d027b81a1291
                            isload = true;
                            int type = responseRecycleViewList.getData().get(responseRecycleViewList.getData().size() - 1).getType();
                            String id = responseRecycleViewList.getData().get(responseRecycleViewList.getData().size() - 1).getId();
                            int nexpage = pager + 1;
                            home_RecyclerViewHttp(id, type, nexpage);
                        }
                    }
                });
            }
        });
    }


    /**
     * Home上部的ViewPager的网络数据访问
     */
    private void home_ViewPagerHttp() {
        Http_Home_Viewpager http = new Http_Home_Viewpager();
        http.getHttp();
        http.setCallback(new Http_Home_Viewpager.Callback() {
            @Override
            public void ViewPagerCallback(Response_home_viewpager response_home_viewpager) {
                MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getActivity(), response_home_viewpager);
                pagerDotIndicator = new PagerDotIndicator(getActivity(), linearLayoutPagerIndicator, viewPagerMainListSlide);
                viewPagerMainListSlide.setAdapter(mainViewPagerAdapter);
                viewPagerMainListSlide.setCurrentItem(response_home_viewpager.getData().size());
                pagerDotIndicator.setDotNums(response_home_viewpager.getData().size());
            }

            @Override
            public void HttpFailded(Exception e) {
                Toast.makeText(getActivity(), "访问错误", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initDatas() {
        //监听APPBAR，确定什么时候可以下拉刷新
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    //RefreshLayout可以触发下拉
                    refreshLayout.setCanPull(true);
                } else {
                    //RefreshLayout不可以触发下拉
                    refreshLayout.setCanPull(false);
                }
            }
        });

        //刷新
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                homerecyvlerviewadapter.setClear();
                home_RecyclerViewHttp("1218226", 3, pager);
                isrefresh = true;
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

<<<<<<< HEAD
    @OnClick({R.id.main_title_zxing, R.id.main_title_search,R.id.main_title_place})
=======
    @OnClick({R.id.main_title_zxing, R.id.main_title_search, R.id.main_title_place})
>>>>>>> eaf9974f2676506293b855560b68d027b81a1291
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_title_zxing:
                Intent intent = new Intent(getActivity(), MyZxingActivity.class);
                getActivity().startActivityForResult(intent, 1000);
                break;
            case R.id.main_title_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.main_title_place:
                showPopuWindow(view);
                break;
        }
    }

    public List<String> stringList() {
        List<String> str = new ArrayList<>();
        for (int i = 0; i <= 34; i++) {
            String s = "成都0 " + i;
            str.add(s);
        }
        return str;
    }

    private void showPopuWindow(View view) {

        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.main_title_place, null);

        final PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.white));

        ViewHolder holder = new ViewHolder(contentView);
        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), stringList());
        holder.textPlaceGps.setText("成都");
        holder.listview.setAdapter(placeAdapter);
        if (!popupWindow.isShowing()) {
            popupWindow.showAsDropDown(view);
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
    }

    static class ViewHolder {
        @BindView(R.id.text_place_gps)
        TextView textPlaceGps;
        @BindView(R.id.listview)
        ListView listview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
