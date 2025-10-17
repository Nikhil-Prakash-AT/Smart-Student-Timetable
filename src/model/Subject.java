package model;

public class Subject {
    private String name;
    private String day;
    private String startTime;
    private String endTime;

    public Subject(String name, String day, String startTime, String endTime) {
        this.name = name;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() { return name; }
    public String getDay() { return day; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }

    @Override
    public String toString() {
        return name + " | " + day + " | " + startTime + " - " + endTime;
    }
}
