import java.util.Objects;

public class Node {
    private String nameOfTheNode;
    private double latitude;
    private double longitude;

    public Node(){

    }
    public Node(String nameOfTheNode, double latitude, double longitude) {
        this.nameOfTheNode = nameOfTheNode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Node(String nameOfTheNode){
        this.nameOfTheNode = nameOfTheNode;
    }

    public String getNameOfTheNode() {
        return nameOfTheNode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setNameOfTheNode(String nameOfTheNode) {
        this.nameOfTheNode = nameOfTheNode;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    //functie folosita in expresia lambda din travelMap pentru a sorta toate nodurile dupa nume
    public static int compareByName(Node oneNode, Node anotherNode){
        return oneNode.getNameOfTheNode().compareTo(anotherNode.getNameOfTheNode());
    }

    @Override
    public String toString() {
        return "Node{" +
                "nameOfTheNode='" + nameOfTheNode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Double.compare(node.latitude, latitude) == 0 &&
                Double.compare(node.longitude, longitude) == 0 &&
                Objects.equals(nameOfTheNode, node.nameOfTheNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfTheNode, latitude, longitude);
    }
}
