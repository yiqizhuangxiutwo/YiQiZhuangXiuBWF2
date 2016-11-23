package aiyiqi.bwf.com.yiqizhuangxiu.utlis.http;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Lizhangfeng on 2016/11/22 0022.
 * Description:
 */

public abstract class HttpCallBack<T> extends StringCallback {

    private Class<T> tClass;

    public HttpCallBack() {
        tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void onError(Call call, Exception e, int id) {

    }

    @Override
    public void onResponse(String response, int id) {

        if (TextUtils.isEmpty(response))
            onFail("数据异常");

        if (response.startsWith("{")) {
            //此处默认为Object
            T t = JSON.parseObject(response, tClass);
            if (t == null)
                onFail("解析异常");

            onSucess(t, null);
        } else {
            List<T> tList = JSON.parseArray(response, tClass);

            if (tList == null)
                onFail("解析异常");
            onSucess(null, tList);
        }


    }

    //请求成功
    abstract void onSucess(T t, List<T> tList);

    //请求失败
    abstract void onFail(String errMsg);

}
