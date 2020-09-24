package com.tamreen.customViews;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

import com.tamreen.R;
import com.tamreen.core.Utilities.GlobalApplication;


public class DJHEditText extends AppCompatAutoCompleteTextView {
    int fontType = 0;
    private GradientDrawable d = new GradientDrawable();
    public DJHEditText(Context context) {
        super(context);
        init();
    }

    public DJHEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        //initStyle(context, attrs);
        init();
    }

    public DJHEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       // initStyle(context, attrs);
        init();
    }

    private void initStyle(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.DJHTextView, 0, 0);

        try {
            int cornerRadius = a.getInt(R.styleable.DJHTextView_djhCornerRadius, 0);
            int background = a.getColor(R.styleable.DJHTextView_backgroundColor, context.getResources().getColor(R.color.white));
            // int borderColor = a.getColor(R.styleable.DJHTextView_borderColor, context.getResources().getColor(R.color.white));
            int borderSize = a.getInt(R.styleable.DJHTextView_borderSize, 0);
            d.setCornerRadius(cornerRadius);
            d.setColor(background);
            // d.setStroke(borderSize, borderColor);
            setBackground(d);

        } finally {
            a.recycle();
        }
    }
    public void init() {
        AssetManager am = GlobalApplication.getAppContext().getAssets();
        Typeface typeface;

    }
}
