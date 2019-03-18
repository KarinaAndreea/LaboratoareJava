import java.util.ArrayList;
import java.util.*;

public class Matching {

    
    /** Check if the project first appears in the preference list of s1.
     * @param p The project�s name.
     * @param s1 The student�s name.
     * @param s2 The student�s  name.
     */
    public boolean isHigherRanked(Project p, Student s1, Student s2) {
        if (p.getPreferences().indexOf(s1) < p.getPreferences().indexOf(s2)) {
            return true;
        }
        return false;
    }
   
     /** Get the student who has the last option the project p.
      *  @param p The project�s name.
      */
    private Student getLowestRanked(Project p) {
        /**an object of the Student class is initialized with the first student*/
        Student lowestRanked = p.getAllocatedStudents().get(0);
        /**for each student who prefers the project p*/
        for(Student s : p.getAllocatedStudents() ){
        /**the student has the project among the last preferences*/
            if(p.getPreferences().indexOf(s) > p.getPreferences().indexOf(lowestRanked)){
                lowestRanked = s;
            }
        }
        return lowestRanked;

    }
       /** Replace the most preferred project with one less preferred
        *  @param s The student�s name.
        *  @param p The project�s name.
        *  @param match a match (student, problem).
        */
    public boolean replaceHigherRanked(Student s, Project p,  Map<String, String> match) { 
        /**the student prefers the project p and the last preference is not the project p*/
        if (p.getPreferences().contains(s)==true && isHigherRanked(p, s, getLowestRanked(p)) == true) {
         /**the student whose last preference is the project p does not have a project*/
            getLowestRanked(p).setHasProject(false);
         /**we can not have the same project assigned twice*/
            match.remove(getLowestRanked(p).toString());
            p.setAllocatedStudents(getLowestRanked(p), s);
          /**match for the student and the project p*/
            match.put(s.toString(), p.toString());
            s.setHasProject(true);
            return true;
        }
        return false;
    }
       /** Check if the project has not been allocated
        *  @param p The project�s name.
       */
    public boolean isProjectFree(Project p) {
        if (p.getCapacity() > p.studentsAllocated) {
            return true;
        } else
            return false;
    }
    
       /** Find a match
        *  @param s The student�s name.
        *  @param match a match (student, problem).
       */
    public void findmatch(Student s, Map<String, String> match) {
         /**for each project from s Preferences*/
        for (Project p : s.getPreferences()) { 
         /**if the project isn't taken*/
            if (isProjectFree(p) == true) { 
            /**match for the student and the project p*/
                match.put(s.getName(), p.getName());
                s.setHasProject(true);
                p.allocatedStudents.add(s);
                p.studentsAllocated++;
                break;
            }
        }
        /**if the project is taken but the student doesn't have a project*/
        if (s.getHasProject() == false) {
            for (Project p : s.getPreferences()) {
        /**reallocate the projects so that each student has one of the first references*/
                if(replaceHigherRanked(s, p, match) == true){
                    break;
                }
            }
        }
    }
    /**Check if all students have a project
     * @param students
     */
    public boolean allStudentsHaveProject(ArrayList<Student> students) {
        for (Student s : students) {
            if (s.getHasProject() == false) {
                return false;
            }
        }
        return true;
    }
    
    /**allocate to each student a problem
     * @param problem
     */
    public Map<String, String> MatchingAlgorithm(Problem problem) {
        Map<String, String> stableMatch = new HashMap<String, String>(); /*HashMap implements Map*/
        /**while not all students have an assigned project*/
        while (allStudentsHaveProject(problem.getStudents()) == false) {
            /**for all students*/
            for (int i = 0; i < problem.getStudents().size(); i++) {
                /**the problem is not assigned to a student*/
                if ((problem.getStudents().get(i).getHasProject()) == false) {
                    /**make a match for the student i and the problem*/
                    findmatch(problem.getStudents().get(i), stableMatch);
                }
            }
        }
        return stableMatch;
    }

}
