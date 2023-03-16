package groupwork;


import java.io.Serializable;

/**
 * The Course class is a class that implements the Serializable interface and represents a course.
 * It contains information such as course type, name, and course ID.
 *
 * @author Yiming Zhou 2755018Z
 */
public class Course implements Serializable {
    private String courseType;
    private String name;
    private int courseId;
    static private int nextID = 0;

    public Course() {
        this.courseId = nextID++;
    }

    public Course(String courseType, String name, int courseId) {
        this.courseType = courseType;
        this.name = name;
        this.courseId = courseId;
    }

    public Course(String name, String courseType) {
        this.courseType = courseType;
        this.name = name;
        this.courseId = nextID++;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String toString() {
        return String.format("Course ID: %-3d Course Name: %-20s CourseType: %-10s", courseId, name, courseType);
    }

}
