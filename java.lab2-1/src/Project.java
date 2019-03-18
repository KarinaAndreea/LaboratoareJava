
import java.time.LocalDate;
import java.util.Objects;
import java.util.ArrayList;

public abstract class Project {
    protected String name;//nu le puteam accesa in application
    protected LocalDate deadline;
    protected ArrayList<Student> Preferences = new ArrayList<>();
    protected ArrayList<Student> allocatedStudents = new ArrayList<>();
    public int studentsAllocated = 0;
    public int capacity;


    public Project(String name, LocalDate deadline) {
        this.name = name;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setAllocatedStudents(Student...students) {
        for (Student s : students){
            this.Preferences.add(s);
        }
    }

    public ArrayList<Student> getPreferences(){
        return this.Preferences;
    }
    public ArrayList<Student> getAllocatedStudents(){
        return this.allocatedStudents;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + ' ' +
                ", deadline=" + deadline +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) &&
                Objects.equals(deadline, project.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, deadline);
    }
}
