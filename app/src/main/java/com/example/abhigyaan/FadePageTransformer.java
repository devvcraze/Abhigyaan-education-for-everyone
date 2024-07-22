package com.example.abhigyaan;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import android.view.View;

public class FadePageTransformer implements ViewPager2.PageTransformer {

    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setTranslationX(-position * page.getWidth());
        page.setAlpha(1 - Math.abs(position));
    }
}
