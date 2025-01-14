package com.mojavscocies.asschicks;

import com.noAprenderNunca.FramePer;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {
    private FramePer marco;

    private JPanel panelPrincipal,panelSuperior,panelInferior;

    private JLabel etNombre, etNivel, etExp,etOro,etAtributos;
    private JLabel etImagen;

    private JButton botonExplorar;

    private Personaje pj;

    public VentanaPrincipal(Personaje pj) {
        this.pj = pj;
        marco = new FramePer(600,500,"juegoCulero",true);
        panelPrincipal = new JPanel(new BorderLayout());
        panelSuperior = new JPanel();
        panelInferior = new JPanel();

        etNombre = new JLabel(pj.getNombre());
        etNivel = new JLabel("Lvl: " + pj.getNivel());
        etExp = new JLabel("Exp: " + pj.getNivel() + "/" + pj.getExpNesesaria());
        etOro  =new JLabel("Oro: " + pj.getOro());
        etAtributos = new JLabel(" Atq: " + pj.getAtack() +" |" + "  Def :" +pj.getDef() + "  Vida: ");

        etImagen = new JLabel();

        botonExplorar = new JButton("Explorar");

    }

    public void ComenzarJuego (){
        MontarEcena();
        marco.setVisible(true);
    }

    private void MontarEcena() {
        panelSuperior.add(etNombre);
        panelSuperior.add(etNivel);
        panelSuperior.add(etExp);
        panelSuperior.add(etOro);
        panelSuperior.add(etAtributos);
        panelSuperior.add(pj.getBarravida());

        etImagen.setIcon(new ImageIcon("./img/pixel.jpg"));
        panelPrincipal.add(etImagen,BorderLayout.CENTER);

        botonExplorar.addActionListener(e -> nuevaExploracion());
        panelInferior.add(botonExplorar);

        panelPrincipal.add(panelSuperior,BorderLayout.NORTH);
        panelPrincipal.add(panelInferior,BorderLayout.SOUTH);

        marco.add(panelPrincipal);
    }

    private void nuevaExploracion() {
        Exploracion ex = new Exploracion(this);
        ex.comenzarExploracion();
        panelPrincipal.add(panelSuperior,BorderLayout.NORTH);
        marco.repaint();

    }

    public Personaje getPj() {
        return pj;
    }

    public JPanel getPanelSuperior() {
        return panelSuperior;
    }

    public JLabel getEtNivel() {
        return etNivel;
    }

    public JLabel getEtExp() {
        return etExp;
    }

    public JLabel getEtOro() {
        return etOro;
    }

    public JLabel getEtAtributos() {
        return etAtributos;
    }
}
