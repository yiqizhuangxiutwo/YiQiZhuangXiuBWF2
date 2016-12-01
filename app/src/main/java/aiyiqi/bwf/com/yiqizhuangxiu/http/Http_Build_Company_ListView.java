package aiyiqi.bwf.com.yiqizhuangxiu.http;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import aiyiqi.bwf.com.yiqizhuangxiu.entity.Response_Buide_Company_ListView;
import aiyiqi.bwf.com.yiqizhuangxiu.utlis.Apis;
import okhttp3.Call;

/**
 * Created by Yishi on 2016/11/29.
 */
public class Http_Build_Company_ListView {

    /**
     * 装修公司界面身体ListView的网络访问数据
     * @param
     * @return
     */
    public void getHttp() {

        OkHttpUtils.get().url(Apis.HTTP_BUILD_COMPANY_LISTVIEW).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (e!=null){
                    callback.HttpFailded(e);
                }
            }

            @Override
            public void onResponse(String response, int id) {
                Response_Buide_Company_ListView response_buide_company_listView = JSON.parseObject(response,Response_Buide_Company_ListView.class);
                callback.ViewPagerCallback(response_buide_company_listView);
            }
        });
    }

    private Callback callback;
    public void setCallback(Callback callback){
        this.callback = callback;
    }
    public interface Callback{
        void ViewPagerCallback( Response_Buide_Company_ListView response_buide_company_listView);
        void HttpFailded(Exception e);
    }

}
