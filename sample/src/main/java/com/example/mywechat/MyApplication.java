package com.example.mywechat;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by song
 * on 2016-10-11 上午11:36.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
