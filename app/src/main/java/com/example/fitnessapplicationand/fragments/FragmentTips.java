package com.example.fitnessapplicationand.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessapplicationand.API.Quote;
import com.example.fitnessapplicationand.API.QuoteAPI;
import com.example.fitnessapplicationand.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragmentTips extends Fragment {

    public FragmentTips() {
        // Required empty public constructor
    }

    private EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_tips, container, false);
        TextView text = view.findViewById(R.id.quoteText);
        TextView author = view.findViewById(R.id.quoteAuthor);

        //take random quotes from the api
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.forismatic.com/api/1.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QuoteAPI quoteAPI = retrofit.create(QuoteAPI.class);
        Call<Quote> call = quoteAPI.getQuote();

        call.enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                if (!response.isSuccessful()) {
                    text.setText("Code: " + response.code());
                    return;
                }
                Toast.makeText(getActivity(), response.body().getQuoteText(), Toast.LENGTH_SHORT).show();
                text.setText(response.body().getQuoteText());

                if (response.body().getQuoteAuthor().equals(""))
                    author.setText("Unknown author");
                else
                    author.setText("\"" + response.body().getQuoteAuthor() + "\"");
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });


        return view;
    }


}