
import model.Subject;
import service.TimetableManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TimetableManager manager = new TimetableManager();
        String filename = "data/timetable.txt";
        manager.loadFromFile(filename);

        while (true) {
            System.out.println("\n====== SMART STUDENT TIMETABLE ======");
            System.out.println("1. Add Subject");
            System.out.println("2. View Timetable (by day)");
            System.out.println("3. Save & Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter subject name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter day (Mon–Sun): ");
                    String day = sc.nextLine();
                    System.out.print("Enter start time (HH:MM): ");
                    String start = sc.nextLine();
                    System.out.print("Enter end time (HH:MM): ");
                    String end = sc.nextLine();
                    manager.addSubject(new Subject(name, day, start, end));
                }
                case 2 -> {
                    System.out.print("Enter day to view: ");
                    String day = sc.nextLine();
                    manager.viewTimetable(day);
                }
                case 3 -> {
                    manager.saveToFile(filename);
                    System.out.println("👋 Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid option.");
            }
        }
    }
}
