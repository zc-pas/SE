package groupwork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupOfTeacher implements Serializable{
	List<Teacher> groupOfTeacher;
	
	public GroupOfTeacher() {
		groupOfTeacher = new ArrayList<Teacher>();
		
	}
	
	public List<Teacher> get() {
		return this.groupOfTeacher;
	}
	
	public void remove(Teacher t) {
		if (groupOfTeacher.contains(t)) {
			groupOfTeacher.remove(t);
		}
	}
	
	public void remove(int ID) {
		for(Teacher c: groupOfTeacher) {
			if(ID == c.getTeacherId()) {
				groupOfTeacher.remove(c);
			}
		}
		
	}
	
	public void add(Teacher t) {
		groupOfTeacher.add(t);
	}
	
	public void add(String name, String type) {
		groupOfTeacher.add(new Teacher(name,type));
	}
	
	public boolean contains(Teacher t) {
		return groupOfTeacher.contains(t);
	}
	
	public Teacher get(int id) {
		for (Teacher t : groupOfTeacher) {
			if (t.getTeacherId() == id) {
				return t;
			}
		}
		return null;
	}
	
	//search a teacher by name
    public Teacher searchTeacherbyName(String name){
        for(Teacher t : groupOfTeacher){
            if(t.getName().equals(name)){
                return t;
            }
        }
        return null;
    }
    
    public Teacher searchTeacherbyId(int id){
        for(Teacher t : groupOfTeacher){
            if(t.getTeacherId() == id){
                return t;
            }
        }
        return null;
    }
    
    
    //search teacher by type
    public ArrayList<Teacher> searchTeacherbyCapable(String type){
        ArrayList<Teacher> result =new ArrayList<Teacher>();
        for(Teacher t : groupOfTeacher){
            if(t.getCourseCapable().contains(type)){
                result.add(t);
            }
        }
        return result;
    }
	
	public String toString() {
		String s = "";
		for (Teacher t : groupOfTeacher) {
			s += t.toString() + "\n";
		}
		return s;
	}
	
	public String toString(String prefix) {
		String s = "";
		for (Teacher t : groupOfTeacher) {
			s += prefix + t.toString() + "\n";
		}
		return s;
		
	}
	
	
}
