package groupwork;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Teacher implements Serializable{
    private String name;    
    private List<String> courseCapable;
    static private int nextID = 0;
    private int teacherId;

    public Teacher(String name){
        this.teacherId=nextID;
        Teacher.nextID++;
        this.name=name;
        this.courseCapable= new ArrayList<String>();
    }
    
    public Teacher(int ID, String name, ArrayList<String> courseCapable){
        this.teacherId=ID;
        this.name=name;
        this.courseCapable=courseCapable;
    }
    
    public Teacher(String name, String capable){
        this.teacherId=nextID;
        Teacher.nextID++;
        this.name=name;
        this.courseCapable= new ArrayList<String>();
        this.courseCapable.add(capable);
    }
    
    public Teacher(String name, ArrayList<String> courseCapable){
        this.teacherId=nextID;
        Teacher.nextID++;
        this.name=name;
        this.courseCapable=courseCapable;
    }
    
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }



    
    public List<String> getCourseCapable() {
        return courseCapable;
    }
    public void setCourseCapable(ArrayList<String> courseCapable) {
        this.courseCapable = courseCapable;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
    	String result = String.format("TeacherID: %-3d Name: %-15s Type: ", teacherId, name);
        for(String s:courseCapable){
            result+=String.format("%-10s", s);
        }
        return result;
    }
    

    
}
