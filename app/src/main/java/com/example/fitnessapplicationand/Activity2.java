package com.example.fitnessapplicationand;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSeekBar;

public class Activity2 extends AppCompatActivity {


    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXTage = "age";
    public static final String TEXTweight = "weight";
    public static final String TEXTheight = "height";
    public static final String TEXTbmi = "bmi";

    private TextView age;
    private TextView weight;
    private AppCompatSeekBar seekBar;
    private TextView height_value;
    private AppCompatButton saveButton;

    private String savedAge;
    private String savedWeight;
    private String savedHeight;
    private String savedBmi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        age = findViewById(R.id.age);
        weight = findViewById(R.id.weight);
        seekBar = findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(listener);
        height_value = findViewById(R.id.height_value);

        saveButton = findViewById(R.id.save_button);

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


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();
            }
        });
        loadData();
        updateViews();
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXTage, age.getText().toString());
        editor.putString(TEXTheight, height_value.getText().toString());
        editor.putString(TEXTweight, weight.getText().toString());

        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();

        openActivity3();
    }

    public void openActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        savedAge = sharedPreferences.getString(TEXTage, "");
        savedHeight = sharedPreferences.getString(TEXTheight, "");
        savedWeight = sharedPreferences.getString(TEXTweight, "");
    }

    public void updateViews() {
        age.setText(savedAge);
        height_value.setText(savedHeight);
        weight.setText(savedWeight);
    }

    //taking out the value from the progress bar
    private SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            height_value.setText(String.format("%d cm", progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public void increaseAge(View view) {
        if (Integer.parseInt(age.getText().toString()) > 0) {
            int age_value = Integer.parseInt(age.getText().toString()) + 1;
            age.setText(String.valueOf(age_value));
        }
    }

    public void decreaseAge(View view) {
        if (Integer.parseInt(age.getText().toString()) > 0) {
            int age_value = Integer.parseInt(age.getText().toString()) - 1;
            age.setText(String.valueOf(age_value));
        }
    }

    public void increaseWeight(View view) {
        if (Integer.parseInt(weight.getText().toString()) > 0) {
            int weight_value = Integer.parseInt(weight.getText().toString()) + 1;
            weight.setText(String.valueOf(weight_value));
        }
    }

    public void decreaseWeight(View view) {
        if (Integer.parseInt(weight.getText().toString()) > 0) {
            int weight_value = Integer.parseInt(weight.getText().toString()) - 1;
            weight.setText(String.valueOf(weight_value));
        }
    }

    public void showResult(View view) {
        int get_age = Integer.parseInt(age.getText().toString());
        int weight_value = Integer.parseInt(weight.getText().toString());
        double get_height = (double) seekBar.getProgress();
        double heightm2 = get_height * get_height / 10000;
        double bmi = weight_value / heightm2;
        showBMI(bmi);


    }

    private void showBMI(double bmi) {

        if (bmi < 18.5) {
            showCustomDialog("Underweight", "Eat foods that are high in carbohidrates and fats");
        } else if (bmi < 25 && bmi > 18.5) {
            showCustomDialog("Normal weight", "You are healthy");
        } else if (bmi > 25) {
            showCustomDialog("Overweight", "Eat foods with less carbohidrates and more protein");
        }


    }

    //showing a pop up with the bmi result and advice
    private void showCustomDialog(String title, String tip) {
        ViewGroup viewgroup = findViewById(android.R.id.content);
        View view = LayoutInflater.from(this).inflate(R.layout.custome_dialog, viewgroup, false);
        AppCompatButton ok = view.findViewById(R.id.ok);

        TextView result = view.findViewById(R.id.result_title);
        TextView tips = view.findViewById(R.id.tips);
        result.setText(title);
        tips.setText(tip);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);


        AlertDialog alertDialog = builder.create();
        alertDialog.show();


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}
