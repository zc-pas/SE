package groupwork;


import java.io.IOException;

public class test {
    public static void main(String[] src) throws IOException, ClassNotFoundException{
    	Database db=Database.getInstance();
    	
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
    	
    	db.showAllTeachingRequirements();
    	db.getAllTeachingRequirements().addTeachingRequirement(new Semester(2020,0130, 10, "Spring"), gc);
    	db.showAllTeachingRequirements();
    	TeachingArrangement ta = new TeachingArrangement(gc);
    	ta.addTeacher(c1, t2);
    	ta.addTeacher(c1, t1);
    	ta.addTeacher(c2, t3);
    	ta.addTeacher(c2, t4);
    	ta.addTeacher(c2, t1);
    	db.getAllTeachingArrangements().addTeachingArrangement(new Semester(2018,901, 20, "Spring"), ta);
    	db.showAllTeachingArrangements();
//    	
//    	
//    	IODatabase.write(db);
    	
    	Menu m = new Menu();
    	m.login();
    	
    	Database newdb = IODatabase.read();
    	System.out.println("read database successfully");
//    	
//    	Course c3 = new Course("Pysical","Type99");
//    	newdb.getAllCourse().add(c3);
//    	Course c4 = new Course("Art","Type66");
//    	newdb.getAllCourse().add(c4);
//  	
//    	Course c5 = new Course("Progromming","hard");
//    	newdb.getAllCourse().add(c5);
//    	Course c6 = new Course("Cooking","easy");
//    	newdb.getAllCourse().add(c6);
    	newdb.showAllcourse();
    	System.out.println("******************************");
    	newdb.showAllteacher();
    	
    	System.out.println("******************************");
    	newdb.showAllTeachingRequirements();
    	System.out.println("******************************");
    	newdb.showAllTeachingArrangements();
 	
    	System.out.println("******************************");
//    	Menu m = new Menu();
    	m.login();
    	
    	
    }
}
