package aiyiqi.bwf.com.yiqizhuangxiu.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import aiyiqi.bwf.com.yiqizhuangxiu.R;

/**
 * Created by Yishi on 2016/11/23.
 */

public class WelcomeActivity extends BaseActivity {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1000) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        }
    };

    @Override
    public int getContentViewResID() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViews() {
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = new Message();
                message.what = 1000;
                handler.sendMessage(message);
            }
        }.start();
    }

    @Override
    protected void initDatas() {

    }
}
