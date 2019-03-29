package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class GraphForm extends JPanel {
    private CatalogFrame frame;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    String item;
    int height = screenSize.height / 2;
    int width = screenSize.width / 4;

    String[] graphType = {"simple", "directed"};
    JComboBox graphList = new JComboBox(graphType);;
    JLabel nameLabel = new JLabel("Name of the graph") ;
    JLabel typeGraph= new JLabel("Graph type");
    JLabel pathLabel=  new JLabel("Path of definition file");
    JLabel pathImgLabel = new JLabel("Path of image file");
    JLabel verticesLabel= new JLabel("Number of vertices");
    JLabel edgeLabel = new JLabel("Number of edges");

    JTextField nameTextField = new JFormattedTextField();
    JTextField pathTextField = new JFormattedTextField();
    JTextField imgField= new JFormattedTextField();
    JSpinner verticesField= new JSpinner(
            new SpinnerNumberModel(0,0, 999,1));
    JSpinner edgeField= new JSpinner(
            new SpinnerNumberModel(0, 0,999,1));

    JButton addButton  = new JButton("Add new graph");
    Border blueBorder=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    TitledBorder titled = BorderFactory.createTitledBorder(blueBorder,"Add graph");

     public GraphForm(CatalogFrame frameArg)
    {
        this.frame = frameArg;
        init();
        this.setLayout(new GridLayout(14,1));
    }


    public JTextField getPathTextField() {
        return pathTextField;
    }

    public JTextField getImgField() {
        return imgField;
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
        gbc.ipadx=350;
        this.add(this.nameTextField,gbc);

        gbc.insets=new Insets(10,10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=2;
        this.add(pathLabel,gbc);


        gbc.insets=new Insets(0, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.ipadx=350;
        this.add(pathTextField,gbc);


        gbc.gridx=0;
        gbc.gridy=4;
        gbc.insets=new Insets(10, 10, 0, 10);
        this.add(pathImgLabel,gbc);

        gbc.gridx=0;
        gbc.gridy=5;
        gbc.ipadx=350;
        gbc.insets=new Insets(0, 10, 0, 10);
        this.add(imgField,gbc);

        gbc.insets=new Insets(10, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=6;
        this.add(typeGraph,gbc);

        gbc.insets=new Insets(0, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=7;
        gbc.ipadx=350;
        this.add(graphList,gbc);


        gbc.insets=new Insets(10, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=8;
        gbc.ipadx=200;
        this.add(verticesLabel,gbc);

        gbc.insets=new Insets(0, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=9;
        gbc.ipadx=200;
        gbc.anchor=GridBagConstraints.NORTHWEST;
        this.add(verticesField,gbc);

        gbc.insets=new Insets(10, 10, 0, 10);
        gbc.gridx=0;
        gbc.gridy=10;
        gbc.ipadx=200;
        gbc.anchor=GridBagConstraints.NORTHWEST;
        this.add(edgeLabel,gbc);

        gbc.insets=new Insets(0, 10, 10, 10);
        gbc.gridx=0;
        gbc.gridy=11;
        gbc.ipadx=200;
        this.add(edgeField,gbc);

        gbc.gridx=0;
        gbc.gridy=12;
        gbc.insets=new Insets(20, 10, 0, 10);
        addButton.setSize(50,30);
        this.add(addButton,gbc);

        this.setBorder(titled);
    }
    private void init(){
    frame.setPreferredSize(new Dimension(width, height));
  /*  add(nameLabel);
    add(nameTextField);
    add(pathLabel);
    add(pathTextField);
    add(pathImgLabel);
    add(imgField);
    add(typeGraph);
    add(graphList);
    add(verticesLabel);
    add(verticesField);
    add(nodesLabel);
    add(nodesField);
    add(addButton);*/
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent press) {
                   setText(nameTextField.getText(), graphList.getSelectedItem(),
                        verticesField.getValue(), edgeField.getValue(), pathTextField.getText(), imgField.getText());
                     addGraph();
                     new Table();
                                    }
                 });

        }
    public void setText(String name, Object graphType, Object vertices, Object edges, String path, String imgPath){
        this.item = "";
        if(!name.isEmpty() && !path.isEmpty()&& graphType != null)
             this.item=name + ", "+graphType+", "+ "n="+ vertices + ", m=" + edges + ", "+ path +", "+imgPath;
    }
    public String getText(){
        return item;
    }
    private void addGraph() {
            frame.list.addGraph(getText());

    }
}
