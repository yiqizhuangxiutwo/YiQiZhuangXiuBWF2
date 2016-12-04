package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.ZZXT_RecelerViewAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.ZZXT_Receler_Down_ViewAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_ZXXT_DownNews;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_ZXXT_DownNews;
import aiyiqi.bwf.com.yiqizhuangxiu.http.Http_ZXXT_Tag;
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

    }

    @Override
    protected void initDatas() {

    }


    private List<String> list_tags = new ArrayList<>();

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
                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerview.setLayoutManager(manager);
                zzxt_recelerViewAdapter = new ZZXT_RecelerViewAdapter(getActivity(),state);
                recyclerview.setAdapter(zzxt_recelerViewAdapter);

                LinearLayoutManager manager2 = new LinearLayoutManager(getActivity());
                manager2.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerviewdown.setLayoutManager(manager2);
                zzxt_down_recelerViewAdapter = new ZZXT_Receler_Down_ViewAdapter(getActivity());
                recyclerviewdown.setAdapter(zzxt_down_recelerViewAdapter);

                tags = new String[stringMap.size()];
                String inner_map = stringMap.get("data");
                String[] strs = inner_map.split("\"");
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


    private int oldState = -1;
    public void setDownNews(int state, final int position) {
        if (oldState == state){
            return;
        }
        oldState = state;
        Http_ZXXT_DownNews http_zxxt_downNews = new Http_ZXXT_DownNews();
        http_zxxt_downNews.getHttp(state, 1);
        http_zxxt_downNews.setCallback(new Http_ZXXT_DownNews.Callback() {

            @Override
            public void ZXXTTagCallback(Response_ZXXT_DownNews response_zxxt_downNews, String str) {
                if (position == 0) {
                    zzxt_down_recelerViewAdapter.addDatas(response_zxxt_downNews.getData().getList());
                }
            }

            @Override
            public void HttpFailded(Exception e) {

            }
        });
    }
}
