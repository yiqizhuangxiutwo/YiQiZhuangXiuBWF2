package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.fragment.MsgFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/25.
 */

public class LoginRegisterActivity extends BaseActivity {
    @BindView(R.id.login_btn_cancel)
    Button loginBtnCancel;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.login_imagebtn_hintpwd)
    ImageButton loginImagebtnHintpwd;
    @BindView(R.id.msg_quick_login)
    Button msgQuickLogin;
    @BindView(R.id.forget_pwd)
    Button forgetPwd;
    @BindView(R.id.login_register)
    Button loginRegister;

    @Override
    public int getContentViewResID() {
        return R.layout.login_register;
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

    @OnClick({R.id.login_btn_cancel, R.id.msg_quick_login, R.id.forget_pwd, R.id.login_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn_cancel:
                Intent intent1 = new Intent(this, MsgFragment.class);
                startActivity(intent1);
                break;
            case R.id.msg_quick_login:
                Intent intent2 = new Intent(this, LoginActivity.class);
                startActivity(intent2);
                break;
            case R.id.forget_pwd:
                Intent intent3 = new Intent(this, ForgetPasswordActivity.class);
                startActivity(intent3);
                break;
            case R.id.login_register:
                break;
        }
    }
}
