package com.mojavscocies.asschicks;

public class ClaseMain {
    public static void main(String[] args) {
        var heroe = new Personaje("Leonidas",30,6,10);
        var juego = new VentanaPrincipal(heroe);
        juego.ComenzarJuego();
    }
}
