package aiyiqi.bwf.com.yiqizhuangxiu.utlis;

/**
 * Created by LG on 2016/10/14.
 * Tips:
 * 存放网络接口的
 */

public interface Apis {
    //Home上部ViewPager接口
    String HTTP_HOME_VIEWPAGER = "http://118.178.142.34/YiQiHouse/HomeAD";

    //Home下方RecycleView的接口
    String HTTP_HOME_RECYCLERVIEW = "http://118.178.142.34/YiQiHouse/HomeBBS?page=1";

    //建材家居
    String HTTP_BUIDLING_HOME = "http://bbs.17house.com/motnt/index.php?a=product&m=misc&model=android&uuid=a444d1b2af4f&app_version=android_com.aiyiqi.galaxy_1.1";

    //精华Recycleview的接口
    String ESSENCE_RECYCLERVIEW = "http://bbs.17house.com/motnt/index.php?a=allThread&c=forumThreadList&mode=digest&uuid=86305803367590&pageSize=10&m=forum&page=1&haspermission=yes&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1";

    //装修预算装修报价接口
    String ZXYS_WEBVIEW = "http://m.beijing.17house.com/baojia/?sem=android&model=android";

    //装修学堂上部TAG数据接口
    String ZZXT_TAG = " http://appapi.17house.com/StageApi.php?version=1&action=getTagsByStage&stage=1&model=android";
}