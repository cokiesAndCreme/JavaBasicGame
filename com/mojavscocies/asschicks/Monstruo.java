package com.mojavscocies.asschicks;

import javax.swing.*;
import java.awt.*;

public class Monstruo extends Madreclass{
    private int premioOro;
    private int premioExp;

    private JLabel etiNombre;
    private JLabel  imagen;

    private static String[] nombresFacil = {"bola2","bola","ballena"};
    private static String[] nombresMedio = {"craneo","baboso","conejo"};
    private static String[] nombresDificil = {"perro","tibu","tortuga"};



    public Monstruo(String nombre, double vidaMax, int def, int atack , String dificultad) {
        super(nombre, vidaMax, def, atack);
        etiNombre = new JLabel(nombre);
        String rutaAImagen = "./img/" + nombre.toLowerCase() + ".png";
        imagen = new JLabel();
        imagen.setIcon(new ImageIcon(rutaAImagen));
        switch (dificultad){
            case "facil":
                premioExp=(int)(Math.random()*2 +1);
                premioOro = (int)(Math.random()*5+1);
                break;
            case "medio":
                premioExp=(int)(Math.random()*6 +1);
                premioOro = (int)(Math.random()*20+1);
                break;
            case "dificil":
                premioExp=(int)(Math.random()*16 +1);
                premioOro = (int)(Math.random()*50+1);
                break;
            default:
                premioExp=500;
                premioOro = 1000;
                break;
        }


    }
    

    public int getPremioOro() {
        return premioOro;
    }

    public int getPremioExp() {
        return premioExp;
    }

    public JLabel getEtiNombre() {
        return etiNombre;
    }

    public JLabel getImagen() {
        return imagen;
    }

    public static Monstruo generaMonstruo(int i){
        Monstruo m;
        int nMonstruo = (int)(Math.random()*3);
        int nVida =  (int)(Math.random()*30);
        int nAtac =  (int)(Math.random()*5);
        int nDef =  (int)(Math.random()*1);
        if ( i<80) {
            m = new Monstruo(nombresFacil[nMonstruo],nVida +15,nDef,nAtac+2,"facil");
        }else if(i <140){
            m = new Monstruo(nombresMedio[nMonstruo],nVida +20,nDef+5,nAtac+8,"medio");
        }else if(i <200){
            m = new Monstruo(nombresDificil[nMonstruo],nVida +40,nDef+15,nAtac+18,"dificil");
        }else{
            m = new Monstruo("jefe",nVida +70,nDef+25,nAtac+22,"jefe");

        }
        return m;

    }
}
