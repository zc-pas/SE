package groupwork;


import java.io.Serializable;
/**
 * 
 * AllCourse class extends GroupOfCourse class and
 * it is used to management the course database
 *
 */
public class AllCourse extends GroupOfCourse implements Serializable{
	
	// current count of courses
	private int count; 
	
	// Constructor, the number of courses is equal to the size of the obtained groupOfCourse
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
	 * add a course to the course database
	 * 
	 */
	public void add(String course, String type) {
		count = this.groupOfCourse.size();
		Course c = new Course(course, type);
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
	
	public int getCount() {
		return this.count;
	}
	
	public void setCount() {
		this.count = this.get().size();
	}
}
