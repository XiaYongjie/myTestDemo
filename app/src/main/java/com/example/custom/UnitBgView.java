package com.example.custom;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.myscrollview.R;


public class UnitBgView extends FrameLayout {
    private TextView bg;

    public UnitBgView(Context context) {
        super(context);
        init();
    }

    public UnitBgView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UnitBgView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.oxford_view_item_simple, this);
        bg = findViewById(R.id.oxford_tv);
    }
    public void setText(String text){
        bg.setText(text);
        bg.setTextColor(Color.TRANSPARENT);
        bg.setBackgroundResource(R.drawable.bg_tv_bg_shape);

    }

}
