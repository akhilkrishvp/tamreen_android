package com.tamreen.network;

import com.tamreen.model.api.account.LoginResponse;
import com.tamreen.model.api.account.OtpResponse;
import com.tamreen.model.api.account.UserResponse;
import com.tamreen.model.api.country.CountryResponse;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClient {

    @GET("Countries")
    Call<CountryResponse> getCountryList();

    @POST("Authentication/signup")
    Call<ResponseBody> signUp(@Body HashMap<String, String> body);

    @POST("Authentication/veryfiotp")
    Call<OtpResponse> verifyOtp(@Body HashMap<String, String> body);

    @POST("Authentication/Login")
    Call<LoginResponse> login(@Body HashMap<String, String> body);

    @GET("Account/profile")
    Call<UserResponse> getUserProfile();

    @POST("Authentication/CreateProfile")
    Call<ResponseBody> createProfile(@Body HashMap<String, String> body);

}
