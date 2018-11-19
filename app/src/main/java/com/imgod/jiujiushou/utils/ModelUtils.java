package com.imgod.jiujiushou.utils;

import com.imgod.jiujiushou.app.Constants;
import com.imgod.jiujiushou.request_model.BaseRequestModel;

public class ModelUtils {
    public static String getModelSign(BaseRequestModel baseRequestModel, String time) {
        StringBuilder stringBuilder = new StringBuilder();
        String contentJson = GsonUtil.GsonString(baseRequestModel);
        stringBuilder.append(contentJson);
        stringBuilder.append(Constants.JIUJIUSHOU_KEY);
        stringBuilder.append(time);
        String md5Sign = MD5Utils.EncoderByMD5(stringBuilder.toString());
        return md5Sign;
    }
}
