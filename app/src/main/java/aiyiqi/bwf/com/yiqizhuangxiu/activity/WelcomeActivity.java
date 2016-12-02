package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.os.Bundle;

import aiyiqi.bwf.com.yiqizhuangxiu.R;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.SPUtils;

/**
 * Created by Yishi on 2016/11/23.
 */

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setFullScreen();
        super.onCreate(savedInstanceState);

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(isCancle){
                    return;
                }
                if(isFirstRun()){
                    gotoSplash();
                }else{
                    gotoMain();
                }
            }
        }.start();
    }

    @Override
    public int getContentViewResID() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }


    /**
     *跳转到引导界面
     */
    private void gotoSplash(){
        startActivity(new Intent(this,FirstInActivity.class));
        finish();
    }

    /**
     * 跳转到主界面
     */
    private void gotoMain(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    /**
     * 判断应用是否是第一次运行
     * @return
     */
    private boolean isFirstRun(){
        boolean isFirst = (boolean) SPUtils.get(this,"version_first_run_guide",true);
        if(isFirst){
            SPUtils.put(this,"version_first_run_guide",false);
        }
        return isFirst;
    }
    private boolean isCancle;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        isCancle = true;
    }
}
