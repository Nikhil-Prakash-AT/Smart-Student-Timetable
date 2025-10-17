
package service;

import model.Subject;
import java.io.*;
import java.util.*;

public class TimetableManager {
    private List<Subject> subjects = new ArrayList<>();

    public void addSubject(Subject s) {
        for (Subject existing : subjects) {
            if (existing.getDay().equalsIgnoreCase(s.getDay())) {
                if (isTimeOverlap(existing, s)) {
                    System.out.println("❌ Time conflict detected with " + existing.getName());
                    return;
                }
            }
        }
        subjects.add(s);
        System.out.println("✅ Subject added successfully!");
    }

    private boolean isTimeOverlap(Subject s1, Subject s2) {
        return !(s1.getEndTime().compareTo(s2.getStartTime()) <= 0 || s2.getEndTime().compareTo(s1.getStartTime()) <= 0);
    }

    public void viewTimetable(String day) {
        System.out.println("\n📅 Schedule for " + day + ":");
        subjects.stream()
                .filter(s -> s.getDay().equalsIgnoreCase(day))
                .sorted(Comparator.comparing(Subject::getStartTime))
                .forEach(System.out::println);
    }

    public void saveToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Subject s : subjects) {
                bw.write(s.getName() + "," + s.getDay() + "," + s.getStartTime() + "," + s.getEndTime());
                bw.newLine();
            }
            System.out.println("💾 Data saved successfully!");
        } catch (IOException e) {
            System.out.println("⚠️ Error saving file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        subjects.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4)
                    subjects.add(new Subject(data[0], data[1], data[2], data[3]));
            }
            System.out.println("📂 Data loaded successfully!");
        } catch (IOException e) {
            System.out.println("⚠️ No previous data found.");
        }
    }
}
