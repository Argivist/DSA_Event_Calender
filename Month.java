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

    public void getMonth(){
        for(Day d:days){
            System.out.println(d.getDate());
            d.printDayEvents();
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
}