import java.time.Duration;
import java.time.LocalTime;


interface Visitable {
    void setSchedule(LocalTime opening, LocalTime closing);
    LocalTime[] getVisitableHours();
    void duration();

    default void setVisitableHours(){
        setSchedule(LocalTime.parse("09:30"),LocalTime.parse("20:00"));
    }
    static Duration getVisitingDuration(LocalTime openingHour, LocalTime closingHour)
    {
        Duration object;
        object = Duration.between(openingHour, closingHour);
        return object;

    }
}
