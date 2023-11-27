import java.util.Hashtable;
import java.time.LocalTime;
import java.util.PriorityQueue;

public class Day {
    private int dayNum;
    private Hashtable<LocalTime, Event> events = new Hashtable<>();
    private PriorityQueue<LocalTime> startTimes = new PriorityQueue<>();

    public boolean addEvent(LocalTime time, int duration, Event e) {
        int count = duration / 15;

        if (getEvent(time) == null) {
            return false;
        } else {
            startTimes.add(time);
            for (int i = 0; i < count; i++) {
                events.put(time, e);

                time = time.plusMinutes(15);
            }
            return true;
        }
    }

    public void removeEvent(LocalTime time, int duration, Event e) {
        int count = duration / 15;

        for (int i = 0; i < count; i++) {
            events.remove(time);
            startTimes.remove(time);
            time = time.plusMinutes(15);
        }
    }

    public Event getEvent(LocalTime t) {
        return events.get(t);
    }

    public Event[] getDayEvents() {

        LocalTime[] pq = (LocalTime[]) startTimes.toArray();
        Event[] e = new Event[pq.length];
        for (int i = 0; i < pq.length; i++) {
            e[i] = getEvent(pq[i]);
        }
        return e;
    }

    public int getDate(){
        return dayNum;
    }

    public Day(int dayNum_){
        this.dayNum=dayNum_;
    }
    public static void main(String[] args) {
        Hashtable<LocalTime, String> events = new Hashtable<>();

        events.put(LocalTime.of(10, 0), "Wake up");
        events.put(LocalTime.of(10, 15), "Wake up");
        events.put(LocalTime.of(12, 0), "Go to class");

        System.out.println(events.get(LocalTime.of(10, 0)));
    }

}