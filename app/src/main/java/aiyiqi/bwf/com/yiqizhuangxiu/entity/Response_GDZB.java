package aiyiqi.bwf.com.yiqizhuangxiu.entity;

import java.util.List;

/**
 * Created by Yishi on 2016/11/29.
 */
public class Response_GDZB {

    /**
     * code : 0
     * message : success
     */

    private BaseOutputBean baseOutput;
    /**
     * buildingSite : {"buildingId":1535476603258159617,"statusId":0,"progressId":1,"acceptanceProgressId":0,"orderId":1535476603258159617,"createTime":1476791047000,"updateTime":1480221378000,"userId":1535476603258159616,"startDisclosure":1,"startDisclosureTime":1476791047000,"splitAlter":0,"splitAlterTime":1476791047000,"waterElectricity":0,"waterElectricityTime":1476791047000,"cementWood":0,"cementWoodTime":1476791047000,"paint":0,"paintTime":1476791047000,"installation":0,"installationTime":1476791047000,"finish":0,"finishTime":1476791047000,"buildingIdStr":"","acceptanceStatus":0,"bespeakExpired":0,"messageNumber":0,"scheduleStatus":0,"isShow":1}
     * orderHouse : {"orderId":1535476603258159617,"layout":"二室一厅一卫一厨","area":"71.3","doorplate":"26-6-501","community":"石景山区苹果园一区","address":"石景山区苹果园一区26-6-501","newHouse":0,"deliveryHouse":2,"lng":116.192195,"lat":39.930775}
     * userDetail : {"userId":1535476603258159616,"realName":"手机用户_1371560","nickName":"手机用户_1371560","avatar":"http://bbs.17house.com/uc_server/avatar.php?uid=1371560&size=big","gender":0,"emailVerified":0,"provinceId":0,"cityId":0,"districtId":0,"userPoint":10,"userLevel":0,"hasOrder":0,"updateTime":1480371122000,"userPointIncrement":10,"userPointDate":1480369647000,"mobile":"13681124602","userType":0}
     * imageUrl : http://apptest-picture.oss-cn-beijing.aliyuncs.com/yiqizhuagnxiu-gongdizhibo/tu10.png
     * members : [{"vendorId":1538457886020100291,"vendorName":"颜晨匣","realName":"颜晨匣","nickName":"颜晨匣","avatar":"http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/4e0e1b8f-33ad-4927-a1be-30d9b652c89b","lifePhoto":"http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/bff65d0f-6649-4a2d-991c-e443f6886b91","signature":"擅长风格: 欧式，田园，简约\n设计理念: 简约不简单，适合自己得才是最好的！","provinceId":3,"workYear":2012,"goodAt":"欧式,现代简约,北欧,新中式","updateTime":1467187773000,"bossId":1701},{"vendorId":229,"vendorName":"李建山","realName":"李建山","nickName":"李建山","avatar":"http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/b8081e7f-7f4c-42d9-93e5-c8b6392cd9ad","lifePhoto":"http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/b243900d-1ab3-405a-97ba-c0416e9d7884","signature":"专业监理","provinceId":0,"workYear":2000,"updateTime":1455848903000,"bossId":1702},{"vendorId":1543702945059586996,"vendorName":"程仪兵","realName":"程仪兵","nickName":"程仪兵","avatar":"http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/7631f045-f5b0-4c3a-a1ac-95631c36d337","lifePhoto":"http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/fb311aad-946b-4ae2-a282-34cd61482211","signature":"性格开朗！心直口快！不喜欢拐弯抹角。","provinceId":12,"workYear":1989,"goodAt":"现代","updateTime":1472189851000,"bossId":1703},{"vendorId":327,"vendorName":"关键","realName":"关键","nickName":"关键","avatar":"http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/ef47bf46-6dd6-446e-9564-a450a8a62543","lifePhoto":"http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/a6fd9e02-da26-4e46-bc40-a5e39642f47d","signature":"1","provinceId":8,"workYear":2016,"updateTime":1460440500000,"bossId":1705}]
     * progress : [{"progressId":1,"progressName":"开工","progressStatus":1,"createTime":1476791047000},{"progressId":2,"progressName":"拆改","progressStatus":0,"createTime":1476791047000},{"progressId":3,"progressName":"水电","progressStatus":0,"createTime":1476791047000},{"progressId":4,"progressName":"泥木","progressStatus":0,"createTime":1476791047000},{"progressId":5,"progressName":"油漆","progressStatus":0,"createTime":1476791047000},{"progressId":6,"progressName":"安装","progressStatus":0,"createTime":1476791047000},{"progressId":7,"progressName":"竣工","progressStatus":0,"createTime":1476791047000}]
     * latestTrackProgressId : 1
     */

    private DataBean data;

    public BaseOutputBean getBaseOutput() {
        return baseOutput;
    }

    public void setBaseOutput(BaseOutputBean baseOutput) {
        this.baseOutput = baseOutput;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

    public static class DataBean {
        /**
         * buildingId : 1535476603258159617
         * statusId : 0
         * progressId : 1
         * acceptanceProgressId : 0
         * orderId : 1535476603258159617
         * createTime : 1476791047000
         * updateTime : 1480221378000
         * userId : 1535476603258159616
         * startDisclosure : 1
         * startDisclosureTime : 1476791047000
         * splitAlter : 0
         * splitAlterTime : 1476791047000
         * waterElectricity : 0
         * waterElectricityTime : 1476791047000
         * cementWood : 0
         * cementWoodTime : 1476791047000
         * paint : 0
         * paintTime : 1476791047000
         * installation : 0
         * installationTime : 1476791047000
         * finish : 0
         * finishTime : 1476791047000
         * buildingIdStr :
         * acceptanceStatus : 0
         * bespeakExpired : 0
         * messageNumber : 0
         * scheduleStatus : 0
         * isShow : 1
         */

        private BuildingSiteBean buildingSite;
        /**
         * orderId : 1535476603258159617
         * layout : 二室一厅一卫一厨
         * area : 71.3
         * doorplate : 26-6-501
         * community : 石景山区苹果园一区
         * address : 石景山区苹果园一区26-6-501
         * newHouse : 0
         * deliveryHouse : 2
         * lng : 116.192195
         * lat : 39.930775
         */

        private OrderHouseBean orderHouse;
        /**
         * userId : 1535476603258159616
         * realName : 手机用户_1371560
         * nickName : 手机用户_1371560
         * avatar : http://bbs.17house.com/uc_server/avatar.php?uid=1371560&size=big
         * gender : 0
         * emailVerified : 0
         * provinceId : 0
         * cityId : 0
         * districtId : 0
         * userPoint : 10
         * userLevel : 0
         * hasOrder : 0
         * updateTime : 1480371122000
         * userPointIncrement : 10
         * userPointDate : 1480369647000
         * mobile : 13681124602
         * userType : 0
         */

        private UserDetailBean userDetail;
        private String imageUrl;
        private int latestTrackProgressId;
        /**
         * vendorId : 1538457886020100291
         * vendorName : 颜晨匣
         * realName : 颜晨匣
         * nickName : 颜晨匣
         * avatar : http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/4e0e1b8f-33ad-4927-a1be-30d9b652c89b
         * lifePhoto : http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/bff65d0f-6649-4a2d-991c-e443f6886b91
         * signature : 擅长风格: 欧式，田园，简约
         设计理念: 简约不简单，适合自己得才是最好的！
         * provinceId : 3
         * workYear : 2012
         * goodAt : 欧式,现代简约,北欧,新中式
         * updateTime : 1467187773000
         * bossId : 1701
         */

        private List<MembersBean> members;
        /**
         * progressId : 1
         * progressName : 开工
         * progressStatus : 1
         * createTime : 1476791047000
         */

        private List<ProgressBean> progress;

        public BuildingSiteBean getBuildingSite() {
            return buildingSite;
        }

        public void setBuildingSite(BuildingSiteBean buildingSite) {
            this.buildingSite = buildingSite;
        }

        public OrderHouseBean getOrderHouse() {
            return orderHouse;
        }

        public void setOrderHouse(OrderHouseBean orderHouse) {
            this.orderHouse = orderHouse;
        }

        public UserDetailBean getUserDetail() {
            return userDetail;
        }

        public void setUserDetail(UserDetailBean userDetail) {
            this.userDetail = userDetail;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getLatestTrackProgressId() {
            return latestTrackProgressId;
        }

        public void setLatestTrackProgressId(int latestTrackProgressId) {
            this.latestTrackProgressId = latestTrackProgressId;
        }

        public List<MembersBean> getMembers() {
            return members;
        }

        public void setMembers(List<MembersBean> members) {
            this.members = members;
        }

        public List<ProgressBean> getProgress() {
            return progress;
        }

        public void setProgress(List<ProgressBean> progress) {
            this.progress = progress;
        }

        public static class BuildingSiteBean {
            private long buildingId;
            private int statusId;
            private int progressId;
            private int acceptanceProgressId;
            private long orderId;
            private long createTime;
            private long updateTime;
            private long userId;
            private int startDisclosure;
            private long startDisclosureTime;
            private int splitAlter;
            private long splitAlterTime;
            private int waterElectricity;
            private long waterElectricityTime;
            private int cementWood;
            private long cementWoodTime;
            private int paint;
            private long paintTime;
            private int installation;
            private long installationTime;
            private int finish;
            private long finishTime;
            private String buildingIdStr;
            private int acceptanceStatus;
            private int bespeakExpired;
            private int messageNumber;
            private int scheduleStatus;
            private int isShow;

            public long getBuildingId() {
                return buildingId;
            }

            public void setBuildingId(long buildingId) {
                this.buildingId = buildingId;
            }

            public int getStatusId() {
                return statusId;
            }

            public void setStatusId(int statusId) {
                this.statusId = statusId;
            }

            public int getProgressId() {
                return progressId;
            }

            public void setProgressId(int progressId) {
                this.progressId = progressId;
            }

            public int getAcceptanceProgressId() {
                return acceptanceProgressId;
            }

            public void setAcceptanceProgressId(int acceptanceProgressId) {
                this.acceptanceProgressId = acceptanceProgressId;
            }

            public long getOrderId() {
                return orderId;
            }

            public void setOrderId(long orderId) {
                this.orderId = orderId;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public int getStartDisclosure() {
                return startDisclosure;
            }

            public void setStartDisclosure(int startDisclosure) {
                this.startDisclosure = startDisclosure;
            }

            public long getStartDisclosureTime() {
                return startDisclosureTime;
            }

            public void setStartDisclosureTime(long startDisclosureTime) {
                this.startDisclosureTime = startDisclosureTime;
            }

            public int getSplitAlter() {
                return splitAlter;
            }

            public void setSplitAlter(int splitAlter) {
                this.splitAlter = splitAlter;
            }

            public long getSplitAlterTime() {
                return splitAlterTime;
            }

            public void setSplitAlterTime(long splitAlterTime) {
                this.splitAlterTime = splitAlterTime;
            }

            public int getWaterElectricity() {
                return waterElectricity;
            }

            public void setWaterElectricity(int waterElectricity) {
                this.waterElectricity = waterElectricity;
            }

            public long getWaterElectricityTime() {
                return waterElectricityTime;
            }

            public void setWaterElectricityTime(long waterElectricityTime) {
                this.waterElectricityTime = waterElectricityTime;
            }

            public int getCementWood() {
                return cementWood;
            }

            public void setCementWood(int cementWood) {
                this.cementWood = cementWood;
            }

            public long getCementWoodTime() {
                return cementWoodTime;
            }

            public void setCementWoodTime(long cementWoodTime) {
                this.cementWoodTime = cementWoodTime;
            }

            public int getPaint() {
                return paint;
            }

            public void setPaint(int paint) {
                this.paint = paint;
            }

            public long getPaintTime() {
                return paintTime;
            }

            public void setPaintTime(long paintTime) {
                this.paintTime = paintTime;
            }

            public int getInstallation() {
                return installation;
            }

            public void setInstallation(int installation) {
                this.installation = installation;
            }

            public long getInstallationTime() {
                return installationTime;
            }

            public void setInstallationTime(long installationTime) {
                this.installationTime = installationTime;
            }

            public int getFinish() {
                return finish;
            }

            public void setFinish(int finish) {
                this.finish = finish;
            }

            public long getFinishTime() {
                return finishTime;
            }

            public void setFinishTime(long finishTime) {
                this.finishTime = finishTime;
            }

            public String getBuildingIdStr() {
                return buildingIdStr;
            }

            public void setBuildingIdStr(String buildingIdStr) {
                this.buildingIdStr = buildingIdStr;
            }

            public int getAcceptanceStatus() {
                return acceptanceStatus;
            }

            public void setAcceptanceStatus(int acceptanceStatus) {
                this.acceptanceStatus = acceptanceStatus;
            }

            public int getBespeakExpired() {
                return bespeakExpired;
            }

            public void setBespeakExpired(int bespeakExpired) {
                this.bespeakExpired = bespeakExpired;
            }

            public int getMessageNumber() {
                return messageNumber;
            }

            public void setMessageNumber(int messageNumber) {
                this.messageNumber = messageNumber;
            }

            public int getScheduleStatus() {
                return scheduleStatus;
            }

            public void setScheduleStatus(int scheduleStatus) {
                this.scheduleStatus = scheduleStatus;
            }

            public int getIsShow() {
                return isShow;
            }

            public void setIsShow(int isShow) {
                this.isShow = isShow;
            }
        }

        public static class OrderHouseBean {
            private long orderId;
            private String layout;
            private String area;
            private String doorplate;
            private String community;
            private String address;
            private int newHouse;
            private int deliveryHouse;
            private double lng;
            private double lat;

            public long getOrderId() {
                return orderId;
            }

            public void setOrderId(long orderId) {
                this.orderId = orderId;
            }

            public String getLayout() {
                return layout;
            }

            public void setLayout(String layout) {
                this.layout = layout;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getDoorplate() {
                return doorplate;
            }

            public void setDoorplate(String doorplate) {
                this.doorplate = doorplate;
            }

            public String getCommunity() {
                return community;
            }

            public void setCommunity(String community) {
                this.community = community;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getNewHouse() {
                return newHouse;
            }

            public void setNewHouse(int newHouse) {
                this.newHouse = newHouse;
            }

            public int getDeliveryHouse() {
                return deliveryHouse;
            }

            public void setDeliveryHouse(int deliveryHouse) {
                this.deliveryHouse = deliveryHouse;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }

        public static class UserDetailBean {
            private long userId;
            private String realName;
            private String nickName;
            private String avatar;
            private int gender;
            private int emailVerified;
            private int provinceId;
            private int cityId;
            private int districtId;
            private int userPoint;
            private int userLevel;
            private int hasOrder;
            private long updateTime;
            private int userPointIncrement;
            private long userPointDate;
            private String mobile;
            private int userType;

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
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

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getEmailVerified() {
                return emailVerified;
            }

            public void setEmailVerified(int emailVerified) {
                this.emailVerified = emailVerified;
            }

            public int getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(int provinceId) {
                this.provinceId = provinceId;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public int getDistrictId() {
                return districtId;
            }

            public void setDistrictId(int districtId) {
                this.districtId = districtId;
            }

            public int getUserPoint() {
                return userPoint;
            }

            public void setUserPoint(int userPoint) {
                this.userPoint = userPoint;
            }

            public int getUserLevel() {
                return userLevel;
            }

            public void setUserLevel(int userLevel) {
                this.userLevel = userLevel;
            }

            public int getHasOrder() {
                return hasOrder;
            }

            public void setHasOrder(int hasOrder) {
                this.hasOrder = hasOrder;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public int getUserPointIncrement() {
                return userPointIncrement;
            }

            public void setUserPointIncrement(int userPointIncrement) {
                this.userPointIncrement = userPointIncrement;
            }

            public long getUserPointDate() {
                return userPointDate;
            }

            public void setUserPointDate(long userPointDate) {
                this.userPointDate = userPointDate;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }
        }

        public static class MembersBean {
            private long vendorId;
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
            private int bossId;

            public long getVendorId() {
                return vendorId;
            }

            public void setVendorId(long vendorId) {
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

            public int getBossId() {
                return bossId;
            }

            public void setBossId(int bossId) {
                this.bossId = bossId;
            }
        }

        public static class ProgressBean {
            private int progressId;
            private String progressName;
            private int progressStatus;
            private long createTime;

            public int getProgressId() {
                return progressId;
            }

            public void setProgressId(int progressId) {
                this.progressId = progressId;
            }

            public String getProgressName() {
                return progressName;
            }

            public void setProgressName(String progressName) {
                this.progressName = progressName;
            }

            public int getProgressStatus() {
                return progressStatus;
            }

            public void setProgressStatus(int progressStatus) {
                this.progressStatus = progressStatus;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }
        }
    }
}
