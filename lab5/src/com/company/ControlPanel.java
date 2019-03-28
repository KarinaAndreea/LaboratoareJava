package com.company;
import java.awt.event.ActionEvent;
import laborator4.Catalog;
import javax.swing.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ActionListener {
    private final CatalogFrame frame;
    Catalog  catalog = new Catalog("C:\\Users\\Karina\\Desktop\\Java\\LaboratoareJava\\lab5\\src\\catalog");
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton openButton = new JButton("Open");


    public ControlPanel(CatalogFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        add(loadButton);
        add(saveButton);
        add(openButton);
        loadButton.addActionListener(this);
        saveButton.addActionListener(this);
        openButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == openButton)
        {
            catalog.open(frame.form);

        } else if(source == saveButton){
            catalog.save("catalog.dat");

        }else if(source == loadButton){
            catalog.load("catalog.dat");
        }
    }
}
