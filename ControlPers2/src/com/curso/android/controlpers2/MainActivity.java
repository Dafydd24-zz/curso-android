package com.curso.android.controlpers2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private ControlLogin ctlogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ctlogin = (ControlLogin)findViewById(R.id.CtlLogin);
		
		ctlogin.setOnLoginListener(new OnLoginListener(){

			@Override
			public void OnLogin(String usuario, String password) {
				// TODO Auto-generated method stub
			
				if(usuario.equals("demo") && password.equals("demo"))
					ctlogin.setMensaje("Login correcto!");
				else
					ctlogin.setMensaje("Vuelva a intentarlo");
				
			}
			
		});
	}
}
