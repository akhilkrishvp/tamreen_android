package com.tamreen.core.Utilities;

import android.util.Base64;

import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by diyaa on 10/3/17.
 */

public class Converter {
    private static final Gson gson = new Gson();

    public static String toBase64(String text) {
        byte[] data = new byte[0];
        data = text.trim().getBytes(StandardCharsets.UTF_8);
        String base64 = Base64.encodeToString(data, Base64.DEFAULT);
        return base64.trim();
    }

    public static <T> T fromJSON(String json, Class<T> dataObj) throws Exception {
        return gson.fromJson(json, dataObj);
    }

    public static String toJSON(Object dataObj) {
        String jsonString = gson.toJson(dataObj);
        return jsonString;
    }


    public static Date JSONDate(String date) throws ParseException {
        //  String date = "/Date(1376841597000)/";
        Calendar calendar = Calendar.getInstance();
        String datereip = date.replace("/Date(", "").replace(")/", "");
        datereip = datereip.split("\\+")[0];
        Long timeInMillis = Long.valueOf(datereip);
        calendar.setTimeInMillis(timeInMillis);
        return calendar.getTime();

    }


    public static String NumberArabicToEnglish(String input) {

        String value = "";

        for (char character : input.toCharArray()) {

            String str = "";
            int ascii = (int) character;
            if (ascii >= 1632 && ascii <= 1641) {
                //arabic number
                int valueOld = ascii - 1584;
                char valueChar = (char) valueOld;
                str = String.valueOf(valueChar);
            } else {
                //default
                str = String.valueOf(character);
            }

            value += str;
        }
        return value;
    }


}
