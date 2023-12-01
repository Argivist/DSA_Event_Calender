import java.util.Hashtable;
import java.time.LocalTime;
import java.util.PriorityQueue;

public class Day {
    private int dayNum;
    private Hashtable<LocalTime, Event> events = new Hashtable<>();
    private PriorityQueue<LocalTime> startTimes = new PriorityQueue<>();


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

    public void removeEvent(LocalTime time) {
        if (events.containsKey(time)) {
            events.remove(time);
            startTimes.remove(time);
        } else {
            System.out.println("No event found at the specified start time.");
        }
    }

    public Event getEvents(LocalTime t) {
        return events.get(t);
    }

    public Event[] getDayEvents() {
        Object[] pq = startTimes.toArray();
        Event[] e = new Event[pq.length];
        for (int i = 0; i < pq.length; i++) {
            e[i] = getEvents((LocalTime)pq[i]);
        }
        return e;
    }
    
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

    public int getDate(){
        return dayNum;
    }

    public Day(int dayNum_){
        this.dayNum=dayNum_;
    }
    public static void main(String[] args) {    
        Day d = new Day(1);
        Event e = new Event(2,"12-03", LocalTime.of(12,0), LocalTime.of(13,0), "Walking", "move to a place");
        Event e2 = new Event(3,"11-09", LocalTime.of(12,10), LocalTime.of(12,20), "Sweeping", "brooming around");

        System.out.println(d.addEvent(e));
        System.out.println(d.addEvent(e2));

        d.printDayEvents();
    }

}