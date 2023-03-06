import java.util.ArrayList;

public class Teacher {
    private String name;    
    private ArrayList<String> courseCapable;    
    private int teacherId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher(int id, String name, ArrayList<String> courseCapable){
        this.teacherId=id;
        this.name=name;
        this.courseCapable=courseCapable;
    }

    public ArrayList<String> getCourseCapable() {
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
        String result=teacherId+" "+name+" ";
        for(String s:courseCapable){
            result+=s;
            result+=" ";
        }
        return result;
    }
    
}
