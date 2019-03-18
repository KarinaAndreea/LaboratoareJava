
import java.util.*;

public class TravelMap {
    private List<Node> nodes;
    private List<Edge> edges;


    public TravelMap() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    /* LE-AM SORTAT */
    public List<Node> getNodes() {
        nodes.sort(Node::compareByName); //sort method din interfata List, '::' referinta la metoda
        /* Echivalente: */
        //Collections.sort(nodes, Node::compareByName);//
        //Collections.sort(nodes, (a,b) -> Node.compareByName(a,b));
        return nodes;
    }

    public void addNode(Node node){
            nodes.add(node);
    }

    public void addEdge(Node firstNode, Node secondNode, int costOfTheEdge) {
        Edge edge = new Edge(firstNode,secondNode,costOfTheEdge,true);
        edges.add(edge);
    }
    public void addEdge(Node firstNode, Node secondNode, int costOfTheEdge, boolean isTwoWayStreet) {
        Edge edge = new Edge(firstNode,secondNode,costOfTheEdge,isTwoWayStreet);
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "TravelMap{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }

    public void visitableButNotPayable(){
        this.getNodes().stream().filter(node -> (node instanceof Visitable) && !(node instanceof Payable)).
                sorted(Comparator.comparing(o -> ((Visitable) o).getVisitableHours()[0])).forEach(System.out::println);
    }

    public double averageFee(){
        return this.getNodes().stream().filter(node -> node instanceof Payable).mapToDouble(node -> ((Payable) node).getEntryFee()).average().getAsDouble();
    }

    public List<Node> getNeighbors(Node n) {
        List<Node> neighbors = new ArrayList<>();
        for(Edge edge : edges) {
            if(edge.getNode1().equals(n)) {
                neighbors.add(edge.getNode2());
            }
        }
        return neighbors;
    }

    public int getDistanceFrom(Node start, Node end) {
        for(Edge e : edges) {
            if(e.getNode1().equals(start) && e.getNode2().equals(end)) {
                return e.getCostOfTheEdge();
            }
        }
        return 0;
    }

    public int getMinimumNeighborDistance(Node curent) {
        List<Node> neighbors = getNeighbors(curent);
        int cost = Integer.MAX_VALUE;
        for (Node n : neighbors) {
            if(cost > getDistanceFrom(curent, n))
                cost = getDistanceFrom(curent,n);
        }
        return cost;
    }
    public Edge anotherEdge(Node node1, Node node2, int cost){
        Edge anotherNewEdge = new Edge(node1,node2,cost);
        return  anotherNewEdge;
    }
    //BUCLA INFINITA :)))))
    /*public List<Edge> printGreedyPath(Node node1, Node node2){
        List<Edge> path = new ArrayList<>();
        Node currentNode = new Node();
        if(getNeighbors(node1).contains(node2)){
            Edge newEdge = new Edge(node1,node2,getDistanceFrom(node1,node2));
            path.add(newEdge);
        }
        else
            currentNode = node1;
            while(!getNeighbors(currentNode).contains(node2)) {
                for (Node n : getNeighbors(currentNode)) {
                    if (getDistanceFrom(currentNode, n) == getMinimumNeighborDistance(currentNode)){
                        path.add(anotherEdge(currentNode, n, getDistanceFrom(currentNode, n)));
                        currentNode = n;
                        break;
                    }
                }
            }
        path.add(anotherEdge(currentNode,node2,getDistanceFrom(currentNode,node2)));
        return path;
    }*/
}
