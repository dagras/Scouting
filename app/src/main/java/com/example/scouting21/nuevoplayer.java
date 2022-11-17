package com.example.scouting21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.scouting21.BaseDatos.DbPlayers;

public class nuevoplayer extends AppCompatActivity {


        EditText txtNombre,txtEdad,txtAltura,txtTiro,txtMinutos,txtPosicion;
        Button btnGuardar;
        Spinner spinner;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_nuevoplayer);

            txtNombre = findViewById(R.id.txtNombre);
            txtEdad = findViewById(R.id.txtEdad);
            txtAltura = findViewById(R.id.txtAltura);
            txtTiro = findViewById(R.id.txtTiro);
            txtMinutos = findViewById(R.id.txtMinutos);
            txtPosicion = findViewById(R.id.txtPosicion);
            spinner = findViewById(R.id.spinner);

            btnGuardar = findViewById(R.id.btnGuardar);
            String [] valores = {"Hombre","Mujer"};
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

            btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    DbPlayers dbPlayers = new DbPlayers(nuevoplayer.this);
                    String sexo = spinner.getSelectedItem().toString();
                    long id=0;
                    if(sexo.equals("Hombre")){
                         id = dbPlayers.crearContactosHombre(txtNombre.getText().toString(),txtEdad.getText().toString(),txtAltura.getText().toString(),txtTiro.getText().toString(),txtMinutos.getText().toString(),txtPosicion.getText().toString());

                    }else{
                         id = dbPlayers.crearContactosMujer(txtNombre.getText().toString(),txtEdad.getText().toString(),txtAltura.getText().toString(),txtTiro.getText().toString(),txtMinutos.getText().toString(),txtPosicion.getText().toString());

                    }


                    if(id > 0){
                        Toast.makeText(nuevoplayer.this, "Se Creo el nuevo jugador", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }else {
                        Toast.makeText(nuevoplayer.this, "Hubo un error", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                }
            });
        }
        private void limpiar(){

            txtNombre.setText("");
            txtEdad.setText("");
            txtAltura.setText("");
            txtTiro.setText("");
            txtMinutos.setText("");
            txtPosicion.setText("");
    }
}