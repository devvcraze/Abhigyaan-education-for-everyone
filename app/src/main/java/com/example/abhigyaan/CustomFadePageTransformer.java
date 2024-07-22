package com.example.abhigyaan;

import android.animation.ObjectAnimator;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class CustomFadePageTransformer implements ViewPager2.PageTransformer {

    private static final long FADE_DURATION = 4000; // Duration in milliseconds

    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position < -1 || position > 1) {
            page.setAlpha(0);
        } else if (position <= 0 || position <= 1) {
            page.setAlpha(1 - Math.abs(position));
            ObjectAnimator fadeOut = ObjectAnimator.ofFloat(page, "alpha", 1 - Math.abs(position));
            fadeOut.setDuration(FADE_DURATION);
            fadeOut.start();
        } else {
            page.setAlpha(1);
        }
        page.setTranslationX(-position * page.getWidth());
    }
}
