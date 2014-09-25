package com.curso.android.preference3;

import com.curso.android.preference2.R;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PrefsFragment extends PreferenceFragment {

	@Override
	  public void onCreate(Bundle savedInstanceState) {
	    
	   super.onCreate(savedInstanceState);
	   addPreferencesFromResource(R.xml.opciones);
	    
	    
	  }
	
}
