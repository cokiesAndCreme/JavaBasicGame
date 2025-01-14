package com.noAprenderNunca;

import javax.swing.*;
import java.awt.*;

public class FramePer extends JFrame {
    public FramePer(int ancho,int alto, String title,boolean esPrincipal){
        setSize(ancho,alto);
        setTitle(title);
        setLocationRelativeTo(null);
        if(esPrincipal) setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
