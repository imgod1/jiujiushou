package com.imgod.jiujiushou;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.imgod.jiujiushou.app.Constants;
import com.imgod.jiujiushou.request_model.LoginModel;
import com.imgod.jiujiushou.response_model.LoginResponse;
import com.imgod.jiujiushou.utils.GsonUtil;
import com.imgod.jiujiushou.utils.LogUtils;
import com.imgod.jiujiushou.utils.SPUtils;
import com.imgod.jiujiushou.utils.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.MediaType;

public class LoginActivity extends BaseActivity {

    private EditText etv_phone;
    private EditText etv_pwd;
    private CheckBox cbox_auto_login;
    //    private EditText etv_img_code;
//    private ImageView iv_code;
    private View mLoginFormView;


    public static void actionStart(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        etv_phone = (EditText) findViewById(R.id.etv_phone);
        etv_pwd = (EditText) findViewById(R.id.etv_pwd);
        cbox_auto_login = findViewById(R.id.cbox_auto_login);
//        etv_img_code = findViewById(R.id.etv_img_code);
//        iv_code = findViewById(R.id.iv_code);
        etv_pwd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

//        iv_code.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });


        Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
//                LogUtils.e("onClick", MD5Utils.EncoderByMD5("123456"));
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        initEvent();
    }

    public static final String SP_PHONE = "phone";
    public static final String SP_PASSWORD = "password";

    private void initEvent() {
        String phone = SPUtils.getInstance().getString(SP_PHONE);
        String password = SPUtils.getInstance().getString(SP_PASSWORD);
        //判断是否设置了自动登录 保存标志位
        if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(password)) {
            //请求登录的逻辑
            requestLogin(phone, password);
        }
    }


    private void attemptLogin() {

        // Reset errors.
        etv_phone.setError(null);
        etv_pwd.setError(null);
//        etv_img_code.setError(null);
        // Store values at the time of the login attempt.
        String phone = etv_phone.getText().toString();
        String password = etv_pwd.getText().toString();
//        String imgCode = etv_img_code.getText().toString();
        // Check for a valid phone address.
        if (TextUtils.isEmpty(phone)) {
            etv_phone.setError(getString(R.string.error_phone_required));
            etv_phone.requestFocus();
            return;
        } else if (!isPhoneValid(phone)) {
            etv_phone.setError(getString(R.string.error_invalid_phone));
            etv_phone.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etv_pwd.setError(getString(R.string.error_invalid_password));
            etv_pwd.requestFocus();
            return;
        } else if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            etv_pwd.setError(getString(R.string.error_invalid_password));
            etv_pwd.requestFocus();
            return;
        }
//        if (TextUtils.isEmpty(imgCode)) {
//            etv_img_code.setError(getString(R.string.error_invalid_img_code));
//            etv_img_code.requestFocus();
//            return;
//        } else if (!TextUtils.isEmpty(imgCode) && !isPasswordValid(imgCode)) {
//            etv_img_code.setError(getString(R.string.error_invalid_img_code));
//            etv_img_code.requestFocus();
//            return;
//        }

        //判断是否设置了自动登录 保存标志位
        if (cbox_auto_login.isChecked()) {
            SPUtils.getInstance().put(SP_PHONE, phone);
            SPUtils.getInstance().put(SP_PASSWORD, password);
        } else {//不自动登录的话 那就清空之前的存储信息
            SPUtils.getInstance().clear();
        }
        //请求登录的逻辑
        requestLogin(phone, password);
    }

    //清空登录数据
    public static void clearLoginData() {
        SPUtils.getInstance().put(SP_PHONE, "");
        SPUtils.getInstance().put(SP_PASSWORD, "");
    }


    private boolean isPhoneValid(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return false;
        } else {
            if (phone.length() == 11) {
                return true;
            }
        }
        return false;
    }

    private boolean isPasswordValid(String password) {
        return !TextUtils.isEmpty(password);
    }

    /**
     * 请求登录服务器
     *
     * @param phone 账号
     * @param pwd   密码
     */
    private void requestLogin(String phone, String pwd) {
        showProgressDialog();
        LoginModel loginModel = new LoginModel();
        loginModel.setUsername(phone);
        loginModel.setPassword(pwd);
        OkHttpUtils
                .postString()
                .url(API.BASE_URL + API.LOGIN_URL)
                .content(GsonUtil.GsonString(loginModel))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        hideProgressDialog();
                        LogUtils.e("onError", e.getMessage());
                        ToastUtils.showToastShort(LoginActivity.this, "登录失败:" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        hideProgressDialog();
                        LogUtils.e("onResponse", response);
                        LoginResponse loginResponse = GsonUtil.GsonToBean(response, LoginResponse.class);
                        if (null != loginResponse) {
                            if (Constants.REQUEST_STATUS.SUCCESS.equals(loginResponse.getRtnCode())) {
                                Constants.TOKEN = loginResponse.getRtnData().getToken();
                                ToastUtils.showToastShort(LoginActivity.this, "登录成功");
                                MainActivity.actionStart(LoginActivity.this);
                                finish();
                            } else {
                                ToastUtils.showToastShort(LoginActivity.this, loginResponse.getRtnMsg());
                            }
                        }
                    }
                });
    }
}

