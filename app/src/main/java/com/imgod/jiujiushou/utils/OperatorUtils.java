package com.imgod.jiujiushou.utils;

import android.text.TextUtils;

/**
 * OperatorUtils.java是液总汇的类。
 *
 * @author imgod1
 * @version 2.0.0 2018/7/9 10:53
 * @update imgod1 2018/7/9 10:53
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class OperatorUtils {
    public static String getOperatorNameByType(String operator) {
        if (TextUtils.isEmpty(operator)) {
            return "不限";
        }
        return operator;
    }
}
