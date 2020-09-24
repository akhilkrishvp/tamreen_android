package com.tamreen.model.api.coaching;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Favourite {
    @SerializedName("fullName")
    private String fullName;
    @SerializedName("id")
    private int id;
    @SerializedName("image")
    private String image;
    @SerializedName("rating")
    private int rating;
    @SerializedName("reviewsCount")
    private int reviewsCount;
    @SerializedName("services")
    private ArrayList<Services> servicesList = new ArrayList<>();

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }

    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public int getReviewsCount() {
        return this.reviewsCount;
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
    public Favourite(JSONObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        fullName = jsonObject.optString("fullName");
        id = jsonObject.optInt("id");
        image = jsonObject.optString("image");
        rating = jsonObject.optInt("rating");
        reviewsCount = jsonObject.optInt("reviewsCount");
        JSONArray servicesJsonArray = jsonObject.optJSONArray("services");
        if (servicesJsonArray != null) {
            ArrayList<Services> servicesArrayList = new ArrayList<>();
            for (int i = 0; i < servicesJsonArray.length(); i++) {
                JSONObject servicesObject = servicesJsonArray.optJSONObject(i);
                servicesList.add(new Services(servicesObject));
            }

        }
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("fullName", fullName);
            jsonObject.put("id", id);
            jsonObject.put("image", image);
            jsonObject.put("rating", rating);
            jsonObject.put("reviewsCount", reviewsCount);
            if (servicesList != null && servicesList.size() > 0) {
                JSONArray servicesJsonArray = new JSONArray();
                for (Services servicesElement : servicesList) {
                    servicesJsonArray.put(servicesElement.toJsonObject());
                }
                jsonObject.put("services", servicesJsonArray);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

}
