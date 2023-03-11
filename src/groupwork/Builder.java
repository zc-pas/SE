package groupwork;

/**
 * 
 * Builder class is used to build GroupOfCourse, TeachingArrangement
 * by history records.
 * 
 * @author tianshuo
 *
 */
public class Builder {
	
	/**
	 * create a new Teaching requirement which include all the 
	 * courses in database.
	 * 
	 * @param db database
	 * @return
	 */
	public static GroupOfCourse loadRequirementByAllCourse(Database db) {
		GroupOfCourse tr = new GroupOfCourse();
		GroupOfCourse allCourse = db.getAllCourse();
		for (Course c : allCourse.get()) {
			tr.add(c);
		}
		return tr;
	}
	
	/**
	 * 
	 * create a new GroupOfCourse which is same as the teaching requirement
	 * in Semester s.
	 * 
	 * @param db
	 * @param s
	 * @return
	 */
	public static GroupOfCourse loadRequirementBySemester(Database db, Semester s) {
		GroupOfCourse tr = new GroupOfCourse();
		GroupOfCourse courses = db.getAllTeachingRequirements().getTeachingRequirement(s);
		for (Course c : courses.get()) {
			tr.add(c);
		}
		return tr;
	}
	
	/**
	 * 
	 * auto fill a teaching requirement by the history teaching arrangement in
	 * Semester s.
	 * 
	 * @param db
	 * @param gc
	 * @param s
	 * @return
	 */
	public static TeachingArrangement autoArrangeTeacherBySemester(Database db, GroupOfCourse gc, Semester s) {
		TeachingArrangement ta = new TeachingArrangement(gc);
		TeachingArrangement historyTa = db.getAllTeachingArrangements().getTeachingArrangement(s);
		for (Course c : ta.getTeachingArrangement().keySet()) {
			if (historyTa.getTeachingArrangement().keySet().contains(c)) {
				ta.addTeacher(c, historyTa.getTeachingArrangement().get(c));
			}
		}
		return ta;
	}
	
	
	
	
	
}
