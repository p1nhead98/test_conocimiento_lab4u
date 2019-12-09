package com.e.testconocimiento.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "Usuario.db";
    public static final int DB_VERSION = 1;

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String USER_TABLE = "CREATE TABLE " + Usuario.UsuarioDetails.TABLE_NAME + " ( " +
                Usuario.UsuarioDetails.COL_ID + " INTEGER PRIMARY KEY, " +
                Usuario.UsuarioDetails.COL_RUT + " TEXT ," +
                Usuario.UsuarioDetails.COL_NOMBRE + " TEXT," +
                Usuario.UsuarioDetails.COL_EMAIL + " TEXT)";
        db.execSQL(USER_TABLE);


    }

    //Insertar Usuario
    public boolean addUser(int id, String rut, String name, String mail) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Usuario.UsuarioDetails.COL_ID, id);
        values.put(Usuario.UsuarioDetails.COL_RUT, rut);
        values.put(Usuario.UsuarioDetails.COL_NOMBRE, name);
        values.put(Usuario.UsuarioDetails.COL_EMAIL, mail);

        long ide = db.insert(Usuario.UsuarioDetails.TABLE_NAME, null, values);

        if (ide > 0)
            return true;
        else
            return false;
    }

    //Modificar Uusarios
    public boolean updateUser(int id, String rut, String name, String email) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Usuario.UsuarioDetails.COL_RUT, rut);
        values.put(Usuario.UsuarioDetails.COL_NOMBRE, name);
        values.put(Usuario.UsuarioDetails.COL_EMAIL, email);


        long ide = db.update(Usuario.UsuarioDetails.TABLE_NAME, values, Usuario.UsuarioDetails.COL_ID + " = ? ", new String[]{String.valueOf(id)});

        if (ide > 0)
            return true;
        else
            return false;

    }
    //Eliminar Usuarios
    public boolean deleteUser(int id){
        SQLiteDatabase db = getWritableDatabase();

        long sid = db.delete(Usuario.UsuarioDetails.TABLE_NAME,  Usuario.UsuarioDetails.COL_ID+ " = ? ",new String[]{String.valueOf(id)});

        if(sid>0)
            return true;
        else
            return false;
    }

    //Devolver Usuarios
    public ArrayList<String> getUsers(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(Usuario.UsuarioDetails.TABLE_NAME,
                new String[]{Usuario.UsuarioDetails.COL_RUT,Usuario.UsuarioDetails.COL_NOMBRE,Usuario.UsuarioDetails.COL_EMAIL},
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {

            lista.add(cursor.getString(cursor.getColumnIndex(Usuario.UsuarioDetails.TABLE_NAME)));

        }
        return lista;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
