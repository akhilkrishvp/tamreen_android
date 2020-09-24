package com.tamreen.views.account;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;

import com.davidmiguel.numberkeyboard.NumberKeyboard;
import com.davidmiguel.numberkeyboard.NumberKeyboardListener;
import com.tamreen.R;
import com.tamreen.core.Utilities.Constants;
import com.tamreen.core.Utilities.CoreVC;
import com.tamreen.core.Utilities.UserSettings;
import com.tamreen.model.api.account.OtpResponse;
import com.tamreen.network.Api;
import com.tamreen.views.splash.LaunchVC;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpActivity extends CoreVC implements NumberKeyboardListener {

    @BindView(R.id.text1)
    AppCompatTextView text1;
    @BindView(R.id.text2)
    AppCompatTextView text2;
    @BindView(R.id.text3)
    AppCompatTextView text3;
    @BindView(R.id.text4)
    AppCompatTextView text4;
    StringBuilder sb = new StringBuilder(100);
    NumberKeyboard numberKeyboard;
    String phone = "";
    int loginType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_view);
        ButterKnife.bind(this);
        numberKeyboard = (NumberKeyboard) findViewById(R.id.numberKeyboard);
        numberKeyboard.setNumberKeyTypeface(ResourcesCompat.getFont(context, R.font.sf_pro_bold));
        numberKeyboard.setListener(this);
        phone = getIntent().getStringExtra(Constants.PHONE);
        loginType = getIntent().getIntExtra(Constants.TYPE,0);
    }

    @Override
    public void onLeftAuxButtonClicked() {

    }

    @Override
    public void onNumberClicked(int i) {
        if(sb.length() < 5){
            sb.append(i);
            setText(sb.length());
            if (sb.length() == 4) {
                Log.e("API ..","call");
                verifyOtp(sb.toString());
                //Launch(CreateProfileVC.class);
            }

        }
    }

    @Override
    public void onRightAuxButtonClicked() {
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        } else {
            sb = new StringBuilder();
        }
        deleteText(sb.length());
    }
    private void setText(int length) {
        switch (length) {
            case 1:
                text1.setText("*");
                text1.setBackgroundResource(R.drawable.otp_selected);
                break;
            case 2:
                text2.setText("*");
                text2.setBackgroundResource(R.drawable.otp_selected);
                break;
            case 3:
                text3.setText("*");
                text3.setBackgroundResource(R.drawable.otp_selected);
                break;
            case 4:
                text4.setText("*");
                text4.setBackgroundResource(R.drawable.otp_selected);
                break;
        }
    }

    private void deleteText(int length) {
        switch (length) {
            case 0:
                text1.setText("");
                text1.setBackgroundResource(R.drawable.otp_bg);
                break;
            case 1:
                text2.setText("");
                text2.setBackgroundResource(R.drawable.otp_bg);
                break;
            case 2:
                text3.setText("");
                text3.setBackgroundResource(R.drawable.otp_bg);
                break;
            case 3:
                text4.setText("");
                text4.setBackgroundResource(R.drawable.otp_bg);
                break;
        }
    }

    private void verifyOtp(String otp){
        startIndicator();
        Api.getApi().verifyOtp(phone, otp, new Callback<OtpResponse>() {
            @Override
            public void onResponse(Call<OtpResponse> call, Response<OtpResponse> response) {
                stopIndicator();
                if(response.body() != null){
                    UserSettings.setAccessToken(response.body().getResult().getAccessToken(),context);
                    HashMap<String, Boolean> hashMap = new HashMap<>();
                    hashMap.put(Constants.IS_EDIT, false);
                    response.body().getResult().getUser().setType(loginType);
                    LaunchWithExtras(CreateProfileVC.class,Constants.userObj,response.body().getResult().getUser(),hashMap);
                }
            }

            @Override
            public void onFailure(Call<OtpResponse> call, Throwable t) {

            }
        });
    }
}
