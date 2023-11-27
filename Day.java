import java.util.Hashtable;
import java.sql.Time;
import java.time.LocalTime;

public class Day {
    private int dayNum;
    private Hashtable<LocalTime, Event> events = new Hashtable<>();

    public void addEvent(Time t, int duration, Event e) {
        int count = duration / 15;
        LocalTime time = t.toLocalTime();

        for (int i = 0; i < count; i++) {
            events.put(time, e);
            time = time.plusMinutes(15);
        }
    }

    public void removeEvent(Time t, int duration, Event e) {
        int count = duration / 15;
        LocalTime time = t.toLocalTime();

        for (int i = 0; i < count; i++) {
            events.remove(time, e);
            time = time.plusMinutes(15);
        }
    }

    public static void main(String[] args) {
        Hashtable<LocalTime, String> events = new Hashtable<>();
        
        events.put(LocalTime.of(10, 0), "Wake up");
        events.put(LocalTime.of(10, 15), "Wake up");
        events.put(LocalTime.of(12, 0), "Go to class");

        System.out.println(events.get(LocalTime.of(10, 0)));
    }

}