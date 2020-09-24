package com.tamreen.model.api.coaching;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FavouriteResult {
    @SerializedName("currentPage")
    private int currentPage;
    @SerializedName("exeptionMessage")
    private String exeptionMessage;
    @SerializedName("isSucsess")
    private boolean isSucsess;
    @SerializedName("message")
    private String message;
    @SerializedName("nextPage")
    private int nextPage;
    @SerializedName("pageCount")
    private int pageCount;
    @SerializedName("pageSize")
    private int pageSize;

    @SerializedName("result")
    private ArrayList<Favourite> favouriteList = new ArrayList<>();

    @SerializedName("rowCount")
    private int rowCount;

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

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

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getNextPage() {
        return this.nextPage;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public boolean isSucsess() {
        return isSucsess;
    }

    public void setSucsess(boolean sucsess) {
        isSucsess = sucsess;
    }

    public ArrayList<Favourite> getFavouriteList() {
        return favouriteList;
    }

    public void setFavouriteList(ArrayList<Favourite> favouriteList) {
        this.favouriteList = favouriteList;
    }

    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public FavouriteResult(JSONObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        currentPage = jsonObject.optInt("currentPage");
        exeptionMessage = jsonObject.optString("exeptionMessage");
        isSucsess = jsonObject.optBoolean("isSucsess");
        message = jsonObject.optString("message");
        nextPage = jsonObject.optInt("nextPage");
        pageCount = jsonObject.optInt("pageCount");
        pageSize = jsonObject.optInt("pageSize");
        JSONArray resultJsonArray = jsonObject.optJSONArray("result");
        if (resultJsonArray != null) {
            ArrayList<Favourite> resultArrayList = new ArrayList<>();
            for (int i = 0; i < resultJsonArray.length(); i++) {
                JSONObject resultObject = resultJsonArray.optJSONObject(i);
                favouriteList.add(new Favourite(resultObject));
            }

        }
        rowCount = jsonObject.optInt("rowCount");
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("currentPage", currentPage);
            jsonObject.put("exeptionMessage", exeptionMessage);
            jsonObject.put("isSucsess", isSucsess);
            jsonObject.put("message", message);
            jsonObject.put("nextPage", nextPage);
            jsonObject.put("pageCount", pageCount);
            jsonObject.put("pageSize", pageSize);
            if (favouriteList != null && favouriteList.size() > 0) {
                JSONArray resultJsonArray = new JSONArray();
                for (Favourite resultElement : favouriteList) {
                    resultJsonArray.put(resultElement.toJsonObject());
                }
                jsonObject.put("result", resultJsonArray);
            }
            jsonObject.put("rowCount", rowCount);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

}
