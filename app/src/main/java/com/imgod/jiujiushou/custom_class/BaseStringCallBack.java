package com.imgod.jiujiushou.custom_class;

import android.text.TextUtils;

import com.imgod.jiujiushou.app.Constants;
import com.imgod.jiujiushou.app.JiuJiuShouApplication;
import com.imgod.jiujiushou.response_model.BaseResponse;
import com.imgod.jiujiushou.utils.GsonUtil;
import com.imgod.jiujiushou.utils.ToastUtils;
import com.zhy.http.okhttp.callback.StringCallback;

public abstract class BaseStringCallBack extends StringCallback {
    @Override
    public void onResponse(String response, int id) {
        if (!TextUtils.isEmpty(response)) {
            BaseResponse baseResponse = GsonUtil.GsonToBean(response, BaseResponse.class);
            if (!Constants.REQUEST_STATUS.SUCCESS.equals(baseResponse.getRtnCode()) && baseResponse.getRtnMsg().equals("用户登录失败")) {
                ToastUtils.showToastShort(JiuJiuShouApplication.context, "请重新登陆");

                return;
            }
        }
    }
}
