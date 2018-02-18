package com.myregistry.homestore.utils;

import android.app.Application;

import com.myregistry.homestore.R;
import com.myregistry.homestore.retrofit.RetroClient;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by nidhiparekh.
 */

public class HomestoreApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetroClient.CreateRetroClient();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/proximanova_reg.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
