package ae2.src;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AllTeachingArrangements implements Serializable{
	Map<Semester,TeachingArrangement> allTeachingArrangements;
	
	public AllTeachingArrangements() {
		allTeachingArrangements = new HashMap<Semester,TeachingArrangement>();
		
	}
	
	public TeachingArrangement getTeachingArrangement(Semester s) {
		return allTeachingArrangements.get(s);
	}
	
	public void addTeachingArrangement(Semester s, TeachingArrangement ta) {
		allTeachingArrangements.put(s, ta);
	}
	
	public String toString() {
		String ans = "";
		for (Semester s : allTeachingArrangements.keySet()) {
			ans += s.toString() + "\n" + allTeachingArrangements.get(s).toString();
		}
		return ans;
	}
}
