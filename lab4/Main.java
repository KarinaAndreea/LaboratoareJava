package com.company;
import java.io.IOException;


import static java.lang.System.exit;

//custom exception
public class Main {

    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog("\\company\\graphs");
        catalog.add(new Graph("k4", "graphs/k4.tgf", "graphs/view/k4.svg"));
        catalog.add(new Graph("k3", "graphs/k3.tgf", "graphs/view/k4.svg"));
        catalog.list();
        catalog.save("catalog.dat");
        // catalog.open("k4");

    }
}