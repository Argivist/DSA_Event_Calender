import java.util.Hashtable;
import java.time.LocalTime;
import java.util.PriorityQueue;

public class Day {
    private int dayNum;
    private Hashtable<Integer, Event> events = new Hashtable<>();
    private PriorityQueue<Integer> ids = new PriorityQueue<>();

    public boolean addEvent(Event e) {
        int id=e.getID();
        
        if (getEvent(id) != null) {
            return false;
        } else {
            ids.add(id);
            
                events.put(id, e);
            //    time = time.plusMinutes(15);
            
            return true;
        }
    }

    public void removeEvent(int id) {
        //int duration=getEvent(time).getDur();
        //int count = duration / 15;

        
            events.remove(id);
            ids.remove(id);
            //time = time.plusMinutes(15);
        
    }

    public Event getEvent(int i) {
        return events.get(i);
    }

    public Event[] getDayEvents() {
        Object[] pq = ids.toArray();
        Event[] e = new Event[pq.length];
        for (int i = 0; i < pq.length; i++) {
            e[i] = getEvent((int)pq[i]);
        }
        return e;
    }
    
    public void printDayEvents(){
        Event[] e=getDayEvents();
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
        Event e = new Event(12,"12-03", LocalTime.of(12,0), "Walking", "move to a place");
        System.out.println(d.addEvent(e));
        System.out.println(d.getEvent(12));
        Event e2 = new Event(2,"11-09", LocalTime.of(1,0), "Sweeping", "brooming around");
        System.out.println(d.addEvent(e2));
        System.out.println(d.getEvent(2));

        d.printDayEvents();
    
    }

}