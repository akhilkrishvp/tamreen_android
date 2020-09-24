package com.tamreen.core.Utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ParseException;
import android.net.Uri;
import android.util.Log;
import android.widget.DatePicker;

import com.google.gson.Gson;
import com.tamreen.model.api.account.UserObj;
import com.tamreen.model.api.country.CountryObj;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserSettings {
    private Context context;
    //public static final String PREFF_FILE_NAME = "RequeuePref";
    public static final String PREFF_FILE_NAME = "TamreenPref";

    public UserSettings(Context context) {
        this.context = context;
    }

    public UserSettings() {
    }

    public static void setKeyValue(PreferencesType keyNam, String keyValue, Context context) {
        saveToPreferences(context, keyNam, keyValue);
    }

    public static String getKeyValue(PreferencesType keyNam, String keyValue, Context context) {
        return readPreferences(context, keyNam.toString(), keyValue);
    }

    public static String getKeyValue(String key, String keyValue, Context context) {
        return readPreferences(context, key, keyValue);
    }

    public static void setKeyValueBool(PreferencesType keyNam, Boolean keyValue, Context context) {
        saveToPreferencesBool(context, keyNam, keyValue);
    }

    public static Boolean getKeyValueBool(PreferencesType keyNam, Boolean keyValue, Context context) {
        return readPreferencesBool(context, keyNam.toString(), keyValue);
    }


    public static void saveToPreferences(Context context, PreferencesType keyNam, String keyValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(keyNam.toString());
        editor.putString(keyNam.toString(), keyValue);
        editor.apply();
    }


    public static void saveValue(Context context, PreferencesType key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key.toString(), value);
        editor.commit();
    }

    public static void saveValue(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void saveValue(Context context, PreferencesType key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key.toString(), value);
        editor.apply();
    }


    public static String getValue(Context context, PreferencesType key, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key.toString(), defaultValue);
    }

    public static int getValue(Context context, PreferencesType key, int defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key.toString(), defaultValue);
    }


    public static String readPreferences(Context context, String keyNam, String keyValue) {
        SharedPreferences sharedPreferences = getAppContext().getSharedPreferences(PREFF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(keyNam, keyValue);
    }


    public static void saveToPreferencesBool(Context context, PreferencesType keyNam, Boolean keyValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(keyNam.toString());
        editor.putBoolean(keyNam.toString(), keyValue);
        editor.apply();
    }

    public static Boolean readPreferencesBool(Context context, String keyNam, Boolean keyValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(keyNam, keyValue);
    }

    public void openURL(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(browserIntent);
    }
    public static void setOnBoardingFinished(Boolean status){
        setKeyValueBool(PreferencesType.onBoarding, status, getAppContext());
    }
    public static Boolean isOnBoardingFinished(Context context) {
        return getKeyValueBool(PreferencesType.onBoarding, false, context);
    }

    public static Boolean didSetLang(Context context) {
        String lang = getKeyValue(PreferencesType.SeletectLagunage, "", context);
        return !lang.isEmpty() && lang != null;

    }

    public static void setLang(Context context, String lang) {
        setKeyValue(PreferencesType.SeletectLagunage, lang, context);
    }

    public static Boolean isArabic() {

        String lang = getKeyValue(PreferencesType.SeletectLagunage, "", getAppContext());
        return lang.equals("ar");


    }

    public static Boolean isArabic(Context context) {

        String lang = getKeyValue(PreferencesType.SeletectLagunage, "", context);
        return lang.equals("ar");


    }
    public static Boolean isLoggedIn(Context context) {
        String token = getAccessToken(context);
        UserObj userObj = getUserDetails(context);

        return !token.isEmpty() && userObj.getId() > 0;
    }
    public static UserObj getUserDetails(Context context){
        return getUserObj(getAppContext());
    }
    public static void setUserDetails(UserObj userObj,Context context){
        String dataObj = Converter.toJSON(userObj);
        saveValue(getAppContext(), PreferencesType.user, dataObj);
    }
    public static UserObj getUserObj(Context context) {
        UserObj userObj = new UserObj();
        String dataString = getKeyValue(PreferencesType.user, "", context);
        if (!dataString.isEmpty()) {
            try {
                userObj = Converter.fromJSON(dataString, UserObj.class);
            } catch (Exception e) {
                Log.e("exception....",e.getMessage());
                e.printStackTrace();
            }
        }

        return userObj;
    }
    public static void setAccessToken(String token, Context context) {
        saveValue(context, PreferencesType.USER_TOKEN, token);
    }
    public static String getAccessToken(Context context) {
        String token = "";
        String storesString = getKeyValue(PreferencesType.USER_TOKEN, "", context);
        if (!storesString.isEmpty()) {
            token = storesString;
        }

        return token;
    }


    public static String getLanguage() {
        String lang = getKeyValue(PreferencesType.SeletectLagunage, "", getAppContext());
        return lang;
    }

    public static String getLanguage(Context context) {
        String lang = getKeyValue(PreferencesType.SeletectLagunage, "", context);
        return lang;
    }

    public static Context getAppContext() {
        return GlobalApplication.getAppContext();
    }

    public static String getCode(Context context) {
        String code = getKeyValue(PreferencesType.ClientCode, "", context);
        if (code.isEmpty()) {
            return "0";
        } else {
            return code;
        }
    }

    public static void setCountryObj(CountryObj countryObj,Context context){
        String dataObj = Converter.toJSON(countryObj);
        saveValue(getAppContext(), PreferencesType.CountryObj, dataObj);
    }
    public static CountryObj getCountryObj(Context context){
        CountryObj countryObj = new CountryObj();
        Gson gson = new Gson();
        String dataString = getKeyValue(PreferencesType.CountryObj, "", context);
        if (!dataString.isEmpty()) {
            countryObj = gson.fromJson(dataString, CountryObj.class);
        }
        return countryObj;

    }


    public static long getTimeStamp(Date date) {
        long output = date.getTime() / 1000L;
        return output;
    }


    public static Date getDateFromDatePicker(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    public static String getPrice(double price) {
        return String.format("%.3f", price);
    }

    // validating email id
    public static boolean isEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isPhoneNumber(String email) {
        String EMAIL_PATTERN = "^[+]?[0-9]{8,13}$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        // return matcher.matches();
        //return android.util.Patterns.PHONE.matcher(email).matches();
        return email.matches(EMAIL_PATTERN);
    }

    public static boolean isSubscriptionFirstOpen() {
        return getKeyValueBool(PreferencesType.SubscriptionFirstOpen, true, getAppContext());

    }

    public static void setSubscriptionFirstOpen(boolean status) {
        setKeyValueBool(PreferencesType.SubscriptionFirstOpen, status, getAppContext());
    }


    public static Date jsonDateConvert(String date) throws ParseException {
        Date createdOn = null;
        if (date.split("\\(").length > 1) {
            String timestamp = date.split("\\(")[1].split("\\+")[0];
            createdOn = new Date(Long.parseLong(timestamp));
        }
        return createdOn;
    }
}