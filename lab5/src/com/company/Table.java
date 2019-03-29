package com.company;
import javax.swing.*;


public class Table {
    public Table(){
        CatalogList list =  new CatalogList();
          // create some tabular data
        String[] colName= new String[] {"Name", "Type", "Path"};
        String [][] data = new String[][] {};

        // create the data model and the JTable
        JTable table = new JTable(data, colName);

        JFrame tFrame = new JFrame("Catalog");
        tFrame.add(new JScrollPane(table));
        tFrame.setSize(500, 200);
        tFrame.setVisible(true);
    }
}
