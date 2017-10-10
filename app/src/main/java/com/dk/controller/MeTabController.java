package com.dk.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dk.R;
import com.dk.activity.PersonalDataActivity;
import com.dk.view.CircleImageView;

/**
 * Created by ${chenyn} on 2017/10/9.
 */

public class MeTabController extends BaseController implements View.OnClickListener {

    private CircleImageView mAvatar;
    private TextView mPhone;
    private RelativeLayout mMorePersonalData, mBrowseRecord, mFeedBack, mAbout;

    public MeTabController(Context context) {
        super(context);
    }

    @Override
    public View initContentView(Context context) {
        View view = View.inflate(context, R.layout.fragment_page_me, null);
        mMorePersonalData = view.findViewById(R.id.rl_morePersonalData);
        mBrowseRecord = view.findViewById(R.id.rl_browseRecord);
        mFeedBack = view.findViewById(R.id.rl_feedBack);
        mAbout = view.findViewById(R.id.rl_about);
        mAvatar = view.findViewById(R.id.iv_avatar);
        mPhone = view.findViewById(R.id.tv_phone);

        return view;
    }

    @Override
    public void initData() {
        mMorePersonalData.setOnClickListener(this);
        mBrowseRecord.setOnClickListener(this);
        mFeedBack.setOnClickListener(this);
        mAbout.setOnClickListener(this);
        super.initData();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.rl_morePersonalData:
                intent.setClass(mContext, PersonalDataActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.rl_browseRecord:

                break;
            case R.id.rl_feedBack:

                break;
            case R.id.rl_about:

                break;
            default:
                break;
        }
    }
}
