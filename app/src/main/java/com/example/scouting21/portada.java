package com.example.scouting21;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class portada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);

        Animation animacio1 = AnimationUtils.loadAnimation(this, R.anim.desplazar_arriba);
        Animation animacio2 = AnimationUtils.loadAnimation(this, R.anim.desplazar_abajo);

        TextView ByTextView = findViewById(R.id.ByTextView);
        TextView ErrorTextView =findViewById(R.id.ErrorTextView);
        ImageView logoView = findViewById(R.id.logoView);

        ByTextView.setAnimation(animacio2);
        ErrorTextView.setAnimation(animacio2);
        logoView.setAnimation(animacio1);

        new Handler().postDelayed(() -> {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            if(user != null){

                Intent intent = new Intent (portada.this,UserActivity.class);
                startActivity(intent);
                finish();
            }else{
                Intent intent = new Intent(portada.this, bifurcacion.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair <View, String>(logoView, "logoImageTrans");
                pairs[1] = new Pair <View, String>(ErrorTextView, "textTrans");

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(portada.this, pairs);
                    startActivity(intent, options.toBundle());

                }else{
                    startActivity(intent);
                    finish();
                }

            }




        }, 4000);
    }
}