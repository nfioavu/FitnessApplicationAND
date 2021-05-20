package com.example.fitnessapplicationand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //allows for this activity to only open for the very first time when using the app
        if (AppConfig.activity == false) {
            Intent intent = new Intent();
            intent.setClass(this, Activity3.class);
            startActivity(intent);
            this.finish();
        }
        if (AppConfig.activity == true) {

            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);
            startActivity(intent);

        }

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


    }

    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }


}