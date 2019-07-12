package com.e.juegopirata.modelo;

public class Contant {

    public static String NAME_DB = "JUEGOP.DB";
    public static int version = 3;


    public static String name_table = "jugador";
    public static String name_table2 = "puntos";
    public static String name_name = "Nombre";
    public static String scoreP = "SCOREP";
    public static String scoreN = "SCOREN";
    public static String state = "STATE";


    public static String table = "CREATE TABLE "+name_table+" ("+
            name_name+" TEXT NOT NULL) ";




    public static String table2 = "CREATE TABLE "+name_table2+" ("+
            scoreP+ " INTEGER,"+
            scoreN+ "  INTEGER,"+
            state+ " INTEGER)";

    public static String drop ="DROP TABLE IF EXISTS "+name_table;
    public static String drop2 ="DROP TABLE IF EXISTS "+name_table2;





}
