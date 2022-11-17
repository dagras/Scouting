package com.example.scouting21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bifurcacion extends AppCompatActivity {
    Button btnplayer, btnScouting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bifurcacion);



        btnplayer = findViewById(R.id.btnplayer);
        btnScouting = findViewById(R.id.btnScouting);


        btnScouting.setOnClickListener(view -> {
            Intent intent = new Intent(bifurcacion.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        btnplayer.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://www.figma.com/proto/IJ1wilulgS2lDhb5JMRW5n/Scouting?node-id=272%3A451&scaling=scale-down&page-id=0%3A1&starting-point-node-id=272%3A451&show-proto-sidebar=1");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);

        });





    }

}