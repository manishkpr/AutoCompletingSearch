package com.travel.autocompletingsearch.adapters;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import com.travel.autocompletingsearch.R;
import com.travel.autocompletingsearch.collections.GoEuroGetSet;
import com.travel.autocompletingsearch.operations.Sort;
import com.travel.autocompletingsearch.webservices.JsonParse;
/**
 * 
 *   @author munish
 *   SuggestionAdapter class returns the Json Parsed suggestions
 */
public class GoEuroSuggestionAdapter extends ArrayAdapter<String> {

	protected static final String TAG = "GoEuro";
	private List<String> suggestions;
	double current_latitude,current_longitude;
	
	public GoEuroSuggestionAdapter(Activity context, String nameFilter,double current_latitude,double current_longitude) {
		super(context, R.layout.simple_list_item_1);
		suggestions = new ArrayList<String>();
		this.current_latitude=current_latitude;
		this.current_longitude=current_longitude;
	}

	@Override
	public int getCount() {
		return suggestions.size();
	}

	@Override
	public String getItem(int index) {
		return suggestions.get(index);
	}

	@Override
	public Filter getFilter() {
		Filter myFilter = new Filter() {
			@Override
			protected FilterResults performFiltering(CharSequence constraint) {
				FilterResults filterResults = new FilterResults();
				JsonParse jp=new JsonParse(current_latitude,current_longitude);
				if (constraint != null) {
					//## A class that queries a web API, parses the data and
					//## returns an ArrayList<GoEuroGetSet>
					List<GoEuroGetSet> new_suggestions =jp.getParseJson(constraint.toString());
					Sort.sortByDistance(new_suggestions);
					suggestions.clear();
					for (int i=0;i<new_suggestions.size();i++) {
						suggestions.add(new_suggestions.get(i).getName());
					}
					
					//## Now assign the values and count to the FilterResults
					//## object
					filterResults.values = suggestions;
					filterResults.count = suggestions.size();
				}
				return filterResults;
			}

			@Override
			protected void publishResults(CharSequence contraint,
					FilterResults results) {
				if (results != null && results.count > 0) {
					notifyDataSetChanged();
				} else {
					notifyDataSetInvalidated();
				}
			}
		};
		return myFilter;
	}

	

}
