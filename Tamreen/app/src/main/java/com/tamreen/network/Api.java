package com.tamreen.network;

import android.content.Context;


import com.tamreen.core.Utilities.GlobalApplication;
import com.tamreen.model.api.account.LoginResponse;
import com.tamreen.model.api.account.OtpResponse;
import com.tamreen.model.api.account.UserObj;
import com.tamreen.model.api.account.UserResponse;
import com.tamreen.model.api.country.CountryResponse;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Callback;


public class Api {
    final Context context = GlobalApplication.getAppContext();

    public Api() {
    }

    public static Api getApi() {
        Api apiClient = new Api();
        return apiClient;
    }

    private static String accessKey = "ETj5DMaTnej42fE66USLTvg";

    private ApiClient getApiClient(ApiVersion apiVersion) {
        return ApiService.getApi(apiVersion);
    }

    public void getCountryList(Callback<CountryResponse> callback){
        getApiClient(ApiVersion.V1).getCountryList().enqueue(callback);
    }

    public void getUserProfile(Callback<UserResponse> callback){
        getApiClient(ApiVersion.V1).getUserProfile().enqueue(callback);
    }

    public void signUp( String phone, String password, int type,Callback<ResponseBody> callback) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", phone);
        hashMap.put("password", password);
        hashMap.put("type", ""+type);
        getApiClient(ApiVersion.V1).signUp(hashMap).enqueue(callback);
    }
    public void verifyOtp( String phone, String otp,Callback<OtpResponse> callback) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", phone);
        hashMap.put("OTP", otp);
        getApiClient(ApiVersion.V1).verifyOtp(hashMap).enqueue(callback);
    }
    public void login( String phone, String password,Callback<LoginResponse> callback) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username", phone);
        hashMap.put("password", password);
        getApiClient(ApiVersion.V1).login(hashMap).enqueue(callback);
    }
    public void createProfile(UserObj userObj,Callback<LoginResponse> callback) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", userObj.getPhone());
        //hashMap.put("password", password);
        hashMap.put("name", userObj.getFullName());
        hashMap.put("email", userObj.getEmail());
        hashMap.put("height", userObj.getHeight());
        hashMap.put("weight", userObj.getWeight());
        hashMap.put("description", userObj.getDescription());
        hashMap.put("age", ""+userObj.getDob());
        hashMap.put("careertime", userObj.getCareerTime());
        getApiClient(ApiVersion.V1).login(hashMap).enqueue(callback);
    }

}
