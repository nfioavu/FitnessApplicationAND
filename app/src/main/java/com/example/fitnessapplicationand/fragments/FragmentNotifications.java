package com.example.fitnessapplicationand.fragments;

import android.app.Notification;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.fitnessapplicationand.Notif;
import com.example.fitnessapplicationand.R;


public class FragmentNotifications extends Fragment {

private NotificationManagerCompat notificationManager;
private EditText editTitle;
private EditText editMessage;
private TimePicker timePicker;

private AppCompatButton channel1btn;
private AppCompatButton channel2btn;

    public FragmentNotifications() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_notifications, container, false);

        notificationManager = NotificationManagerCompat.from(view.getContext());

        editTitle = (EditText) view.findViewById(R.id.editTitle);
        editMessage = (EditText) view.findViewById(R.id.editMessage);
        timePicker = (TimePicker) view.findViewById(R.id.timePicker);

        channel1btn = (AppCompatButton) view.findViewById(R.id.channel1Button);
        channel2btn = (AppCompatButton) view.findViewById(R.id.channel2Button);

        channel1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString();
                String message = editMessage.getText().toString();
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                Notification notification = new NotificationCompat.Builder(view.getContext(), Notif.CHANNEL_1_ID).setSmallIcon(R.drawable.ic_baseline_looks_one_24)
                        .setContentTitle(title).setContentText(message + "\n"+ "to do at: " + hour + ":" + minute).setPriority(NotificationCompat.PRIORITY_HIGH).setCategory(NotificationCompat.CATEGORY_MESSAGE).build();
                notificationManager.notify(1, notification);
            }
        });

        channel2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString();
                String message = editMessage.getText().toString();
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                Notification notification = new NotificationCompat.Builder(view.getContext(), Notif.CHANNEL_2_ID).setSmallIcon(R.drawable.ic_baseline_looks_two_24)
                        .setContentTitle(title).setContentText(message+ "\n" + "to do at: " + hour + ":" + minute).setPriority(NotificationCompat.PRIORITY_LOW).build();
                notificationManager.notify(2, notification);
            }
        });

        return view;
    }
}