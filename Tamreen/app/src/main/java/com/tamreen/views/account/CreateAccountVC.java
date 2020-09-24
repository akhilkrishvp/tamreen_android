package com.tamreen.views.account;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.tamreen.R;
import com.tamreen.core.Utilities.Constants;
import com.tamreen.core.Utilities.CoreVC;
import com.tamreen.network.Api;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateAccountVC extends CoreVC implements View.OnClickListener {

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
    @BindView(R.id.titleTV)
    AppCompatTextView titleTV;
    @BindView(R.id.phoneTxt)
    AppCompatEditText phoneTxt;
    @BindView(R.id.passwordTxt)
    AppCompatEditText passwordTxt;
    int loginType = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initClick();
        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backLayout:
                finishActivity();
                break;
            case R.id.signUp:
                Launch(LoginVC.class);
                break;
            case R.id.customerTabTV:
                loginType = 0;
                tabSelection(true);
                break;
            case R.id.trainerTabTV:
                loginType = 1;
                tabSelection(false);
                break;
            case R.id.forgotPwdTV:
                break;
            case R.id.btnLogin:
                validateFields();

                break;

        }
    }
    private void initView(){
        signUp.setText(getResources().getString(R.string.log_in));
        titleTV.setText(getResources().getString(R.string.signup_text));
        btnLogin.setText(getResources().getString(R.string.create_account));
        forgotPwdTV.setVisibility(View.GONE);
    }
    private void initClick(){
        backLayout.setOnClickListener(this::onClick);
        signUp.setOnClickListener(this::onClick);
        customerTabTV.setOnClickListener(this::onClick);
        trainerTabTV.setOnClickListener(this::onClick);
        forgotPwdTV.setOnClickListener(this::onClick);
        btnLogin.setOnClickListener(this::onClick);
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
            createAccount(phoneTxt.getText().toString(),
                    passwordTxt.getText().toString());
        }
    }
    private void createAccount(String phone,String password){
        signUp(phone,password);
    }
    private void signUp(String phone,String password){
        startIndicator();
        Api.getApi().signUp(phone, password, loginType, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                stopIndicator();
                if(response.body() != null){
                    Launch(OtpActivity.class, Constants.PHONE,phone,Constants.TYPE,loginType);
                }
                else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(getApplicationContext(),jObjError.getString("message"),Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}