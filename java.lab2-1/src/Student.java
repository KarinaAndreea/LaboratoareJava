
import java.util.*;


public class Student {
    private String name;
    private int yearOfStudy;
    private List<Project> preferences = new ArrayList<>();
    private boolean hasProject;


    public Student(String name, int yearOfStudy) {
        this.name = name;
        this.yearOfStudy = yearOfStudy;
    }

    /**
     * @return the preferences of each student
     */
    public List<Project> getPreferences() {
        return preferences;
    }


    /**
     * @param projects is a list of objects of the class Project which stores the project preferences of a Student object
     * @ok is a variable that indicates if the arg Student is valid for adding to the stud Array
     * @method equals is overridden in the Project class
     */
    public void setPreferences(Project ... projects) {
            for (Project projectsSet : projects) {
                int ok=1;
                for (Project project : preferences)
                    if (project.equals(projectsSet)) {
                        System.out.println("Trying to set the same project twice");
                        ok=0;
                    }
                if(ok == 1){
                    preferences.add(projectsSet);
                }
            }
    }

    public String getName() {
        return name;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public boolean getHasProject(){
        return hasProject;
    }

    public boolean setHasProject(boolean value){
        return this.hasProject=value;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + ' ' +
                ", yearOfStudy=" + yearOfStudy +
                ", preferences=" + preferences +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return yearOfStudy == student.yearOfStudy &&
                Objects.equals(name, student.name) &&
                Objects.equals(preferences, student.preferences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfStudy, preferences);
    }
}
