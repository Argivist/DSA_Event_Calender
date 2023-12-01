import java.time.LocalTime;
public class Month {
    private int num_days;
    private String name;
    private Day[] days;

    /**
     * Sets the name of the month and the number of days in the month.
     * 
     * @param name the name of the month
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the number of days in the month.
     * 
     * @param num_days the number of days in the month
     */
    public void setNumDays(int num_days) {
        this.num_days = num_days;
    }

    /**
     * Sets the day at the given index to the given day.
     * 
     * @param index the index of the day to be set. If today is 21st, the index
     *              entered would be 21.
     *              The program will subtract 1 from the index to match the array
     *              index.
     * @param day   the Day object to assign to the given index
     */
    public void setDay(int index, Day day) {
        days[index - 1] = day;
    }

    /**
     * Returns the day at the given index.
     * 
     * @param index the index of the day to be returned
     * @return the day at the given index
     */
    public Day getDay(int index) {
        return days[index];
    }

    /**
     * Returns the list of all the days.
     * 
     * @return the list containing all the days in the month.
     */
    public Day[] getDays() {
        return days;
    }

    /**
     * Returns the name of the month.
     * 
     * @return the name of the month
     */
    public String getName() {
        return name;
    }

    public void getMonthView(){
        for(Day d:days){
            if(d==null){
                continue;
            }else{
                System.out.println(d.getDate());
                d.printDayEvents();
            }
        }
    }
    /**
     * Returns the number of days in the month.
     * 
     * @return the number of days in the month
     */
    public int getNumDays() {
        return num_days;
    }

    /**
     * Takes the name of the month and the number of days and
     * creates an array with a size matching the number of days.
     * 
     * @param name     the name of the month
     * @param num_days the number of days in the month
     */
    public Month(String name, int num_days) {
        setName(name);
        setNumDays(num_days);
        days = new Day[num_days];
    }

    public void addEvent(Event e){
        int date=Integer.parseInt(e.getDate().split("-")[1]);
        days[date].addEvent(e);
    }
    public static void main(String[] args) {
        Month m = new Month("January", 31);
        Day d = new Day(1);
        Day d1 = new Day(2);
        Event e = new Event(1,"12-03", LocalTime.of(12,0), "Walking", "move to a place");
        Event e1 = new Event(2,"9-11", LocalTime.of(2, 30), "Running", "levitating");
        Event e2 = new Event(3,"3-4", LocalTime.of(3, 30), "Swimming", "swim to a place");
        Event e3 = new Event(4,"4-5", LocalTime.of(4, 30), "Cycling", "cycle to a place");
        Event e4 = new Event(5,"5-6", LocalTime.of(5, 30), "Driving", "drive to a place");
        d.addEvent(e);
        d.addEvent(e1);
        d.addEvent(e2);
        d.addEvent(e3);

        d1.addEvent(e4);
        d1.addEvent(e3);
        d1.addEvent(e2);
        d1.addEvent(e1);

        m.setDay(1, d);
        m.setDay(2, d1);
        m.getMonthView();
        

    }
}