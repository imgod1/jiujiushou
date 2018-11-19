package com.imgod.jiujiushou.response_model;

public class BaseResponse {


    /**
     * rtnCode : 000000
     * rtnMsg : 成功!
     */

    private String rtnCode;
    private String rtnMsg;

    public String getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getRtnMsg() {
        return rtnMsg;
    }

    public void setRtnMsg(String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }
}
