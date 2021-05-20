package com.example.fitnessapplicationand;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessapplicationand.fragments.FragmentProfile;
import com.example.fitnessapplicationand.fragments.FragmentWorkouts;
import com.example.fitnessapplicationand.fragments.FragmentTips;
import com.example.fitnessapplicationand.fragments.FragmentNotifications;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Activity3 extends AppCompatActivity {





    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        AppConfig.activity=true;

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        openProfile();
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.profile:openProfile(); break;
                            case R.id.workouts: openWorkout(); break;
                            case R.id.tips:openTips(); break;
                            case R.id.notifications: opennNotifications();
                            default:return true;
                        }
                        return true;
                    }
                }
        );


    }

    private void openProfile()
    {
        androidx.fragment.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new FragmentProfile(), "profile");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void openWorkout()
    {
        androidx.fragment.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new FragmentWorkouts(), "workouts");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void openTips()
    {
        androidx.fragment.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new FragmentTips(), "tips");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void opennNotifications()
    {
        androidx.fragment.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new FragmentNotifications(), "notifications");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }


}
