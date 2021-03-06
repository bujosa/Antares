package com.bujosa.antares.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.app.DatePickerDialog;

import java.util.Calendar;

public class DatePicker extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    final OnDateListener onDateListener;

    public DatePicker(OnDateListener onDateListener) {
        super();
        this.onDateListener = onDateListener;
    }

    public interface OnDateListener {
        void onSelected(int year, int month, int day);
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(android.widget.DatePicker view, int year, int month, int day) {
        this.onDateListener.onSelected(year, month, day);
    }

}