package com.dk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.dk.R;

/**
 * Created by ${chenyn} on 2017/10/9.
 */

public class PersonalDataActivity extends BaseActivity implements View.OnClickListener {

    private static final int RESULT_NAME = 1;
    private static final int RESULT_PERSONAL_ID = 2;
    private static final int RESULT_EDUCATION_LEVEL = 3;
    private static final int RESULT_CREDIT_CARD = 4;
    private static final int RESULT_PROFESSION_INFO = 5;
    private static final int RESULT_INCOME = 6;
    private TextView mPhone;
    private TextView mSetName, mPersonalID, mEducationLevel, mCreditCard, mProfessionInfo, mIncome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_personal_data);

        initView();
    }

    private void initView() {
        mPhone = findViewById(R.id.tv_phone);
        mSetName = findViewById(R.id.tv_setName);
        mPersonalID = findViewById(R.id.tv_personalID);
        mEducationLevel = findViewById(R.id.tv_educationLevel);
        mCreditCard = findViewById(R.id.tv_creditCard);
        mProfessionInfo = findViewById(R.id.tv_professionInfo);
        mIncome = findViewById(R.id.tv_income);
        initTitle(getString(R.string.personal_data));

        findViewById(R.id.rl_setName).setOnClickListener(this);
        findViewById(R.id.rl_personalID).setOnClickListener(this);
        findViewById(R.id.rl_educationLevel).setOnClickListener(this);
        findViewById(R.id.rl_creditCard).setOnClickListener(this);
        findViewById(R.id.rl_professionInfo).setOnClickListener(this);
        findViewById(R.id.rl_income).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(PersonalDataActivity.this, PersonalDataSettingActivity.class);
        switch (view.getId()) {
            case R.id.rl_setName:
                intent.putExtra("setTitle", getString(R.string.input_name));
                intent.putExtra("setHint", getString(R.string.please_input_name));
                startActivityForResult(intent,RESULT_NAME);
                break;
            case R.id.rl_personalID:
                intent.putExtra("setTitle", getString(R.string.input_personal_id));
                intent.putExtra("setHint", getString(R.string.please_input_personal_id));
                startActivityForResult(intent,RESULT_PERSONAL_ID);
                break;
            case R.id.rl_educationLevel:
                intent.putExtra("setTitle", getString(R.string.please_choose_education_level));
                intent.setFlags(RESULT_EDUCATION_LEVEL);
                startActivityForResult(intent, RESULT_EDUCATION_LEVEL);
                break;
            case R.id.rl_creditCard:
                intent.putExtra("setTitle", getString(R.string.please_choose_is_have_credit_card));
                intent.setFlags(RESULT_CREDIT_CARD);
                startActivityForResult(intent, RESULT_CREDIT_CARD);
                break;
            case R.id.rl_professionInfo:
                intent.putExtra("setTitle", getString(R.string.please_choose_profession));
                intent.setFlags(RESULT_PROFESSION_INFO);
                startActivityForResult(intent, RESULT_PROFESSION_INFO);
                break;
            case R.id.rl_income:
                intent.putExtra("setTitle", getString(R.string.input_income));
                intent.putExtra("setHint", getString(R.string.please_input_income));
                startActivityForResult(intent, RESULT_INCOME);
                break;
            default:
                break;
        }

    }
}
