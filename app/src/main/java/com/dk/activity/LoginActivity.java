package com.dk.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dk.R;
import com.dk.utils.Code;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ${chenyn} on 2017/10/9.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText mEt_securityCode, mEt_smsCode, mEt_phone;
    private ImageView mIv_showSecurityCode;
    private TextView mGetSmsCode;
    private String mRealCode;
    private int mTimess;
    private TimerTask mTimerTask;
    private Timer mTimer;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        mEt_phone = findViewById(R.id.et_phone);
        mEt_securityCode = findViewById(R.id.et_securityCode);
        mEt_smsCode = findViewById(R.id.et_smsCode);
        mGetSmsCode = findViewById(R.id.tv_getSmsCode);
        mIv_showSecurityCode = findViewById(R.id.iv_showSecurityCode);
        //将验证码用图片的形式显示出来
        mIv_showSecurityCode.setImageBitmap(Code.getInstance().createBitmap());
        mRealCode = Code.getInstance().getCode().toLowerCase();
        findViewById(R.id.btn_login).setOnClickListener(this);
        mIv_showSecurityCode.setOnClickListener(this);
        mGetSmsCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String phoneNum = mEt_phone.getText().toString();
        switch (v.getId()) {
            case R.id.iv_showSecurityCode:
                mIv_showSecurityCode.setImageBitmap(Code.getInstance().createBitmap());
                mRealCode = Code.getInstance().getCode().toLowerCase();
                break;
            case R.id.btn_login:
                if (TextUtils.isEmpty(phoneNum)) {
                    Toast.makeText(LoginActivity.this, "请输入手机号码", Toast.LENGTH_SHORT).show();
                    return;
                }

                String securityCode = mEt_securityCode.getText().toString().toLowerCase();
                if (TextUtils.isEmpty(securityCode)) {
                    Toast.makeText(LoginActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                    return;
                }

                String smsCode = mEt_smsCode.getText().toString();
                if (TextUtils.isEmpty(smsCode)) {
                    Toast.makeText(LoginActivity.this, "请输入短信验证码", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (securityCode.equals(mRealCode)) {//验证码正确
                    progressDialog.setTitle("正在验证...");
                    progressDialog.show();
                    //短信验证码
//                    SMSSDK.getInstance().checkSmsCodeAsyn(phoneNum.trim(), smsCode.trim(), new SmscheckListener() {
//                        @Override
//                        public void checkCodeSuccess(final String code) {
//                            if (progressDialog != null && progressDialog.isShowing()) {
//                                progressDialog.dismiss();
//                            }
//                            Toast.makeText(LoginActivity.this, code, Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void checkCodeFail(int errCode, final String errmsg) {
//                            if (progressDialog != null && progressDialog.isShowing()) {
//                                progressDialog.dismiss();
//                            }
//                            HandleResponseCode.onHandle(LoginActivity.this, errCode);
//                        }
//                    });
                } else {//验证码错误
                    Toast.makeText(LoginActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.tv_getSmsCode:
                if (TextUtils.isEmpty(phoneNum)) {
                    Toast.makeText(LoginActivity.this, "请输入手机号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                mGetSmsCode.setClickable(false);
                //开始倒计时
                startTimer();
//                SMSSDK.getInstance().getSmsCodeAsyn(phoneNum.trim(), 1 + "", new SmscodeListener() {
//                    @Override
//                    public void getCodeSuccess(final String uuid) {
//                        Toast.makeText(LoginActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void getCodeFail(int errCode, final String errmsg) {
//                        //失败后停止计时
//                        stopTimer();
//                        HandleResponseCode.onHandle(LoginActivity.this, errCode);
//                    }
//                });
                break;
        }
    }

    private void startTimer() {
//        mTimess = (int) (SMSSDK.getInstance().getIntervalTime() / 1000);
        mGetSmsCode.setText(mTimess + "s");
        if (mTimerTask == null) {
            mTimerTask = new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTimess--;
                            if (mTimess <= 0) {
                                stopTimer();
                                return;
                            }
                            mGetSmsCode.setText(mTimess + "s");
                        }
                    });
                }
            };
        }
        if (mTimer == null) {
            mTimer = new Timer();
        }
        mTimer.schedule(mTimerTask, 1000, 1000);
    }

    private void stopTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        if (mTimerTask != null) {
            mTimerTask.cancel();
            mTimerTask = null;
        }
        mGetSmsCode.setText("重新获取");
        mGetSmsCode.setClickable(true);
    }
}
