package aiyiqi.bwf.com.yiqizhuangxiu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.activity.LoginRegisterActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2016/11/23.
 */

public class MsgFragment extends BaseFragment {
    @BindView(R.id.linearlayout_new_coment)
    LinearLayout linearlayoutNewComent;
    @BindView(R.id.linearlayout_new_zan)
    LinearLayout linearlayoutNewZan;
    @BindView(R.id.linearlayout_me)
    LinearLayout linearlayoutMe;
    @BindView(R.id.linearlayout_system)
    LinearLayout linearlayoutSystem;

    @Override
    protected int getContentViewResID() {
        return R.layout.fragment_msg;
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

    @OnClick({R.id.linearlayout_new_coment, R.id.linearlayout_new_zan, R.id.linearlayout_me, R.id.linearlayout_system})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linearlayout_new_coment:
                    Intent intent1 = new Intent(getActivity(), LoginRegisterActivity.class);
                    startActivity(intent1);
                break;
            case R.id.linearlayout_new_zan:
                Intent intent2 = new Intent(getActivity(), LoginRegisterActivity.class);
                startActivity(intent2);
                break;
            case R.id.linearlayout_me:
                Intent intent3 = new Intent(getActivity(), LoginRegisterActivity.class);
                startActivity(intent3);
                break;
            case R.id.linearlayout_system:
                Intent intent4 = new Intent(getActivity(), LoginRegisterActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
