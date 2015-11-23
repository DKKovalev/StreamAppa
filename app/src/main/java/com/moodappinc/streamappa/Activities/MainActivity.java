package com.moodappinc.streamappa.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.moodappinc.streamappa.R;

public class MainActivity extends FragmentActivity {

    private FragmentManager fragmentManager;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragment = fragmentManager.findFragmentById();
        if (fragment == null) {
            fragment = new Fragment();
            fragmentManager.beginTransaction()
                    .add()
                    .commit();
        }
    }
}
