package com.example.scouting21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class passwordPerdido extends AppCompatActivity {

    MaterialButton recuperarbtn;
    TextInputEditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_perdido);


        recuperarbtn = findViewById(R.id.recuperarbtn);
        emailEditText = findViewById(R.id.emailEditText);

        recuperarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar();
            }
        });
    }
    public void validar(){
        String email = emailEditText.getText().toString().trim();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Correo inavlido");
            return;
        }

        sendEmail(email);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(passwordPerdido.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }


    public void sendEmail (String email){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String direccion = email;
        auth.sendPasswordResetEmail(direccion)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(passwordPerdido.this, "Revisa tu correo", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(passwordPerdido.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(passwordPerdido.this, "Algo no fue bien", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }
}