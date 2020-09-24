package com.tamreen.core.Utilities;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;

import java.util.Locale;

public class LocaleManager {

    private static final String LANGUAGE_KEY = "LANG";
    private static final String PREF_HAS_SET_LANG = "HAS_SET_LANG";

    public static Context setLocale(Context c) {
        return updateResources(c, getLanguage(c));
    }

    public static Context setNewLocale(Context c, String language) {
        return updateResources(c, language.equals("en") ? 1 : 0);
    }

    public static int getLanguage(Context c) {
//        int result = 1;
        return UserSettings.isArabic(c) ? 0 : 1;
//        return UserSettings.getLanguage(c);
    }

    private static Context updateResources(Context context, int language) {
        String lang = language == 1 ? "en" : "ar";
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
        } else {
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
        Log.d("Local**",locale.getLanguage());
        config.setLayoutDirection(locale);
        return context;
    }

    public static Locale getLocale(Resources res) {
        Configuration config = res.getConfiguration();
        return Build.VERSION.SDK_INT >= 24 ? config.getLocales().get(0) : config.locale;
    }
}
