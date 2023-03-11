package ae2.src;


import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Menu {

	Database db;
	GroupOfCourse currentRequirement; 
	Semester currentSemester;
	TeachingArrangement currentArrangement;
    // Login page 
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
    
	public void basic() {
		while(true) {
			try {
				System.out.println("---------- Course&Teacher ----------");
				System.out.println("1 Show all courses\n2 Show all teachers\n3 Search teacher(Name)\n"
	    				+ "4 Search course(Name)\n5 Search teacher(Subject)\n0 Exit\nEnter your choice: ");
	    		// return previous page
				// TODO
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
    				System.out.println("Error, Please enter again. ");
    			}
        }
    }
    
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
	    				editRequirement();
	    				break;
	    			case "3":
	    				loadAllcourseRequirement();
	    				editRequirement();
	    				break;
	    			case "4":
	    				loadPastSemesterRequirement();
	    				editRequirement();
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
	    				db.getAllTeachingRequirements().addTeachingRequirement(currentSemester,currentRequirement);
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
    
    public void AdministratorArrange() {
    	while(true) {
        	try {
	    		System.out.println("---------- Arrange ----------");
	    		System.out.println("1 Check all history arrangements\n2 Add teacher\n3 Delete teacher\n0 Exit");
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
	    				System.out.println("Save successfully");
	    				IODatabase.write(db);;
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
    // Basic function(Display&Search)
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
    
    // Class director management
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
    public void createNewEmptyTeachingRequirement(){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the year:");
		String year = sc.nextLine();
		System.out.println("Enter the season: ");
		String season = sc.nextLine();
		String signature = year + " " + season;
		Semester s = new Semester(Integer.parseInt(year),season);
		currentSemester = s;
		
		if(!db.getAllTeachingRequirements().searchSemester(currentSemester)) {
			db.getAllTeachingRequirements().addTeachingRequirement(s, new GroupOfCourse());
			currentRequirement = db.getAllTeachingRequirements().getTeachingRequirement(currentSemester);
		}else {
			System.out.println(signature + " teaching requirement has been created");
			createRequirementsInterface();
		}
		
    }
    public void loadAllcourseRequirement() {
    	currentRequirement = Builder.loadRequirementByAllCourse(db);
    	// TODO
    }
    public void loadPastSemesterRequirement() {
    	// TODO
    }
    public void addCoursetoRequirement() {
    	if (currentSemester != null) {
    		String title = "*****************************************\nCurrent teaching requirement\n";
    		System.out.println("DB_course");
    		db.showAllcourse();
    		System.out.println(title + currentRequirement.toString());
    		
         	Scanner sc = new Scanner(System.in);
        	System.out.println("Enter the courseid: ");
        	String id = sc.nextLine();
        	currentRequirement.add(db.getAllCourse().searchCoursebyId(Integer.parseInt(id)));
        	
        	System.out.println(title + currentRequirement.toString());
    	} else {
    		System.out.println("Create requirement first");
    		createNewEmptyTeachingRequirement();
    	}
    }
    public void deleteCoursefromRequirement() {
    	if (currentSemester != null) {
    		String title = "*****************************************\nCurrent teaching requirement\n";
    		System.out.println(title + currentRequirement.toString());
    		
         	Scanner sc = new Scanner(System.in);
        	System.out.println("Enter the courseid: ");
        	String id = sc.nextLine();
        	currentRequirement.remove(db.getAllCourse().searchCoursebyId(Integer.parseInt(id)));
        	
        	System.out.println(title + currentRequirement.toString());
    	} else {
    		System.out.println("Create requirement first");
    		createNewEmptyTeachingRequirement();
    	}
    }

    // Administrator management
    public void createNewEmptyArrangement() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the year:");
		String year = sc.nextLine();
		System.out.println("Enter the season: ");
		String season = sc.nextLine();
		String signature = year + " " + season;
		
		GroupOfCourse gc = db.getAllTeachingRequirements().searchTeachingRequirement(signature);
		if (gc != null) {
			currentArrangement = new TeachingArrangement(gc);
			System.out.println("Success");
			AdministratorArrange();
		} else {
			System.out.println(signature + "teaching requirement hasn't been finished");
		}
    }
    public void loadHistoryArrangement() {
    	//TODO
    }
    public void addTeachertoArrangement() {
    	if(currentArrangement != null) {
    		String title = "*****************************************\nTeaching arrangement(todo)\n";
    		System.out.println(title + currentArrangement);
    		db.showAllteacher();
    		Scanner sc = new Scanner(System.in);
        	System.out.println("Enter the course name: ");
    		String c = sc.nextLine();
    		Course cc = db.getAllCourse().searchCoursebyName(c);
    		
    		for(int i = 0; i < 2; i++) {
    			System.out.println("Enter the teacher's ID: ");
    			int t = sc.nextInt();
    			Teacher got = db.getAllTeacher().searchTeacherbyId(t);
    			currentArrangement.addTeacher(cc, got);
    		}
    		
    		db.getAllTeachingArrangements().addTeachingArrangement(currentSemester, currentArrangement);
    		System.out.println(currentArrangement.toString());
    	}else {
    		createNewEmptyArrangement();
    	}
    }
    public void deleteTeacherfromArrangement() {
    	
    }
   
}



