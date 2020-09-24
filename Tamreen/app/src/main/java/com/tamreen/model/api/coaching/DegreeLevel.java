package com.tamreen.model.api.coaching;

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class DegreeLevel{

    @SerializedName("id")
    private int id;
    @SerializedName("nameAr")
    private String nameAr;
    @SerializedName("nameEn")
    private String nameEn;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setNameAr(String nameAr){
        this.nameAr = nameAr;
    }
    public String getNameAr(){
        return this.nameAr;
    }
    public void setNameEn(String nameEn){
        this.nameEn = nameEn;
    }
    public String getNameEn(){
        return this.nameEn;
    }

    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public DegreeLevel(JSONObject jsonObject){
        if(jsonObject == null){
            return;
        }
        id = jsonObject.optInt("id");
        nameAr = jsonObject.optString("nameAr");
        nameEn = jsonObject.optString("nameEn");
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
            jsonObject.put("nameAr", nameAr);
            jsonObject.put("nameEn", nameEn);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

}