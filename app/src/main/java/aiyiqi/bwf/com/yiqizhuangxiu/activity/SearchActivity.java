package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.adapter.SearchAdapter;
import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseSearch;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.SearchPresenter;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.presenter.impl.SearchPresenterImpl;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.SearchView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lee Vane.
 */

public class SearchActivity extends BaseActivity implements SearchView {


    @BindView(R.id.search_textview)
    EditText searchTextview;
    @BindView(R.id.search_cancle_image)
    ImageButton searchCancleImage;
    @BindView(R.id.search_cancle)
    Button searchCancle;
    @BindView(R.id.search_recycleview)
    RecyclerView searchRecycleview;
    @BindView(R.id.refreshLayout_search)
    MaterialRefreshLayout refreshLayoutSearch;
    @BindView(R.id.search_linearlayout_view)
    LinearLayout searchLinearlayoutView;

    private SearchPresenter presenter;
    private SearchAdapter adapter;
    private LinearLayoutManager manager;
    private String content;
    @Override
    public int getContentViewResID() {
        return R.layout.search_activity;
    }

    private boolean isLoading;
    private boolean isNoMoreData;

    private void loadNextDatas(String content) {
        presenter.loadDatas(content);
        isLoading = false;
    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (isNoMoreData) {
                return;
            }
            if (!isLoading && manager.findLastVisibleItemPosition() == manager.getItemCount() - 1) {
                isLoading = true;
                loadNextDatas(content);
            }
        }
    };

    @Override
    protected void initViews() {
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        searchRecycleview.setLayoutManager(manager);
        adapter = new SearchAdapter(this);
        searchRecycleview.setAdapter(adapter);
        searchRecycleview.addOnScrollListener(onScrollListener);

        searchTextview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(s)){
                    searchCancleImage.setVisibility(View.GONE);
                }else{
                    searchCancleImage.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        refreshLayoutSearch.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                presenter.loadDatas(content);
            }
        });
    }

    @Override
    protected void initDatas() {
//        content = searchTextview.getText().toString();
        content = "aa";
//        if (content.equals("")) {
//            searchLinearlayoutView.setVisibility(View.VISIBLE);
//            refreshLayoutSearch.setVisibility(View.GONE);
//
//            return;
//        }else {
//            searchLinearlayoutView.setVisibility(View.GONE);
//            refreshLayoutSearch.setVisibility(View.VISIBLE);
//            presenter = new SearchPresenterImpl(this, content);
            presenter = new SearchPresenterImpl(this);
            presenter.loadDatas(content);
//        }

    }

    @Override
    public void showPictureSuccess(List<ResponseSearch.DataBean> dataBeen) {
        Log.d("SearchActivity", "jinglaile");
        Log.d("SearchActivity", "dataBeen:" + dataBeen);
        refreshLayoutSearch.finishRefresh();
        adapter.addDatas(dataBeen);
    }

    @Override
    public void showNoMoreData() {

    }

    @Override
    public void showFailed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
