package com.dk.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.dk.R;

/**
 * Created by ${chenyn} on 2017/10/9.
 */

public class PersonalDataSettingActivity extends BaseActivity {

    private static final int CHOOSE_EDUCATION_FLAG = 3;
    private static final int CHOOSE_CREDIT_FLAG = 4;
    private static final int CHOOSE_PROFESSION_FLAG = 5;
    private EditText mInputName;
    private Button mSave;
    private LinearLayout mInputInfo;
    private LinearLayout mChooseEducation;
    private LinearLayout mChooseProfession;
    private LinearLayout mChooseCredit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data_setting);

        initView();
        initListener();

    }

    private void initView() {
        mInputName = findViewById(R.id.et_inputName);
        mSave = findViewById(R.id.btn_save);
        mInputInfo = findViewById(R.id.ll_inputInfo);

        mChooseEducation = findViewById(R.id.ll_chooseEducation);
        mChooseProfession = findViewById(R.id.ll_chooseProfession);
        mChooseCredit = findViewById(R.id.ll_chooseCredit);

        initTitle(getIntent().getStringExtra("setTitle"));
        if (TextUtils.isEmpty(getIntent().getStringExtra("setHint"))) {
            mInputInfo.setVisibility(View.GONE);
            mSave.setVisibility(View.GONE);
        } else {
            mSave.setVisibility(View.VISIBLE);
            mInputInfo.setVisibility(View.VISIBLE);
            mInputName.setHint(getIntent().getStringExtra("setHint"));
        }

        if (getIntent().getFlags() == CHOOSE_EDUCATION_FLAG) {
            mChooseEducation.setVisibility(View.VISIBLE);
        } else if (getIntent().getFlags() == CHOOSE_PROFESSION_FLAG) {
            mChooseProfession.setVisibility(View.VISIBLE);
        } else if (getIntent().getFlags() == CHOOSE_CREDIT_FLAG) {
            mChooseCredit.setVisibility(View.VISIBLE);
        }
    }

    private void initListener() {
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
