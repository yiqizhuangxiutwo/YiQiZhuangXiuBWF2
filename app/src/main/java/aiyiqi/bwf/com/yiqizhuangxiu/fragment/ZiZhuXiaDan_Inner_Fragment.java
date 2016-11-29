package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yishi on 2016/11/28.
 */
public class ZiZhuXiaDan_Inner_Fragment extends BaseFragment {
    private String text;

    @BindView(R.id.activity_zzxd_inner_viewpager_text)
    TextView activityZzxdInnerViewpagerText;

    public ZiZhuXiaDan_Inner_Fragment() {
    }

    public ZiZhuXiaDan_Inner_Fragment(String text) {
        this.text = text;
    }

    @Override
    protected int getContentViewResID() {
        return R.layout.activity_zzxd_inner_viewpager_item;
    }

    @Override
    protected void initViews() {
        if (text.equals("0")){
            activityZzxdInnerViewpagerText.setText("");
        }else{
            activityZzxdInnerViewpagerText.setText(text);
        }

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
}
