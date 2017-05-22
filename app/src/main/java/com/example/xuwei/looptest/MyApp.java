package com.example.xuwei.looptest;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Xu Wei on 2017/5/22.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
