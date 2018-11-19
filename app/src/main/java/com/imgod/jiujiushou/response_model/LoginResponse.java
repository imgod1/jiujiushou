package com.imgod.jiujiushou.response_model;

public class LoginResponse extends BaseResponse {

    /**
     * rtnData : {"token":"bce50261a8d24586a705648021417b2f"}
     */

    private RtnDataBean rtnData;

    public RtnDataBean getRtnData() {
        return rtnData;
    }

    public void setRtnData(RtnDataBean rtnData) {
        this.rtnData = rtnData;
    }

    public static class RtnDataBean {
        /**
         * token : bce50261a8d24586a705648021417b2f
         */

        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
