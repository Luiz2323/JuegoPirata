package com.e.juegopirata.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.juegopirata.R;
import com.e.juegopirata.modelo.Jugador;
import com.e.juegopirata.modelo.ManagerDB;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText edinombre;
    Button btn_Registro;
    MediaPlayer adudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    private void inicializar() {
        edinombre =  findViewById(R.id.edinombre);

        btn_Registro = findViewById(R.id.btnregister);
        btn_Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edinombre.getText().toString().length()!=0) {
                    Jugador jugador = new Jugador();
                    jugador.setName(edinombre.getText().toString());
                    ManagerDB managerDB = new ManagerDB(getApplicationContext());
                    if (managerDB.insertarNombre(jugador) > 0) {
                        Toast.makeText(MainActivity.this, "Bienvenido Pirata " + edinombre.getText().toString(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Menu.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Tuvimos un pequeño problema con el registro pirata ", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Porfavor ingresa tu nombre ", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }


    @Override
    protected void onPostResume() {
        super.onPostResume();

        adudio = new MediaPlayer();
        adudio = MediaPlayer.create(getApplicationContext(),R.raw.pirates);
        adudio.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (adudio.isPlaying()){
            adudio.stop();
        }
    }
}
