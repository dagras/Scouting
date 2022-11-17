package com.example.scouting21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class Sing_Up_Activity extends AppCompatActivity {
    TextView nuevoUsuario,bienvenidolabel,continuarlabel;
    ImageView singUpImageView;
    TextInputLayout usuarioSingUpTextField, passwordTextField ;
    MaterialButton inicioSingUp;
    TextInputEditText confirmPasswordEditText,passwordEditText, emailEditText;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        singUpImageView = findViewById(R.id.singUpImageView);
        bienvenidolabel = findViewById(R.id.bienvenidolabel);
        continuarlabel = findViewById(R.id.continuarlabel);
        usuarioSingUpTextField = findViewById(R.id.usuarioSingUpTextField);
        passwordTextField = findViewById(R.id.passwordTextField);
        inicioSingUp = findViewById(R.id.inicioSingUp);
        nuevoUsuario = findViewById(R.id.nuevoUsuario);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);

        nuevoUsuario.setOnClickListener((v) -> {transtionBack(); });

        inicioSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
        mAuth = FirebaseAuth.getInstance();

    }

    public void validar(){
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirm = confirmPasswordEditText.getText().toString().trim();

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Correo No Válido");
            return;
        }else{
            emailEditText.setError(null);
        }
        if(password.isEmpty() || password.length()< 8){
            passwordEditText.setError("Se Necesitan más de 8 caracteres");
            return;
        }else if (!Pattern.compile("[0-9]").matcher(password).find()) {
            passwordEditText.setError("Debe de incluir un numero");
            return;
        }else{
            passwordEditText.setError(null);
        }
        if(!confirm.equals(password)){
            confirmPasswordEditText.setError("Deben de ser como dos gotaas de agua");
            return;
        }else {
            registrar(email,password);
        }
    }

    public void registrar(String email, String password){
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){

                                            Intent intent = new Intent(Sing_Up_Activity.this,LoginActivity.class);
                                            startActivity(intent);
                                            Toast.makeText(Sing_Up_Activity.this,"Por favor,verificar tu mail",Toast.LENGTH_SHORT).show();
                                            finish();

                                        }else {
                                            Toast.makeText(Sing_Up_Activity.this,"Hubo un fallo en el registro",Toast.LENGTH_LONG).show();
                                        }
                                }
                            });
                        }else{
                            Toast.makeText(Sing_Up_Activity.this,"Hubo un fallo en el registro",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    @Override
    public void onBackPressed(){
        transtionBack();
    }

    public void transtionBack(){

        Intent intent = new Intent(Sing_Up_Activity.this, LoginActivity.class);

        Pair[] pairs = new Pair [7];
        pairs [0] = new Pair<View, String>(singUpImageView, "logoImageTrans");
        pairs [1] = new Pair<View, String>(bienvenidolabel, "textTrans");
        pairs [2] = new Pair<View, String>(continuarlabel, "iniciaSesionTextTrans");
        pairs [3] = new Pair<View, String>(usuarioSingUpTextField, "emailInputTextTrans");
        pairs [4] = new Pair<View, String>(passwordTextField, "passwordInputTextTrans");
        pairs [5] = new Pair<View, String>(inicioSingUp, "buttonSingInTrans");
        pairs [6] = new Pair<View, String>(nuevoUsuario, "newUserTrans");
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Sing_Up_Activity.this, pairs);
            startActivity(intent, options.toBundle());

        }else{
            startActivity(intent);
            finish();
        }

    }
}