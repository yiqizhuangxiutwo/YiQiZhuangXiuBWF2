package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Lee Vane.
 */

public class FirstInActivity extends BaseActivity {


    @BindView(R.id.welcome_cancle)
    TextView welcomeCancle;
    @BindView(R.id.radiobutton_nan)
    RadioButton radiobuttonNan;
    @BindView(R.id.radiobutton_nv)
    RadioButton radiobuttonNv;
    @BindView(R.id.datepicker)
    DatePicker datepicker;

    @BindView(R.id.text_btn)
    TextView textBtn;
    @BindView(R.id.sex)
    RadioGroup sex;

    @BindView(R.id.zhuangxiu)
    RadioGroup zhuangxiu;
    @BindView(R.id.radiobutton_tag_01)
    RadioButton radiobuttonTag01;
    @BindView(R.id.radiobutton_tag_02)
    RadioButton radiobuttonTag02;
    @BindView(R.id.radiobutton_tag_03)
    RadioButton radiobuttonTag03;
    @BindView(R.id.radiobutton_tag_04)
    RadioButton radiobuttonTag04;

    private String sexStr = null;
    private String zxStr = null;

    @Override
    public int getContentViewResID() {
        return R.layout.welcome;
    }

    @Override
    protected void initViews() {
        datepicker.setCalendarViewShown(false);
        Calendar calendar = Calendar.getInstance();
        datepicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), null);

        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioId = group.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) FirstInActivity.this.findViewById(radioId);
                sexStr = (String) radioButton.getText();
            }
        });
        zhuangxiu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioId = group.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) FirstInActivity.this.findViewById(radioId);
                zxStr = (String) radioButton.getText();
            }
        });
        if ("".equals(sexStr) || "".equals(zxStr)) {
            textBtn.getBackground().setAlpha(50);
        } else {
            textBtn.getBackground().setAlpha(255);
        }

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

    @OnClick({R.id.welcome_cancle, R.id.text_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.welcome_cancle:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.text_btn:
                startActivity(new Intent(this, MainActivity.class));
//                Toast.makeText(this, sexStr.toString() + zxStr.toString(), Toast.LENGTH_SHORT).show();
                finish();
                break;

        }
    }


}
