package com.e.juegopirata.modelo;

public class Jugador {

    String Name;
    int ScorePo;
    int ScoreNe;
    int State = 0;


    public Jugador() {
    }


    public Jugador(String name, int scorePo, int scoreNe, int state) {
        Name = name;
        ScorePo = scorePo;
        ScoreNe = scoreNe;
        State = state;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getScorePo() {
        return ScorePo;
    }

    public void setScorePo(int scorePo) {
        ScorePo = scorePo;
    }

    public int getScoreNe() {
        return ScoreNe;
    }

    public void setScoreNe(int scoreNe) {
        ScoreNe = scoreNe;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }
}
