package com.e.juegopirata.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.e.juegopirata.R;
import com.e.juegopirata.modelo.Jugador;

public class Personajes extends AppCompatActivity {


    private ImageView imageView;
    private ImageView comeback;
    private ImageView pirata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        inicializar();
    }

    private void inicializar() {

        comprobar();

        imageView = findViewById(R.id.imageView);


        comeback = findViewById(R.id.comeback);
        comeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        pirata = findViewById(R.id.pirataimg);


    }

    private void comprobar() {
        Jugador jugador = new Jugador();
       int state = jugador.getState();
       if (state == 1 ){
           imageView.setImageResource(R.drawable.gorradesbloqueda);
       }else {

       }

    }


}
