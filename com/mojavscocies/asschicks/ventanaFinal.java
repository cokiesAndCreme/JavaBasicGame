package com.mojavscocies.asschicks;

import javax.swing.*;
import java.awt.*;

public class ventanaFinal {
    private JTextArea areaTexto;
    private JLabel imagen;
    private JButton botonSalir;

    private ImageIcon rutaImagen;
    private JDialog marco;
    private JPanel panelPrincipal;
    
    public final int VICTORIA=0;
    public final int DERROTA = 0;
    private int condicion;
    private Personaje pj;

    public ventanaFinal(int condicion,Personaje pj) {
        marco = new JDialog();
        panelPrincipal = new JPanel(new BorderLayout());

        areaTexto = new JTextArea();
        botonSalir = new JButton("salir");
        this.condicion = condicion;
        this.pj = pj;

        if (condicion == VICTORIA) rutaImagen = new ImageIcon("./img/victoria.png");
        else  rutaImagen = new ImageIcon("./img/derrota.png");
        imagen = new JLabel(rutaImagen);
    }

    public void abrir(){
        prepararmensaje();
        montarEcena();
        marco.setVisible(true);
    }

    private void prepararmensaje() {
        String mensajeFinal;
        if (condicion == VICTORIA){
            mensajeFinal = "Gnaste guacho  Nivel:"+ pj.getNivel()+ "  ORO:" +pj.getOro()  ;
        }else
            mensajeFinal = "Moriste pe";
        areaTexto.setText(mensajeFinal);
    }

    private void montarEcena() {
        panelPrincipal.add(imagen,BorderLayout.NORTH);
        panelPrincipal.add(areaTexto,BorderLayout.CENTER);

        botonSalir.addActionListener(e-> System.exit(0));
        panelPrincipal.add(botonSalir, BorderLayout.SOUTH);
        marco.add(panelPrincipal);
        marco.setSize(600,600);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);

    }
}
