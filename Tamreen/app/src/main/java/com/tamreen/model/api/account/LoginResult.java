package com.tamreen.model.api.account;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginResult {
    @SerializedName("accessToken")
    private String accessToken;


    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }
    public String getAccessToken(){
        return this.accessToken;
    }


    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public LoginResult(JSONObject jsonObject){
        if(jsonObject == null){
            return;
        }
        accessToken = jsonObject.optString("accessToken");
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
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
