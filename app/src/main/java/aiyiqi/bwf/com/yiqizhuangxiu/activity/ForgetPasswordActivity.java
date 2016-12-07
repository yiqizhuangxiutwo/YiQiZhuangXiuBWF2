package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/25.
 */

public class ForgetPasswordActivity extends BaseActivity implements TextWatcher {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.editText_01)
    EditText editText01;
    @BindView(R.id.editText_02)
    EditText editText02;
    @BindView(R.id.forget_pwd_code)
    Button forgetPwdCode;
    @BindView(R.id.editText_03)
    EditText editText03;
    @BindView(R.id.forget_pwd_imagebtn_hintpwd)
    ImageButton forgetPwdImagebtnHintpwd;
    @BindView(R.id.forget_btn_ok)
    Button forgetBtnOk;
    private String phone;
    private String yanzheng;
    private String yanzhengma;

    @Override
    public int getContentViewResID() {
        return R.layout.forget_password;
    }

    @Override
    protected void initViews() {
        forgetBtnOk.getBackground().setAlpha(50);
        title.setText("忘记密码");
    }

    @Override
    protected void initDatas() {
        editText01.addTextChangedListener(this);
        editText02.addTextChangedListener(this);
        editText03.addTextChangedListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.forget_pwd_code,
            R.id.forget_btn_ok,})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forget_pwd_code:
                break;
            case R.id.forget_btn_ok:

                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        phone = editText01.getText().toString();
        yanzheng = editText02.getText().toString();
        yanzhengma = editText03.getText().toString();

        if (!phone.equals("") && !yanzheng.equals("") && !yanzhengma.equals("")){
            forgetBtnOk.getBackground().setAlpha(255);
            Log.d("ForgetPasswordActivity", "jinlaile1");
        } else {
            Log.d("ForgetPasswordActivity", "jinlaile2");
            forgetBtnOk.getBackground().setAlpha(50);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }


}
