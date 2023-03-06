import java.util.ArrayList;

public class Database {
    public static ArrayList<Course> courseList=new ArrayList<Course>();
    public static ArrayList<Teacher> teacherList= new ArrayList<Teacher>();


    //show all course information
    public static void showAllcourse(){
        for(Course c:courseList){
            System.out.println(c);
        }
    }

    //show all teacher information
    public static void showAllteacher(){
        for(Teacher t:teacherList){
            System.out.println(t);
        }
    }

    //search a teacher by name
    public static Teacher searchTeacherbyName(String name){
        for(Teacher t:teacherList){
            if(t.getName().equals(name)){
                return t;
            }
        }
        return null;
    }

    //search a course by name
    public static Course searchCoursebyName(String name){
        for(Course c:courseList){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public static ArrayList<Teacher> searchTeacherbyCapable(String type){
        ArrayList<Teacher> result =new ArrayList<Teacher>();
        for(Teacher t:teacherList){
            if(t.getCourseCapable().contains(type)){
                result.add(t);
            }
        }
        return result;
    }

    public static void addTeachertoCourse(Course c, Teacher t){
        for(String s:t.getCourseCapable()){
            if(s.equals(c.getCourseType())){
                c.setTeacher(t.getName());
                System.out.println("add success");
                return;
            }
        }
        System.out.println("illegal add");
        return;
    }
}
