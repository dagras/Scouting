package com.example.scouting21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    TextView emailTextView;
    MaterialButton logOutBtn, playerslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        emailTextView = findViewById(R.id.emailTextView);
        logOutBtn = findViewById(R.id.logOutBtn);
        playerslist = findViewById(R.id.playerslist);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            emailTextView.setText(user.getEmail());
        }

        logOutBtn.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(UserActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
        playerslist.setOnClickListener(v -> {
            Intent intent = new Intent(UserActivity.this, BBDDPlayers.class);
            startActivity(intent);
            finish();
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_crear,menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.nuevoRegistro:
                nuevoRegistro();
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }

    }
    private void nuevoRegistro(){

        Intent intent = new Intent(UserActivity.this,nuevoplayer.class);
        startActivity(intent);
    }


    }

