package com.imgod.jiujiushou.response_model;

import java.util.List;

/**
 * RechargingResponse.java是液总汇的类。
 *
 * @author imgod1
 * @version 2.0.0 2018/7/9 14:12
 * @update imgod1 2018/7/9 14:12
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class RechargingResponse extends BaseResponse {


    private List<RtnDataBean> rtnData;

    public List<RtnDataBean> getRtnData() {
        return rtnData;
    }

    public void setRtnData(List<RtnDataBean> rtnData) {
        this.rtnData = rtnData;
    }

    public static class RtnDataBean {
        /**
         * id : 4233988
         * addtime : 2018-11-19 16:44:52
         * querytime : 2018-11-19 16:47:07
         * prov : 山东省
         * phoneChannel : 1
         * phoneFacevalue : 50
         * phoneNo : 15163950301
         * phoneBalance : 4.1
         * phoneBalanceAfter : 4.1
         * status : 0
         * feerate : 98.5
         * amount : 49.25
         * note :
         */

        private long id;
        private String addtime;
        private String querytime;
        private String prov;
        private int phoneChannel;
        private double phoneFacevalue;
        private String phoneNo;
        private double phoneBalance;
        private double phoneBalanceAfter;
        private int status;
        private double feerate;
        private double amount;
        private String note;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getQuerytime() {
            return querytime;
        }

        public void setQuerytime(String querytime) {
            this.querytime = querytime;
        }

        public String getProv() {
            return prov;
        }

        public void setProv(String prov) {
            this.prov = prov;
        }

        public int getPhoneChannel() {
            return phoneChannel;
        }

        public void setPhoneChannel(int phoneChannel) {
            this.phoneChannel = phoneChannel;
        }

        public double getPhoneFacevalue() {
            return phoneFacevalue;
        }

        public void setPhoneFacevalue(double phoneFacevalue) {
            this.phoneFacevalue = phoneFacevalue;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public double getPhoneBalance() {
            return phoneBalance;
        }

        public void setPhoneBalance(double phoneBalance) {
            this.phoneBalance = phoneBalance;
        }

        public double getPhoneBalanceAfter() {
            return phoneBalanceAfter;
        }

        public void setPhoneBalanceAfter(double phoneBalanceAfter) {
            this.phoneBalanceAfter = phoneBalanceAfter;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public double getFeerate() {
            return feerate;
        }

        public void setFeerate(double feerate) {
            this.feerate = feerate;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }
    }
}
