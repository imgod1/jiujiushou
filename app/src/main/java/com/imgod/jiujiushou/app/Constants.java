package com.imgod.jiujiushou.app;

/**
 * Constants.java是液总汇的类。
 *
 * @author imgod1
 * @version 2.0.0 2018/7/6 16:56
 * @update imgod1 2018/7/6 16:56
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class Constants {
    public static final String JIUJIUSHOU_KEY = "dabf5323e55a498a8518bebd56f5a46f";
    public static String TOKEN_KEY = "token";
    public static String TOKEN = "";
    public static String CHANNELID_KEY = "channelid";
    public static String CHANNELID = "OP0001";
    public static String TXNTIME_KEY = "txntime";
    public static String SIGN_KEY = "sign";

    public interface REQUEST_STATUS {
        String SUCCESS = "000000";
        String GET_TASK_NO_SOTCK = "100005";//没库存
        String GET_TASK_ERROR = "010034";//差一点就获取成功
        String GET_TASK_FREQUENTLY = "899991";//获取订单频繁
    }

    //运营商类型
    public interface OPERATOR_TYPE {
        String DEFAULT = "";//默认 不限制运营商
        String MOBILE = "1";//中国移动
        String UNICOM = "2";//中国联通
        String TELECOM = "3";//中国电信
    }

    //省份列表
    public static String[] PROVINCE_ARRAY = {
            "不限",
            "山东", "江苏", "四川", "陕西", "湖北", "北京", "天津",
            "上海", "广东", "广西", "浙江", "河南", "甘肃", "吉林",
            "辽宁", "内蒙古", "新疆", "黑龙江", "福建", "河北", "重庆",
            "安徽", "海南", "江西", "山西", "湖南", "青海", "贵州", "宁夏",
            "云南", "西藏", "台湾", "香港", "澳门"
    };

    //话费面额
    public static int[] AMOUNT_ARRAY = {
            30, 50, 100, 200, 300, 500
    };

    //报单的时候的充值类型
    public interface RECHARGE_TYPE {
        int SUCCESS = 1;//成功下单并充值成功
        int FAILED = 2;//下单失败 我没充 尽量让用户反复确认
    }

}
