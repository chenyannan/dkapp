package com.dk.controller;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.dk.R;

/**
 * Created by ${chenyn} on 2017/10/9.
 */

public abstract class BaseController {

    public Context mContext;
    public View mRootView;
    private FrameLayout mContainer;

    public BaseController(Context context) {
        mContext = context;
        mRootView = initView(mContext);
    }

    private View initView(Context context) {
        View view = View.inflate(context, R.layout.layout_base_tab, null);
        mContainer = view.findViewById(R.id.base_tab_content_container);
        mContainer.addView(initContentView(context));
        return view;
    }

    public abstract View initContentView(Context context);


    public void initData() {
    }

}
