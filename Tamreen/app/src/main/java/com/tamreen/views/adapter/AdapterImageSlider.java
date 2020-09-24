package com.tamreen.views.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.tamreen.R;

import java.util.ArrayList;

public class AdapterImageSlider extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;

    public AdapterImageSlider(Context context) {
        this.context = context;

    }
    private int [] slideImages={
            R.drawable.onboarding_1,R.drawable.onboarding_2
    };

    @Override
    public int getCount() {
        return slideImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.item_on_boarding_view_pager,container,false);

        ImageView onboardingIV = v.findViewById(R.id.onBoardingIV);
        onboardingIV.setImageResource(slideImages[position]);
        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}