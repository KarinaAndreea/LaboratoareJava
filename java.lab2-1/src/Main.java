
import java.time.LocalDate;
import java.time.Month;
public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("S1", 2);
        Student s2 = new Student("S2",2);
        Student s3 = new Student("S3",2);
        Student s4 = new Student("S4",2);
        /** 4 objects of Student class have been initialized */
        Application a1 = new Application("A1", LocalDate.of(2019, Month.JUNE, 1), Application.Language.JAVA);
        Application a2 = new Application("A2",LocalDate.of(2019, Month.JULY, 17), Application.Language.C);
        Application a3 = new Application("A3",LocalDate.of(2019, Month.AUGUST, 3),Application.Language.GO);
        Essay e1 = new Essay("E1", LocalDate.parse("2019-06-01"), Essay.Topic.ALGORITHMS);
        Essay e2 = new Essay("E2",LocalDate.parse("2019-08-20"), Essay.Topic.DATA_STRUCTURES);
        System.out.println(a1.toString());
        System.out.println(e1.toString());

        a1.setCapacity(1);
        a2.setCapacity(1);
        a3.setCapacity(1);
        e1.setCapacity(1);
        e2.setCapacity(1);

        /** the students set their project preferences*/
        s1.setPreferences(a1, a2, a3);
        System.out.println(s1.toString());
        s2.setPreferences(a1, e1);
        s3.setPreferences(a2,a3,e1);
        s4.setPreferences(a3,e2);
s1.getPreferences();
        Problem problem = new Problem(4,5);
        problem.setStudents(s1, s2, s3, s4); //for verifying the equals method
        System.out.println();
        System.out.println("Matching Algorithm : ");
        Matching m = new Matching();
        System.out.println(m.MatchingAlgorithm(problem));
        //System.out.println(problem.getStudents());
        //System.out.println(problem.getProjects());
    }
}
