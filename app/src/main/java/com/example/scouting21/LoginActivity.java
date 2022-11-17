package com.example.scouting21;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    TextView nuevoUsuario, bienvenidolabel, continuarlabel,olvidasteContrasenya;
    ImageView loginImageView;
    TextInputLayout ususarioTextField, passwordTextField;
    MaterialButton inicioSesion;
    TextInputEditText emailEditText, passwordEditText;
   // ActivityResultLauncher<String> mgetContent;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginImageView = findViewById(R.id.loginImageView);
        bienvenidolabel = findViewById(R.id.bienvenidolabel);
        continuarlabel = findViewById(R.id.continuarlabel);
        ususarioTextField = findViewById(R.id.ususarioTextField);
        passwordTextField = findViewById(R.id.passwordTextField);
        inicioSesion = findViewById(R.id.inicioSesiom);
        nuevoUsuario = findViewById(R.id.nuevoUsuario);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        olvidasteContrasenya = findViewById(R.id.olvidoTextView);


        mAuth = FirebaseAuth.getInstance();


        nuevoUsuario.setOnClickListener((v) -> {
            Intent intent = new Intent(LoginActivity.this, Sing_Up_Activity.class);

            Pair[] pairs = new Pair[7];
            pairs[0] = new Pair<View, String>(loginImageView, "logoImageTrans");
            pairs[1] = new Pair<View, String>(bienvenidolabel, "textTrans");
            pairs[2] = new Pair<View, String>(continuarlabel, "iniciaSesionTextTrans");
            pairs[3] = new Pair<View, String>(ususarioTextField, "emailInputTextTrans");
            pairs[4] = new Pair<View, String>(passwordTextField, "passwordInputTextTrans");
            pairs[5] = new Pair<View, String>(inicioSesion, "buttonSingInTrans");
            pairs[6] = new Pair<View, String>(nuevoUsuario, "newUserTrans");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                startActivity(intent, options.toBundle());

            } else {
                startActivity(intent);
                finish();
            }

        });

        olvidasteContrasenya.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this,passwordPerdido.class);
            startActivity(intent);
            finish();


        });

        inicioSesion.setOnClickListener((v) -> validar());

    }

    public void validar() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();


        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Correo No Válido");
            return;
        } else {
            emailEditText.setError(null);
        }
        if (password.isEmpty() || password.length() < 8) {
            passwordEditText.setError("Se Necesitan más de 8 caracteres");
            return;
        } else if (!Pattern.compile("[0-9]").matcher(password).find()) {
            passwordEditText.setError("Debe de incluir un numero");
            return;
        } else {
            passwordEditText.setError(null);
        }

        inicioSesion(email, password);

    }

    private void inicioSesion(String email, String password) {
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()){
                        Intent intent = new Intent (LoginActivity.this, UserActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Prueba de nuevo algo fue mal", Toast.LENGTH_LONG).show();
                    }
                });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(LoginActivity.this,bifurcacion.class);
        startActivity(intent);
        finish();
    }


}