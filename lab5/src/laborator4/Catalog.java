package laborator4;
import com.company.GraphForm;

import java.io.*;
import java.awt.Desktop;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

public class Catalog implements Commands, Serializable{
    private String path;
    private List<Graph>  graphs;
    private String tgvPath = new String();
    private String imagePath = new String();

    public Catalog(String path) {
        this.graphs=new ArrayList<Graph>();
        this.path = path;
    }

    public void save(String destination) {
        try {

            FileOutputStream fos = new FileOutputStream(this.path + "\\" + destination);
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
 public void open(GraphForm graph)
    {  tgvPath = graph.getPathTextField().getText();
       imagePath = graph.getImgField().getText();
        File tgvFile;
        File imgFile;
        tgvFile = new File(tgvPath);
        imgFile = new File(imagePath);
        Desktop desktop = Desktop.getDesktop();
      try{
           desktop.open(tgvFile);
          desktop.open(tgvFile);
      }
      catch (FileNotFoundException e) {
          if (!imgFile.exists())
              throw new WrongFileNameException("Incorrect filename : " + imgFile );
          if (!tgvFile.exists())
              throw new WrongFileNameException("Incorrect filename : " + tgvFile );
      }
      catch (IOException err) {
          System.out.println("Eroare la citire");
          err.printStackTrace();
      }
    }
}

