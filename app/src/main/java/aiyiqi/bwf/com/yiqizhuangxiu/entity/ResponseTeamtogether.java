package aiyiqi.bwf.com.yiqizhuangxiu.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/1.
 */

public class ResponseTeamtogether {

    /**
     * code : 0
     * message : success
     */

    private BaseOutputBean baseOutput;
    /**
     * pageNo : 0
     * pageSize : 10
     * pageTotalNum : 102
     */

    private PageInfoBean pageInfo;
    /**
     * vendorId : 27
     * vendorName : 朱文君
     * realName : 朱文君
     * nickName : 朱文君
     * avatar : http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/1476267743611661027
     * lifePhoto : http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/1476267780017840660
     * signature : 坚持用设计服务生活
     * provinceId : 12
     * workYear : 2009
     * goodAt : 现代 北欧 现代简约 简欧
     * updateTime : 1455849695000
     * vendorAccount : 18610125383
     * bossId : 1701
     * storeId : 1717
     * storeName : 一起网服务
     * provinceName : 安徽省
     * workTimeSpan : 7
     * caseNumber : 18
     * messageNumber : 0
     * sponsorNumber : 0
     * rating : 5
     * registerTime : 1455849663000
     * commentCount : 0
     */

    private List<DataBean> data;

    public BaseOutputBean getBaseOutput() {
        return baseOutput;
    }

    public void setBaseOutput(BaseOutputBean baseOutput) {
        this.baseOutput = baseOutput;
    }

    public PageInfoBean getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoBean pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class BaseOutputBean {
        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class PageInfoBean {
        private int pageNo;
        private int pageSize;
        private int pageTotalNum;

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageTotalNum() {
            return pageTotalNum;
        }

        public void setPageTotalNum(int pageTotalNum) {
            this.pageTotalNum = pageTotalNum;
        }
    }

    public static class DataBean {
        private int vendorId;
        private String vendorName;
        private String realName;
        private String nickName;
        private String avatar;
        private String lifePhoto;
        private String signature;
        private int provinceId;
        private int workYear;
        private String goodAt;
        private long updateTime;
        private String vendorAccount;
        private int bossId;
        private int storeId;
        private String storeName;
        private String provinceName;
        private int workTimeSpan;
        private int caseNumber;
        private int messageNumber;
        private int sponsorNumber;
        private int rating;
        private long registerTime;
        private int commentCount;

        public int getVendorId() {
            return vendorId;
        }

        public void setVendorId(int vendorId) {
            this.vendorId = vendorId;
        }

        public String getVendorName() {
            return vendorName;
        }

        public void setVendorName(String vendorName) {
            this.vendorName = vendorName;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getLifePhoto() {
            return lifePhoto;
        }

        public void setLifePhoto(String lifePhoto) {
            this.lifePhoto = lifePhoto;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(int provinceId) {
            this.provinceId = provinceId;
        }

        public int getWorkYear() {
            return workYear;
        }

        public void setWorkYear(int workYear) {
            this.workYear = workYear;
        }

        public String getGoodAt() {
            return goodAt;
        }

        public void setGoodAt(String goodAt) {
            this.goodAt = goodAt;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public String getVendorAccount() {
            return vendorAccount;
        }

        public void setVendorAccount(String vendorAccount) {
            this.vendorAccount = vendorAccount;
        }

        public int getBossId() {
            return bossId;
        }

        public void setBossId(int bossId) {
            this.bossId = bossId;
        }

        public int getStoreId() {
            return storeId;
        }

        public void setStoreId(int storeId) {
            this.storeId = storeId;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public int getWorkTimeSpan() {
            return workTimeSpan;
        }

        public void setWorkTimeSpan(int workTimeSpan) {
            this.workTimeSpan = workTimeSpan;
        }

        public int getCaseNumber() {
            return caseNumber;
        }

        public void setCaseNumber(int caseNumber) {
            this.caseNumber = caseNumber;
        }

        public int getMessageNumber() {
            return messageNumber;
        }

        public void setMessageNumber(int messageNumber) {
            this.messageNumber = messageNumber;
        }

        public int getSponsorNumber() {
            return sponsorNumber;
        }

        public void setSponsorNumber(int sponsorNumber) {
            this.sponsorNumber = sponsorNumber;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public long getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(long registerTime) {
            this.registerTime = registerTime;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }
    }
}
