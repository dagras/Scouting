package com.example.scouting21.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.scouting21.entidad.Entidad;

import java.util.ArrayList;

public class DbPlayers extends DbHelper{
    Context context;
    static int IdplayerH = 600;
    static int IdplayerM = 600;
    public DbPlayers(@Nullable Context context) {
        super(context);
        this.context = context;
    }



    public long crearContactos(String nombre,String edad,String altura,String tiro,String minutos,String posicon) {
        long id = 0;
        try {


            DbHelper dbhelper = new DbHelper(context);
            SQLiteDatabase db = dbhelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            IdplayerH++;
            values.put("Id",IdplayerH);
            values.put("Nombre", nombre);
            values.put("Edad", edad);
            values.put("Altura", altura);
            values.put("Tiro", tiro);
            values.put("Minutos", minutos);
            values.put("Posicion", posicon);


            id = db.insert(TABLA_HOMBRES, null, values);
        } catch (Exception ex) {

            ex.toString();

        }

        return id;
    }


    public long crearContactosHombre(String nombre,String edad,String altura,String tiro,String minutos,String posicon) {
        long id = 0;
        try {


            DbHelper dbhelper = new DbHelper(context);
            SQLiteDatabase db = dbhelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            IdplayerH++;

            values.put("Id",IdplayerH);
            values.put("Nombre", nombre);
            values.put("Edad", edad);
            values.put("Altura", altura);
            values.put("Tiro", tiro);
            values.put("Minutos", minutos);
            values.put("Posicion", posicon);


            id = db.insert(TABLA_HOMBRES, null, values);
        } catch (Exception ex) {

            ex.toString();

        }

        return id;
    }
    public long crearContactosMujer(String nombre,String edad,String altura,String tiro,String minutos,String posicon) {
        long id = 0;
        try {


            DbHelper dbhelper = new DbHelper(context);
            SQLiteDatabase db = dbhelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            IdplayerM++;
            values.put("Id",IdplayerM);
            values.put("Nombre", nombre);
            values.put("Edad", edad);
            values.put("Altura", altura);
            values.put("Tiro", tiro);
            values.put("Minutos", minutos);
            values.put("Posicion", posicon);


            id = db.insert(TABLA_MUJERES, null, values);
        } catch (Exception ex) {

            ex.toString();

        }

        return id;
    }
    public ArrayList<Entidad> mostrarContactos(){
        DbHelper dbhelper = new DbHelper(context);
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        ArrayList<Entidad> listaContactos = new ArrayList<>();
        Entidad entidad = null;
        Cursor cursorEntidad = null;

        cursorEntidad = db.rawQuery("SELECT * FROM " + TABLA_HOMBRES, null);

        if(cursorEntidad.moveToFirst()){
            do{
                entidad = new Entidad();
                entidad.setId(cursorEntidad.getInt(0));
                entidad.setNombre(cursorEntidad.getString(1));
                entidad.setEdad(cursorEntidad.getString(2));
                entidad.setAltura(cursorEntidad.getString(3));
                entidad.setTiro(cursorEntidad.getString(4));
                entidad.setMinutos(cursorEntidad.getString(5));
                entidad.setPosicion(cursorEntidad.getString(6));
                listaContactos.add(entidad);
            }while (cursorEntidad.moveToNext());
        }
        cursorEntidad.close();
        cursorEntidad = db.rawQuery("SELECT * FROM " + TABLA_MUJERES, null);

        if(cursorEntidad.moveToFirst()){
            do{
                entidad = new Entidad();
                entidad.setId(cursorEntidad.getInt(0));
                entidad.setNombre(cursorEntidad.getString(1));
                entidad.setEdad(cursorEntidad.getString(2));
                entidad.setAltura(cursorEntidad.getString(3));
                entidad.setTiro(cursorEntidad.getString(4));
                entidad.setMinutos(cursorEntidad.getString(5));
                entidad.setPosicion(cursorEntidad.getString(6));
                listaContactos.add(entidad);
            }while (cursorEntidad.moveToNext());
        }
        cursorEntidad.close();


        return listaContactos;
    }



}
