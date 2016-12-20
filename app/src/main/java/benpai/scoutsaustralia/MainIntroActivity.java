package benpai.scoutsaustralia;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class MainIntroActivity extends IntroActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //Options
        setSkipEnabled(false);


        addSlide(new SimpleSlide.Builder()
                .title("Scouts Australia")
                .description("Welcome to the Scouts Australia app")
                .image(R.drawable.scouts_australia_logo)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                //.permission(Manifest.permission.CAMERA)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title("Award Scheme")
                .description("Browse the award scheme for any level of scouting")
                .image(R.drawable.intro_progress_tracker)
                .background(R.color.introSlide2)
                .backgroundDark(R.color.introSlide2Dark)
                //.permission(Manifest.permission.CAMERA)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title("Progress Tracker")
                .description("Keep track of your badges with the progress tracker")
                .image(R.drawable.intro_progress_tracker)
                .background(R.color.introSlide3)
                .backgroundDark(R.color.introSlide3Dark)
                //.permission(Manifest.permission.CAMERA)
                .build());
    }
}
