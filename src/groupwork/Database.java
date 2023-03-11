package groupwork;


import java.io.Serializable;


public class Database implements Serializable{

    private AllCourse courseList;
    private AllTeacher teacherList;
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
    
    public GroupOfCourse getAllCourse() {
    	return courseList;
    }
	  
    public GroupOfTeacher getAllTeacher() {
		return teacherList;
	}
    
    public AllTeachingRequirements getAllTeachingRequirements() {
		return allTeachingRequirements;
	}
    
	public AllTeachingArrangements getAllTeachingArrangements() {
		return allTeachingArrangements;
	}

}
