package groupwork;


import java.io.Serializable;

/**
 * 
 * The AllTeacher class is a class that extends the GroupOfTeacher class and
 * implements the Serializable interface.
 * AllTeacher class is used to store and managements all teachers
 *
 */
public class AllTeacher extends GroupOfTeacher implements Serializable{
	private int count;
	
	// Use count to create unique ID for teacher
	public AllTeacher() {
		super();
		count = groupOfTeacher.size();
	}
	
	/**
	 * add a teacher in the teacher databse
	 * 
	 */
	public void add(Teacher t) {
		count = this.groupOfTeacher.size();
		this.groupOfTeacher.add(t);
		t.setTeacherId(count);
		count = this.groupOfTeacher.size();
	}
	
	public void add(String teacher, String ability) {
		count = this.groupOfTeacher.size();
		Teacher t = new Teacher(teacher, ability);
		this.groupOfTeacher.add(t);
		t.setTeacherId(count);
		count = this.groupOfTeacher.size();
	}
	
	/**
	 * 
	 * remove a teacher from teacher database. Only a small 
	 * number of privileged people can use it. Both administrator
	 * and class director cannot use it.
	 * 
	 */
	public void remove(Teacher c) {
		System.out.print("you cannot remove from the Teacher database");
	}
}
