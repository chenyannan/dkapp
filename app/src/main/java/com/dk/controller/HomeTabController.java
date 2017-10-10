package com.dk.controller;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ${chenyn} on 2017/10/9.
 */

public class HomeTabController extends BaseController{
    public HomeTabController(Context context) {
        super(context);
    }

    @Override
    public View initContentView(Context context) {
        TextView tv = new TextView(context);
        tv.setTextColor(Color.RED);
        tv.setGravity(Gravity.CENTER);
        tv.setText("主页");
        return tv;
    }
}
