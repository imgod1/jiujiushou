package com.imgod.jiujiushou.request_model;

/**
 * ReportModel.java是液总汇的类。
 *
 * @author imgod1
 * @version 2.0.0 2018/7/9 9:31
 * @update imgod1 2018/7/9 9:31
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class ReportModel extends BaseRequestModel {

   private String orderId;
   private String imgBase64;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }
}
