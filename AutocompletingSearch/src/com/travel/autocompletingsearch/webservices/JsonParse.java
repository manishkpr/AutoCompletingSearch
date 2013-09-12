package com.travel.autocompletingsearch.webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travel.autocompletingsearch.collections.GoEuroGetSet;
import com.travel.autocompletingsearch.config.AppConfig;

/****
 * 
 * @author munish
 * JsonParse class parse the Json data from webservice
 */
public class JsonParse {
	 private double current_latitude,current_longitude;
	 private String TAG_RESULTS="results",TAG_GEO_POSITION="geo_position";
	 public JsonParse(){}
	 public JsonParse(double current_latitude,double current_longitude){
		 this.current_latitude=current_latitude;
		 this.current_longitude=current_longitude;
	 }
	 //#### JSon Parsing data from web services  
	 public List<GoEuroGetSet> getParseJson(String sName)
		{
		
		 List<GoEuroGetSet> ListData = new ArrayList<GoEuroGetSet>();
		 
			try {
				URL js = new URL(AppConfig.SUGGESTION_URL+sName);
				URLConnection jc = js.openConnection();
				BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));
				String line = reader.readLine();
				JSONObject jsonResponse = new JSONObject(line);
				JSONArray jsonArray = jsonResponse.getJSONArray(TAG_RESULTS);
				for(int i = 0; i < jsonArray.length(); i++){
				    JSONObject r = jsonArray.getJSONObject(i);
				    JSONObject location = r.getJSONObject(TAG_GEO_POSITION);
				    ListData.add(new 
				    		GoEuroGetSet
				    		(   current_latitude,current_longitude,
				    			r.getString("_type"),r.getString("_id"),r.getString("name"),r.getString("type")
				    		    ,location.getString("latitude"),location.getString("longitude")
				    		));
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 return ListData;
		 
		}
	
}
