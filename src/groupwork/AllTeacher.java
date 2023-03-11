package groupwork;


import java.io.Serializable;

public class AllTeacher extends GroupOfTeacher implements Serializable{
	private int count;
	
	public AllTeacher() {
		super();
		count = groupOfTeacher.size();
	}
	
	public void add(Teacher t) {
		count = this.groupOfTeacher.size();
		this.groupOfTeacher.add(t);
		t.setTeacherId(count);
		count = this.groupOfTeacher.size();
	}
	
	public void remove(Teacher c) {
		System.out.print("you cannot remove from the Teacher database");
	}
}
