package com.example.myscrollview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {
    public MyScrollView(@NonNull Context context) {
        super(context);
    }

    public MyScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private float mDownPosY = 0;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final float y = ev.getY();

        final int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mDownPosY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                final float deltaY = y - mDownPosY;
                // 这里是够拦截的判断依据是左右滑动，读者可根据自己的逻辑进行是否拦截
                if (deltaY <0 && getChildAt(0).getHeight()-getHeight() ==getScrollY()) {
                    return false;
                }

                if (deltaY>0 && getScrollY()==0) {
                    return false;
                }
        }

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean result  = super.onTouchEvent(ev);
        Log.e("XYJ","onTouchEvent: "+result);
        return result;
    }
}
