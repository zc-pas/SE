package groupwork;


import java.io.Serializable;

/**
 * The AllTeacher class is a class that extends the GroupOfTeacher class and
 * implements the Serializable interface.
 * AllTeacher class is used to store and managements all teachers
 *
 * @author Tianshuo Zang 2746520Z
 */
public class AllTeacher extends GroupOfTeacher implements Serializable {

    // Number of teachers
    private int count;

    // Constructor, the number of teachers is equal to the size of the group of teachers acquired
    public AllTeacher() {
        super();
        count = groupOfTeacher.size();
    }

    // Add a teacher in the teacher databse
    public void add(Teacher t) {
        count = this.groupOfTeacher.size();
        this.groupOfTeacher.add(t);
        t.setTeacherId(count);
        count = this.groupOfTeacher.size();
    }

    /**
     * remove a teacher from teacher database. Only a small
     * number of privileged people can use it. Both administrator
     * and class director cannot use it.
     */
    public void remove(Teacher c) {
        System.out.print("you cannot remove from the Teacher database");
    }
}
