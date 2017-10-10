package com.dk.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ${chenyn} on 2017/10/9.
 *
 * @desc 全部状态码返回toast
 */

public class HandleResponseCode {

    public static void onHandle(Context context, int statusCode) {
        Toast toast = new Toast(context);
        switch (statusCode) {
            case 0:
                break;
            case 3001:
                toast.setText("请求超时");
                break;
            case 3002:
                toast.setText("无效的手机号码");
                break;
            case 4002:
                toast.setText("无效的 AppKey");
                break;
            case 4009:
                toast.setText("没有短信验证权限");
                break;
            case 4011:
                toast.setText("发送超频");
                break;
            case 4017:
                toast.setText("验证码超时");
                break;
            case 4018:
                toast.setText("验证码校验失败");
                break;

            default:
                toast.setText("Response code: " + statusCode);
                break;
        }
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

}
