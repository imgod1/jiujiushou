package com.imgod.jiujiushou;

/**
 * API.java是液总汇的类。
 *
 * @author imgod1
 * @version 2.0.0 2018/7/6 16:15
 * @update imgod1 2018/7/6 16:15
 * @updateDes 文档地址:http://www.mf178.cn/themes/default/%E8%9C%9C%E8%9C%82%E8%AF%9D%E8%B4%B9%E6%8E%A5%E5%8F%A3-%E9%80%9A%E7%94%A8.txt
 * @include {@link }
 * @used {@link }
 */
public interface API {
    //地址
    String BASE_URL = "http://99shou.cn/api/";

    //action类型
    String LOGIN_URL = "user-server/user/login";
    String GET_ORDER_URL = "phonecharge-server/phonecharge/phone/receive";
    String REPORT_URL = "phonecharge-server/phonecharge/phone/report";
    String REPORT_CLOSE_URL = "phonecharge-server/phonecharge/phone/close";
    String GET_DOING_ORDER_URL = "phonecharge-server/phonecharge/phone/orders/doing";
}
