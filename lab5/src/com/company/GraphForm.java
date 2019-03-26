package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphForm extends JPanel {
    private final CatalogFrame frame;
    String[] graphType = {"simple", "directed"};
    JComboBox graphList= new JComboBox(graphType);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int height = screenSize.height ;
    int width = screenSize.width /2;

    JLabel titleLabel = new JLabel("Name of the graph");
    JLabel typeLabel = new JLabel("Type of the graph");
    JLabel pathLabel = new JLabel("Path of definition file");
    JLabel pathImgLabel = new JLabel("Path of image file");
    JLabel verticesLabel = new JLabel("Number of vertices");
    JLabel nodesLabel = new JLabel("Number of nodes");
    JButton addButton = new JButton("Add new graph");

    JTextField titleField = new JFormattedTextField();
    JTextField pathField = new JFormattedTextField();
    JTextField imageField = new JFormattedTextField();
    JSpinner verticesField = new JSpinner(
            new SpinnerNumberModel(0,0, 999,1));
    JSpinner nodesField = new JSpinner(
            new SpinnerNumberModel(0, 0,999,1));


    public GraphForm(CatalogFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Add graph"));
        this.frame = frame;
        init();
        this.setLayout(new GridLayout(7,2));
    }
    private void init() {
        frame.setPreferredSize(new Dimension(width, height));

        add(titleLabel);
        add(titleField);

        add(typeLabel);
        add(graphList);

        add(pathLabel);
        add(pathField);

        add(pathImgLabel);
        add(imageField);

        add(verticesLabel);
        add(verticesField);

        add(nodesLabel);
        add(nodesField);


        add(addButton);

    }
}
