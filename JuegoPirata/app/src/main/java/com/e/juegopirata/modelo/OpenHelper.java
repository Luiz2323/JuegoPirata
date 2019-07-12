package com.e.juegopirata.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.e.juegopirata.modelo.Contant.*;

public class OpenHelper extends SQLiteOpenHelper {
    public OpenHelper(Context context) {
        super(context, NAME_DB,null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(table);
        db.execSQL(table2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(drop);
        db.execSQL(drop2);
        onCreate(db);

    }
}
