package com.tamreen.network;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.multidex.BuildConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.q8.flowers.app.Network.ApiConfig;
import com.tamreen.core.Utilities.GlobalApplication;
import com.tamreen.core.Utilities.UserSettings;

import java.nio.Buffer;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tamreen.core.Utilities.Converter.toBase64;

public class ApiService {

    private static ApiClient api;
    private static OkHttpClient.Builder clientBuilder;
    private static OkHttpClient client;

    public static ApiClient getApi(ApiVersion apiVersion) {
        final Context context = GlobalApplication.getAppContext();
        ApiConfig apiConfig = new ApiConfig(context);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel( HttpLoggingInterceptor.Level.BODY);

        clientBuilder = new OkHttpClient.Builder();

        clientBuilder.readTimeout(240, TimeUnit.SECONDS);
        clientBuilder.connectTimeout(240, TimeUnit.SECONDS);
        clientBuilder.retryOnConnectionFailure(true);
        clientBuilder.addInterceptor(logging);


        clientBuilder.addInterceptor(chain -> {

            Request original = chain.request();



            String version = "";
            String build = "";
            int countryid = UserSettings.getCountryObj(context).getId();

            try {
                PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                version = pInfo.versionName;
                build = "" + pInfo.versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            // Request customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("countryid",""+countryid)
                    .addHeader("device", "1")
                    .addHeader("lang",UserSettings.isArabic() ? "0" : "1");


            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        try {

            client = clientBuilder.build();
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Date.class, new DotNetDateDeserializer());
            Gson gson = builder.create();
            //set the headers


            Retrofit restAdapter = new Retrofit.Builder().baseUrl(apiConfig.getApiURL(apiVersion))
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();
            api = restAdapter.create(ApiClient.class);
            Log.d("HELLO", "getApi: " + apiConfig.getApiURL(apiVersion));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return api;
    }

}


