package com.company;
import javax.swing.JFrame;
import java.awt.BorderLayout;



public class CatalogFrame extends JFrame {
    CatalogList list;
    ControlPanel control;
    GraphForm form;

        public CatalogFrame() {
        super("Visual Graph Manager");
        init();
        addComponents();
        this.pack();
    }
    private void init() {
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        form = new GraphForm(this);
        list =  new CatalogList();
        control = new ControlPanel(this);
        form.drawGraphForm();
         }
    private void addComponents(){
        add(form, BorderLayout.NORTH);
        add(list, BorderLayout.CENTER);
        add(control, BorderLayout.SOUTH);
    }
}
