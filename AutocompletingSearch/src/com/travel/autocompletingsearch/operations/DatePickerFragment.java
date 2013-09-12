package com.travel.autocompletingsearch.operations;

import java.util.Calendar;

import com.travel.autocompletingsearch.MainActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;
/**
 * 
 * @author munish
 *
 */
@SuppressLint("ValidFragment")
public class DatePickerFragment extends DialogFragment
implements DatePickerDialog.OnDateSetListener {
	EditText editText;
	@SuppressLint("ValidFragment")
	public DatePickerFragment(EditText editText){
		this.editText=editText;
	}
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
	// Use the current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		// Create a new instance of DatePickerDialog and return it
		return new DatePickerDialog(getActivity(), this, year, month, day);
	}
    //## OndateSet update the EditText value
	public void onDateSet(DatePicker view, int year, int month, int day) {
	// Do something with the date chosen by the user
		this.editText.setText(day+"."+month+"."+year);
	}
	
}
