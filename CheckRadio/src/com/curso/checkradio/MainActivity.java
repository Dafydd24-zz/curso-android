package com.curso.checkradio;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

	private CheckBox cbMarcar;
	private TextView lblMensaje;
	private RadioGroup rgOpciones;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        cbMarcar = (CheckBox)findViewById(R.id.ChkMarcame);
        cbMarcar.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					cbMarcar.setText("Checkbox marcado!");
				}else{
					cbMarcar.setText("Checkbox desmarcado!");
				}
			}
        	
        });
        
        lblMensaje = (TextView)findViewById(R.id.LblSeleccion);
        rgOpciones = (RadioGroup)findViewById(R.id.gruporb);
        
        rgOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				lblMensaje.setText("ID opción selecionada: " + checkedId);
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
