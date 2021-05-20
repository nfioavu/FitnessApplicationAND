package com.example.fitnessapplicationand;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fitnessapplicationand.fragments.Fragment1LW;
import com.example.fitnessapplicationand.fragments.Fragment2LW;
import com.example.fitnessapplicationand.fragments.Fragment3LW;
import com.example.fitnessapplicationand.fragments.Fragment4LW;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Activity3 extends AppCompatActivity {





    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);



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
        fragmentTransaction.replace(R.id.container, new Fragment1LW(), "profile");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void openWorkout()
    {
        androidx.fragment.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new Fragment2LW(), "workouts");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void openTips()
    {
        androidx.fragment.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new Fragment3LW(), "tips");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void opennNotifications()
    {
        androidx.fragment.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new Fragment4LW(), "notifications");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }


}
