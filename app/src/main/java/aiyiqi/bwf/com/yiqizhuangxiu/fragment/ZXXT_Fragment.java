package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.ZZXT_RecelerViewAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.ZZXT_Receler_Down_ViewAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_ZXXT_DownNews;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_ZXXT_DownNews;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_ZXXT_Tag;
import aiyiqi.bwf.com.yiqizhuangxiu.view.CustomRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/12/2.
 */
public class ZXXT_Fragment extends BaseFragment {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.recyclerviewdown)
    RecyclerView recyclerviewdown;
    @BindView(R.id.refreshLayout)
    CustomRefreshLayout refreshLayout;
    @BindView(R.id.scroll)
    ScrollView scroll;

    private int state;
    private String[] tags;

    public ZXXT_Fragment() {

    }

    public ZXXT_Fragment(int state) {
        super();
        this.state = state;
    }

    @Override
    protected int getContentViewResID() {
        return R.layout.fragment_zxxt;
    }


    private static ZZXT_RecelerViewAdapter zzxt_recelerViewAdapter;
    private static ZZXT_Receler_Down_ViewAdapter zzxt_down_recelerViewAdapter;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getHttpTag(state);
        }
    }

    @Override
    protected void initViews() {
        scroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        if (v.getScrollY() == 0){
                            refreshLayout.setCanPull(true);
                        }else{
                            refreshLayout.setCanPull(false);
                        }
                        break;
                }
                return false;
            }
        });
    }

    @Override
    protected void initDatas() {
        //刷新的操作
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getHttpTag(state);
            }
        });
    }


    private List<String> list_tags = new ArrayList<>();
    private static List<String> ints = new ArrayList<>();

    /**
     * 获得上部TAG的数据星信息
     */
    private void getHttpTag(final int state) {

        Http_ZXXT_Tag zxxt_tag = new Http_ZXXT_Tag();
        zxxt_tag.getHttp(state);
        list_tags.clear();

        zxxt_tag.setCallback(new Http_ZXXT_Tag.Callback() {
            @Override
            public void ZXXTTagCallback(Map<String, String> stringMap) {
                refreshLayout.finishRefresh();

                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerview.setLayoutManager(manager);
                zzxt_recelerViewAdapter = new ZZXT_RecelerViewAdapter(getActivity(), state);
                recyclerview.setAdapter(zzxt_recelerViewAdapter);

                LinearLayoutManager manager2 = new LinearLayoutManager(getActivity());
                manager2.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerviewdown.setLayoutManager(manager2);
                zzxt_down_recelerViewAdapter = new ZZXT_Receler_Down_ViewAdapter(getActivity(), ZXXT_Fragment.this);
                recyclerviewdown.setAdapter(zzxt_down_recelerViewAdapter);

                tags = new String[stringMap.size()];
                String inner_map = stringMap.get("data");
                String[] strs = inner_map.split("\"");
                for (int i = 1; i < strs.length; i += 4) {
                    ints.add(strs[i]);
                }
                for (int i = 3; i < strs.length; i = i + 4) {
                    list_tags.add(strs[i]);
                }
                zzxt_recelerViewAdapter.addDatas(list_tags);
            }

            @Override
            public void HttpFailded(Exception e) {

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


    private int oldPosition = -1;
    private List<String> strs = new ArrayList<>();
    private List<String> intids = new ArrayList<>();
    private List<Response_ZXXT_DownNews.DataBean.ListBean> lists = new ArrayList<>();
    private int page = 1;

    public void setDownNews(final int state, final int position, final boolean isLoadPage) {
        if (oldPosition == position && isLoadPage == false) {
            return;
        }
        oldPosition = position;
        lists.clear();
        Http_ZXXT_DownNews http_zxxt_downNews = new Http_ZXXT_DownNews();
        if (isLoadPage) {
            page++;
        }
        http_zxxt_downNews.getHttp(state, page);
        http_zxxt_downNews.setCallback(new Http_ZXXT_DownNews.Callback() {

            @Override
            public void ZXXTTagCallback(Response_ZXXT_DownNews response_zxxt_downNews, String str) {
                for (int i = 0; i < str.length(); i++) {
                    int x = str.indexOf("tag");
                    int y = str.indexOf("isJump");
                    if (x == -1 || y == -1) {
                        break;
                    }
                    String str2 = str.substring(x, y);
                    strs.add(str2);
                    str = str.substring(y + 9, str.length());
                }
                for (int i = 0; i < strs.size(); i++) {
                    String[] strsid = strs.get(i).split("\"");
                    intids.add(strsid[2]);
                }
                if (position == 0) {
                    if (!isLoadPage) {
                        zzxt_down_recelerViewAdapter.clearDatas();
                    }
                    zzxt_down_recelerViewAdapter.addDatas(response_zxxt_downNews.getData().getList(), state, position);
                } else {
                    for (int i = 0; i < response_zxxt_downNews.getData().getList().size(); i++) {
                        if (ints.get(position - 1).equals(intids.get(i))) {
                            lists.add(response_zxxt_downNews.getData().getList().get(i));
                        }
                    }
                    if (!isLoadPage) {
                        zzxt_down_recelerViewAdapter.clearDatas();
                    }
                    zzxt_down_recelerViewAdapter.addDatas(lists, state, position);
                }
            }

            @Override
            public void HttpFailded(Exception e) {
            }
        });
    }
}
