package com.tamreen.model.api.country;

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class Area{

    @SerializedName("id")
    private int id;
    @SerializedName("image")
    private String image;
    @SerializedName("nameAr")
    private String nameAr;
    @SerializedName("nameEn")
    private String nameEn;
    @SerializedName("sorder")
    private int sorder;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImage(){
        return this.image;
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
    public void setSorder(int sorder){
        this.sorder = sorder;
    }
    public int getSorder(){
        return this.sorder;
    }

    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public Area(JSONObject jsonObject){
        if(jsonObject == null){
            return;
        }
        id = jsonObject.optInt("id");
        image = jsonObject.optString("image");
        nameAr = jsonObject.optString("nameAr");
        nameEn = jsonObject.optString("nameEn");
        sorder = jsonObject.optInt("sorder");
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
            jsonObject.put("image", image);
            jsonObject.put("nameAr", nameAr);
            jsonObject.put("nameEn", nameEn);
            jsonObject.put("sorder", sorder);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

}