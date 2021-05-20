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



        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS,  Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String weight = sharedPreferences.getString(TEXTweight, null);
        String height = sharedPreferences.getString(TEXTheight, null);
        String age = sharedPreferences.getString(TEXTage, null);

        View view = inflater.inflate(R.layout.fragment_fragment_profile, container, false);

        TextView weightEdit = (TextView) view.findViewById(R.id.weightEdit);
        TextView heightEdit = (TextView) view.findViewById(R.id.heightEdit);
        TextView ageEdit = (TextView) view.findViewById(R.id.ageEdit);

        AppCompatButton plus =(AppCompatButton) view.findViewById(R.id.plus);
        AppCompatButton minus = (AppCompatButton) view.findViewById(R.id.minus);
        AppCompatButton save = (AppCompatButton) view.findViewById(R.id.save_button);

        weightEdit.setText(weight);
        heightEdit.setText(height);
        ageEdit.setText(age);



        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(weightEdit.getText().toString())>0)
        {
            int weight_value = Integer.parseInt(weightEdit.getText().toString())+1;
            weightEdit.setText(String.valueOf(weight_value));
        }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(weightEdit.getText().toString())>0)
        {
            int weight_value = Integer.parseInt(weightEdit.getText().toString())-1;
            weightEdit.setText(String.valueOf(weight_value));
        }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(TEXTweight, weightEdit.getText().toString());
                editor.apply();

                Toast.makeText(getContext(), "Data updated", Toast.LENGTH_SHORT).show();
            }
        });



//        calculate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                float weightVal = Float.parseFloat(weightEdit.getText().toString().replaceAll("S\\$|\\.$", ""));
//                float heightVal =( Float.parseFloat(heightEdit.getText().toString().replaceAll("S\\$|\\.$", "")))/100;
//                double bmiVal = weightVal/(heightVal*heightVal);
//                bmiEdit.setText(String.valueOf(bmiVal));
//                System.out.println(weightEdit.getText().toString());
//                System.out.println(heightEdit.getText().toString());
//            }
//        });

return view;
    }

//    public void showResult(View view) {
//        int get_age = Integer.parseInt(TEXTage);
//        int weight_value = Integer.parseInt(TEXTweight);
//        double get_height = Double.parseDouble(TEXTheight);
//
//        int bmi = weight_value / (int)(get_height*get_height);
//        showBMI(bmi);
//
//
//    }
//
//    private void showBMI(int bmi)
//    {
//
//        if(bmi<18.5)
//        {
//            showCustomDialog("Underweight", "Eat foods that are high in carbohidrates and fats");
//        }
//        else if(bmi>18.5 && bmi<24.9)
//        {
//            showCustomDialog("Normal weight", "You are healthy");
//        }
//        else if(bmi>25){
//            showCustomDialog("Overweight", "Eat foods with less carbohidrates and more protein");
//        }
//
//
//    }
//
//    private void showCustomDialog(String title, String tip)
//    {
//        ViewGroup viewgroup = getView().findViewById(android.R.id.content);
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.custome_dialog, viewgroup, false);
//        AppCompatButton ok = view.findViewById(R.id.ok);
//
//        TextView result = view.findViewById(R.id.result_title);
//        TextView tips = view.findViewById(R.id.tips);
//        result.setText(title);
//        tips.setText(tip);
//
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        builder.setView(view);
//
//
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//
//
//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog.dismiss();
//            }
//        });
//    }

}