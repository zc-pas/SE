package groupwork;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * AllTeachingRequirements class is used to store and management
 * all TeachingRequirements of every semester.
 * 
 * @author tianshuo
 *
 */
public class AllTeachingRequirements implements Serializable{
	 // A mapping table indicating the teaching requirements for different semesters
	Map<Semester,GroupOfCourse> allTeachingRequirements;
	
	public AllTeachingRequirements() {
		allTeachingRequirements = new HashMap<Semester,GroupOfCourse>();
		
	}
	
	/**
	 * 
	 * return the TeachingRequirement in semester s.
	 * 
	 * @param s
	 * @return
	 */
	public GroupOfCourse getTeachingRequirement(Semester s) {
		return allTeachingRequirements.get(s);
	}
	
	/**
	 * 
	 * add TeachingRequirement gc in Semester s on AllTeachingRequirements
	 * database.
	 * 
	 * @param s
	 * @param gc a GroupOfCourse object which include some courses
	 */
	public void addTeachingRequirement(Semester s, GroupOfCourse gc) {
		allTeachingRequirements.put(s, gc);
	}
	
	
	
	/**
	 * Same function as the former
	 * But so far, actually we implement this method to add arrangement
	 * We keep the former one for future version  
	 * @param signature
	 * @param gc
	 */
	public void addTeachingRequirement(String signature, GroupOfCourse gc) {
		String[] str = signature.split(" ");
		int year = Integer.parseInt(str[0]);
		String season = str[1];
		Semester s = new Semester(year, season);
		allTeachingRequirements.put(s, gc);
	}
	
	/**
	 * 
	 * get TeachingRequirement in AllTeachingRequirements database 
	 * by signature. return a GroupOfCourse if there is a 
	 * teaching Requirement in that semester; Otherwise, return null.
	 * 
	 * @param signature e.g. "2021 Spring"
	 * @return
	 */
	public GroupOfCourse getTeachingRequirement(String signature) {
		Set<Semester> keyset = allTeachingRequirements.keySet();
		for(Semester s : keyset) {
			if(s.getSignature().equals(signature)) {
				GroupOfCourse goc = allTeachingRequirements.get(s);
				return goc;
			}
		}return null;
	}
	
	/**
	 * 
	 * search TeachingRequirement in AllTeachingRequirements database 
	 * by Semester s. return true if there is a teaching Requirement 
	 * in that semester; Otherwise, return false.
	 * 
	 * @param s
	 * @return
	 */
	public boolean searchSemester(Semester s) {
		if(allTeachingRequirements.containsKey(s)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 * return the String format of AllTeachingRequirements
	 * 
	 */
	public String toString() {
		String ans = "";
		for (Semester s : allTeachingRequirements.keySet()) {
			ans += s.toString() + "\n" + allTeachingRequirements.get(s).toString();
		}
		return ans;
	}
	
}
