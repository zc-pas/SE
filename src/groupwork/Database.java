package groupwork;


import java.io.Serializable;

public class Database implements Serializable{
	// DB course/teacher list
    private AllCourse courseList;
    private AllTeacher teacherList;
    // Each semester list

    private AllTeachingRequirements allTeachingRequirements;
    private AllTeachingArrangements allTeachingArrangements;
    
    private static Database database;

    public static Database getInstance(){
        if(database==null){
            database= new Database();
        }
        return database;
    }
    
    private Database() {
    	courseList=new AllCourse();
        teacherList= new AllTeacher();
    	allTeachingRequirements = new AllTeachingRequirements();
    	allTeachingArrangements = new AllTeachingArrangements();
    }
    // Common function
    //show all course information
    public void showAllcourse(){
    	System.out.println("Course List:");
        for(Course c: courseList.get()){
            System.out.println(c);
        }
    }

    //show all teacher information
    public void showAllteacher(){
    	System.out.println("Teacher List:");
        for(Teacher t:teacherList.get()){
            System.out.println(t);
        }
    }
    
    public void showAllTeachingRequirements(){
    	System.out.println("All Teaching Requirements:");
        System.out.println(allTeachingRequirements);
    }
    
    public void showAllTeachingArrangements(){
    	System.out.println("All Teaching Arrangements:");
        System.out.println(allTeachingArrangements);
    }

	/* 
	 * Class director 
	 * 1. delete/add course
	 * 2. check history requirements
	 */
    
    public GroupOfCourse getAllCourse() {
    	return courseList;
    }
	  
    public GroupOfTeacher getAllTeacher() {
		return teacherList;
	}
    
    
    // Add course
//    public void addCourse(String name, String type) {
//    	Course course = new Course();
//    	course.setName(name);
//    	course.setCourseType(type);
//    	courseList.add(course);
//    	System.out.println(name + " course add successfully");
//    }
//    
//    // Delete course
//    public void deleteCourse(String name) {
//    	for(Course c: courseList.get()) {
//    		if(c.getName().equals(name)) {
//    			courseList.remove(c);
//    			break;
//    		}
//    	}
//    	System.out.println(name + " course delete successfully");
//    }
    
	/* Admin 
	 * Arrange
	 */
    // add teacher to course
//    public void addTeachertoCourse(Course c, Teacher t){
//        for(String s:t.getCourseCapable()){
//            if(s.equals(c.getCourseType())){
//                c.addTeacher(t);
//                System.out.println("add success");
//                return;
//            }
//        }
//        System.out.println("illegal add");
//        return;
//    }
    
//    public void setTeachingRequirementBySemester(Semester s, GroupOfCourse gc) {
//    	allTeachingRequirements.addTeachingRequirement(s,gc);
//    }
    
    public AllTeachingRequirements getAllTeachingRequirements() {
		return allTeachingRequirements;
	}
    
	public AllTeachingArrangements getAllTeachingArrangements() {
		return allTeachingArrangements;
	}

    
//	public ArrayList<Semester> getSemesterList() {
//		return semesterList;
//	}
}
