package com.mojavscocies.asschicks;

import javax.swing.*;
import java.awt.*;

public class Madreclass implements Atacable{
    private  String nombre;
    private int vidaActual,def,atack;
    private double vidaMax;
    private boolean estado;
    private JProgressBar barravida;

    public Madreclass(String nombre, double vidaMax, int def, int atack) {
        this.nombre = nombre;
        this.vidaMax = vidaMax;
        this.def = def;
        this.atack = atack;
        vidaActual = (int) vidaMax;
        estado = true;
        barravida = new JProgressBar(0,(int) vidaMax);
        barravida.setPreferredSize(new Dimension(100,25));
        estableserVida(vidaActual);
    }

    @Override
    public void atacar(Atacable e) {
        e.recibirDaño(atack);

    }

    @Override
    public void recibirDaño(int cant) {
        if(estado){
            int cantidadTotal = cant - def;
            if (cantidadTotal <=0) cantidadTotal =1;
            vidaActual -= cantidadTotal;
            System.out.println(cantidadTotal);
            if (vidaActual <=0) {
                estado =false;
                vidaActual = 0;
            }
        }

    }

    public void estableserVida(int vida) {
        barravida.setValue(vida);
        barravida.setForeground(Color.red);
        barravida.setStringPainted(true);
        barravida.setString(vidaActual + "/" + (int)vidaMax);
    }

    public int getAtack() {
        return atack;
    }

    public void setAtack(int atack) {
        this.atack = atack;
    }

    public JProgressBar getBarravida() {
        return barravida;
    }


    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }


    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public double getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(double vidaMax) {
        this.vidaMax = vidaMax;
    }


}
