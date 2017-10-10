package com.dk.activity;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dk.R;

/**
 * Created by ${chenyn} on 2017/10/9.
 */

public class BaseActivity extends Activity {

    public void initTitle(String titleString) {
        TextView title = findViewById(R.id.tv_title);
        ImageView back = findViewById(R.id.iv_back);

        title.setText(titleString);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
