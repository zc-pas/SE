package groupwork;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * The TeachingArrangement class represents a mapping relationship between courses and the groups of teachers assigned to teach those courses.
 * It contains a map object called teachingArrangement that maps each course object to the corresponding GroupOfTeacher object.
 * This class provides methods for adding or removing teacher objects from the GroupOfTeacher object in the teachingArrangement map.
 * It also provides a toString method that returns a string representation of the teachingArrangement map.
 *
 */

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
