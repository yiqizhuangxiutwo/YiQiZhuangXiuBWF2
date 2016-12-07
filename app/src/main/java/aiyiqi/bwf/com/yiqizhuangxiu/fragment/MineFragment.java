package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.Activity_Setting;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.LoginRegisterActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/23.
 */

public class MineFragment extends BaseFragment {
    @BindView(R.id.setting)
    RelativeLayout setting;
    @BindView(R.id.login)
    TextView login;

    @Override
    protected int getContentViewResID() {
        return R.layout.activity_mine;
    }

    @Override
    protected void initViews() {

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

    @OnClick({R.id.login, R.id.setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                startActivity(new Intent(getActivity(), LoginRegisterActivity.class));
                break;
            case R.id.setting:
                startActivity(new Intent(getActivity(), Activity_Setting.class));
                break;
        }
    }
}
