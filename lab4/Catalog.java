package com.company;
import java.io.*;
import java.awt.Desktop;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import static java.awt.Desktop.getDesktop;

public class Catalog implements Commands, Serializable{
    private List<Graph> graphs = new ArrayList<>(); //lista de grafuri
    private String path;

    public Catalog(){
        this.path=null;
        this.graphs=new ArrayList<Graph>();}

    public Catalog(String path) {
        this.path = path;
    }

    public void add(Graph graph) {
        graphs.add(graph);
    }

    public void list() {
        for (Graph g : graphs) {
            System.out.println( g.toString());
        }
    }

    public void save(String path) {
        Path p = Paths.get(path);
        try {
            if (!Files.exists(p)) {
                Files.createFile(p);
            }
            File f = p.toFile();
            FileOutputStream fos
                    = new FileOutputStream(f);
            try (ObjectOutputStream out = new ObjectOutputStream(fos)) {
                out.writeObject(this);
                out.flush();
            }
            System.out.println("Ceva frumos");
        } catch (IOException e) {
            System.out.println("Eroare serializare");

        }

    }
    public void load(String nume)
    {
        try {
            FileInputStream fis = new FileInputStream(nume);
            ObjectInputStream in = new ObjectInputStream(fis);

            graphs = (List<Graph>) in.readObject();

            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println(" " + e);

        } catch (IOException e) {
            System.out.println(" " + e);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (ClassCastException e ) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public void open (String path)
    {   File f1 = null;
        try {
            f1 = new File(path);
            Desktop desc = getDesktop();
            desc.open(f1);
        } catch (FileNotFoundException e) {
            System.err.println("Fisierul " + f1 + "nu a fost gasit!");
        } catch (IOException err) {
            System.out.println("Eroare la citire");
            err.printStackTrace();
        }
    }
}