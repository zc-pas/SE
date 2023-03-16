package groupwork;


import java.io.IOException;

public class App {
    public static void main(String[] src) throws IOException, ClassNotFoundException{
    	
    	
		/*
		 * We provide some test data for you 
		 * If you want to use it, use importTestData() below
		 * 
		 */
    	
//    	importTestData();
    	
    	Database db = Database.getInstance();
		db = IODatabase.read();
    	System.out.println("Read database successfully");
    	Menu m = new Menu();
    	m.login();
    }
    
    
    public static void importTestData() throws IOException {
    	
    	
		Database db = Database.getInstance();
    	
    	db.getAllCourse().add("Chinese", "Type9");
    	db.getAllCourse().add("Computer Science", "Type10");
    	db.getAllCourse().add("Math", "Type1");
    	db.getAllCourse().add("English", "Type5");
    	
    	GroupOfCourse gc = new GroupOfCourse();
    	Course c1 = new Course("Biology","Type7");
    	Course c2 = new Course("Game","Type5");
    	gc.add(c1);
    	gc.add(c2);
    	
    	GroupOfTeacher gt = new GroupOfTeacher();
    	Teacher t1 = new Teacher("MingQi", "perfect");
    	Teacher t2 = new Teacher("Marry","soso");
    	Teacher t3 = new Teacher("Collins","good");
    	Teacher t4 = new Teacher("Maguire","bad");
      	Teacher t5 = new Teacher("Lily", "not bad");
    	db.getAllTeacher().add(t5);
    	
    	Teacher t6 = new Teacher("Ann", "not good");
    	db.getAllTeacher().add(t6);
    	db.getAllTeacher().add(t1);
    	db.getAllTeacher().add(t2);
    	db.getAllTeacher().add(t3);
    	db.getAllTeacher().add(t4);
    	
    	gt.add(t1);
    	gt.add(t2);
    	gt.add(t3);
    	gt.add(t4);
    	
    	db.getAllTeachingRequirements().addTeachingRequirement(new Semester(2020,0130, 10, "Spring"), gc);
    	TeachingArrangement ta = new TeachingArrangement(gc);
    	ta.addTeacher(c1, t2);
    	ta.addTeacher(c1, t1);
    	ta.addTeacher(c2, t3);
    	ta.addTeacher(c2, t4);
    	ta.addTeacher(c2, t1);
    	db.getAllTeachingArrangements().addTeachingArrangement(new Semester(2018,901, 20, "Spring"), ta);
    	
    	
    	IODatabase.write(db);	
	}
}
