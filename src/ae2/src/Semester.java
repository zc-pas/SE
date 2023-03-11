package ae2.src;


import java.io.Serializable;
import java.util.ArrayList;

public class Semester extends Period implements Serializable{
	private String season;
	private String signature;
	private ArrayList<Course> listcourse;
	
	public Semester() {
		
	}
	
	public Semester(int year, String season) {
		super(year);
		this.season = season;
		this.signature = year + " " + season;
	}
	
	public Semester(int year, int startDate, int duration, String season) {
		super(year,startDate,duration);
		this.season = season;
		this.signature = year + " " + season;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public ArrayList<Course> getListcourse() {
		return listcourse;
	}
	public void setListcourse(ArrayList<Course> listcourse) {
		this.listcourse = listcourse;
	}
	public void addCourse(Course c) {
		this.listcourse.add(c);
	}
	
    public String toString(){
        return signature;
    }
}
