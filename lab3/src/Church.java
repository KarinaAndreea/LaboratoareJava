import java.time.LocalTime;

public class Church extends Node implements Visitable {
    private LocalTime openingHour;
    private LocalTime closingHour;

    public Church(String nameOfTheNode, double latitude, double longitude) {
        super(nameOfTheNode, latitude, longitude);
        setVisitableHours();
    }

    public Church(String nameOfTheNode) {
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

    public void duration(){
        System.out.print(Visitable.getVisitingDuration(openingHour,closingHour).toHours());
    }
}
