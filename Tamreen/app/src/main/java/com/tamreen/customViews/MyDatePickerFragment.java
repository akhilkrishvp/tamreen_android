package com.tamreen.customViews;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Date;

public class MyDatePickerFragment extends DialogFragment {

    public DatePickerDialog.OnDateSetListener selectedDateListener;

    public MyDatePickerFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), selectedDateListener, year, month, day);

        Calendar calendar = Calendar.getInstance();
        calendar.set(year-13,0,1);
        Date minDate = calendar.getTime();

        datePickerDialog.getDatePicker().setMaxDate(minDate.getTime());


        return datePickerDialog;
    }


}