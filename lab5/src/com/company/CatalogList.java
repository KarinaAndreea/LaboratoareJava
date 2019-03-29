package com.company;

import javax.swing.*;

public class CatalogList extends JList {
    DefaultListModel model = new DefaultListModel<>();
    JPanel listPanel = new JPanel();
    JList<String> listOfGraphs ;

    public CatalogList() {
        String title = "<html><i><font color='blue'>" +
                "Catalog Graphs" + "</font></i></hmtl>";
        this.setBorder(BorderFactory.createTitledBorder(title));
        this.setModel(model);
        init();
    }
    private void init() {
        model.addElement("Petersen Graph");
        model.addElement("K3 - Complete Graph");
        model.addElement("Random Graph");
        listOfGraphs = new JList<>(model);
        listPanel.add(listOfGraphs);
    }

    public void addGraph(String item) {
        model.addElement(item);
    }

    // getters and setters
    public JPanel getListPanel() {
        return listPanel;
    }

    public void setListPanel(JPanel listPanel) {
        this.listPanel = listPanel;
    }

    public DefaultListModel<String> getListModel() {
        return model;
    }

    public void setListModel(DefaultListModel<String> listModel) {
        this.model = listModel;
    }

    public JList<String> getListOfGraphs() {
        return listOfGraphs;
    }

    public void setListOfGraphs(JList<String> listOfGraphs) {
        this.listOfGraphs = listOfGraphs;
    }
}
