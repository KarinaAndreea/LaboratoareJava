import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        //List<Double> l1 = new ArrayList<Double>();
        Node v1 = new Hotel("California");
        Node v2 = new Museum("Lourve");
        Node v3 = new Church("Sagrada Familia");
        Node v4 = new Museum("Metropolitan Museum of Art");
        Node v5 = new Museum("The British Museum");
        Node v6 = new Museum("The Vatican Museums");
        Node v7 = new Restaurant("Vivo");
       /* ((Museum) v1).addFee(17.02, l1);
        ((Museum) v4).addFee(22.00, l1);
        ((Museum) v5).addFee(18.50, l1);
        ((Museum) v6).addFee(19.33, l1);*/
        ((Museum) v2).setFee(17.02);
        ((Museum) v4).setFee(22.00);
        ((Museum) v5).setFee(18.50);
        ((Museum) v6).setFee(19.33);
       /* double stats;
        stats = Payable.streamAverage(l1);
        System.out.println("The average price ticket of the Museums: " + stats + " euro");*/
        TravelMap map = new TravelMap();
        map.addNode(v1);
        map.addNode(v2);
        map.addNode(v3);
        map.addNode(v4);
        map.addNode(v5);
        map.addNode(v6);
        map.addNode(v7);
        System.out.println("\nNodurile TravelMap:");
        System.out.println(map.getNodes());
        map.addEdge(v1, v2, 15); //two way street by default
        map.addEdge(v3, v2, 1, false); //one-way street
        map.addEdge(v1, v3,10);
        map.addEdge(v3, v4,2);
        map.addEdge(v4, v5,1);
        map.addEdge(v5,v6,1);
        map.addEdge(v2,v6,10);
        System.out.println("\nMuchiile din TravelMap:");
        System.out.println(map.getEdges());

        ((Restaurant) v7).setSchedule(LocalTime.parse("08:00"),LocalTime.parse("19:00"));
        System.out.println("\nLocations that are visitable but not payable, sorted by their opening hours");
        map.visitableButNotPayable();

        System.out.println("\nAverage fee " + map.averageFee());

        ((Museum) v2).setSchedule(LocalTime.parse("12:00"),LocalTime.parse("19:00"));
        System.out.println(v2.getNameOfTheNode() + " opens at " + ((Museum) v2).getVisitableHours()[0] + " and closes at " + ((Museum) v2).getVisitableHours()[1] + " =>");
        ((Museum) v2).duration();
        System.out.println(" hours.");

        System.out.println(v2.getNameOfTheNode() + " opens at " + ((Church) v3).getVisitableHours()[0] + " and closes at " + ((Church) v3).getVisitableHours()[1] + " =>");
        ((Church) v3).duration();
        System.out.println(" hours.\n");

        System.out.println(map.getNeighbors(v1));
        System.out.println(map.getMinimumNeighborDistance(v1));
        //System.out.println(map.printGreedyPath(v1,v2));
    }
}
