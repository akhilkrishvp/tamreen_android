package com.tamreen.views.account;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.tamreen.R;
import com.tamreen.core.Utilities.Constants;
import com.tamreen.core.Utilities.Converter;
import com.tamreen.core.Utilities.CoreVC;
import com.tamreen.core.Utilities.UserSettings;
import com.tamreen.customViews.MyDatePickerFragment;
import com.tamreen.model.api.account.LoginResponse;
import com.tamreen.model.api.account.UserObj;
import com.tamreen.model.api.account.UserResponse;
import com.tamreen.network.Api;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateProfileVC extends CoreVC implements View.OnClickListener  {

    @BindView(R.id.backBtn)
    ImageView backBtn;
    @BindView(R.id.toolBarTitleTV)
    AppCompatTextView toolBarTitleTV;
    @BindView(R.id.profileIV)
    CircleImageView profileIV;
    @BindView(R.id.editBtn)
    AppCompatTextView editBtn;
    @BindView(R.id.createProfileBtn)
    AppCompatTextView createProfileBtn;
    @BindView(R.id.degreesLayout)
    ConstraintLayout degreesLayout;
    @BindView(R.id.serviceLayout)
    ConstraintLayout serviceLayout;
    @BindView(R.id.locationLayout)
    ConstraintLayout locationLayout;
    @BindView(R.id.careerTimeLayout)
    ConstraintLayout careerTimeLayout;
    @BindView(R.id.customerContentLayout)
    ConstraintLayout customerContentLayout;
    @BindView(R.id.trainerContentLayout)
    ConstraintLayout trainerContentLayout;
    @BindView(R.id.nameTxt)
    AppCompatEditText nameTxt;
    @BindView(R.id.emailTxt)
    AppCompatEditText emailTxt;
    @BindView(R.id.phoneTxt)
    AppCompatEditText phoneTxt;
    @BindView(R.id.passwordTxt)
    AppCompatEditText passwordTxt;
    @BindView(R.id.heightTxt)
    AppCompatEditText heightTxt;
    @BindView(R.id.weightTxt)
    AppCompatEditText weightTxt;
    @BindView(R.id.ageTxt)
    AppCompatTextView ageTxt;
    @BindView(R.id.descriptionTxt)
    AppCompatEditText descriptionTxt;

    @BindView(R.id.errorNameTV)
    AppCompatTextView errorNameTV;
    @BindView(R.id.errorEmailTV)
    AppCompatTextView errorEmailTV;
    @BindView(R.id.errorHeightTV)
    AppCompatTextView errorHeightTV;
    @BindView(R.id.errorWeightTV)
    AppCompatTextView errorWeightTV;
    @BindView(R.id.errorAgeTV)
    AppCompatTextView errorAgeTV;
    @BindView(R.id.careerTimeTV)
    AppCompatTextView careerTimeTV;
    boolean isEdit = false;
    int type = 0;
    UserObj userObj = new UserObj();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        ButterKnife.bind(this);
        initClick();
        toolBarTitleTV.setText(getResources().getString(R.string.create_profile));
        initData();

    }
    private void initClick(){
        backBtn.setOnClickListener(this::onClick);
        profileIV.setOnClickListener(this::onClick);
        editBtn.setOnClickListener(this::onClick);
        createProfileBtn.setOnClickListener(this::onClick);
        degreesLayout.setOnClickListener(this::onClick);
        serviceLayout.setOnClickListener(this::onClick);
        locationLayout.setOnClickListener(this::onClick);
        ageTxt.setOnClickListener(this::onClick);
        careerTimeLayout.setOnClickListener(this::onClick);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backBtn:
                finishActivity();
                break;
            case R.id.profileIV:
                break;
            case R.id.editBtn:
                // edit click
                break;
            case R.id.createProfileBtn:
                validateInputs();
                // create btn click
                break;
            case R.id.degreesLayout:
                // degree click
                break;
            case R.id.serviceLayout:
                // service click
                break;
            case R.id.locationLayout:
                // location click
                break;
            case R.id.ageTxt:
                selectBirthDay();
                break;
            case R.id.careerTimeLayout:
                // careerTimeLayout click
                break;

        }
    }
    private void initData(){
        isEdit = getIntent().getBooleanExtra(Constants.IS_EDIT, false);
        try {
            userObj = (UserObj) getPassedModel(Constants.userObj, userObj.getClass());
            type = userObj.getType();
            if (!isEdit){
                phoneTxt.setText(userObj.getPhone());
                phoneTxt.setEnabled(false);
            }
            else {
                phoneTxt.setEnabled(true);
                getUserProfile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getUserProfile(){
        Api.getApi().getUserProfile(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.body() != null){

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }

    private void validateInputs(){
        if(TextUtils.isEmpty(nameTxt.getText().toString())){
            errorNameTV.setVisibility(View.VISIBLE);
        }
        else if(TextUtils.isEmpty(emailTxt.getText().toString())){
            errorEmailTV.setVisibility(View.VISIBLE);
        }
        else {
            if(type == 0){
                if(TextUtils.isEmpty(heightTxt.getText().toString())){
                    errorHeightTV.setVisibility(View.VISIBLE);
                }
                else if(TextUtils.isEmpty(weightTxt.getText().toString())){
                    errorWeightTV.setVisibility(View.VISIBLE);
                }
                else if(TextUtils.isEmpty(ageTxt.getText().toString())){
                    errorAgeTV.setVisibility(View.VISIBLE);
                }
                else {
                    errorNameTV.setVisibility(View.GONE);
                    errorEmailTV.setVisibility(View.GONE);
                    errorHeightTV.setVisibility(View.GONE);
                    errorWeightTV.setVisibility(View.GONE);
                    errorAgeTV.setVisibility(View.GONE);
                    String name = nameTxt.getText().toString();
                    String email = emailTxt.getText().toString();
                    String height = heightTxt.getText().toString();
                    String weight = weightTxt.getText().toString();
                    String age = ageTxt.getText().toString();
                    String desc = descriptionTxt.getText().toString();
                    String careerTime = "";
                    userObj.setFullName(name);
                    userObj.setEmail(email);
                    userObj.setHeight(height);
                    userObj.setWeight(weight);
                    userObj.setDob(age);
                    userObj.setDescription(desc);
                    userObj.setCareerTime(careerTime);
                    createProfile();
                }

            }
            else {
                errorNameTV.setVisibility(View.GONE);
                errorEmailTV.setVisibility(View.GONE);
                String name = nameTxt.getText().toString();
                String email = emailTxt.getText().toString();
                String desc = descriptionTxt.getText().toString();
                userObj.setFullName(name);
                userObj.setEmail(email);
                userObj.setDescription(desc);
                createProfile();
            }


        }

    }
    private void createProfile(){
        Api.getApi().createProfile(userObj, new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.body() != null){
                    UserSettings.setUserDetails(userObj,context);
                }
                else {

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    void selectBirthDay() {
        MyDatePickerFragment datePicker = new MyDatePickerFragment();
        datePicker.selectedDateListener = (view, year, month, day) -> {
            String selectedDate = view.getDayOfMonth() + "-" + (view.getMonth() + 1) + "-" + view.getYear();
            selectedDate = Converter.NumberArabicToEnglish(selectedDate);
            final String finalSelectedDate = selectedDate;
            runOnUiThread(() -> setBirthDate(finalSelectedDate));
        };
        datePicker.show(getSupportFragmentManager(), "date picker");
    }
    public void setBirthDate(String selectedDate) {
        ageTxt.setText(selectedDate);
    }
}
