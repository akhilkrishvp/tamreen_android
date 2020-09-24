package com.tamreen.views.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tamreen.R;
import com.tamreen.core.Utilities.CoreFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BookingVC extends CoreFragment {
    Unbinder unbinder;

    public BookingVC() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bookings, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
}
