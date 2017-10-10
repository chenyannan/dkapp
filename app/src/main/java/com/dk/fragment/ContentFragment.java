package com.dk.fragment;

import android.support.annotation.IdRes;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dk.R;
import com.dk.controller.BaseController;
import com.dk.controller.CreditTabController;
import com.dk.controller.HomeTabController;
import com.dk.controller.MeTabController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${chenyn} on 2017/10/9.
 */

public class ContentFragment extends BaseFragment {

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private RadioButton mRbHome, mRbCredit, mRbMe;
    private List<BaseController> mTabController;
    private int mCurTabIndex;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_content, null);
        mViewPager = view.findViewById(R.id.content_viewpager);
        mRadioGroup = view.findViewById(R.id.content_rg);
        mRbHome = view.findViewById(R.id.content_rb_home);
        mRbCredit = view.findViewById(R.id.content_rb_credit);
        mRbMe = view.findViewById(R.id.content_rb_me);
        return view;
    }

    @Override
    public void initDate() {
        mTabController = new ArrayList<>();
        mTabController.add(new HomeTabController(mContext));
        mTabController.add(new CreditTabController(mContext));
        mTabController.add(new MeTabController(mContext));

        mViewPager.setAdapter(new ContentPagerAdapter());
        //默认选中首页
        mRadioGroup.check(R.id.content_rb_home);

        super.initDate();
    }

    @Override
    public void initListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.content_rb_home:
                        mCurTabIndex = 0;
                        break;
                    case R.id.content_rb_credit:
                        mCurTabIndex = 1;
                        break;
                    case R.id.content_rb_me:
                        mCurTabIndex = 2;
                        break;
                    default:
                        break;
                }
                mViewPager.setCurrentItem(mCurTabIndex);

            }
        });
        super.initListener();
    }

    private class ContentPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mTabController == null ? 0 : mTabController.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BaseController baseController = mTabController.get(position);
            View rootView = baseController.mRootView;
            container.addView(rootView);

            baseController.initData();
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
