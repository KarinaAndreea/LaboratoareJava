public class Edge {
    private Node node1;
    private Node node2;
    private int costOfTheEdge;
    private boolean isTwoWayStreet;

    public Edge(Node node1, Node node2, int costOfTheEdge) {
        this.node1 = node1;
        this.node2 = node2;
        this.costOfTheEdge = costOfTheEdge;
    }

    public Edge(Node node1, Node node2, int costOfTheEdge, boolean isTwoWayStreet) {
        this.node1 = node1;
        this.node2 = node2;
        this.costOfTheEdge = costOfTheEdge;
        this.isTwoWayStreet = isTwoWayStreet;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public boolean isTwoWayStreet() {
        return isTwoWayStreet;
    }

    public void setTwoWayStreet(boolean twoWayStreet) {
        isTwoWayStreet = twoWayStreet;
    }

    public int getCostOfTheEdge() {
        return costOfTheEdge;
    }

    public void setCostOfTheEdge(int costOfTheEdge) {
        this.costOfTheEdge = costOfTheEdge;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "node1=" + node1 +
                ", node2=" + node2 +
                ", costOfTheEdge=" + costOfTheEdge +
                ", isTwoWayStreet=" + isTwoWayStreet +
                '}';
    }
}
