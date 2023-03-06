

public class Course {
    private String courseType;
    private String name;
    private String teacher;    
    private int courseId;
        
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }


    public Course(String courseType, String name, int courseId){
        this.courseType = courseType;
        this.name = name;
        this.courseId = courseId;
    }
    
    public Course(String courseType, String name, int courseId, String teacher) {
        this.courseType = courseType;
        this.name = name;
        this.courseId = courseId;
        this.teacher=teacher;
    }

    public String getCourseType() {
        return courseType;
    }
    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String toString(){
        return courseId+" "+name+" "+courseType+" "+teacher;
    }
    
}
