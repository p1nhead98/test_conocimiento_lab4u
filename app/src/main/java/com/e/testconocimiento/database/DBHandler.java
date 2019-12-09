package com.e.testconocimiento.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
    public boolean addUser(int id, String rut,String name, String mail) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Usuario.UsuarioDetails.COL_ID, id);
        values.put(Usuario.UsuarioDetails.COL_RUT,rut);
        values.put(Usuario.UsuarioDetails.COL_NOMBRE, name);
        values.put(Usuario.UsuarioDetails.COL_EMAIL, mail);

        long ide = db.insert(Usuario.UsuarioDetails.TABLE_NAME, null, values);

        if (ide > 0)
            return true;
        else
            return false;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
