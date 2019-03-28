package com.company;

import javax.swing.*;
import java.awt.*;

public class CatalogFrame extends JFrame {
    CatalogList list;
    ControlPanel control;
    GraphForm form;

        public CatalogFrame() {
        super("Visual Graph Manager");
        init();
        addComponents();
        }
    private void init() {
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        form = new GraphForm();
        list =  new CatalogList();
        control = new ControlPanel(this);
        form.setLayout(new GridBagLayout());
        form.drawGraphForm();
        }
    private void addComponents(){
        add(form, BorderLayout.NORTH);
        add(list, BorderLayout.CENTER);
        add(control, BorderLayout.SOUTH);
    }
}
