package com.example.fitnessapplicationand.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessapplicationand.R;

import static com.example.fitnessapplicationand.Activity2.SHARED_PREFS;
import static com.example.fitnessapplicationand.Activity2.TEXTage;
import static com.example.fitnessapplicationand.Activity2.TEXTheight;
import static com.example.fitnessapplicationand.Activity2.TEXTweight;


public class FragmentProfile extends Fragment {

//    private TextView weightEdit;

//    private TextView heightEdit = getView().findViewById(R.id.heightEdit);
//    private TextView ageEdit = getView().findViewById(R.id.ageEdit);
//
//    private String savedWeight;
//    private Button saveButton = getView().findViewById(R.id.save_button);


    public FragmentProfile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_profile, container, false);

        AppCompatButton plus = (AppCompatButton) view.findViewById(R.id.plus);
        AppCompatButton minus = (AppCompatButton) view.findViewById(R.id.minus);
        AppCompatButton save = (AppCompatButton) view.findViewById(R.id.save_button);

        //retrieve data from SharedPreferences
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String weight = sharedPreferences.getString(TEXTweight, null);
        String height = sharedPreferences.getString(TEXTheight, null);
        String age = sharedPreferences.getString(TEXTage, null);

        TextView weightEdit = (TextView) view.findViewById(R.id.weightEdit);
        TextView heightEdit = (TextView) view.findViewById(R.id.heightEdit);
        TextView ageEdit = (TextView) view.findViewById(R.id.ageEdit);

        weightEdit.setText(weight);
        heightEdit.setText(height);
        ageEdit.setText(age);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(weightEdit.getText().toString()) > 0) {
                    int weight_value = Integer.parseInt(weightEdit.getText().toString()) + 1;
                    weightEdit.setText(String.valueOf(weight_value));
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(weightEdit.getText().toString()) > 0) {
                    int weight_value = Integer.parseInt(weightEdit.getText().toString()) - 1;
                    weightEdit.setText(String.valueOf(weight_value));
                }
            }
        });

        //save the new weight into our SharePreferences
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(TEXTweight, weightEdit.getText().toString());
                editor.apply();

                Toast.makeText(getContext(), "Data updated", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}