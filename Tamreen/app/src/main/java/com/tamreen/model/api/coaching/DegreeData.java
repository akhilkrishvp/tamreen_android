package com.tamreen.model.api.coaching;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DegreeData {
    @SerializedName("coachingDegrees")
    private ArrayList<CoachingDegree> coachingDegreesList = new ArrayList<>();
    @SerializedName("degreeLevel")
    private ArrayList<DegreeLevel> degreeLevelsList = new ArrayList<>();

    public ArrayList<CoachingDegree> getCoachingDegreesList() {
        return coachingDegreesList;
    }

    public void setCoachingDegreesList(ArrayList<CoachingDegree> coachingDegreesList) {
        this.coachingDegreesList = coachingDegreesList;
    }

    public ArrayList<DegreeLevel> getDegreeLevelsList() {
        return degreeLevelsList;
    }

    public void setDegreeLevelsList(ArrayList<DegreeLevel> degreeLevelsList) {
        this.degreeLevelsList = degreeLevelsList;
    }

    /**
     * Instantiate the instance using the passed jsonObject to set the properties values
     */
    public DegreeData(JSONObject jsonObject){
        if(jsonObject == null){
            return;
        }
        JSONArray coachingDegreesJsonArray = jsonObject.optJSONArray("coachingDegrees");
        if(coachingDegreesJsonArray != null){
            ArrayList<CoachingDegree> coachingDegreesArrayList = new ArrayList<>();
            for (int i = 0; i < coachingDegreesJsonArray.length(); i++) {
                JSONObject coachingDegreesObject = coachingDegreesJsonArray.optJSONObject(i);
                coachingDegreesList.add(new CoachingDegree(coachingDegreesObject));
            }

        }		JSONArray degreeLevelJsonArray = jsonObject.optJSONArray("degreeLevel");
        if(degreeLevelJsonArray != null){
            ArrayList<DegreeLevel> degreeLevelArrayList = new ArrayList<>();
            for (int i = 0; i < degreeLevelJsonArray.length(); i++) {
                JSONObject degreeLevelObject = degreeLevelJsonArray.optJSONObject(i);
                degreeLevelsList.add(new DegreeLevel(degreeLevelObject));
            }
        }	}

    /**
     * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
     */
    public JSONObject toJsonObject()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            if(coachingDegreesList != null && coachingDegreesList.size() > 0){
                JSONArray coachingDegreesJsonArray = new JSONArray();
                for(CoachingDegree coachingDegreesElement : coachingDegreesList){
                    coachingDegreesJsonArray.put(coachingDegreesElement.toJsonObject());
                }
                jsonObject.put("coachingDegrees", coachingDegreesJsonArray);
            }
            if(degreeLevelsList != null && degreeLevelsList.size() > 0){
                JSONArray degreeLevelJsonArray = new JSONArray();
                for(DegreeLevel degreeLevelElement : degreeLevelsList){
                    degreeLevelJsonArray.put(degreeLevelElement.toJsonObject());
                }
                jsonObject.put("degreeLevel", degreeLevelJsonArray);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonObject;
    }


}
