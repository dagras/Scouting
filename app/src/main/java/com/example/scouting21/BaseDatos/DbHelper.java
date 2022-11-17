package com.example.scouting21.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static  final int DATABASE_VERSION = 1;
    private static  final String DATABASE_NOMBRE= "AppScouting.db";
    public  static  final  String TABLA_DATOS = "Mujeres2bis";
    public  static  final  String TABLA_MUJERES = "Mujeres";
    public  static  final  String TABLA_HOMBRES = "Hombres";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_DATOS  + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nombre TEXT NOT NULL, " +
                " edad TEXT NOT NULL, " +
                " altura TEXT NOT NULL, " +
                " tiro TEXT NOT NULL, "+
                " minutos TEXT NOT NULL,"+
                " posicion TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLA_DATOS);

        onCreate(sqLiteDatabase);

    }
}
