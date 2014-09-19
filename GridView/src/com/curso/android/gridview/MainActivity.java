package com.curso.android.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView lblMensaje;
	private GridView grdOpciones;
	
	private String[] datos = new String[25];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		for(int i=1;i<=25;i++)
			datos[i-1]="Dato "+ i;
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
		
		lblMensaje = (TextView)findViewById(R.id.LblMensaje);
		grdOpciones = (GridView)findViewById(R.id.GridOpciones);
		
		grdOpciones.setOnItemClickListener(
				new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						lblMensaje.setText("Opción seleccionada:" + datos[position]);
					}
				});
		
		grdOpciones.setAdapter(adaptador);
	}
}
