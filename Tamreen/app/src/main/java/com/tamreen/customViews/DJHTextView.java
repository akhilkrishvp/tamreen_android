package com.tamreen.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.tamreen.R;


public class DJHTextView extends AppCompatTextView {


    private GradientDrawable d = new GradientDrawable();
    int fontType = 0;

    public DJHTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initStyle(context, attrs);
        init();
    }

    public DJHTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initStyle(context, attrs);
        init();

    }

    private void initStyle(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.DJHTextView, 0, 0);

        try {


            int cornerRadius = a.getInt(R.styleable.DJHTextView_djhCornerRadius, 0);
            int background = a.getColor(R.styleable.DJHTextView_backgroundColor, context.getResources().getColor(R.color.white));
           // fontType = a.getInt(R.styleable.DJHTextView_fontType,0);
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


    public DJHTextView(Context context) {
        super(context);
        init();
    }

    public void setTextBackground(int color) {
        d.setColor(color);
    }

    public void init() {

       // Typeface typeface = null;
      //  Log.e("font value....",""+fontType);
      //  typeface = Font.getFont(Font.FontType.fromInt(fontType));
       // setTypeface(typeface);
    }

}
