package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
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
import butterknife.OnClick;

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
    private static final int PHOTO_REQUEST_CAREMA = 1;// 拍照
    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    private static final int PHOTO_REQUEST_CUT = 3;// 结果

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

        if (mBitmap != null)
            imgZxing.setImageBitmap(mBitmap);
        imgZxing.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgZxing.setVisibility(View.GONE);
            }
        }, 3000);
        if(result.startsWith("http:")) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri content_url = Uri.parse(result.toString());
            intent.setData(content_url);
            startActivity(intent);
        } else {
            Toast.makeText(this, "二维码内容为: " + result, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onAnalyzeFailed() {//解析失败

    }

    @OnClick({R.id.zxing_guanbi, R.id.zxing_xiangce})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zxing_guanbi:
                finish();
                break;
            case R.id.zxing_xiangce:
                // 激活系统图库，选择一张图片
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
                startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
                break;
        }
    }
}
