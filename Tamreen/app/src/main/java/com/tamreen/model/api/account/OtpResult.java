package com.tamreen.model.api.account;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

public class OtpResult {
    @SerializedName("accessToken")
    private String accessToken;
    @SerializedName("user")
    private UserObj user;

    public UserObj getUser() {
        return user;
    }

    public void setUser(UserObj user) {
        this.user = user;
    }

    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }
    public String getAccessToken(){
        return this.accessToken;
    }

    public OtpResult(JSONObject jsonObject){
        accessToken = jsonObject.optString("accessToken");
    }
    public JSONObject toJsonObject()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("accessToken", accessToken);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }


}
