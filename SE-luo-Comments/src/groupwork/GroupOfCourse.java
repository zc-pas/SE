package groupwork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * GroupOfCourse class, which implements the Serializable interface
 * The class contains a List<Course> collection named groupOfCourse for storing course objects.
 * The class provides methods for adding, deleting and finding courses, including finding course objects by course name or ID.
 * The class also provides a toString() method for converting the elements of the collection to strings.
 *
 * @author Chu Zhang 2650227Z
 */
public class GroupOfCourse implements Serializable {
    protected List<Course> groupOfCourse;

    // Instantiate groupOfCourse
    public GroupOfCourse() {
        groupOfCourse = new ArrayList<Course>();
    }

    public List<Course> get() {
        return this.groupOfCourse;
    }

    // Iterate through the groupOfCourse collection and return the course if the course ids are equal
    public Course get(int id) {
        for (Course c : groupOfCourse) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    // Delete the course if the course list contains it
    public void remove(Course c) {
        if (groupOfCourse.contains(c)) {
            groupOfCourse.remove(c);
        }
    }

    // If the course list contains the id of the course, delete the course
    public void remove(int ID) {
        for (Course c : groupOfCourse) {
            if (ID == c.getCourseId()) {
                groupOfCourse.remove(c);
            }
        }

    }

    public void add(Course c) {
        groupOfCourse.add(c);
    }

    // Create a new Course object and add it to the groupOfCourse collection
    public void add(String name, String type) {
        groupOfCourse.add(new Course(name, type));
    }

    // Search a course by name
    public Course searchCoursebyName(String name) {
        for (Course c : groupOfCourse) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    // Search a course by id
    public Course searchCoursebyId(int id) {
        for (Course c : groupOfCourse) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    public String toString() {
        String s = "";
        for (Course c : groupOfCourse) {
            s += c.toString() + "\n";
        }
        return s;
    }

}
