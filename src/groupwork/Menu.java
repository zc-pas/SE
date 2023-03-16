package groupwork;


import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

/**
 *  Menu page
 * Menu class for displaying console output
 * Entering numbers at the prompt to complete the corresponding function
 * 
 */
public class Menu {

	Database db;
	GroupOfCourse currentRequirement; 
	String currentSemester;
	TeachingArrangement currentArrangement;
	
	
	/**
	 * 
	 * Login page
	 * 
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void login() throws FileNotFoundException, ClassNotFoundException, IOException {
    	System.out.println("---------- Login ----------");
    	System.out.println("1 Class Director\n2 Administrator\n0 Exit System");
    	db = IODatabase.read();
    	while(true) {
    		try {
    			Scanner sc = new Scanner(System.in);
    			System.out.println("Please choose your role");
    			String line = sc.nextLine();
    			switch(line) {
	    			case "1":
	    				ClassDirectorMainMenu();
					break;
	    			case "2":
	    				AdministratorMainMenu();
					break;
	    			case "0":
	    				System.exit(0);
					break;
    			}
    		} catch(Exception e) {
    			System.out.println("Something wrong, please enter again. ");
    		}
    	}
    }
    
	
	/**
	 * basic function for both user
	 * like display and search
	 */
	public void basic() {
		while(true) {
			try {
				System.out.println("---------- Course&Teacher ----------");
				System.out.println("1 Show all courses\n2 Show all teachers\n3 Search teacher(Name)\n"
	    				+ "4 Search course(Name)\n5 Search teacher(Subject)\n0 Exit\nEnter your choice: ");
				Scanner sc = new Scanner(System.in);
	    		String line = sc.nextLine();
	    		
	    		switch(line) {
	    			case "1":
	    				db.showAllcourse();
	    				break;
	    			case "2":
	    				db.showAllteacher();
	    				break;
	    			case "3":
	    				searchTeacher();
	    				break;
	    			case "4":
	    				searchCourse();
	    				break;
	    			case "5":
	    				searchTeacherbyType();
	    				break;
	    			case "0":
	    				System.out.println("Exit successfully");
	    				System.exit(0);
	    		}
			}catch(Exception e) {
				
			}
		}
	}
	
    /**
     * Class director is available to add course/teacher to Database
     * And class director can create a teaching requirement
     * 
     */
    public void ClassDirectorMainMenu() {
        while(true) {
        	try {
	    		System.out.println("---------- Class Director ----------");
	    		System.out.println("1 Course&Teacher\n2 Add course to DB\n3 Add teacher to DB\n4 Create requirement\n0 Exit\nEnter your choice: ");
	    		Scanner sc = new Scanner(System.in);
	    		String line = sc.nextLine();
	    		
	    		switch(line) {
	    			case "1":
	    				basic();
	    				break;
	    			case "2":
	    				addCoursetoDB();
	    				break;
	    			case "3":
	    				addTeachertoDB();
	    				break;
	    			case "4":
	    				createRequirementsInterface();
	    				break;
	    			case "0":
	    				System.out.println("Exit successfully");
	    				System.exit(0);
	    			}
    			}catch(Exception e) {
    				System.out.println("Error, Enter again. ");
    			}
        }
    }
    
    /**
     * Class director(CD) can create a new empty requirement(2)
     * CD can create a requirement by loading all courses from DB
     * CD can create a requirement by loading past semester's requirement
     * If class director has already created a requirement, it would jump to edit Requirement page
     *  
     */
    public void createRequirementsInterface() {
    	while(true) {
        	try {
	    		System.out.println("---------- Load/Create requirement ----------");
	    		System.out.println("1 Check all history requirements\n2 Load new requirement\n3 Load requirement with all courses\n"
	    				+ "4 Load requirement by search semster\n0 Exit");
	    		System.out.println("Please enter your choice: ");
	    		Scanner sc = new Scanner(System.in);
	    		String line = sc.nextLine();
	    		
	    		switch(line) {
	    			case "1":
	    				db.showAllTeachingRequirements();
	    				break;
	    			case "2":
	    				createNewEmptyTeachingRequirement();
	    				break;
	    			case "3":
	    				loadAllcourseRequirement();
	    				break;
	    			case "4":
	    				loadPastSemesterRequirement();
	    				break;
	    			case "0":
	    				System.out.println("Exit successfully");
	    				System.exit(0);
	    			}
    			}catch(Exception e) {
    				System.out.println("Error, Please enter again. ");
    			}
        }
    }
    /**
     * Class director can add/delete courses from the current requirement
     * CD can save the requirement to the DB
     * 
     */
    public void editRequirement() {
    	while(true) {
        	try {
	    		System.out.println("---------- Edit requirement ----------");
	    		System.out.println("1 Check all history requirements\n2 Add course\n3 Delete course\n4 save Requirement\n0 Exit");
	    		System.out.println("Please enter your choice: ");
	    		Scanner sc = new Scanner(System.in);
	    		String line = sc.nextLine();
	    		
	    		switch(line) {
	    			case "1":
	    				db.showAllTeachingRequirements();
	    				break;
	    			case "2":
	    				addCoursetoRequirement();
	    				break;
	    			case "3":
	    				deleteCoursefromRequirement();
	    				break;
	    			case "4":
	    				IODatabase.write(db);
	    				System.out.println("Save successfully");
	    				break;
	    			case "0":
	    				System.out.println("Exit successfully");
	    				System.exit(0);
	    			}
    			}catch(Exception e) {
    				System.out.println("Error, Enter again. ");
    			}
        }
    }
    
    /**
     * Admin can use basic function or create a teaching arrangement
     * 
     */
    public void AdministratorMainMenu() {
    	while(true) {
        	try {
	    		System.out.println("---------- Administrator ----------");
	    		System.out.println("1 Course&Teacher\n2 Arrange teacher\n0 Exit");
	    		System.out.println("Please enter your choice: ");
	    		Scanner sc = new Scanner(System.in);
	    		String line = sc.nextLine();
	    		
	    		switch(line) {
	    			case "1":
	    				basic(); 
	    				break;
	    			case "2":
	    				createArrangementInterface(); 
	    				break;
	    			case "0":
	    				System.out.println("Exit successfully");
	    				System.exit(0);
	    			}
    			}catch(Exception e) {
    				System.out.println("Error, Please enter again. ");
    			}
        }
    }
    
    /**
     * Admin can create a new arrangement by enter the current semester(year&season)
     * Admin can also load a arrangement by choosing past semester, 
     * our system would arrange the teacher from the selected semester's arrangement to the current requirement
     * 
     */
    public void createArrangementInterface() {
    	while(true) {
        	try {
	    		System.out.println("---------- Load arrangement ----------");
	    		System.out.println("1 Check all history arrangements\n2 Load requirement\n3 Load history arrangement by search\n0 Exit");
	    		System.out.println("Please enter your choice: ");
	    		Scanner sc = new Scanner(System.in);
	    		String line = sc.nextLine();
	    		
	    		switch(line) {
	    			case "1":
	    				db.showAllTeachingArrangements(); 
	    				break;
	    			case "2":
	    				createNewEmptyArrangement();
	    				break;
	    			case "3":
	    				loadHistoryArrangement();
	    				break;
	    			case "0":
	    				System.out.println("Exit successfully");
	    				System.exit(0);
	    			}
    			}catch(Exception e) {
    				System.out.println("Error, enter again. ");
    			}
        }
    }
    
    /**
     * Admin can add/delete teacher from the current arrangement
     * Admin can save arrangement
     * 
     */
    public void AdministratorArrange() {
    	while(true) {
        	try {
	    		System.out.println("---------- Arrange ----------");
	    		System.out.println("1 Check all history arrangements\n2 Add teacher\n3 Delete teacher\n4 save\n0 Exit");
	    		System.out.println("Please enter your choice: ");
	    		Scanner sc = new Scanner(System.in);
	    		String line = sc.nextLine();
	    		
	    		switch(line) {
	    			case "1":
	    				db.showAllTeachingArrangements(); 
	    				break;
	    			case "2":
	    				addTeachertoArrangement(); 
	    				break;
	    			case "3":
	    				deleteTeacherfromArrangement();
	    				break;
	    			case "4":
	    				IODatabase.write(db);;
	    				System.out.println("Save successfully");
	    				break;
	    			case "0":
	    				System.out.println("Exit successfully");
	    				System.exit(0);
	    			}
    			}catch(Exception e) {
    				System.out.println("Error, enter again. ");
    			}
        }
    }
   // Basic function
    public void searchCourse() {
    	System.out.println("Please enter the course name: ");
    	Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println(db.getAllCourse().searchCoursebyName(name));
    }
    public void searchTeacher() {
    	System.out.println("Please enter the teacher's name: ");
    	Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println(db.getAllTeacher().searchTeacherbyName(name));
    }
    public void searchTeacherbyType() {
    	System.out.println("Please enter the subject: ");
    	Scanner sc = new Scanner(System.in);
		String subject = sc.nextLine();
		System.out.println(db.getAllTeacher().searchTeacherbyCapable(subject));
    }
    /**
     * Ask user to enter the semester
     * @return
     */
    public String checkSemester(){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the year:");
		String year = sc.nextLine();
		System.out.println("Enter the season: ");
		String season = sc.nextLine();
		return year + " " + season;
    }
    
    /**
     * Class director management
     * CD is only able to add data to the database
     * 
     */
    public void addCoursetoDB(){
    	db.showAllcourse();
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the course name: ");
		String name = sc.nextLine();
		System.out.println("Enter the course type: ");
		String type = sc.nextLine();
		db.getAllCourse().add(name,type);
		System.out.println("Add course successfully");
    }
    public void addTeachertoDB(){
    	db.showAllteacher();
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the teacher name: ");
		String name = sc.nextLine();
		System.out.println("Enter the teacher ability: ");
		String ab = sc.nextLine();
		db.getAllTeacher().add(name,ab);
		System.out.println("Success");
    }
    
    
    /**
     * 
     * Class director can create a new requirement by enter the current semester
     * It would an empty requirement
     * 
     */
    public void createNewEmptyTeachingRequirement(){
    	this.currentSemester = checkSemester();
    	
		if(db.getAllTeachingRequirements().getTeachingRequirement(currentSemester) == null) {
			db.getAllTeachingRequirements().addTeachingRequirement(currentSemester, new GroupOfCourse());
			currentRequirement = db.getAllTeachingRequirements().getTeachingRequirement(currentSemester);
			editRequirement();
		}else {
			System.out.println(currentSemester + " teaching requirement has been created");
			createRequirementsInterface();
		}
    }
    /**
     * 
     * Class director can load a new requirement with all courses form DB, entering the current semester
     * 
     */
    public void loadAllcourseRequirement() {
    	System.out.println("Enter current semester:");
    	currentSemester = checkSemester();
    	if(db.getAllCourse() != null && db.getAllTeachingRequirements().getTeachingRequirement(currentSemester) == null) {
    		GroupOfCourse tempCourses = Builder.loadRequirementByAllCourse(db);
    		db.getAllTeachingRequirements().addTeachingRequirement(currentSemester, tempCourses);
    		currentRequirement = db.getAllTeachingRequirements().getTeachingRequirement(currentSemester);
    		System.out.println("Load requirement of all courses successfully");
        	editRequirement();
    	}else if (db.getAllCourse() == null) {
    		System.out.println("DB is empty, add course or create new requirement");
    		createRequirementsInterface();
    	}else if (db.getAllTeachingRequirements().getTeachingRequirement(currentSemester) != null) {
    		System.out.println("Current semester requirement has been created");
    		editRequirement();
    	}
    }
    /**
     * 
     * Class director can load a new requirement by choosing a past semester 
     * 
     */
    public void loadPastSemesterRequirement() {
    	String temp = checkSemester();
    	if(db.getAllTeachingRequirements().getTeachingRequirement(temp) != null) {
    		System.out.println("Enter current semester:");
    		currentSemester = checkSemester();
    		if(db.getAllTeachingRequirements().getTeachingRequirement(currentSemester) == null) {
    			GroupOfCourse tempCourses = Builder.loadRequirementBySemester(db, temp);
        		db.getAllTeachingRequirements().addTeachingRequirement(currentSemester, tempCourses);
        		currentRequirement = db.getAllTeachingRequirements().getTeachingRequirement(currentSemester);
        		System.out.println("Load requirement by semester successfully");
        		editRequirement();
    		}else {
    			System.out.println("Current semester requirement has been created");
    			editRequirement();
    		}
    	}else {
    		System.out.println("The semester requirement doesn't exist, add course or create new requirement");
    		createRequirementsInterface();
    	}
    }
    /**
     * 
     * Class director can add/delete courser from current requirement
     * 
     */
    public void addCoursetoRequirement() {
    	
    	String title = "*****************************************\nCurrent teaching requirement\n";
    		System.out.println("DB_course");
    		db.showAllcourse();
    		System.out.println(title + currentRequirement.toString());
    		
         	Scanner sc = new Scanner(System.in);
        	System.out.println("Enter the courseid: ");
        	String id = sc.nextLine();
        	currentRequirement.add(db.getAllCourse().searchCoursebyId(Integer.parseInt(id)));
        	
        	System.out.println(title + currentRequirement.toString());
    }
    public void deleteCoursefromRequirement() {
    		String title = "*****************************************\nCurrent teaching requirement\n";
    		System.out.println(title + currentRequirement.toString());
    		
         	Scanner sc = new Scanner(System.in);
        	System.out.println("Enter the courseid: ");
        	String id = sc.nextLine();
        	currentRequirement.remove(db.getAllCourse().searchCoursebyId(Integer.parseInt(id)));
        	
        	System.out.println(title + currentRequirement.toString());
    }

   
    /**
     * Administrator management
     */
    
    public void createNewEmptyArrangement() {
    	System.out.println("Enter current semester:");
    	currentSemester = checkSemester();
		
		GroupOfCourse gc = db.getAllTeachingRequirements().getTeachingRequirement(currentSemester);
		if (gc != null && db.getAllTeachingArrangements().getTeachingArrangement(currentSemester) == null) {
			currentArrangement = new TeachingArrangement(gc);
			System.out.println("Success");
			AdministratorArrange();
		} else if(gc == null){
			System.out.println(currentSemester + " Teaching requirement hasn't been finished");
		} else if(db.getAllTeachingArrangements().getTeachingArrangement(currentSemester) != null) {
			System.out.println(currentSemester + " teaching arrangement has been created");
    		AdministratorArrange();
		}
    }

    /**
     * Invoking this method will inform user(Admin) to enter the past semester(year&season) 
     * So that it will automatically add teachers who are from the selected semester arrangement
     * to the current teaching requirement. After that, it will jump to Arrange menu for Admin to
     * modify the arrangement
     * 
     * If class director haven't created the requirement or the selected arrangement doesn't exist,
     * It will stay in the AdminMainMenu
     * 
     */
    public void loadHistoryArrangement() {
    	System.out.println("Enter past semester:");
    	String temp = checkSemester();
    	System.out.println("Enter current semester:");
    	currentSemester = checkSemester();
		currentRequirement = db.getAllTeachingRequirements().getTeachingRequirement(currentSemester);
		
    	if(currentRequirement != null && db.getAllTeachingArrangements().getTeachingArrangement(temp) != null &&
    			db.getAllTeachingArrangements().getTeachingArrangement(currentSemester) == null){
    		TeachingArrangement ta = Builder.autoArrangeTeacherBySemester(db, currentRequirement, temp);
    		db.getAllTeachingArrangements().addTeachingArrangement(currentSemester, ta);
    		currentArrangement = db.getAllTeachingArrangements().getTeachingArrangement(currentSemester);
    		AdministratorArrange();
    	}else if(currentRequirement == null){
    		System.out.println(currentSemester + " teaching requirement hasn't been finished");
    		createArrangementInterface();
    	}else if(db.getAllTeachingArrangements().getTeachingArrangement(currentSemester) == null) {
    		System.out.println(temp + " teaching arrangement doesn't exist");
    		createArrangementInterface();
    	}else if(db.getAllTeachingArrangements().getTeachingArrangement(currentSemester) != null) {
    		System.out.println(currentSemester + " teaching arrangement has been created");
    		AdministratorArrange();
    	}
    }
    
    /**
     * 
     * Admin can add/delete teacher from current arrangement
     * 
     */
    public void addTeachertoArrangement() {
		String title = "*****************************************\nTeaching arrangement " + currentSemester + "\n";
		currentArrangement = db.getAllTeachingArrangements().getTeachingArrangement(currentSemester);
		System.out.println(title + " " + currentArrangement);
		db.showAllteacher();
		Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the course name: ");
		String c = sc.nextLine();
		Course cc = db.getAllCourse().searchCoursebyName(c);
		
		System.out.println("Enter the teacher's ID(separated by one space)");
		String[] teachers = sc.nextLine().split(" ");
		for(String t: teachers) {
			Teacher teacher = db.getAllTeacher().searchTeacherbyId(Integer.parseInt(t));
			currentArrangement.addTeacher(cc, teacher);
		}
		System.out.println(currentArrangement.toString());
    }
    
    public void deleteTeacherfromArrangement() {
    	String title = "*****************************************\nTeaching arrangement " + currentSemester + "\n";
    	currentArrangement = db.getAllTeachingArrangements().getTeachingArrangement(currentSemester);
		System.out.println(title + " " + currentArrangement);
		Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the course name: ");
		String c = sc.nextLine();
		Course cc = db.getAllCourse().searchCoursebyName(c);
		
		System.out.println("Enter the teacher's ID(separated by one space)");
		String[] teachers = sc.nextLine().split(" ");
		for(String t: teachers) {
			Teacher teacher = db.getAllTeacher().searchTeacherbyId(Integer.parseInt(t));
			currentArrangement.removeTeacher(cc, teacher);
		}
		System.out.println(currentArrangement.toString());
    }
   
}



