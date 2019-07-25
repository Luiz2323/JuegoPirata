package com.e.juegopirata.controlador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.e.juegopirata.R;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class StartGame extends AppCompatActivity implements View.OnClickListener {

    private int[] img ={R.drawable.a,R.drawable.e,R.drawable.i,R.drawable.o,R.drawable.u,R.drawable.p,R.drawable.c};
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private ImageView img7;
    private ImageView img8;
    private ImageView recuadro;
    private Button btnrandom;
    private String name;
    private MediaPlayer audio;
    private ImageView palabra;
    private FragmentManager manager;
    private FragmentTransaction trans;

    ConstraintLayout container;
    public static int contNega = 0 ;
    public static int contPosi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        inicializar();
    }

    private void inicializar() {
        container = findViewById(R.id.container);


        img1 = findViewById(R.id.line1);
        img1.setOnClickListener(this);

        img2 = findViewById(R.id.line2);
        img2.setOnClickListener(this);

        img3 = findViewById(R.id.line3);
        img3.setOnClickListener(this);

        img4 = findViewById(R.id.line4);
        img4.setOnClickListener(this);

        img5 = findViewById(R.id.line5);
        img5.setOnClickListener(this);

        img6 = findViewById(R.id.line6);
        img6.setOnClickListener(this);

        img7 = findViewById(R.id.line7);
        img7.setOnClickListener(this);

        img8 = findViewById(R.id.line8);
        img8.setOnClickListener(this);

        palabra = findViewById(R.id.palabra);

        btnrandom = findViewById(R.id.random);
        btnrandom.setOnClickListener(this);

        manager = getSupportFragmentManager();


        recuadro = findViewById(R.id.imageView3);

        audio  = new MediaPlayer();


        aletoreo();

    }

    private void aletoreo() {
        try{
        ImageView[] preba ={img1,img2,img3,img4,img5,img6,img7,img8};
        for (int i=0;i<=7;i++) {
            int random = (int) ((Math.random() * 7) + 1);
            preba[i].setImageResource(img[random - 1]);
            String name2 = getApplicationContext().getResources().getResourceEntryName(img[random - 1]);
            preba[i].setTag(name2);
        }
        }catch (Exception e){
                e.printStackTrace();
       }
   }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.random:
                if (audio.isPlaying()){
                    audio.pause();
                    onLowMemory();
                    aletoreo();

                }else {
                    aletoreo();
                }
                break;
            case R.id.line1:
                name =String.valueOf(img1.getTag());
                if (name.equals("a")){
                    correcto();
                }else {
                   incorrect();
                }

                break;
            case R.id.line2:
                name =String.valueOf(img2.getTag());
                if (name.equals("a")){
                    correcto();
                }else {
                    incorrect();
                }

                break;
            case R.id.line3:
                 name =String.valueOf(img3.getTag());
                if (name.equals("a")){
                    correcto();
                }else {
                    incorrect();
                }

                break;
            case R.id.line4:
                name =String.valueOf(img4.getTag());
                if (name.equals("a")){
                    correcto();
                }else {
                    incorrect();
                }

                break;
            case R.id.line5:
                name =String.valueOf(img5.getTag());
                if (name.equals("a")){
                    correcto();
                }else {
                    incorrect();
                }


                break;
            case R.id.line6:
                name =String.valueOf(img6.getTag());
                if (name.equals("a")){
                    correcto();
                }else {
                    incorrect();
                }

                break;
            case R.id.line7:

                name =String.valueOf(img7.getTag());
                if (name.equals("a")){
                    correcto();
                }else {
                    incorrect();
                }

                break;
            case R.id.line8:
                name =String.valueOf(img8.getTag());
                if (name.equals("a")){
                    correcto();
                }else {
                    incorrect();
                }

                break;
            default:
            break;


        }


    }

    private void incorrect() {
        if (audio.isPlaying()){
            audio.pause();
            audio.reset();
            incorrect();

        }else {

            contNega = contNega + 1;
            audio = MediaPlayer.create(getApplicationContext(), R.raw.trueno);
            audio.start();
        }
    }

    private void correcto() {
        if (audio.isPlaying()){
            audio.pause();
            audio.reset();
            correcto();


        }else {

            audio = MediaPlayer.create(getApplicationContext(), R.raw.correct);
            audio.start();

            contPosi = contPosi+1;
        }
        cambio();
    }

    private void cambio() {
        switch (contPosi) {

            case 1:
                palabra.setImageResource(R.drawable.a);
                Timer tiempo = new Timer();
                TimerTask accion = new TimerTask() {
                    @Override
                    public void run() {

                        recuadro.setImageResource(R.drawable.carro);



                    }
                };
                tiempo.schedule(accion,2000);
              //  recuadro.setImageResource(R.drawable.carro);


        }


    }
}
