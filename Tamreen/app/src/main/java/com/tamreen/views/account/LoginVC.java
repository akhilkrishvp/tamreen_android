package com.tamreen.views.account;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.tamreen.R;
import com.tamreen.core.Utilities.CoreVC;
import com.tamreen.model.api.account.LoginResponse;
import com.tamreen.network.Api;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginVC extends CoreVC implements View.OnClickListener {

    @BindView(R.id.backLayout)
    LinearLayout backLayout;
    @BindView(R.id.signUp)
    AppCompatTextView signUp;
    @BindView(R.id.customerTabTV)
    AppCompatTextView customerTabTV;
    @BindView(R.id.trainerTabTV)
    AppCompatTextView trainerTabTV;
    @BindView(R.id.forgotPwdTV)
    AppCompatTextView forgotPwdTV;
    @BindView(R.id.btnLogin)
    AppCompatTextView btnLogin;
    @BindView(R.id.phoneNumberError)
    AppCompatTextView phoneNumberError;
    @BindView(R.id.pwdError)
    AppCompatTextView pwdError;
    @BindView(R.id.phoneTxt)
    AppCompatEditText phoneTxt;
    @BindView(R.id.passwordTxt)
    AppCompatEditText passwordTxt;
    @BindView(R.id.titleTV)
    AppCompatTextView titleTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initClick();
    }
    private void initClick(){
        backLayout.setOnClickListener(this::onClick);
        signUp.setOnClickListener(this::onClick);
        customerTabTV.setOnClickListener(this::onClick);
        trainerTabTV.setOnClickListener(this::onClick);
        forgotPwdTV.setOnClickListener(this::onClick);
        btnLogin.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backLayout:
                finishActivity();
                break;
            case R.id.signUp:
                Launch(CreateAccountVC.class);
                break;
            case R.id.customerTabTV:
                tabSelection(true);
                break;
            case R.id.trainerTabTV:
                tabSelection(false);
                break;
            case R.id.forgotPwdTV:
                break;
            case R.id.btnLogin:
                validateFields();
                break;

        }
    }
    private void tabSelection(boolean isCustomer){
        if(isCustomer){
            customerTabTV.setBackgroundResource(R.drawable.tab_selected_bg);
            trainerTabTV.setBackgroundResource(R.drawable.tab_un_selected_bg);
            customerTabTV.setTextColor(getResources().getColor(R.color.black));
            trainerTabTV.setTextColor(getResources().getColor(R.color.grey));
        }
        else {
            customerTabTV.setBackgroundResource(R.drawable.tab_un_selected_bg);
            trainerTabTV.setBackgroundResource(R.drawable.tab_selected_bg);
            customerTabTV.setTextColor(getResources().getColor(R.color.grey));
            trainerTabTV.setTextColor(getResources().getColor(R.color.black));
        }
    }
    private void validateFields(){
        if(TextUtils.isEmpty(phoneTxt.getText().toString())){
            phoneNumberError.setVisibility(View.VISIBLE);
        }
        else  if(passwordTxt.getText().length() < 8){
            pwdError.setVisibility(View.VISIBLE);
        }
        else {
            phoneNumberError.setVisibility(View.GONE);
            phoneNumberError.setVisibility(View.GONE);
            login(phoneTxt.getText().toString(),
                    passwordTxt.getText().toString());
        }
    }
    private void login(String userName,String password){
        Api.getApi().login(userName, password, new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                stopIndicator();
                if(response.body() != null){

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}
