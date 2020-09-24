package com.tamreen.model.api.country;
import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;
import com.tamreen.core.Utilities.UserSettings;

public class CountryObj {

    @SerializedName("code")
    private String code;
    @SerializedName("currancySymbolAr")
    private String currancySymbolAr;
    @SerializedName("currancySymbolEn")
    private String currancySymbolEn;
    @SerializedName("decimalNumbers")
    private int decimalNumbers;
    @SerializedName("hasBranch")
    private boolean hasBranch;
    @SerializedName("id")
    private int id;
    @SerializedName("imageLink")
    private String imageLink;
    @SerializedName("nameAr")
    private String nameAr;
    @SerializedName("nameEn")
    private String nameEn;
    @SerializedName("siteLink")
    private String siteLink;
    private boolean isSelected;

    public CountryObj() {

    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setCurrancySymbolAr(String currancySymbolAr){
        this.currancySymbolAr = currancySymbolAr;
    }
    public String getCurrancySymbolAr(){
        return this.currancySymbolAr;
    }
    public void setCurrancySymbolEn(String currancySymbolEn){
        this.currancySymbolEn = currancySymbolEn;
    }
    public String getCurrancySymbolEn(){
        return this.currancySymbolEn;
    }
    public void setDecimalNumbers(int decimalNumbers){
        this.decimalNumbers = decimalNumbers;
    }
    public int getDecimalNumbers(){
        return this.decimalNumbers;
    }
    public void setHasBranch(boolean hasBranch){
        this.hasBranch = hasBranch;
    }
    public boolean isHasBranch()
    {
        return this.hasBranch;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setImageLink(String imageLink){
        this.imageLink = imageLink;
    }
    public String getImageLink(){
        return this.imageLink;
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
    public void setSiteLink(String siteLink){
        this.siteLink = siteLink;
    }
    public String getSiteLink(){
        return this.siteLink;
    }

    public String getNameString() {
        return UserSettings.isArabic() ? this.nameAr : this.nameEn;
    }
    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public CountryObj(JSONObject jsonObject){
        if(jsonObject == null){
            return;
        }
        code = jsonObject.optString("code");
        currancySymbolAr = jsonObject.optString("currancySymbolAr");
        currancySymbolEn = jsonObject.optString("currancySymbolEn");
        decimalNumbers = jsonObject.optInt("decimalNumbers");
        hasBranch = jsonObject.optBoolean("hasBranch");
        id = jsonObject.optInt("id");
        imageLink = jsonObject.optString("imageLink");
        nameAr = jsonObject.optString("nameAr");
        nameEn = jsonObject.optString("nameEn");
        siteLink = jsonObject.optString("siteLink");
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("code", code);
            jsonObject.put("currancySymbolAr", currancySymbolAr);
            jsonObject.put("currancySymbolEn", currancySymbolEn);
            jsonObject.put("decimalNumbers", decimalNumbers);
            jsonObject.put("hasBranch", hasBranch);
            jsonObject.put("id", id);
            jsonObject.put("imageLink", imageLink);
            jsonObject.put("nameAr", nameAr);
            jsonObject.put("nameEn", nameEn);
            jsonObject.put("siteLink", siteLink);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }


}
