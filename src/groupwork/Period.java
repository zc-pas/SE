package groupwork;

/**
 * This class represents a period of time.
 * It contains information about the year, start date, and duration of the period.
 * We keep it for updated version in the future, 
 * like adding more details of the semester, arranging training timetable for teachers
 *
 */

public class Period {
	private int year; 
	private int startDate; 
	private int duration; 
	
	public Period() {
		this.year = 2023;
		this.startDate = 901;
		this.duration = 20;
	}
	
	public Period(int year) {
		this.year = year;
		this.startDate = 901;
		this.duration = 20;
	}
	
	public Period(int year, int startDate, int duration) {
		this.year = year;
		this.startDate = startDate;
		this.duration = duration;
	}
}
