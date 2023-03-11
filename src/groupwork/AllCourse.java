package groupwork;


import java.io.Serializable;
/**
 * 
 * AllCourse class extends GroupOfCourse class and 
 * it is used to management the course database
 * 
 * @author tianshuo
 *
 */
public class AllCourse extends GroupOfCourse implements Serializable{
	
	private int count; // current count of courses
	

	public AllCourse() {
		super();
		count = groupOfCourse.size();
	}
	
	/**
	 * add a course to the course database
	 * 
	 */
	public void add(Course c) {
		count = this.groupOfCourse.size();
		this.groupOfCourse.add(c);
		c.setCourseId(count);
		count = this.groupOfCourse.size();
	}
	
	/**
	 * remove a course from course database. Only a small 
	 * number of privileged people can use it. Both administrator
	 * and class director cannot use it.
	 * 
	 */
	public void remove(Course c) {
		System.out.print("you cannot remove from the course database");
	}
}
