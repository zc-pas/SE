package groupwork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * GroupOfTeacher class, which implements the Serializable interface
 * The class contains a List<Teacher> collection named groupOfTeacher to store teacher objects.
 * The class provides methods for adding, removing and finding teachers, including finding teacher objects based on their name, ID or the type of course they can teach.
 * The class also provides two toString() methods, one without a prefix and one with a prefix, for converting the elements of the collection to strings.
 *
 * @author Chu Zhang 2650227Z
 */
public class GroupOfTeacher implements Serializable {
    List<Teacher> groupOfTeacher;

    // Instantiate groupOfTeacher
    public GroupOfTeacher() {
        groupOfTeacher = new ArrayList<Teacher>();

    }

    public List<Teacher> get() {
        return this.groupOfTeacher;
    }

    // Delete the teacher if the teacher list contains it
    public void remove(Teacher t) {
        if (groupOfTeacher.contains(t)) {
            groupOfTeacher.remove(t);
        }
    }

    // If the teacher list contains the id of the teacher, delete the teacher
    public void remove(int ID) {
        for (Teacher c : groupOfTeacher) {
            if (ID == c.getTeacherId()) {
                groupOfTeacher.remove(c);
            }
        }

    }

    public void add(Teacher t) {
        groupOfTeacher.add(t);
    }

    // Create a new Teacher object and add it to the groupOfTeacher collection
    public void add(String name, String type) {
        groupOfTeacher.add(new Teacher(name, type));
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

    // Search a teacher by name
    public Teacher searchTeacherbyName(String name) {
        for (Teacher t : groupOfTeacher) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    // Search a teacher by id
    public Teacher searchTeacherbyId(int id) {
        for (Teacher t : groupOfTeacher) {
            if (t.getTeacherId() == id) {
                return t;
            }
        }
        return null;
    }


    // Search teacher by type
    public ArrayList<Teacher> searchTeacherbyCapable(String type) {
        ArrayList<Teacher> result = new ArrayList<Teacher>();
        for (Teacher t : groupOfTeacher) {
            if (t.getCourseCapable().contains(type)) {
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
