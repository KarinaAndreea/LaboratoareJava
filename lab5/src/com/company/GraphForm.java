package com.company;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class GraphForm extends JPanel {

    String[] graphType = {"simple", "directed"};
    JComboBox graphList;
    JLabel nameLabel ;
    JLabel typeGraph;
    JLabel pathLabel ;
    JLabel pathImgLabel ;
    JLabel verticesLabel;
    JLabel nodesLabel;

    JTextField nameTextField ;
    JTextField pathTextField ;
    JTextField imgField;
    JSpinner verticesField;
    JSpinner nodesField;

    JButton addButton ;

    Border blueBorder ;
    TitledBorder titled;

       public GraphForm() {

        graphList= new JComboBox(graphType);

        nameLabel = new JLabel("Name of the graph");
        pathLabel = new JLabel("Path of definition file");
        pathImgLabel = new JLabel("Path of image file");
        typeGraph = new JLabel("Graph type");
        verticesLabel = new JLabel("Number of vertices");
        nodesLabel = new JLabel("Number of nodes");

        addButton = new JButton("Add new graph");

         nameTextField = new JFormattedTextField();
         pathTextField = new JFormattedTextField();
         imgField = new JFormattedTextField();
         verticesField = new JSpinner(
                new SpinnerNumberModel(0,0, 999,1));
         nodesField = new JSpinner(
                new SpinnerNumberModel(0, 0,999,1));

        blueBorder=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        titled = BorderFactory.createTitledBorder(blueBorder,"Add graph");
    }


    public void drawGraphForm(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(0, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx = 10;
        gbc.weighty = 1;
        gbc.anchor=GridBagConstraints.NORTHWEST;
        this.add(nameLabel,gbc);


        gbc.gridx=0;
        gbc.gridy=1;
        gbc.ipadx=450;
        this.add(this.nameTextField,gbc);

        gbc.insets=new Insets(10, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=2;
        this.add(pathLabel,gbc);


        gbc.insets=new Insets(0, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.ipadx=450;
        this.add(pathTextField,gbc);


        gbc.gridx=0;
        gbc.gridy=4;
        gbc.insets=new Insets(10, 10, 0, 10);
        this.add(pathImgLabel,gbc);

        gbc.gridx=0;
        gbc.gridy=5;
        gbc.ipadx=450;
        gbc.insets=new Insets(0, 10, 0, 10);
        this.add(imgField,gbc);

        gbc.insets=new Insets(0, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=6;
        this.add(typeGraph,gbc);

        gbc.insets=new Insets(0, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=7;
        gbc.ipadx=20;
        this.add(graphList,gbc);


        gbc.insets=new Insets(0, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=8;
        gbc.ipadx=20;
        this.add(verticesLabel,gbc);

        gbc.insets=new Insets(0, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=9;
        gbc.anchor=GridBagConstraints.NORTHWEST;
        this.add(verticesField,gbc);

        gbc.insets=new Insets(0, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=10;
        gbc.anchor=GridBagConstraints.NORTHWEST;
        this.add(nodesLabel,gbc);

        gbc.insets=new Insets(0, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=11;
        this.add(nodesField,gbc);

        gbc.gridx=0;
        gbc.gridy=12;
        gbc.insets=new Insets(20, 10, 0, 10);
        this.add(addButton,gbc);


        this.setBorder(titled);


    }
}
