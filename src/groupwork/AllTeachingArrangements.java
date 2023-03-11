package groupwork;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * AllTeachingArrangements class is used to store and management
 * all TeachingArrangement of every semester.
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
	
	public void addTeachingArrangement(Semester s, TeachingArrangement ta) {
		allTeachingArrangements.put(s, ta);
	}
	public boolean searchArrangement(Semester s) {
		if(allTeachingArrangements.containsKey(s)) {
			return true;
		}else {
			return false;
		}
	}
	
	public TeachingArrangement searchTeachingArrangement(String signature) {
		Set<Semester> keyset = allTeachingArrangements.keySet();
		for(Semester s : keyset) {
			if(s.getSignature().equals(signature)) {
				TeachingArrangement ta = allTeachingArrangements.get(s);
				return ta;
			}
		}return null;
	}
	
	public String toString() {
		String ans = "";
		for (Semester s : allTeachingArrangements.keySet()) {
			ans += s.toString() + "\n" + allTeachingArrangements.get(s).toString();
		}
		return ans;
	}
}
