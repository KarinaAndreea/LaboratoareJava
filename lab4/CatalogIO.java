package com.company;
import java.lang.String;
import java.util.Scanner;
import static java.lang.System.exit;


public class CatalogIO {
    String[] parametru;
    Catalog catalog = new Catalog();

    while(true)
    {
        Scanner read = new Scanner((System.in));
        String sir = read.nextLine();
        parametru = new String [sir.split(" ").length-1];
        for (int i=1; i<sir.split(" ").length; i++)
            parametru[i-1] = sir.split(" ")[i];

        switch (sir.split(" ")[0]) {
            case "add": {
                if(parametru[0].equals("Graph")) {
                    Graph g = new Graph(parametru[1], parametru[2], parametru[3]);
                    catalog.add(g);
                }
                break;
            }
            case "open": {
                catalog.open(parametru[1]);
                break;
            }
            case "save": {
                catalog.save(parametru[1]);
                break;
            }
            case "load": {
                catalog.load(parametru[1]);
                break;
            }
            case "list": {
                catalog.list();
                break;
            }
           case "exit": {
                exit(0);
            }
        }
    }
}

