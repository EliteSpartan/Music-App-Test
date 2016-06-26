package com.native_code.musicapptest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    boolean viewIntro;
    CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);

        SharedPreferences mSharedPreferences = getSharedPreferences("Main", MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        viewIntro = mSharedPreferences.getBoolean("IntroScreen", false);

        if (!viewIntro) {
            Intent intent = new Intent(this, IntroMainActivity.class);
            startActivity(intent);

            viewIntro = true;
            editor.putBoolean("IntroScreen", viewIntro);
            editor.apply();
        }

//        Button button = (Button) findViewById(R.id.button);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), IntroMainActivity.class);
//                startActivity(intent);
//            }
//        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.menu_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_help:
                Snackbar.make(mCoordinatorLayout, menuItem.getTitle() + " was Clicked",
                        Snackbar.LENGTH_SHORT)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
