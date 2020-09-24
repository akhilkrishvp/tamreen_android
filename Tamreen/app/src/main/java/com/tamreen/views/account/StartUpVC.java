package com.tamreen.views.account;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatTextView;

import com.tamreen.R;
import com.tamreen.core.Utilities.CoreVC;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartUpVC extends CoreVC {
    @BindView(R.id.createAccountBtn)
    AppCompatTextView createAccountBtn;
    @BindView(R.id.loginLayout)
    LinearLayout loginLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up_vc);
        ButterKnife.bind(this);
        createAccountBtn.setOnClickListener(view -> {
            Launch(CreateAccountVC.class);
        });
        loginLayout.setOnClickListener(view -> {
            Launch(LoginVC.class);
        });
    }
}
