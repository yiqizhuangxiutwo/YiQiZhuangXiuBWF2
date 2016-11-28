package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/25.
 */

public class ForgetPasswordActivity extends BaseActivity {
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.forget_pwd_code)
    Button forgetPwdCode;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.login_imagebtn_hintpwd)
    ImageButton loginImagebtnHintpwd;
    @BindView(R.id.forget_btn_ok)
    Button forgetBtnOk;

    @Override
    public int getContentViewResID() {
        return R.layout.forget_password;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.forget_pwd_code, R.id.login_imagebtn_hintpwd, R.id.forget_btn_ok,})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forget_pwd_code:
                break;
            case R.id.login_imagebtn_hintpwd:
                break;
            case R.id.forget_btn_ok:
                break;
        }
    }
}
