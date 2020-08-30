package com.example.custom;

import android.support.v4.view.ViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;

/**
 * 简化和ViewPager绑定
 * Created by hackware on 2016/8/17.
 */

public class BookViewPagerHelper {
    public static void bind(final MagicIndicator magicIndicator, VerticalViewPager viewPager, final int siae) {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                magicIndicator.onPageScrolled(siae -position-1, 1-positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                magicIndicator.onPageSelected(siae -position-1);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                magicIndicator.onPageScrollStateChanged(state);
            }
        });
    }
}
