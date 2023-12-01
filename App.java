import java.time.LocalTime;
import java.util.Scanner;

public class App {
    /**
     * This method validates the input time.
     * 
     * @return The time in the format of HH:MM.
     */
    public static LocalTime inputTimeValidation(){
        Scanner input = new Scanner(System.in);
        String input_;
        while (true) {
            input_=input.nextLine();
            if(input_.length()==5){
                String[] s = input_.split(":");
                
                try {
                    int hour = Integer.parseInt(s[0]);
                    int min = Integer.parseInt(s[1]);
                    if (hour>=0&&hour<=24&&min>=0&&min<60) {
                        return LocalTime.of(hour, min);
                    }
                }catch (Exception e) {
                    System.out.println("Enter in the format of HH:MM, H-hours and M-minutes should be numbers");
                }
            }
        }

    }

    /**
     * This method validates the input date.
     * 
     * @return The date in the format of MM-DD.
     */
    private static String inputDateValidation() {
        Calender c = new Calender(00);
        Scanner input = new Scanner(System.in);
        String input_;
        while (true) {
            input_ = input.nextLine();
            if (input_.split("-").length == 2) {
                String[] s = input_.split("-");

                try {
                    int month = Integer.parseInt(s[0]);
                    int day = Integer.parseInt(s[1]);
                    if (month <= 12 && month > 0) {
                        if (day > 0 && day < c.num_days[month-1]) {
                            c = null;
                            return input_;
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Enter in the format of MM-DD, M and D should be numbers");
                }

            }
            System.out.println("Enter in the format of MM-DD");

        }
    }

    public static void main(String[] args) {
        Calender calender = new Calender(2023);
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Event Scheduler!");
        System.out.println("Choose from the following options:");
        String quit = "";

        while (!quit.equals("q")) {
            System.out.println("1. Add an event");
            System.out.println("2. Remove an event");
            System.out.println("3. Get events in a month");
            System.out.println("4. Get events in a day");
            System.out.println("5. Get events in a year");
            System.out.println("6. Get a specific event");
            System.out.println("7. Event reminder");
            System.out.println("8. Edit event");
            System.out.println("9. Exit");

            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("Enter the title of the event: ");
                String title = sc.nextLine();
                System.out.println("Enter the description of the event: ");
                String description = sc.nextLine();
                System.out.println("Enter the date of the event(MM-DD): "); 
                String date = inputDateValidation();
                System.out.println("Enter the start time of the event(HH:MM): "); 
                LocalTime startTime = inputTimeValidation();
                System.out.println("Enter the end time of the event(HH:MM): "); 
               LocalTime endTime = inputTimeValidation();

                
                Event e = new Event(date, startTime, endTime, title, description);

                calender.addEvent(e);
            } else if (choice == 2) {
                System.out.println("Enter the date of the event(MM-DD): "); 
                String date = inputDateValidation();
                System.out.println("Enter the start time of the event(HH:MM): ");
                LocalTime startTime = inputTimeValidation();

                calender.removeEvent(date, startTime);
            } else if (choice == 3) {
                System.out.println("Enter the month of the event(MM): "); 
                int month = sc.nextInt();
                calender.getAllEvent(month);
            } else if (choice == 4) {
                System.out.println("Enter the date of the event(MM-DD): "); 
                String date = inputDateValidation();
    
                for (Event i : calender.getAllEvent(date)) {
                    System.out.println(i.toString());
                }
            } else if (choice == 5) {
                calender.getAllEvent();
            } else if (choice == 6) {
                System.out.println("Enter the date of the event(MM-DD): "); 
                String date = inputDateValidation();
                System.out.println("Enter the start time of the event(HH:MM): "); 
                LocalTime startTime = inputTimeValidation();

                Event event = calender.getEvents(date, startTime);
                System.out.println(event.toString());
            } else if (choice == 7){
                System.out.println("What day do you want to get the reminder for? (MM-DD)");
                String date = inputDateValidation();
                System.out.println(calender.Year[Integer.parseInt(date.split("-")[0])-1].getDay(Integer.parseInt(date.split("-")[1])).eventReminder());
            } else if (choice == 8){
                System.out.println("Enter the date of the event(MM-DD): "); 
                String oldDate = inputDateValidation();
                System.out.println("Enter the start time of the event(HH:MM): "); 
                LocalTime oldStartTime = inputTimeValidation();

                Event event = calender.getEvents(oldDate, oldStartTime);
                if (event == null) {
                    System.out.println("No event found at the specified start time.");
                    return;
                }
                System.out.println(event.toString());
                System.out.println("Enter the new title of the event: ");
                String title = sc.nextLine();
                System.out.println("Enter the new description of the event: ");
                String description = sc.nextLine();
                System.out.println("Enter the new date of the event(MM-DD): "); 
                String date_ = inputDateValidation();
                System.out.println("Enter the new start time of the event(HH:MM): "); 
                LocalTime startTime_ = inputTimeValidation();
                System.out.println("Enter the new end time of the event(HH:MM): "); 
                LocalTime endTime_ = inputTimeValidation();

                calender.addEvent(new Event(date_, startTime_, endTime_, title, description));
                calender.removeEvent(oldDate, oldStartTime);
            } else if (choice == 9) {
                System.out.println("Goodbye!");
                quit = "q";
            } else {
                System.out.println("Invalid input. Please try again.");
            }
           
        }

    }
}
