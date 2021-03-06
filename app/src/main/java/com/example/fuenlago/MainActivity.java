package com.example.fuenlago;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private ImageButton ButtonAjustes;
    private ImageButton ButtonHome;
    private ImageButton ButtonEventos;
    private ImageButton ButtonNoticias;

    private Button inicio;
    private Button register;

    private boolean ayuda = false;
    private ImageButton ayudaButton;
    private ConstraintLayout help1;
    private ConstraintLayout help2;
    private ConstraintLayout help3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.thesound);

        ButtonNoticias = findViewById(R.id.imageButtonNoticias);
        ButtonNoticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                openNoticiasActivity();
            }
        });
        ButtonAjustes = findViewById(R.id.imageButtonAjustes);
        ButtonAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                openSettingsActivity();
            }
        });
        ButtonHome = findViewById(R.id.imageButtonHome);
        ButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                openHomeActivity();
            }
        });
        ButtonEventos = findViewById(R.id.imageButtonEventos);
        ButtonEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                openEventsActivity();
            }
        });

        inicio = findViewById(R.id.login);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openErrorActivity();
            }
        });
        register = findViewById(R.id.signup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openErrorActivity();
            }
        });

        ayudaButton = findViewById(R.id.ayudaButton);
        ayudaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                help1 = findViewById(R.id.help1);
                help2 = findViewById(R.id.help2);
                help3 = findViewById(R.id.help3);

                if (ayuda) {
                    ayuda = false;
                    help1.setVisibility(View.GONE);
                    help2.setVisibility(View.GONE);
                    help3.setVisibility(View.GONE);
                } else {
                    ayuda = true;
                    help1.setVisibility(View.VISIBLE);
                    help2.setVisibility(View.VISIBLE);
                    help3.setVisibility(View.VISIBLE);
                }
            }
        });

        if(!Ayuda.isShowAyuda()){
            ayudaButton.setVisibility(View.GONE);
        }

    }


    private void openNoticiasActivity() {
        Intent intent = new Intent(this, Noticias.class);
        startActivity(intent);
    }

    private void openSettingsActivity(){
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }
    private void openHomeActivity(){
        //Intent intent = new Intent(this,MainActivity.class);
        //startActivity(intent);
    }
    private void openEventsActivity(){
        Intent intent = new Intent(this,Error.class);
        startActivity(intent);
    }

    private void openErrorActivity(){
        Intent intent = new Intent(this,Error.class);
        startActivity(intent);
    }
}
