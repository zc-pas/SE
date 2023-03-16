package groupwork;


import java.io.Serializable;

/**
 * This is a singleton class that serves as a database for the program.
 * It contains the lists of courses and teachers, as well as the teaching requirements and arrangements for each semester.
 * The class also includes methods for displaying the course and teacher lists, as well as the teaching requirements and arrangements.
 * Additionally, there are methods for adding and deleting courses, adding teachers to courses, and setting the teaching requirements for each semester.
 *
 * @author Mingqi Zhang 2810329Z
 */
public class Database implements Serializable {

    // DB course/teacher list
    private AllCourse courseList;
    private AllTeacher teacherList;
    // Each semester list
    private AllTeachingRequirements allTeachingRequirements;
    private AllTeachingArrangements allTeachingArrangements;

    /**
     * The getInstance() method is a factory method
     * that returns a reference to the only instance of the Database class.
     * It creates a new instance of the Database class if it does not exist yet,
     * and returns the existing instance otherwise.
     */
    private static Database database;

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    private Database() {
        courseList = new AllCourse();
        teacherList = new AllTeacher();
        allTeachingRequirements = new AllTeachingRequirements();
        allTeachingArrangements = new AllTeachingArrangements();
    }

    // Common function
    // Show all course information
    public void showAllcourse() {
        System.out.println("Course List:");
        for (Course c : courseList.get()) {
            System.out.println(c);
        }
    }

    // Show all teacher information
    public void showAllteacher() {
        System.out.println("Teacher List:");
        for (Teacher t : teacherList.get()) {
            System.out.println(t);
        }
    }

    public void showAllTeachingRequirements() {
        System.out.println("All Teaching Requirements:");
        System.out.println(allTeachingRequirements);
    }

    public void showAllTeachingArrangements() {
        System.out.println("All Teaching Arrangements:");
        System.out.println(allTeachingArrangements);
    }

    public GroupOfCourse getAllCourse() {
        return courseList;
    }

    public GroupOfTeacher getAllTeacher() {
        return teacherList;
    }

    public AllTeachingRequirements getAllTeachingRequirements() {
        return allTeachingRequirements;
    }

    public AllTeachingArrangements getAllTeachingArrangements() {
        return allTeachingArrangements;
    }

}
