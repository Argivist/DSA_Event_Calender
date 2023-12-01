import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        // Create a new calendar for the year 2023
        Calendar calendar = new Calendar(2023);

        // Create some events and add them to the calendar
        Event event1 = new Event("2023-05-15", LocalTime.of(10, 30), "Meeting");
        Event event2 = new Event("2023-06-20", LocalTime.of(14, 0), "Conference");
        Event event3 = new Event("2023-12-05", LocalTime.of(9, 0), "Seminar");

        calendar.addEvent(event1);
        calendar.addEvent(event2);
        calendar.addEvent(event3);

        // Retrieve events and print them
        Event retrievedEvent = calendar.getEvent("2023-05-15", LocalTime.of(10, 30));
        if (retrievedEvent != null) {
            System.out.println("Retrieved Event: " + retrievedEvent.getDescription());
        }

        // Get all events for a specific day and print them
        Event[] allEvents = calendar.getAllEvent("2023-06-20");
        if (allEvents != null) {
            System.out.println("All Events on 2023-06-20:");
            for (Event e : allEvents) {
                System.out.println(e.getDescription());
            }
        }

        // Print all events in each month
        calendar.getAllEvent();
    }
}
