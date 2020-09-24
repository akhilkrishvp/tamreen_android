package com.tamreen.views.splash;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;

import com.tamreen.MainActivity;
import com.tamreen.R;
import com.tamreen.core.Utilities.CoreVC;
import com.tamreen.core.Utilities.UserSettings;
import com.tamreen.model.staticModel.Onboarding;
import com.tamreen.views.account.StartUpVC;
import com.tamreen.views.home.MainTabBarVC;
import com.tamreen.views.landing.LandingVC;
import com.tamreen.views.landing.OnboardingVC;

import java.util.Locale;

import butterknife.ButterKnife;
import id.voela.actrans.AcTrans;

public class LaunchVC extends CoreVC {
    public static final int DELAY_MILLIS = 1200;
    public void setApplicationLanguage(String newLanguage) {
        Resources activityRes = getResources();
        Configuration activityConf = activityRes.getConfiguration();
        Locale newLocale = new Locale(newLanguage);
        activityConf.setLocale(newLocale);
        activityRes.updateConfiguration(activityConf, activityRes.getDisplayMetrics());
        Resources applicationRes = getApplicationContext().getResources();
        Configuration applicationConf = applicationRes.getConfiguration();
        applicationConf.setLocale(newLocale);
        applicationRes.updateConfiguration(applicationConf,
                applicationRes.getDisplayMetrics());

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        setApplicationLanguage(UserSettings.isArabic() ? "ar" : "en");
        Handler handler = new Handler();
        handler.postDelayed(() -> {
           // Launch(LandingVC.class);
            if(!UserSettings.didSetLang(context)){
                Launch(LandingVC.class);
            }
            else if(!UserSettings.isOnBoardingFinished(context)){
                Launch(OnboardingVC.class);
            }
            else {
                Launch(MainActivity.class);
            }
        }, DELAY_MILLIS);
    }
}
