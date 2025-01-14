package com.noAprenderNunca;

import javax.swing.JPanel;
import java.awt.*;

public class PanelPersonalisado extends JPanel {
    public static final int FLOWLAYOUT = 0;
    public static final int BORDERLAYOUT = 1;
    public static final int GRIDLAYOUT = 2;

    public PanelPersonalisado(int panelPorDefecto) {
        if (panelPorDefecto == 1)setLayout(new BorderLayout());
        if (panelPorDefecto == 2)setLayout(new GridLayout());


    }
}
