
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Restaurant extends Node implements Visitable, Classifiable {
    private int rank;
    private LocalTime openingHour;
    private LocalTime closingHour;
    public Restaurant(String nameOfTheNode, double latitude, double logitude) {
        super(nameOfTheNode, latitude, logitude);
        setVisitableHours();
    }
    public Restaurant(String nameOfTheNode){
        super(nameOfTheNode);
        setVisitableHours();
    }

    public void setSchedule(LocalTime openingHour, LocalTime closingHour){
        this.openingHour=openingHour;
        this.closingHour=closingHour;
    }

    public LocalTime[] getVisitableHours(){
        return new LocalTime[] {openingHour,closingHour};
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void duration(){
        System.out.print(Visitable.getVisitingDuration(openingHour,closingHour).toHours());
    }
}
