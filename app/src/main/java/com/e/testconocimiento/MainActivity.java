package com.e.testconocimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.e.testconocimiento.database.DBHandler;

public class MainActivity extends AppCompatActivity {
    EditText etId,etRut,etNombre,etEmail;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId=findViewById(R.id.add_id);
        etRut=findViewById(R.id.add_rut);
        etNombre=findViewById(R.id.add_nombre);
        etEmail=findViewById(R.id.add_email);

        dbHandler = new DBHandler(this);
    }
    public void btnAdd(View v){

        int id = Integer.parseInt(etId.getText().toString());
        String rut = etRut.getText().toString();
        String name = etNombre.getText().toString();
        String mail = etEmail.getText().toString();

        boolean status = dbHandler.addUser(id,rut,name,mail);

        if(status)
            Toast.makeText(this,"Usuario ingresado Existosamente!",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Usuario no se puede ingresar",Toast.LENGTH_SHORT).show();
    }

    public void btnDetele(View v){
        int id = Integer.parseInt(etId.getText().toString());

        boolean status = dbHandler.deleteUser(id);

        if(status)
            Toast.makeText(this, "Usuario eliminado Exitosamente",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Usuario no se encuentra registrado",Toast.LENGTH_SHORT).show();
    }
    public void btnUpdate(View v){

        int id=Integer.parseInt(etId.getText().toString());
        String rut = etRut.getText().toString();
        String name = etNombre.getText().toString();
        String mail = etEmail.getText().toString();

        boolean status = dbHandler.updateUser(id,rut,name,mail);

        if(status)
            Toast.makeText(this,"Usuario modificado Existosamente!",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Usuario no se puede modificar",Toast.LENGTH_SHORT).show();

    }

    public void btnView(View v){
        Intent intent = new Intent(MainActivity.this,ListaUsuario.class);
        startActivity(intent);
    }
}
