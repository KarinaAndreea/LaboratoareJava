public class Hotel extends Node implements Classifiable {
    private int rank;
    public Hotel(String nameOfTheNode, double latitude, double logitude) {
        super(nameOfTheNode, latitude, logitude);
    }

    public Hotel(String nameOfTheNode){
        super(nameOfTheNode);
    }
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
