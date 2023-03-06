package ae2.src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupOfCourse implements Serializable{
	protected List<Course> groupOfCourse;
	
	public GroupOfCourse() {
		groupOfCourse = new ArrayList<Course>();
	}
	
	public List<Course> get() {
		return this.groupOfCourse;
	}
	
	public Course get(int id) {
		for (Course c : groupOfCourse) {
			if (c.getCourseId() == id) {
				return c;
			}
		}
		return null;
	}
	
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
	
	public void add(String name, String type) {
		groupOfCourse.add(new Course(name,type));
	}
	
    //search a course by name
    public Course searchCoursebyName(String name){
        for(Course c:groupOfCourse){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
    
    public Course searchCoursebyId(int id){
        for(Course c:groupOfCourse){
            if(c.getCourseId()==id){
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
