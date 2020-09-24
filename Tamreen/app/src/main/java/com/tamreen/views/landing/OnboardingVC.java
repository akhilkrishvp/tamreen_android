package com.tamreen.views.landing;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.ViewPager;

import com.tamreen.R;
import com.tamreen.core.Utilities.CoreVC;
import com.tamreen.core.Utilities.UserSettings;
import com.tamreen.model.staticModel.Onboarding;
import com.tamreen.views.account.StartUpVC;
import com.tamreen.views.adapter.AdapterImageSlider;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnboardingVC extends CoreVC {
    @BindView(R.id.onBoardingTitleTV)
    AppCompatTextView onBoardingTitleTV;
    @BindView(R.id.onBoardingDescTV)
    AppCompatTextView onBoardingDescTV;
    @BindView(R.id.letsStartedBtb)
    AppCompatTextView letsStartedBtb;
    @BindView(R.id.skipBtn)
    AppCompatTextView skipBtn;
    @BindView(R.id.dotsLayout)
    LinearLayout dotsLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    AdapterImageSlider adapterImageSlider;
    private TextView[] dots;
    private int mCurrentPge;
    ArrayList<Onboarding> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_vc);
        ButterKnife.bind(this);
        setData();
        viewPager.addOnPageChangeListener(onPageChangeListener);
        addDotIndicator(0);
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSettings.setOnBoardingFinished(true);
                Launch(StartUpVC.class);
            }
        });
        letsStartedBtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSettings.setOnBoardingFinished(true);
                Launch(StartUpVC.class);
            }
        });
    }

    public void addDotIndicator(int position) {
        dots = new TextView[2];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextColor(getResources().getColor(R.color.brownish_grey_2));
            dots[i].setTextSize(35);
            dots[i].setPadding(2,2,2,2);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.brownish_grey));
        }
    }
    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotIndicator(position);
            mCurrentPge=position;
            onBoardingTitleTV.setText(dataList.get(position).getName());
            onBoardingDescTV.setText(dataList.get(position).getDesc());
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private void setData(){
        dataList.add(new Onboarding("Smart & Skilled","Personalized workouts and plans for \nany fitness goal and skill level"));
        dataList.add(new Onboarding("View and Go","Preview your generated workout based \non your location and time"));
        adapterImageSlider = new AdapterImageSlider(this);
        viewPager.setAdapter(adapterImageSlider);
    }

}
