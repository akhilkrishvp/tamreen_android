package com.tamreen.model.api.account;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

public class UserObj {
    @SerializedName("age")
    private int age;
    @SerializedName("description")
    private String description;
    @SerializedName("dob")
    private String dob;
    @SerializedName("email")
    private String email;
    @SerializedName("fullName")
    private String fullName;
    @SerializedName("height")
    private String height;
    @SerializedName("id")
    private int id;
    @SerializedName("image")
    private String image;
    @SerializedName("password")
    private String password;
    @SerializedName("phone")
    private String phone;
    @SerializedName("type")
    private int type;
    @SerializedName("weight")
    private String weight;
    private String careerTime = "";

    public UserObj() {

    }

    public String getCareerTime() {
        return careerTime;
    }

    public void setCareerTime(String careerTime) {
        this.careerTime = careerTime;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDob(String dob){
        this.dob = dob;
    }
    public String getDob(){
        return this.dob;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getFullName(){
        return this.fullName;
    }
    public void setHeight(String height){
        this.height = height;
    }
    public String getHeight(){
        return this.height;
    }
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
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setType(int type){
        this.type = type;
    }
    public int getType(){
        return this.type;
    }
    public void setWeight(String weight){
        this.weight = weight;
    }
    public String getWeight(){
        return this.weight;
    }

    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public UserObj(JSONObject jsonObject){
        if(jsonObject == null){
            return;
        }
        age = jsonObject.optInt("age");
        description = jsonObject.optString("description");
        dob = jsonObject.optString("dob");
        email = jsonObject.optString("email");
        fullName = jsonObject.optString("fullName");
        height = jsonObject.optString("height");
        id = jsonObject.optInt("id");
        image = jsonObject.optString("image");
        password = jsonObject.optString("password");
        phone = jsonObject.optString("phone");
        type = jsonObject.optInt("type");
        weight = jsonObject.optString("weight");
    }

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("age", age);
            jsonObject.put("description", description);
            jsonObject.put("dob", dob);
            jsonObject.put("email", email);
            jsonObject.put("fullName", fullName);
            jsonObject.put("height", height);
            jsonObject.put("id", id);
            jsonObject.put("image", image);
            jsonObject.put("password", password);
            jsonObject.put("phone", phone);
            jsonObject.put("type", type);
            jsonObject.put("weight", weight);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }

}
