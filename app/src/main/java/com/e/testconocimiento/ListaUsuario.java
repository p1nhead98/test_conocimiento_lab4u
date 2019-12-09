package com.e.testconocimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.e.testconocimiento.database.DBHandler;

import java.util.ArrayList;

public class ListaUsuario extends AppCompatActivity {

    ListView listView;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);

        listView= findViewById(R.id.listView);
        dbHandler = new DBHandler(this);

        ArrayList<String> list = dbHandler.getUsers();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.lista_item,list);

        listView.setAdapter(adapter);
    }
}
