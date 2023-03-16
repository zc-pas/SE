package groupwork;

/**
 * 
 * Builder class is used to build GroupOfCourse, TeachingArrangement
 * by history records.
 * 
 *
 */
public class Builder {
	
	/**
	 * create a new Teaching requirement which include all the 
	 * courses in database.
	 * 
	 * @param db database
	 * @return GroupOfCourse which include all courses in database
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
	 * @param db database
	 * @param signature the Semester that you need
	 * @return
	 */
	public static GroupOfCourse loadRequirementBySemester(Database db, String signature) {
		GroupOfCourse tr = new GroupOfCourse();
		for (Course c : db.getAllTeachingRequirements().getTeachingRequirement(signature).get()) {
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
	 * @param gc the current teaching requirement that you want to fill
	 * @param s the history Semester that you want to followed 
	 * @return
	 */
	public static TeachingArrangement autoArrangeTeacherBySemester(Database db, GroupOfCourse gc, String signature) {
		TeachingArrangement ta = new TeachingArrangement(gc);
		TeachingArrangement historyTa = db.getAllTeachingArrangements().getTeachingArrangement(signature);
		for (Course c : ta.getTeachingArrangement().keySet()) {
			if (historyTa.getTeachingArrangement().keySet().contains(c)) {
				ta.addTeacher(c, historyTa.getTeachingArrangement().get(c));
			}
		}
		return ta;
	}
	
	
	
	
	
}
