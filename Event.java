import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class Event {
    private String title; // Event Title
    private String description; // Event description
    private LocalTime time; // Event time
    private Date date; // Event date

    ////// Getters and Setters///////
    //// Getters
    /**
     * Gets the date of the event
     * 
     * @return the date of the event
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Gets the time of the event
     * 
     * @return the time of the event
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Gets the event title
     * 
     * @return the event title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the event description
     * 
     * @return the event description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the event details
     * 
     * @return the event details
     */
    public String toString() {
        return "Event: " + title + "\nTime: " + time + "\nDate: " + date + "\nDescription: " + description;
    }

    //// Setters
    /**
     * Sets the date of the event.
     * 
     * @param date_ the new date of the event
     */
    public void setDate(Date date_) {
        this.date = date_;
    }

    /**
     * Sets the time of the event.
     * 
     * @param time_ the new time of the event
     */
    public void setTime(LocalTime time_) {
        this.time = time_;
    }

    /**
     * Sets the event title.
     * 
     * @param title_ the new event title
     */
    public void setTitle(String title_) {
        this.title = title_;
    }

    /**
     * Sets the description of the event.
     * 
     * @param desc_ the new description of the event
     */
    public void setDescription(String desc_) {
        this.description = desc_;
    }

    /**
     * Event Constructor
     * 
     * @param date_        the date of the event
     * @param time_        the time of the event
     * @param title_       the title of the event
     * @param description_ the description of the event
     */
    public Event(Date date_, LocalTime time_, String title_, String description_) {
        setDate(date_);
        setTime(time_);
        setDescription(description_);
        setTitle(title_);
    }
}
