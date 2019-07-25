package com.e.juegopirata.modelo;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.e.juegopirata.R;

import static com.e.juegopirata.controlador.StartGame.*;

public class Threadd extends AsyncTask<Void, Boolean, Boolean> {

    int number;

    int[] igm = {R.drawable.papaimg, R.drawable.bebe, R.drawable.mama, R.drawable.gato, R.drawable.vaca};
    int[] letras = {R.drawable.a, R.drawable.e, R.drawable.a, R.drawable.o, R.drawable.a};




    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        recuadro.setImageResource(igm[contPosi]);

    }

    @SuppressLint("WrongThread")
    @Override
    protected Boolean doInBackground(Void... voids) {
        for (int i = 0; i <= 4; i++) {
            dormir();

        }

        return true;
    }


    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        ejecutar();




    }

    private void ejecutar() {
        if (contPosi<5) {
            Threadd threadd = new Threadd();
            threadd.execute();
        }else {

        }
    }






    private void dormir() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
