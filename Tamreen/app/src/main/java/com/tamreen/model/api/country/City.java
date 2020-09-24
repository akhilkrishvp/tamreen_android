package com.tamreen.model.api.country;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class City {
    @SerializedName("areas")
    private ArrayList<Area> areaList = new ArrayList<>();
    @SerializedName("id")
    private int id;
    @SerializedName("nameAr")
    private String nameAr;
    @SerializedName("nameEn")
    private String nameEn;
    @SerializedName("sorder")
    private int sorder;

    public ArrayList<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(ArrayList<Area> areaList) {
        this.areaList = areaList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameAr() {
        return this.nameAr;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public void setSorder(int sorder) {
        this.sorder = sorder;
    }

    public int getSorder() {
        return this.sorder;
    }

    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public City(JSONObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        JSONArray areasJsonArray = jsonObject.optJSONArray("areas");
        if (areasJsonArray != null) {
            for (int i = 0; i < areasJsonArray.length(); i++) {
                JSONObject areasObject = areasJsonArray.optJSONObject(i);
                areaList.add(new Area(areasObject));
            }

        }
        id = jsonObject.optInt("id");
        nameAr = jsonObject.optString("nameAr");
        nameEn = jsonObject.optString("nameEn");
        sorder = jsonObject.optInt("sorder");
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        try {
            if (areaList != null && areaList.size() > 0) {
                JSONArray areasJsonArray = new JSONArray();
                for (Area areasElement : areaList) {
                    areasJsonArray.put(areasElement.toJsonObject());
                }
                jsonObject.put("areas", areasJsonArray);
            }
            jsonObject.put("id", id);
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
