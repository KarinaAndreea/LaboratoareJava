import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Problem {
    int numberOfStudents;
    int numberOfProjects;
    private ArrayList<Student> students = new ArrayList<>();
    protected List<Project> allProjects = new ArrayList<>();


    public Problem() {
    }
    public Problem(int numberOfStudents, int numberOfProjects) {
        this.numberOfStudents = numberOfStudents;
        this.numberOfProjects = numberOfProjects;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * @allProjects is a list that will store all de projects (applications and essays) of all students
     * @set is a LinkedHashSet which is used to eliminate all the duplicates from allProjects (Set is an interface that contains no duplicate elements, LinkedHashSet is an implemented class from the Set interface)
     * @return all the distinct projects from all students
     */
    public List<Project> getProjects(){
        for(Student student:students){
            for(Project pro : student.getPreferences()){
                allProjects.add(pro);
            }
        }
        Set<Project> set = new LinkedHashSet<>();
        set.addAll(allProjects);
        allProjects.clear();
        allProjects.addAll(set);
        return allProjects;
    }
    /**
     * @param stud is a list of Students and their project preferences that must be added to the problem
     * @ok is a variable that indicates if the arg Student is valid for adding to the stud Array
     * @method equals is overridden in the Student class
     */
    public void setStudents(Student ... stud)//zero sau mai multe obiecte Student
    {
            for (Student student : stud) {
                int ok=1;
                for (Student studentAlreadySet : students)
                    if (student.equals(studentAlreadySet)) {
                        System.out.println("Trying to set the same student twice");
                        ok=0;
                    }
                if(ok == 1){
                    students.add(student);
                }
            }
    }
}
