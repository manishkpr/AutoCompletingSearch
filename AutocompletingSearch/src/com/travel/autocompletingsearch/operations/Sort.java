package com.travel.autocompletingsearch.operations;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.annotation.SuppressLint;

import com.travel.autocompletingsearch.collections.GoEuroGetSet;
/**
 * 
 * @author munish
 * Distance sorting
 */
@SuppressLint("UseValueOf")
public class Sort {

	public static void sortByDistance(List<GoEuroGetSet> data){
	       Collections.sort(data, new Comparator<GoEuroGetSet>() {
			    @SuppressLint("UseValueOf")
				public int compare(GoEuroGetSet c1, GoEuroGetSet c2) {
			        return new Double(c1.getDistance()).compareTo(new Double(c2.getDistance()));
			    }
			});	
		}

}
