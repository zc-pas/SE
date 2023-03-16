package groupwork;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * AllTeachingArrangements class is used to store and
 * management all TeachingArrangements of every semester.
 *
 * @author Tianshuo Zang 2746520Z
 */
public class AllTeachingArrangements implements Serializable {

    // A mapping table indicating the teaching schedule for all semesters
    Map<Semester, TeachingArrangement> allTeachingArrangements;

    // Constructor
    public AllTeachingArrangements() {
        allTeachingArrangements = new HashMap<Semester, TeachingArrangement>();
    }

    /**
     * return the TeachingArrangement in semester s.
     *
     * @param s The semester to be queried.
     * @return The corresponding teaching arrangements.
     */
    public TeachingArrangement getTeachingArrangement(Semester s) {
        return allTeachingArrangements.get(s);
    }

    /**
     * add TeachingArrangement ta in Semester s on AllTeachingArrangements
     * database.
     *
     * @param s  The semester for which the teaching arrangement is to be added.
     * @param ta TeachingArrangement which include some arrangements
     */
    public void addTeachingArrangement(Semester s, TeachingArrangement ta) {
        allTeachingArrangements.put(s, ta);
    }


    public void addTeachingArrangement(String signature, TeachingArrangement ta) {
        String[] str = signature.split(" ");
        int year = Integer.parseInt(str[0]);
        String season = str[1];
        Semester s = new Semester(year, season);
        allTeachingArrangements.put(s, ta);
    }


    public boolean searchArrangement(Semester s) {
        if (allTeachingArrangements.containsKey(s)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * get TeachingArrangement in AllTeachingArrangements database
     * by signature. return the TeachingArrangementif there is a
     * TeachingArrangement in that semester; Otherwise, return null.
     *
     * @param signature e.g. "2021 Spring"
     * @return
     */
    public TeachingArrangement getTeachingArrangement(String signature) {
        Set<Semester> keyset = allTeachingArrangements.keySet();
        for (Semester s : keyset) {
            if (s.getSignature().equals(signature)) {
                TeachingArrangement ta = allTeachingArrangements.get(s);
                return ta;
            }
        }
        return null;
    }

    /**
     * return the String format of AllTeachingArrangements
     */
    public String toString() {
        String ans = "";
        // Traversing the teaching schedule for all semesters
        for (Semester s : allTeachingArrangements.keySet()) {
            // Stitching together the string representation of the semester and the corresponding teaching schedule into one string
            ans += s.toString() + "\n" + allTeachingArrangements.get(s).toString();
        }
        return ans;
    }
}
