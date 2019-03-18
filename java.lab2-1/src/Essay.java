import java.time.LocalDate;

public class Essay extends Project{
    public enum Topic {
        ALGORITHMS, DATA_STRUCTURES, WEB, DATABASES;
    }
    Topic topic;
    /** Creates an essay with the specified name.
     * @param name The essay’s  name.
     * @param deadline The essay’s deadline.
     * @param topic The essay’s topic.
     */
    public Essay(String name, LocalDate deadline, Topic topic) {
        super(name, deadline);
        this.topic = topic;
    }

    /** Gets the esays’s topic
     * @return ....
     */
    public Topic getTopic() {
        return topic;
    }

    /** Sets the essay’s topic.
     * @param topic An object containing the essay's
     * topic.
     */
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Essay{" +
                "topic=" + topic +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
