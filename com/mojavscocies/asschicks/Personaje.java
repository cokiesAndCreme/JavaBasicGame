package com.mojavscocies.asschicks;

public class Personaje extends Madreclass{
    private int nivel;
    private int oro;
    private int exp;
    private int expNesesaria;



    public Personaje(String nombre, double vidaMax, int def, int atack) {
        super(nombre, vidaMax, def, atack);
        nivel = 1;
        oro = 0;
        exp = 0;
        expNesesaria = 10;

    }

    public int getExp() {
        return exp;
    }

    public void subirExp (int cantidad){
        exp += cantidad;
        if (exp >= expNesesaria)subirNiel();

    }

    public int getExpNesesaria() {
        return expNesesaria;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getNivel() {
        return nivel;
    }
    public void subirNiel(){
        nivel++;
        setAtack(getAtack() + 1);
        setDef(getDef() + 1);
        setVidaMax(getVidaMax() *1.1);
        getBarravida().setMaximum((int) getVidaMax());
        setVidaActual((int)getVidaMax());
        estableserVida((int)getVidaMax());
        expNesesaria += (expNesesaria + 5);

    }


}
