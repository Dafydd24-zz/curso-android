package com.curso.android.preference2;

import android.os.Bundle;
import android.preference.PreferenceActivity;
//import android.preference.PreferenceFragment;

public class OpcionesActivity extends PreferenceActivity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.opciones);
        
        /*if (Build.VERSION.SDK_INT<Build.VERSION_CODES.HONEYCOMB) {
            addPreferencesFromResource(R.xml.preferences);
            addPreferencesFromResource(R.xml.preferences2);
        }*/
    }
}
