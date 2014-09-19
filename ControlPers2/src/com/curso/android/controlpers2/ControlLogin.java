package com.curso.android.controlpers2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ControlLogin extends LinearLayout{

	private EditText txtUsuario;
	private EditText txtPassword;
	private Button btnLogin;
	private TextView lblMensaje;
	
	private OnLoginListener listener;
	
	public ControlLogin(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		inicializar();
	}
	
	public ControlLogin(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		inicializar();
		
		TypedArray a=
				getContext().obtainStyledAttributes(attrs,
						R.styleable.ControlLogin);
		
		String textoBoton= a.getString(
				R.styleable.ControlLogin_login_text);
		
		btnLogin.setText(textoBoton);
		
		a.recycle();
	}
	
	public ControlLogin(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		inicializar();
	}

	private void inicializar() {
		// TODO Auto-generated method stub
		String infService = Context.LAYOUT_INFLATER_SERVICE;
		LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
		li.inflate(R.layout.control_login, this,true);
		
		txtUsuario = (EditText)findViewById(R.id.editText1);
		txtPassword =(EditText)findViewById(R.id.editText2);
		btnLogin = (Button)findViewById(R.id.BtnAceptar);
		lblMensaje = (TextView)findViewById(R.id.LblMensaje);
		
		asignarEventos();
	}
	
	public void setOnLoginListener(OnLoginListener l){
		listener=l;
	}

	private void asignarEventos() {
		// TODO Auto-generated method stub
		btnLogin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listener.OnLogin(txtUsuario.getText().toString(),
						txtPassword.getText().toString());
			}});
	}
	
	public void setMensaje(String msj){
		lblMensaje.setText(msj);
	}

}
