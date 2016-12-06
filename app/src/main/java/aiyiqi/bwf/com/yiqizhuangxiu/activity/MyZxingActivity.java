package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MyZxingActivity extends AppCompatActivity implements CodeUtils.AnalyzeCallback {

    @BindView(R.id.zxing_guanbi)
    TextView zxingGuanbi;
    @BindView(R.id.zxing_xiangce)
TextView zxingXiangce;
    @BindView(R.id.zxing_top_back)
    LinearLayout zxingTopBack;
    @BindView(R.id.img_zxing)
    ImageView imgZxing;
    @BindView(R.id.activity_my_zxing)
    RelativeLayout activityMyZxing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_zxing);
        ButterKnife.bind(this);
        CaptureFragment captureFragment = (CaptureFragment) getSupportFragmentManager().findFragmentById(R.id.fram_zxing);
        captureFragment.setAnalyzeCallback(this);//添加解析回调
        zxingTopBack.getBackground().setAlpha(80);
    }

    @Override
    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {//解析成功
        Toast.makeText(this, "二维码内容为: " + result, Toast.LENGTH_SHORT).show();

        if (mBitmap != null)
            imgZxing.setImageBitmap(mBitmap);
        imgZxing.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgZxing.setVisibility(View.GONE);
            }
        }, 3000);
    }

    @Override
    public void onAnalyzeFailed() {//解析失败

    }
}
