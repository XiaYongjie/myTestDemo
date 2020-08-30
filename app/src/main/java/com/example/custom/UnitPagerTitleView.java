package com.example.custom;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myscrollview.R;

import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView;


/**
 * 带文本的指示器标题
 * 博客: http://hackware.lucode.net
 * Created by hackware on 2016/6/26.
 */
public class UnitPagerTitleView extends LinearLayout implements IMeasurablePagerTitleView {
    protected int mSelectedColor;
    protected int mNormalColor;
    private TextView textView;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int paddingBottom;
    public UnitPagerTitleView(Context context) {
        super(context, null);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.oxford_view_item_simple,this);
        textView = findViewById(R.id.oxford_tv);
    }

    @Override
    public void onSelected(int index, int totalCount) {
        textView.setTextColor(mSelectedColor);
    }

    @Override
    public void onDeselected(int index, int totalCount) {
        textView.setTextColor(mNormalColor);
    }

    @Override
    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
    }

    @Override
    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
    }

    @Override
    public int getContentLeft() {
        return getLeft() + paddingLeft- UIUtil.dip2px(getContext(),0.5f);
    }

    @Override
    public int getContentTop() {
        return paddingTop- UIUtil.dip2px(getContext(),0.5f);
    }

    @Override
    public int getContentRight() {
        return getLeft() + paddingLeft + textView.getWidth()+ UIUtil.dip2px(getContext(),0.5f);
    }
    @Override
    public int getContentBottom() {
        return textView.getHeight()+paddingBottom+ UIUtil.dip2px(getContext(),0.5f);
    }

    public int getSelectedColor() {
        return mSelectedColor;
    }

    public void setSelectedColor(int selectedColor) {
        mSelectedColor = selectedColor;
    }

    public int getNormalColor() {
        return mNormalColor;
    }

    public void setNormalColor(int normalColor) {
        mNormalColor = normalColor;
    }

    public void setText(String str){
        textView.setText(str);
    }

    public String getText(){
       return textView.getText().toString();
    }
    public void setPadding(int paddingLeft,int paddingTop,int paddingRight,int paddingBottom){
        this.paddingLeft = paddingLeft;
        this.paddingTop = paddingTop;
        this.paddingRight = paddingRight;
        this.paddingBottom = paddingBottom;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
