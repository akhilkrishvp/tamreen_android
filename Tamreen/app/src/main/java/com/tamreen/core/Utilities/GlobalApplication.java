package com.tamreen.core.Utilities;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.DisplayMetrics;


import java.util.Locale;



/**
 * Created by diyaa on 10/17/17.
 */

public class GlobalApplication extends Application {
    private static GlobalApplication sInstance;

    public static GlobalApplication getsInstance() {
        return sInstance;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        /*if (BuildConfig.DEBUG) {
            AppSettings.environment = Environment.Development;
        }
        else {
            AppSettings.environment = Environment.Live;
        }*/
       // AppSettings.environment = Environment.Live;


        registerActivityLifecycleCallbacks(new AdjustLifecycleCallbacks());

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        LocaleManager.setLocale(this);
    }

//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(LocaleManager.setLocale(base));
//    }

    void setLocal() {
        if (UserSettings.isArabic()) {
            Resources resources = getApplicationContext().getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Locale locale = new Locale("ar");

            Configuration configuration = resources.getConfiguration();
            configuration.setLocale(locale);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                LocaleList locales = new LocaleList(locale);
                configuration.setLocales(locales);
            }

            configuration.setLayoutDirection(locale);
            resources.updateConfiguration(configuration, displayMetrics);
            getApplicationContext().createConfigurationContext(configuration);
        } else {
            Resources resources = getApplicationContext().getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Locale locale = new Locale("en");

            Configuration configuration = resources.getConfiguration();
            configuration.setLocale(locale);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                LocaleList locales = new LocaleList(locale);
                configuration.setLocales(locales);
            }
            configuration.setLayoutDirection(locale);
            resources.updateConfiguration(configuration, displayMetrics);
            getApplicationContext().createConfigurationContext(configuration);

        }

    }


    public static Context getAppContext() {
        return getsInstance().getApplicationContext();
    }


    private static final class AdjustLifecycleCallbacks implements ActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    }


}
