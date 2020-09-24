package com.tamreen.model.api.account;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

public class OtpResponse {
    @SerializedName("exeptionMessage")
    private String exeptionMessage;
    @SerializedName("isSucsess")
    private boolean isSucsess;
    @SerializedName("message")
    private String message;
    @SerializedName("result")
    private OtpResult result;

    public void setExeptionMessage(String exeptionMessage){
        this.exeptionMessage = exeptionMessage;
    }
    public String getExeptionMessage(){
        return this.exeptionMessage;
    }
    public void setIsSucsess(boolean isSucsess){
        this.isSucsess = isSucsess;
    }
    public boolean isIsSucsess()
    {
        return this.isSucsess;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setResult(OtpResult result){
        this.result = result;
    }
    public OtpResult getResult(){
        return this.result;
    }

    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public OtpResponse(JSONObject jsonObject){
        if(jsonObject == null){
            return;
        }
        exeptionMessage = jsonObject.optString("exeptionMessage");
        isSucsess = jsonObject.optBoolean("isSucsess");
        message = jsonObject.optString("message");
        result = new OtpResult(jsonObject.optJSONObject("result"));
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("exeptionMessage", exeptionMessage);
            jsonObject.put("isSucsess", isSucsess);
            jsonObject.put("message", message);
            jsonObject.put("result", result.toJsonObject());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

}
