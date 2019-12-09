package com.e.testconocimiento.database;

import android.provider.BaseColumns;

public class Usuario {
    private Usuario(){

    }
    public static final class UsuarioDetails implements BaseColumns{
        public static final String TABLE_NAME = "usuario";
        public static final String COL_ID  =" id";
        public static final String COL_RUT = "rut";
        public static final String COL_NOMBRE = "nombre";
        public static final String COL_EMAIL = "email";
    }
}
