package com.curso.listview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView lstOpciones;
	private TextView lblEtiqueta;
	
	private Titular[] datos = new Titular[]{ 
			new Titular("Título 1","Subtitulo largo 1"),
			new Titular("Título 2","Subtitulo largo 2"),
			new Titular("Título 3","Subtitulo largo 3"),
			new Titular("Título 4","Subtitulo largo 4"),
			new Titular("Título 5","Subtitulo largo 5")};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
		

		lstOpciones = (ListView)findViewById(R.id.LstOpciones);
		lblEtiqueta = (TextView)findViewById(R.id.LblEtiqueta);
		lstOpciones.setAdapter(adaptador);
		/*ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
		*/
		lstOpciones.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String opcionSeleccionada =((Titular)parent.getAdapter().getItem(position)).getTitulo();	
			lblEtiqueta.setText("Opción Seleccionada: " + opcionSeleccionada);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});			
		
	}
	
	class AdaptadorTitulares extends ArrayAdapter<Titular>{
		
		Activity context;
		
		public AdaptadorTitulares(Activity context) {
			super(context,R.layout.listitem_titular,datos);
			this.context =context;
			// TODO Auto-generated constructor stub
		}
		
		public View getView(int position, View convertView, ViewGroup parent){
			LayoutInflater inflater =context.getLayoutInflater();
			View item =inflater.inflate(R.layout.listitem_titular, null);
			
			TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
			lblTitulo.setText(datos[position].getTitulo());
			
			TextView  lblSubtitulo = (TextView)item.findViewById(R.id.LblSubtitulo);
			lblSubtitulo.setText(datos[position].getSubtitulo());
			
			return item;			
			
		}
		
	}
}
