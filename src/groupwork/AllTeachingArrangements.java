package groupwork;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * AllTeachingArrangements class is used to store and management
 * all TeachingArrangements of every semester.
 * 
 * @author tianshuo
 *
 */
public class AllTeachingArrangements implements Serializable{
	Map<Semester,TeachingArrangement> allTeachingArrangements;
	
	public AllTeachingArrangements() {
		allTeachingArrangements = new HashMap<Semester,TeachingArrangement>();
	}
	
	/**
	 * return the TeachingArrangement in semester s.
	 * 
	 * @param s 
	 * @return
	 */
	public TeachingArrangement getTeachingArrangement(Semester s) {
		return allTeachingArrangements.get(s);
	}
	
	/**
	 * 
	 * add TeachingArrangement ta in Semester s on AllTeachingArrangements
	 * database.
	 * 
	 * @param s
	 * @param ta TeachingArrangement which include some arrangements
	 * 
	 */
	public void addTeachingArrangement(Semester s, TeachingArrangement ta) {
		allTeachingArrangements.put(s, ta);
	}
	
	/**
	 * 
	 * search TeachingArrangement in AllTeachingArrangements database 
	 * by signature. return the TeachingArrangementif there is a 
	 * TeachingArrangement in that semester; Otherwise, return null.
	 * 
	 * @param signature e.g. "2021 Spring"
	 * @return
	 */
	public TeachingArrangement searchTeachingArrangement(String signature) {
		Set<Semester> keyset = allTeachingArrangements.keySet();
		for(Semester s : keyset) {
			if(s.getSignature().equals(signature)) {
				TeachingArrangement ta = allTeachingArrangements.get(s);
				return ta;
			}
		}return null;
	}
	
	/**
	 * 
	 * return the String format of AllTeachingArrangements
	 * 
	 */
	public String toString() {
		String ans = "";
		for (Semester s : allTeachingArrangements.keySet()) {
			ans += s.toString() + "\n" + allTeachingArrangements.get(s).toString();
		}
		return ans;
	}
}
