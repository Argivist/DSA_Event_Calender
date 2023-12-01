import java.time.LocalTime;


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

    // Adding event to year calender
    public boolean addEvent(Event e) {
        String[] s = e.getDate().split("-");
        Boolean b = Year[Integer.parseInt(s[0])-1].getDay(Integer.parseInt(s[1])).addEvent(e);
        return b;
    }

    // getting events
    public Event getEvent(String date, LocalTime t) {
        String[] s = date.split("-");
        return Year[Integer.parseInt(s[0])].getDay(Integer.parseInt(s[1])).getEvent(t);
    }

    // removing event
    public boolean removeEvent(String date, LocalTime t) {
        String[] s = date.split("-");
        if (getEvent(date, t) == null) {
            return false;
        } else {
            Year[Integer.parseInt(s[0])].getDay(Integer.parseInt(s[1])).removeEvent(t);
            return true;
        }
    }

    // getting all events in a day
    public Event[] getAllEvent(String date) {
        String[] s = date.split("-");
        return Year[Integer.parseInt(s[0])].getDay(Integer.parseInt(s[1])).getDayEvents();
    }

    // get all events in month
    public void getAllEvent(int month) {
        System.out.println(Year[month].getName());
        for (Day i : Year[month].getDays()) {
            System.out.println("Day"+i.getDate());
            i.printDayEvents();
        }
    }
    //gets all event
    public void getAllEvent(){
        for(int i=0;i<12;i++){
            System.out.println(months[i]);
            getAllEvent(i);
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



    
    public static void main(String[] args) {
        // Create a new calendar for the year 2023
        Calender calendar = new Calender(2023);

        // Create some events and add them to the calendar
        Event event1 = new Event(2,"12-03", LocalTime.of(12,0), "Walking", "move to a place");
        Event event2 = new Event(2,"12-03", LocalTime.of(12,0), "Walking", "move to a place");
        Event event3 = new Event(2,"12-03", LocalTime.of(12,0), "Walking", "move to a place");

        calendar.addEvent(event1);
        calendar.addEvent(event2);
        calendar.addEvent(event3);

        // Retrieve events and print them
        Event retrievedEvent = calendar.getEvent("2023-05-15", LocalTime.of(10, 30));
        if (retrievedEvent != null) {
            System.out.println("Retrieved Event: " + retrievedEvent.getDescription());
        }

        // Get all events for a specific day and print them
        Event[] allEvents = calendar.getAllEvent("2023-06-20");
        if (allEvents != null) {
            System.out.println("All Events on 2023-06-20:");
            for (Event e : allEvents) {
                System.out.println(e.getDescription());
            }
        }

        // Print all events in each month
        calendar.getAllEvent();
    }
}
