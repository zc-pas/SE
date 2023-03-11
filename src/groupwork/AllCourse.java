package groupwork;


import java.io.Serializable;

public class AllCourse extends GroupOfCourse implements Serializable{
	private int count;
	
	public AllCourse() {
		super();
		count = groupOfCourse.size();
	}
	
	public void add(Course c) {
		count = this.groupOfCourse.size();
		this.groupOfCourse.add(c);
		c.setCourseId(count);
		count = this.groupOfCourse.size();
	}
	
	public void remove(Course c) {
		System.out.print("you cannot remove from the course database");
	}
}
