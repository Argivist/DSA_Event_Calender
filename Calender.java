/**
 * This class represents a calendar for a specific year.
 */
public class Calender {
    int year;
    Month[] Year = new Month[12];
    int[] num_days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };

    //// Getters and Setters////
    /// Setters

    /**
     * This method sets the year for the calendar.
     * 
     * @param y The year to be set.
     */
    public void setYear(int y) {
        this.year = y;
    }

    /**
     * This method adds months to the calendar.
     */
    public void addMonths() {
        for (int i = 0; i < 12; i++) {
            Year[i] = new Month(months[i], num_days[i]);
        }
    }
    //// Getters

    /**
     * This method gets the year of the calendar.
     * 
     * @return The year of the calendar.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * This is the constructor for the Calender class.
     * 
     * @param year_ The year to be set for the calendar.
     */
    public Calender(int year_) {
        setYear(year_);
        addMonths();
    }
}
