package com.tamreen.customViews;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import com.tamreen.core.Utilities.GlobalApplication;


public class DJHButton extends AppCompatButton {
    int fontType = 0;

    public DJHButton(Context context) {
        super(context);
        init();
    }

    public DJHButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DJHButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {

        AssetManager am = GlobalApplication.getAppContext().getAssets();
        Typeface typeface;

    }

}
