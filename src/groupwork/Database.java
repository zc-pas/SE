package groupwork;


import java.io.Serializable;


/**
 * 
 *  The class includes methods for displaying all courses and teachers from DB, as well as the teaching requirements and arrangements.
 * 	Additionally, there are methods for adding courses and getters for AllCourse, AllTeacher, AllTeachingRequirements, AllTeachingArrangements.
 * 
 */
public class Database implements Serializable{

    private AllCourse courseList;
    private AllTeacher teacherList;
    private AllTeachingRequirements allTeachingRequirements;
    private AllTeachingArrangements allTeachingArrangements;
    
    private static Database database;

    
    /**
     * Singleton pattern
     * This method returns a reference to the only instance of the Database class.
     * It creates a new instance of the Database class if it does not exist yet,
     * and returns the existing instance otherwise.
     * 
     */
    public static Database getInstance(){
        if(database==null){
            database= new Database();
        }
        ((AllCourse) database.getAllCourse()).setCount();
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
    
    public AllCourse getAllCourse() {
    	return courseList;
    }
	  
    public AllTeacher getAllTeacher() {
		return teacherList;
	}
    
    public AllTeachingRequirements getAllTeachingRequirements() {
		return allTeachingRequirements;
	}
    
	public AllTeachingArrangements getAllTeachingArrangements() {
		return allTeachingArrangements;
	}

}
