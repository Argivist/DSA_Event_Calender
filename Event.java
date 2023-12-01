import java.time.LocalTime;

public class Event {
    private int id;
    private String title; // Event Title
    private String description; // The description of the event
    private LocalTime startTime; // The time an event starts
    private LocalTime endTime; // The time an event ends
    private String date; // The date the event occurs


    /**
     * Gets the date of the event
     * @return the date of the event
     */
    public String getDate() {return this.date;}

    /**
     * Gets the time of the event
     * @return the start time of the event
     */
    public LocalTime getStartTime() {return startTime;}

    /**
     * Gets the end time of the event
     * @return the end time of the event
     */
    public LocalTime getEndTime() {return endTime;}

    /**
     * Gets the event title
     * @return the event title
     */
    public String getTitle() {return title;}

    /**
     * Gets the event description
     * @return the event description
     */
    public String getDescription() {return description;}

    /**
     * Gets the event id
     * @return the event id
     */
    public int getID() {return id;}

    /**
     * Gets the event details
     * @return the event details
     */
    public String toString() {return "Event: " + title + "\nStart Time: " + startTime + "\nDate: " + date + "\nDescription: " + description;}


    /**
     * Sets the date of the event.
     * @param date_ the new date of the event
     */
    public void setDate(String date_) {this.date = date_;}

    /**
     * Sets the time of the event.
     * @param time_ the new time of the event
     */
    public void setStartTime(LocalTime time_) {this.startTime = time_;}

    /**
     * Sets the end time of the event.
     * @param time_ the new end time of the event
     */
    public void setEndTime(LocalTime time_) {this.endTime = time_;}

    /**
     * Sets the event title.
     * @param title_ the new event title
     */
    public void setTitle(String title_) {this.title = title_;}

    /**
     * Sets the description of the event.
     * @param desc_ the new description of the event
     */
    public void setDescription(String desc_) {this.description = desc_;}

    /**
     * Event Constructor
     * 
     * @param date_        the date of the event
     * @param startTime_        the time of the event
     * @param title_       the title of the event
     * @param description_ the description of the event
     */
    public Event(int id_,String date_, LocalTime startTime_, LocalTime endTime_, String title_, String description_) {
        this.id=id_;
        setDate(date_);
        setTitle(title_);
        setStartTime(startTime_);
        setEndTime(endTime_);
        setDescription(description_);
    }
}
