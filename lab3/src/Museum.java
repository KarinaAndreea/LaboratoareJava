import java.time.LocalTime;

public class Museum extends Node implements Visitable, Payable {
    private LocalTime openingHour;
    private LocalTime closingHour;
    private double fee;

    public Museum(String nameOfTheNode, double latitude, double longitude) {
        super(nameOfTheNode, latitude, longitude);
        setVisitableHours();
    }

    public Museum(String nameOfTheNode){
        super(nameOfTheNode);
        setVisitableHours();//am apelat functia care seteaza default opening and closing hours
    }

    //metoda implementata din interfata Visitable, seteaza open/closingHours
    public void setSchedule(LocalTime openingHour, LocalTime closingHour){
        this.openingHour=openingHour;
        this.closingHour=closingHour;
    }

    public LocalTime[] getVisitableHours(){
        return new LocalTime[] {openingHour,closingHour};
    }


    public double getEntryFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    //metoda ce apeleaza functia statica ce afla numarul de ore in care o locatie e deschisa
    public void duration(){
        System.out.print(Visitable.getVisitingDuration(openingHour,closingHour).toHours());
    }
}
