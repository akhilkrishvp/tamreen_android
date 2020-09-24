package com.tamreen.model.api.coaching;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

public class Services {
    @SerializedName("id")
    private int id;
    @SerializedName("imageAr")
    private String imageAr;
    @SerializedName("imageEn")
    private String imageEn;
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
    public void setImageAr(String imageAr){
        this.imageAr = imageAr;
    }
    public String getImageAr(){
        return this.imageAr;
    }
    public void setImageEn(String imageEn){
        this.imageEn = imageEn;
    }
    public String getImageEn(){
        return this.imageEn;
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
    public Services(JSONObject jsonObject){
        if(jsonObject == null){
            return;
        }
        id = jsonObject.optInt("id");
        imageAr = jsonObject.optString("imageAr");
        imageEn = jsonObject.optString("imageEn");
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
            jsonObject.put("imageAr", imageAr);
            jsonObject.put("imageEn", imageEn);
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
