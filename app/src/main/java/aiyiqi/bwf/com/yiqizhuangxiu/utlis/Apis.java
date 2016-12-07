package aiyiqi.bwf.com.yiqizhuangxiu.utlis;

/**
 * Created by LG on 2016/10/14.
 * Tips:
 * 存放网络接口的
 */

public interface Apis {
    //Home上部ViewPager接口
    String HTTP_HOME_VIEWPAGER = "http://appapi.17house.com/AppManagerApi.php?version=1&action=getownerinfo&cityId=2&model=android";

    //Home下方RecycleView的接口
    String HTTP_HOME_RECYCLERVIEW = "http://bbs.17house.com/motnt/index.php?a=appindex&c=index&id={0}&uuid=86305803367590&pageSize=10&uid=1633055&m=misc&type={1}&page={2}&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";

    //建材家居
    String HTTP_BUIDLING_HOME = "http://bbs.17house.com/motnt/index.php?a=product&m=misc&model=android&uuid=a444d1b2af4f&app_version=android_com.aiyiqi.galaxy_1.1";

    //精华Recycleview的接口
    String ESSENCE_RECYCLERVIEW = "http://bbs.17house.com/motnt/index.php?a=allThread&c=forumThreadList&mode=digest&uuid=86305803367590&pageSize=10&m=forum&page=1&haspermission=yes&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1";

    //装修预算装修报价接口
    String ZXYS_WEBVIEW = "http://m.beijing.17house.com/baojia/?sem=android&model=android";

    //装修学堂上部TAG数据接口
    String ZZXT_TAG = " http://appapi.17house.com/StageApi.php?version=1&action=getTagsByStage&stage={0}&model=android";

    //同城活动数据接口
    String HTTP_TONGCHENG = "http://bbs.17house.com/motnt/index.php?a=activityThreadlist&c=forumThreadList&uuid=a444d1b2af4f&pageSize=10&uid=1633055&cityName=%E6%88%90%E9%83%BD&m=forum&page=1&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";

    //设计量房左fragment的接口
    String SJLF_LEFT = "http://hui.17house.com/svc/payment-facade/h5/measureDesignFree/measureFree.html?model=android";

    //设计量房右fragment的接口
    String SJLF_RIGHT = "http://hui.17house.com/svc/payment-facade/h5/measureDesignFree/designFree.html?model=android";

    //自助下单的接口
    String ZZXD = "http://appapi.17house.com/GrouponApi.php?version=1&action=getSingleSupplementInfo&cityId=2&model=android&app_version=android_com.aiyiqi.galaxy_1.1";

    //效果图专题接口
    String EFFECT_TOPIC_LEFT = " http://appapi.17house.com/xiaoguotuApi.php?version=1&page={0}&action=albumList2&pageSize=10&tagid=1&model=android";

    //效果美图接口
    String EFFECT_PICTURE_RIGHT = " http://appapi.17house.com/xiaoguotuApi.php?version=1&page={0}&action=imageList2&pageSize=10&tagid=0&model=android";

    //装修公司界面头部Viewpager的接口
    String HTTP_BUILD_COMPANY_VIEWPAGER = " http://appapi.17house.com/AppManagerApi.php?version=1&action=integratedpackage&model=android&app_version=android_com.aiyiqi.galaxy_1.1";

    //搜索接口
    String SEARCH = "http://bbs.17house.com/motnt/index.php?a=searchForum&c=search&uuid=86305803367590&pageSize=10&m=search&page={0}&haspermission=yes&kw={1}&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1";

    //装修公司的装修直播
    String HTTP_BUILD_COMPANY_LISTVIEW = "http://hui.17house.com/svc/payment-facade/housekeep/listLatestLiveBuildingSites";

    //帖子接口
    String TIE = "http://bbs.17house.com/motnt/index.php?a=viewThread&c=forumThread&imgwidth=330&uuid=86305803367590&tid={0}&m=forum&haspermission=yes&model=android&app_version=android_com.aiyiqi.galaxy_1.1";

    //文章接口


    String HTTP_BUILD_COMPANY_TEAMTOGETHER = "http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteVendors";



    String ARTICLE = " http://appapi.17house.com/NewsApi.php?version=1&newsId={0}&page={1}&action=newsDetail&relatedNum=3&model=android";

    //工地直播基本信息获取
    String HTTP_GDZB = "http://hui.17house.com/svc/payment-facade/housekeep/getLiveBuildingSite";
    

    //工地晒图信息获取
    String HTTP_GDZB_ST = "http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteTrackByProgress";



    //文章评论
    String ARTICLE_COMMENTS = "http://appapi.17house.com/newsApi.php?version=1&page={0}&dataId={1}&action=commentList&limit=10&model=android";

    //装修学堂下部新闻数据接口
    String ZZXT_DOWNNEWS = " http://appapi.17house.com/NewsApi.php?version=1&action=getNewsByStage&stage={0}&page={1}&pagesize=10&model=android";

}