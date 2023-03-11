package groupwork;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AllTeachingRequirements implements Serializable{
	Map<Semester,GroupOfCourse> allTeachingRequirements;
	
	public AllTeachingRequirements() {
		allTeachingRequirements = new HashMap<Semester,GroupOfCourse>();
		
	}
	
	public GroupOfCourse getTeachingRequirement(Semester s) {
		return allTeachingRequirements.get(s);
	}
	public GroupOfCourse getTeachingRequirement(String signature) {
		String[] str = signature.split(" ");
		int year = Integer.parseInt(str[0]);
		String season = str[1];
		Semester s = new Semester(year, season);
		return allTeachingRequirements.get(s);
	}
	
	
	public void addTeachingRequirement(Semester s, GroupOfCourse gc) {
		allTeachingRequirements.put(s, gc);
	}
	public void addTeachingRequirement(String signature, GroupOfCourse gc) {
		String[] str = signature.split(" ");
		int year = Integer.parseInt(str[0]);
		String season = str[1];
		Semester s = new Semester(year, season);
		allTeachingRequirements.put(s, gc);
	}
	
	public GroupOfCourse searchTeachingRequirement(String signature) {
		Set<Semester> keyset = allTeachingRequirements.keySet();
		for(Semester s : keyset) {
			if(s.getSignature().equals(signature)) {
				GroupOfCourse goc = allTeachingRequirements.get(s);
				return goc;
			}
		}return null;
	}
	
	public boolean searchSemester(Semester s) {
		if(allTeachingRequirements.containsKey(s)) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String ans = "";
		for (Semester s : allTeachingRequirements.keySet()) {
			ans += s.toString() + "\n" + allTeachingRequirements.get(s).toString();
		}
		return ans;
	}
	
}
