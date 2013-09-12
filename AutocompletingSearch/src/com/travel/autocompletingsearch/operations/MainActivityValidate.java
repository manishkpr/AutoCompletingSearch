package com.travel.autocompletingsearch.operations;

import android.app.Activity;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.travel.autocompletingsearch.R;

public class MainActivityValidate {
   public static void validData(Activity act,AutoCompleteTextView start,AutoCompleteTextView end,EditText date,Button search){
	   if(!start.getText().toString().equalsIgnoreCase("")){
		   if(!end.getText().toString().equalsIgnoreCase("")){
			   if(!date.getText().toString().equalsIgnoreCase("")){
					showMsg(act,act.getResources().getString(R.string.search_msg));
			   }else{
				   showMsg(act,act.getResources().getString(R.string.date_msg));
			   }
		   }else{
			   showMsg(act,act.getResources().getString(R.string.end_loc_msg));
		   }
	   }else{
		   showMsg(act,act.getResources().getString(R.string.start_loc_msg));
	   }
   }
   static void showMsg(Activity act,String msg){
	   Toast.makeText(act, msg, Toast.LENGTH_SHORT).show();
   }
}
