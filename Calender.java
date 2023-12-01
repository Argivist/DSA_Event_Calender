import java.time.LocalTime;


/**
 * This class represents a calendar for a specific year.
 */
public class Calender {
    int year;
    public Month[] Year = new Month[12];
    public int[] num_days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };


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
     * This method gets the month of the calendar.
     * 
     * @param month_ The month to be returned.
     * @return The month of the calendar.
     */
    public boolean addEvent(Event e) {
        String[] s = e.getDate().split("-");
        if(Year[Integer.parseInt(s[0])-1].getDay(Integer.parseInt(s[1]))==null){
            return false;
        }
        Boolean b = Year[Integer.parseInt(s[0])-1].getDay(Integer.parseInt(s[1])).addEvent(e);
        return b;
    }

    /**
     * This method gets the event that starts at the specified time.
     * 
     * @param date The date of the event.
     * @param t    The time of the event.
     * @return The event that starts at the specified time.
     */
    public Event getEvents(String date, LocalTime t) {
        String[] s = date.split("-");
        if(Year[Integer.parseInt(s[0])-1].getDay(Integer.parseInt(s[1]))==null){
            return null;
        }
        return Year[Integer.parseInt(s[0])-1].getDay(Integer.parseInt(s[1])).getEvents(t);
    }

    /**
     * This method removes an event from the calendar.
     * 
     * @param date The date of the event to be removed.
     * @param t    The time of the event to be removed.
     * @return True if the event was removed, false otherwise.
     */
    public boolean removeEvent(String date, LocalTime t) {
        String[] s = date.split("-");
        if (getEvents(date, t) == null) {
            return false;
        } else {
            Year[Integer.parseInt(s[0])-1].getDay(Integer.parseInt(s[1])).removeEvent(t);
            return true;
        }
    }

    /**
     * This method gets all the events in a specific day.
     * 
     * @param date The date to get the events from.
     * @return The events in the specified day.
     */
    public Event[] getAllEvent(String date) {
        String[] s = date.split("-");
        if(Year[Integer.parseInt(s[0])-1].getDay(Integer.parseInt(s[1]))==null){
            return null;
        }
        return Year[Integer.parseInt(s[0])-1].getDay(Integer.parseInt(s[1])).getDayEvents();
    }

    /**
     * This method gets all the events in a specific month.
     * 
     * @param month_ The month to get the events from.
     */
    public void getAllEvent(int month_) {
        System.out.println(Year[month_-1].getName());
        
        for (Day i : Year[month_-1].getDays()) {
            if(i==null){
            System.out.println("no event");
            break;
        }
            System.out.println("Day"+(i.getDate()+1));
            i.printDayEvents();
        }
    }
    
    /**
     * This method gets all the events in the calendar.
     */
    public void getAllEvent(){
        for(int i=0;i<12;i++){
            getAllEvent(i+1);
        }
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
