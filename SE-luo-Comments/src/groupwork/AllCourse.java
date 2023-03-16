package groupwork;


import java.io.Serializable;

/**
 * AllCourse class extends GroupOfCourse class and
 * it is used to management the course database
 *
 * @author Tianshuo Zang 2746520Z
 */
public class AllCourse extends GroupOfCourse implements Serializable {

    // current count of courses
    private int count;

    // Constructor, the number of courses is equal to the size of the obtained groupOfCourse
    public AllCourse() {
        super();
        count = groupOfCourse.size();
    }

    // Adds a course in the course database
    public void add(Course c) {
        count = this.groupOfCourse.size();// Get the current number of courses
        this.groupOfCourse.add(c);// Adding courses to a group
        c.setCourseId(count);// Set course id
        count = this.groupOfCourse.size();// Get the number of new courses
    }

    /**
     * remove a course from course database. Only a small
     * number of privileged people can use it. Both administrator
     * and class director cannot use it.
     */
    public void remove(Course c) {
        System.out.print("you cannot remove from the course database");
    }
}
