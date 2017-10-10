package com.dk.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.dk.R;
import com.dk.fragment.ContentFragment;

public class MainActivity extends FragmentActivity {
    private static final String FRAGMENT_MAIN_CONTENT = "fragment_main_content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        initFragment();
    }

    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.fragment_main_content, new ContentFragment(), FRAGMENT_MAIN_CONTENT);
        transaction.commit();
    }
}
