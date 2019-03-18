package cofg;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String graphPath;
    private String catalogPath;
    private String catalog;//path folder pt catalog
    private List<Graph>  graphs = new ArrayList<>();

    public Catalog(String catalog) {
        this.catalog = catalog;
    }
    public void add(Graph graph){
        graphs.add(graph);
    }
    public void list(){
        for(Graph g : graphs)
            System.out.println(g.toString());
    }
    public void open(String name) throws IOException
    {
        String imagePath = new String();
        for (Graph g : graphs){
                if(g.getName() == name)
                    imagePath = g.getImage();
        }
        File imageFile = new File(imagePath);
        Desktop desktop = Desktop.getDesktop();
        if(imageFile.exists())
            desktop.open(imageFile);
    }

}
