package com.e.juegopirata.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.e.juegopirata.R;

public class Menu extends AppCompatActivity {

    private ImageView imageView2;
    private ImageView personajes;
    private  MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();
        inicializar();
    }

    private void inicializar() {


        imageView2 = findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),StartGame.class);
                startActivity(intent);

            }
        });

        personajes = findViewById(R.id.personajes);

        personajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Personajes.class);
                startActivity(intent);
            }
        });



    }


    @Override
    protected void onPostResume() {
        super.onPostResume();

        audio = new MediaPlayer();
        audio = MediaPlayer.create(getApplicationContext(),R.raw.pirates);
        audio.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (audio.isPlaying()){
            audio.stop();
        }
    }
}
