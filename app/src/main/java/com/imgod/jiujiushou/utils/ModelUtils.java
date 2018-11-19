package com.imgod.jiujiushou.utils;

import com.imgod.jiujiushou.request_model.BaseRequestModel;

public class ModelUtils {
    public static void initModelSign(BaseRequestModel baseRequestModel) {
        String sign = SignUtils.getSortedKeyStringFromObject(baseRequestModel);
        String md5Sign = MD5Utils.EncoderByMD5(sign);
        baseRequestModel.setSign(md5Sign);
    }
}
