package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/25.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.login_btn_cancel)
    ImageButton loginBtnCancel;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.login_imagebtn_hintpwd)
    Button loginImagebtnHintpwd;
    @BindView(R.id.msg_login)
    Button msgLogin;
    @BindView(R.id.editText_01)
    EditText editText01;
    @BindView(R.id.editText_02)
    EditText editText02;

    private String phone;
    private String password;

    @Override
    public int getContentViewResID() {
        return R.layout.login;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {
        phone = editText01.getText().toString();
        password = editText02.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_btn_cancel)
    public void onClick() {
    }

    @OnClick({R.id.login_imagebtn_hintpwd, R.id.msg_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_imagebtn_hintpwd:
                break;
            case R.id.msg_login:
                if(!phone.equals("") && !password.equals("")){
                    msgLogin.getBackground().setAlpha(255);
                } else {
                    msgLogin.getBackground().setAlpha(50);
                }
                break;
        }
    }
}
