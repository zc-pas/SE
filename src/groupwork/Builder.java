package groupwork;
public class Builder {
	public static GroupOfCourse loadRequirementByAllCourse(Database db) {
		GroupOfCourse tr = new GroupOfCourse();
		GroupOfCourse allCourse = db.getAllCourse();
		for (Course c : allCourse.get()) {
			tr.add(c);
		}
		return tr;
	}
	
	public static GroupOfCourse loadRequirementBySemester(Database db, Semester s) {
		GroupOfCourse tr = new GroupOfCourse();
		GroupOfCourse courses = db.getAllTeachingRequirements().getTeachingRequirement(s);
		for (Course c : courses.get()) {
			tr.add(c);
		}
		return tr;
	}
	
	
	
}
