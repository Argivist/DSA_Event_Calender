import java.util.Hashtable;
import java.time.LocalTime;
import java.util.PriorityQueue;

public class Day {
    private int dayNum;
    private Hashtable<LocalTime, Event> events = new Hashtable<>();
    private PriorityQueue<LocalTime> startTimes = new PriorityQueue<>();


    /**
     * Adds an event to the day.
     * @param e the event to be added
     * @return true if the event was added successfully, false otherwise
     */
    public boolean addEvent(Event e) {
        LocalTime newEventStartTime = e.getStartTime();
        LocalTime newEventEndTime = e.getEndTime();

        if (getEvents(newEventStartTime) != null) {return false;}

        for (LocalTime existingEventStartTime : startTimes) {
            Event existingEvent = events.get(existingEventStartTime);
            LocalTime existingEventEndTime = existingEvent.getEndTime();

            if ((newEventStartTime.isBefore(existingEventEndTime) || newEventStartTime.equals(existingEventEndTime))
                    && (newEventEndTime.isAfter(existingEventStartTime) || newEventEndTime.equals(existingEventStartTime))) {
                return false;
            }
        }

        startTimes.add(newEventStartTime);
        events.put(newEventStartTime, e);
        return true;
    }

    /**
     * Gets the event that starts at the specified time.
     * @param time the time the event starts
     * @return the event that starts at the specified time
     */
    public Event eventReminder(){
        return events.get(startTimes.peek());
    }

    /**
     * Removes an event from the day.
     * @param time the time the event starts
     */
    public void removeEvent(LocalTime time) {
        if (events.containsKey(time)) {
            events.remove(time);
            startTimes.remove(time);
        } else {
            System.out.println("No event found at the specified start time.");
        }
    }

    /**
     * Gets the event that starts at the specified time.
     * @param t the time the event starts
     * @return the event that starts at the specified time
     */
    public Event getEvents(LocalTime t) {
        return events.get(t);
    }

    /**
     * Gets all the events in the day.
     * @return all the events in the day
     */
    public Event[] getDayEvents() {
        Object[] pq = startTimes.toArray();
        Event[] e = new Event[pq.length];
        for (int i = 0; i < pq.length; i++) {
            e[i] = getEvents((LocalTime)pq[i]);
        }
        return e;
    }
    
    /**
     * Prints all the events in the day.
     */
    public void printDayEvents(){
        Event[] e=getDayEvents();

        if (e.length==0){
            System.out.println("No events today");
            return;
        }
        for(Event event: e){
            System.out.println(event);
        }

    }

    /**
     * Gets the day number.
     * @return the day number
     */
    public int getDate(){
        return dayNum;
    }

    /**
     * Creates a new day.
     * @param dayNum_ the day number
     */
    public Day(int dayNum_){
        this.dayNum=dayNum_;
    }
}