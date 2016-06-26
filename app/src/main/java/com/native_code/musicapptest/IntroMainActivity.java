package com.native_code.musicapptest;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class IntroMainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setSkipEnabled(false);

        // Add the first slide
        addSlide(new SimpleSlide.Builder()
                .title(R.string.intro_slide_one_title)
                .description(R.string.intro_slide_one_desc)
                .background(R.color.intro_page_one)
                .backgroundDark(R.color.intro_page_one_dark)
                .image(R.mipmap.ic_launcher)
                .scrollable(true)
                .build());

        // check if device is running Android 6 or above, if so, ask for permissions
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.M) {

            // add the second slide for permissions
            addSlide(new SimpleSlide.Builder()
                    .title(R.string.intro_slide_two_title)
                    .description(R.string.intro_slide_two_desc)
                    .background(R.color.intro_page_two)
                    .backgroundDark(R.color.intro_page_two_dark)
                    .permission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    .image(R.drawable.ic_library_music)
                    .scrollable(true)
                    .build());

        }
    }

}
