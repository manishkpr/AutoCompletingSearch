package com.travel.autocompletingsearch;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.travel.autocompletingsearch.adapters.GoEuroSuggestionAdapter;
import com.travel.autocompletingsearch.operations.CurrentLocation;
import com.travel.autocompletingsearch.operations.DatePickerFragment;
import com.travel.autocompletingsearch.operations.MainActivityValidate;

/**
 * 
 * @author munish
 *  
 */
public class MainActivity extends FragmentActivity {
    AutoCompleteTextView startLocation,endLocation;
    EditText date;
    CurrentLocation location;
    Button search;
    //## Default Location of Berlin 
    private double lat=52.519171,lon=13.406091; 
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		currentLocation();
	}
	
    void init(){
    	 startLocation = (AutoCompleteTextView)findViewById(R.id.startLocation);
    	 endLocation   = (AutoCompleteTextView)findViewById(R.id.endLocation);
    	 date		   = (EditText)findViewById(R.id.date);
    	 search        = (Button)findViewById(R.id.search);
    }
   //## This Method enable AutoTextView suggestion adapter 
    void initAction(){
    	 startLocation.setAdapter(new GoEuroSuggestionAdapter(this,startLocation.getText().toString(),lat,lon));
    	 endLocation.setAdapter(new GoEuroSuggestionAdapter(this,endLocation.getText().toString(),lat,lon));
    }
   //## This Method get user current location  
    void currentLocation(){
    	location = new CurrentLocation(MainActivity.this);
    	 if(location.canGetLocation()){
             double latitude = location.getLatitude();
             double longitude = location.getLongitude();
             if(latitude!=0 && longitude!=0){
            	 lat=latitude;
            	 lon=longitude;
             }
             
         }else{
             location.showSettingsAlert();
         }
    	 init();
 		 initAction();
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//## DatePicker Click Action
	public void showDatePickerDialog(View v) {
	    DialogFragment newFragment = new DatePickerFragment(date);
	    newFragment.show(this.getSupportFragmentManager(), "datePicker");
	    
	}
	//## Search Click Action
	public void searchAction(View v){
		MainActivityValidate.validData(this, startLocation, endLocation, date, search);
	}
	
	
}
