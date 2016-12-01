package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;

import java.util.List;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.ResponseTongcheng;
import aiyiqi.bwf.com.yiqizhuangxiu.mvp.view.TongchengView;

/**
 * Created by Administrator on 2016/11/25.
 */

public class TongchengFragment extends BaseFragment implements TongchengView {




//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // TODO: inflate a fragment view
//        View rootView = super.onCreateView(inflater, container, savedInstanceState);
//        ButterKnife.bind(this, rootView);
//        return rootView;
//    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        linearLayoutManager = new LinearLayoutManager(getActivity());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        tongchengRecyclerview.setLayoutManager(linearLayoutManager);
//
//        tongchengAdapter = new Tongcheng_Adapter(getActivity());
//
//        tongchengRecyclerview.setAdapter(tongchengAdapter);
//        tongchengPresenter = new TongchengPresenterImpl(this);
//        tongchengPresenter.loadTongchengDatas();


//        Bundle bundle = getArguments();
//        urlTag = bundle.getString("urlTag");
//        tongchengPresenter = new TongchengPresenterImpl(this,urlTag);
    }

    @Override
    protected int getContentViewResID() {
        return 0;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }


//    @Override
//    public void showTongchengSuccess(List<ResponseTongcheng.DataBean> tongcheng) {
//        tongchengAdapter.addDatas(tongcheng);
//    }

    @Override
    public void showTongchengSuccess(List<ResponseTongcheng.DataBean.ForumlistBean> tongcheng) {

    }

    @Override
    public void showFailed() {

    }
}
