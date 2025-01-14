package com.mojavscocies.asschicks;

import javax.swing.*;
import java.awt.*;

public class Exploracion {
    private JDialog marco;

    private JPanel panelPrincipal, panelSuperior, panelInferior, panelMonstruo, panelMonstruoSec;

    private JButton botAtacar, botHuir;

    private JTextArea infoExploracion;
    private JScrollPane barraDes;

    private Personaje pj;
    private Monstruo en;
    private VentanaPrincipal ventp;


    private static int numExploracion = 0;


    public Exploracion(VentanaPrincipal vp) {
        this.ventp = vp;
        pj = vp.getPj();
        marco = new JDialog();
        panelPrincipal = new JPanel(new BorderLayout());
        panelSuperior = vp.getPanelSuperior();
        panelInferior = new JPanel();
        panelMonstruo = new JPanel();
        panelMonstruoSec = new JPanel();
        infoExploracion = new JTextArea();
        infoExploracion.setEditable(false);
        barraDes = new JScrollPane(infoExploracion);
        barraDes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        botAtacar = new JButton("Atacar");
        botHuir = new JButton("hUIR");

    }



    public void comenzarExploracion(){
        decidirDificultad();
        montarInterfaz();
    }

    private void montarInterfaz() {
        panelPrincipal.add(barraDes,BorderLayout.CENTER);
        botAtacar.addActionListener(e -> atacar());
        botHuir.addActionListener(e-> marco.dispose());
        panelInferior.add(botAtacar);
        panelInferior.add(botHuir);

        panelMonstruoSec.add(en.getEtiNombre());
        panelMonstruoSec.add(en.getBarravida());

        panelMonstruo.setLayout(new BoxLayout(panelMonstruo,BoxLayout.Y_AXIS));
        panelMonstruo.add(en.getImagen());
        panelMonstruo.add(panelMonstruoSec);

        panelPrincipal.add(panelSuperior,BorderLayout.NORTH);
        panelPrincipal.add(panelInferior,BorderLayout.SOUTH);
        panelPrincipal.add(panelMonstruo,BorderLayout.EAST);

        marco.add(panelPrincipal);
        marco.setSize(600,500);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);
        marco.setVisible(true);

    }

    private void atacar() {
        int damag;
        pj.atacar(en);
        infoExploracion.setText(
                infoExploracion.getText() + pj.getNombre() +"Ataca con un fuerza de "
                + pj.getAtack() +".\n");
        damag = pj.getAtack() - en.getDef();
        if (damag <= 0) damag = 1;
        infoExploracion.setText(
                infoExploracion.getText() + en.getNombre() + " a recibido " + damag + " de daño gracias a su defensa .\n");
        en.estableserVida(en.getVidaActual());
        if (!en.isEstado()){
            enemigoDerrotado();
        }else{
            en.atacar(pj);
            infoExploracion.setText(
                    infoExploracion.getText() + en.getNombre() +"Ataca con un fuerza de "
                            + en.getAtack() +".\n");
            damag = en.getAtack() - pj.getDef();
            if (damag <= 0) damag = 1;
            infoExploracion.setText(
                    infoExploracion.getText() + pj.getNombre() + " a recibido " + damag + " de daño gracias a su defensa .\n");
            pj.estableserVida(pj.getVidaActual());
            if(!pj.isEstado())derrotado();
        }
    }

    private void derrotado() {
    }

    private void enemigoDerrotado() {
        botAtacar.setEnabled(false);
        botHuir.setText("salir");
        infoExploracion.setText(infoExploracion.getText() + " Enemigo" + en.getNombre() + " A MUERTO" + ".\n"
        + "Oro Obtenido: " +en.getPremioOro() +"\n" + "Exp Obtenida: " + en.getPremioExp());
        pj.subirExp(en.getPremioExp());
        ventp.getEtExp().setText("  Exp: " + pj.getExp() + "/" + pj.getExpNesesaria());
    }

    private void decidirDificultad() {
        int numAlea = (int)(Math.random() * 100) + numExploracion;
        numExploracion++;
        en = Monstruo.generaMonstruo(numAlea);

    }


}
