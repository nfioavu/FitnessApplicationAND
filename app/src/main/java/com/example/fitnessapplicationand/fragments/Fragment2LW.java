package com.example.fitnessapplicationand.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fitnessapplicationand.recyclerView.MyRecyclerViewAdapter;
import com.example.fitnessapplicationand.R;
import com.example.fitnessapplicationand.recyclerView.Workout;

import java.util.ArrayList;


public class Fragment2LW extends Fragment implements MyRecyclerViewAdapter.ItemClickListener {

    public Fragment2LW() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_fragment2_l_w, container, false);

        Workout workout1 = new Workout();
        workout1.setDay("DAY 1 - Total body");
        workout1.setEx("ROUND 1 \n 15 Jump squats \n 15 Bench hops \n 15 Jumps toe taps \n 10 Weighed lunges \n 10 Box/bench jumps \n \n ROUND 2 \n 10 Burpees \n 15 Jackknives \n 10 Push ups \n 20sec Rope skipping \n 15 Squat & press");

        Workout workout2 = new Workout();
        workout2.setDay("DAY 2 - Arms & abs");
        workout2.setEx("ROUND 1 \n 10 Bench push ups \n 20 Scissor kicks \n 10 Squat & shoulder press \n 10 Straigh leg sit ups \n 10 Bent leg raises with hip lift \n \nROUND 2 \n 10 Weighted bent leg jackknives \n 10 Bench dips \n 10 Raised leg sit ups with twist \n 5 Mountain climbers + 5 push ups \n 15 Commandos");


        Workout workout3 = new Workout();
        workout3.setDay("DAY 3 - Legs & glutes");
        workout3.setEx("ROUND 1 \n 10 Kneeling step ups \n 10 Tuck jumps  \n 10 Weighed walking lunges \n 10 180 degree jump squat \n 20sec Rope skipping \n \n ROUND 2 \n 20 Crab walks \n 10 Bench/box jumps \n 20 Squats \n 10 Weighted bench step ups \n 15 Jump squats");


        Workout workout4 = new Workout();
        workout4.setDay("DAY 4 - Optional total body");
        workout4.setEx("ROUND 1 \n 10 Burpees \n 15 Weighted double bench squats  \n 15 Plank jacks \n 10 Laydown push ups \n 10 Jumping lunges \n \n ROUND 2 \n 25 sec Rope skipping \n 15 180 degree jump squat \n 15 Twisted sit ups \n 10 Burpees \n 15 Squat & shoulder press");


        ArrayList<Workout> workouts = new ArrayList<>();
        workouts.add(workout1);
        workouts.add(workout2);
        workouts.add(workout3);
        workouts.add(workout4);




        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new MyRecyclerViewAdapter(view.getContext(), workouts);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return view;
    }

   @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}