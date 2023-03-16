package groupwork;


/**
 * This class represents a period of time.
 * It contains information about the year, start date, and duration of the period.
 * For recording semester times
 *
 * @author Jiasong Liu 2750568L
 */
public class Period {
    private int year; // 2023
    private int startDate; // 0901
    private int duration; // 10 weeks

    public Period() {
        this.year = 2023;
        this.startDate = 901;
        this.duration = 20;
    }

//	@SuppressWarnings("null")
//	public Period(int year) {
//		this.year = year;
//		this.startDate = (Integer) null;
//		this.duration = (Integer) null;
//	}

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
