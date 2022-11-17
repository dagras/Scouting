package com.example.scouting21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.scouting21.BaseDatos.DbHelper;
import com.example.scouting21.BaseDatos.DbPlayers;
import com.example.scouting21.adaptador.listaAdaptador;
import com.example.scouting21.entidad.Entidad;

import java.util.ArrayList;

public class BBDDPlayers extends AppCompatActivity implements SearchView.OnQueryTextListener{
    RecyclerView listaPlayers;
    ArrayList<Entidad>listaArrayEntidad;
    SearchView txtBuscar;
    Spinner spinner;
    listaAdaptador adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbddplayers);
        listaPlayers= findViewById(R.id.listaPlayers);
        listaPlayers.setLayoutManager(new LinearLayoutManager(this));
        txtBuscar = findViewById(R.id.txtBuscar);
        DbPlayers dbPlayers = new DbPlayers(BBDDPlayers.this);
        spinner = findViewById(R.id.spinner);
        listaArrayEntidad = new ArrayList<>();


        listaArrayEntidad=dbPlayers.mostrarContactos();

                adapter= new listaAdaptador(dbPlayers.mostrarContactos());
        listaPlayers.setAdapter(adapter);

        txtBuscar.setOnQueryTextListener(this);
        String [] valores = {"Nombre","Edad","Altura","Tiro","Minutos","Posición"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(),(String) adapterView.getItemAtPosition(i),Toast.LENGTH_SHORT);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_player,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_player:
                nuevoRegistro();
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }
    private void nuevoRegistro(){
        Intent intent = new Intent(BBDDPlayers.this,nuevoplayer.class);
        startActivity(intent);
    }



    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        opcionEscogida(s);
        return false;
    }
        public void opcionEscogida(String s) {
            switch (spinner.getSelectedItem().toString()) {
                case "Nombre":
                    adapter.filtradoNombre(s);
                    break;
                case "Edad":
                    adapter.filtradoEdad(s);
                    break;
                case "Altura":
                    adapter.filtradoAltura(s);
                    break;
                case "Tiro":
                    adapter.filtradoTiro(s);
                    break;
                case "Minutos":
                    adapter.filtradoMinutos(s);
                    break;
                case "Posicion":
                    adapter.filtradoPosicion(s);
                    break;

            }
    }
}