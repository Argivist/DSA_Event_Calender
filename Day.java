import java.util.Hashtable;
import java.time.LocalTime;
import java.util.PriorityQueue;

public class Day {
    private int dayNum;
    private Hashtable<LocalTime, Event> events = new Hashtable<>();
    private PriorityQueue<LocalTime> startTimes = new PriorityQueue<>();

    public boolean addEvent(Event e) {
        
        LocalTime time=e.getTime();
        
        if (getEvent(time) != null) {
            return false;
        } else {
            startTimes.add(time);
            
                events.put(time, e);
            //    time = time.plusMinutes(15);
            
            return true;
        }
    }

    public void removeEvent(LocalTime time) {
        //int duration=getEvent(time).getDur();
        //int count = duration / 15;

        
            events.remove(time);
            startTimes.remove(time);
            //time = time.plusMinutes(15);
        
    }

    public Event getEvent(LocalTime t) {
        return events.get(t);
    }

    public Event[] getDayEvents() {
        Object[] pq = startTimes.toArray();
        Event[] e = new Event[pq.length];
        for (int i = 0; i < pq.length; i++) {
            e[i] = getEvent((LocalTime)pq[i]);
        }
        return e;
    }
    
    public void printDayEvents(){
        Event[] e=getDayEvents();
        if(e.length==0){
            return null;
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
        Event e = new Event(2,"12-03", LocalTime.of(12,0), "Walking", "move to a place");
        System.out.println(d.addEvent(e));
        System.out.println(d.getEvent(LocalTime.of(12, 0)));
        Event e2 = new Event(3,"11-09", LocalTime.of(1,0), "Sweeping", "brooming around");
        System.out.println(d.addEvent(e2));
        System.out.println(d.getEvent(LocalTime.of(1, 0)));

        d.printDayEvents();
    
    }

}