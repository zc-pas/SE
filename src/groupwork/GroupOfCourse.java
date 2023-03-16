package groupwork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * GroupOfCourse class, which implements the Serializable interface
 * The class contains a List<Course> collection named groupOfCourse for storing course objects.
 * The class provides methods for adding, deleting and finding courses, including finding course by course name or ID.
 * The class also provides a toString() method for converting the elements of the collection to strings.
 *
 */

public class GroupOfCourse implements Serializable{
	protected List<Course> groupOfCourse;
	
	public GroupOfCourse() {
		groupOfCourse = new ArrayList<Course>();
	}
	
	public List<Course> get() {
		return this.groupOfCourse;
	}
	
	
	// get the course by id from the group of course 
	public Course get(int id) {
		for (Course c : groupOfCourse) {
			if (c.getCourseId() == id) {
				return c;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * Delete course from group of course by two input
	 * @param c
	 */
	public void remove(Course c) {
		if (groupOfCourse.contains(c)) {
			groupOfCourse.remove(c);
		}
	}
	
	public void remove(int ID) {
		for(Course c: groupOfCourse) {
			if(ID == c.getCourseId()) {
				groupOfCourse.remove(c);
			}
		}
		
	}
	
	public void add(Course c) {
		groupOfCourse.add(c);
	}
		
    /**
     * search a course by name
     * @param name
     * @return
     * 
     */
    public Course searchCoursebyName(String name){
        for(Course c:groupOfCourse){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
    
    /**
     * search a course by id
     * @param id
     * @return
     */
    public Course searchCoursebyId(int id){
        for(Course c:groupOfCourse){
            if(c.getCourseId()==id){
                return c;
            }
        }
        return null;
    }
	
	public String toString() {
		String s = " ";
		for (Course c : groupOfCourse) {
			s += c.toString() + "\n";
		}
		return s;
	}
	
}
