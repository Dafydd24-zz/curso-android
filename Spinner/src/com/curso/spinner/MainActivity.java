package com.curso.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView lblMensaje;
	private Spinner cmbOpciones;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lblMensaje = (TextView)findViewById(R.id.LblMensaje);
		cmbOpciones =(Spinner)findViewById(R.id.CmbOpciones);
		
		final String[] datos =
				new String[]{"Elemento1", "Elemento2","Elemento3", "Elemento4","Elemento5"};
		
		//Alternativa 1: Array java
//		ArrayAdapter<String> adaptador=
	//			new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, datos);
		
		//Alternativa 2: Recurso XML de tipo string-array
		ArrayAdapter<CharSequence> adaptador=
				ArrayAdapter.createFromResource(this, R.array.valores_array,
						android.R.layout.simple_spinner_item);
		
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		cmbOpciones.setAdapter(adaptador);

		cmbOpciones.setOnItemSelectedListener(
				new AdapterView.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						// TODO Auto-generated method stub
						lblMensaje.setText("Seleccionado:" + datos[position]);
						
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub
						lblMensaje.setText("");
						
					}
					
				});
	}
}
