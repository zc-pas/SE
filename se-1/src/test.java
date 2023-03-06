import java.io.IOException;

public class test {
    public static void main(String[] src) throws IOException{
        FileSystem.readfromFile("src/db.txt");
        Database.showAllcourse();         
        Database.showAllteacher();
        Database.addTeachertoCourse(Database.searchCoursebyName("Course2"), Database.searchTeacherbyName("teacher2"));
        FileSystem.saveasFile("src/db.txt");
    }
}
