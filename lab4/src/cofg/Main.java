package cofg;
import java.io.IOException;

//custom exception
public class Main {

    public static void main(String[] args) throws IOException
    {
        Catalog catalog = new Catalog("\\src\\cofg");
        catalog.add (new Graph("K4", "graphs/k4.tgf", "graphs/view/k4.svg"));
        catalog.add (new Graph("K3", "graphs/k3.tgf", "graphs/view/k4.svg"));
        catalog.list();
        catalog.open("K4");
    }
}
