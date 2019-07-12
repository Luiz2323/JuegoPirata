package com.e.juegopirata.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.e.juegopirata.modelo.Contant.*;

public class ManagerDB  {
    SQLiteDatabase db;
    OpenHelper openHelper;

    public ManagerDB(Context context) {
        openHelper = new OpenHelper(context);
    }

    public void read(){
        db = openHelper.getReadableDatabase();
    }

    public void write(){
        db = openHelper.getWritableDatabase();
    }

    public void close(){
        if (db != null){
            db.close();
        }
    }

    public long insertarNombre(Jugador jugador){
        write();
        ContentValues contentValues = new ContentValues();
        contentValues.put(name_name,jugador.getName());
        long resultado =db.insert(name_table,null,contentValues);

        return resultado;



    }


}
