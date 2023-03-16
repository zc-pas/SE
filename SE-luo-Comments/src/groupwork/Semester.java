package groupwork;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Semester courses represent a period of time during which a course is offered in a given year
 * It extends the Period class and implements the serializable interface.
 *
 * @author Jiasong Liu 2750568L
 */
public class Semester extends Period implements Serializable {
    private String season;
    private String signature;
    private ArrayList<Course> listcourse;

    public Semester() {

    }

    /**
     * Constructor with year and season parameters
     *
     * @param year   the year of the semester
     * @param season the season of the semester
     */
    public Semester(int year, String season) {
        super(year);
        this.season = season;
        this.signature = year + " " + season;
    }

    /**
     * Constructor with year, start date, duration, and season parameters
     *
     * @param year      the year of the semester
     * @param startDate the start date of the semester
     * @param duration  the duration of the semester in weeks
     * @param season    the season of the semester
     */
    public Semester(int year, int startDate, int duration, String season) {
        super(year, startDate, duration);
        this.season = season;
        this.signature = year + " " + season;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public ArrayList<Course> getListcourse() {
        return listcourse;
    }

    public void setListcourse(ArrayList<Course> listcourse) {
        this.listcourse = listcourse;
    }

    public void addCourse(Course c) {
        this.listcourse.add(c);
    }

    public String toString() {
        return signature;
    }
}
