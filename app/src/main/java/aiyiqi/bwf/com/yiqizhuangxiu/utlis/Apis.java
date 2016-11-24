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

    //精华Recycleview的接口
    String ESSENCE_RECYCLERVIEW = "http://bbs.17house.com/motnt/index.php?a=allThread&c=forumThreadList&mode=digest&uuid=86305803367590&pageSize=10&m=forum&page=1&haspermission=yes&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1";
}