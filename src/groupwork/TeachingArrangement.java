package groupwork;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TeachingArrangement implements Serializable{
	Map<Course,GroupOfTeacher> teachingArrangement;

	
	public TeachingArrangement() {
		teachingArrangement = new HashMap<Course,GroupOfTeacher>();
	}
	
	public TeachingArrangement(GroupOfCourse gc) {
		teachingArrangement = new HashMap<Course,GroupOfTeacher>();
		for (Course c : gc.get()) {
			teachingArrangement.put(c, new GroupOfTeacher());
		}
	}
	
	public Map<Course,GroupOfTeacher> getTeachingArrangement() {
		return this.teachingArrangement;
	}
	
	public void addTeacher(Course c, Teacher t) {
		teachingArrangement.get(c).add(t);
	}
	
	public void addTeacher(Course c, GroupOfTeacher gt) {
		teachingArrangement.put(c,gt);
	}
	
	public void removeTeacher(Course c, Teacher t) {
		if (teachingArrangement.get(c).contains(t)) {
			teachingArrangement.get(c).remove(t);
		}
	}
	
	public String toString() {
		String s = "";
		for (Course c : teachingArrangement.keySet()) {
			s += "\t" + c.toString() + "\n";
			s += teachingArrangement.get(c).toString("\t\t");
		}
		return s;
	}

	
	
}
