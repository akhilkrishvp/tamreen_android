package com.tamreen.model.api.coaching;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ServiceResult {
    @SerializedName("exeptionMessage")
    private String exeptionMessage;
    @SerializedName("isSucsess")
    private boolean isSucsess;
    @SerializedName("message")
    private String message;
    @SerializedName("result")
    private ArrayList<Services> servicesList = new ArrayList<>();

    public void setExeptionMessage(String exeptionMessage) {
        this.exeptionMessage = exeptionMessage;
    }

    public String getExeptionMessage() {
        return this.exeptionMessage;
    }

    public void setIsSucsess(boolean isSucsess) {
        this.isSucsess = isSucsess;
    }

    public boolean isIsSucsess() {
        return this.isSucsess;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSucsess() {
        return isSucsess;
    }

    public void setSucsess(boolean sucsess) {
        isSucsess = sucsess;
    }

    public ArrayList<Services> getServicesList() {
        return servicesList;
    }

    public void setServicesList(ArrayList<Services> servicesList) {
        this.servicesList = servicesList;
    }

    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public ServiceResult(JSONObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        exeptionMessage = jsonObject.optString("exeptionMessage");
        isSucsess = jsonObject.optBoolean("isSucsess");
        message = jsonObject.optString("message");
        JSONArray resultJsonArray = jsonObject.optJSONArray("result");
        if (resultJsonArray != null) {
            ArrayList<Services> resultArrayList = new ArrayList<>();
            for (int i = 0; i < resultJsonArray.length(); i++) {
                JSONObject resultObject = resultJsonArray.optJSONObject(i);
                servicesList.add(new Services(resultObject));
            }
        }
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("exeptionMessage", exeptionMessage);
            jsonObject.put("isSucsess", isSucsess);
            jsonObject.put("message", message);
            if (servicesList != null && servicesList.size() > 0) {
                JSONArray resultJsonArray = new JSONArray();
                for (Services resultElement : servicesList) {
                    resultJsonArray.put(resultElement.toJsonObject());
                }
                jsonObject.put("result", resultJsonArray);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

}
