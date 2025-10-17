📘 Smart Student Timetable App

A simple yet powerful Core Java project that helps students organize their weekly timetable efficiently.
The app allows users to add subjects, check for schedule conflicts, and save their timetable for future use.

🚀 Features

✅ Add new subjects with day and time
✅ Automatically detects time conflicts
✅ View daily schedules (sorted by time)
✅ Save and load timetable from file
✅ Lightweight and fully console-based

🧠 Technologies Used

. Java (Core)
. OOP Principles (Encapsulation, Abstraction)
. File Handling (Read/Write)
. Collections Framework (ArrayList)
. Exception Handling

🗂️ Project Structure

SmartStudentTimetable/
├── src/
│   ├── model/
│   │   └── Subject.java
│   ├── service/
│   │   └── TimetableManager.java
│   └── Main.java
└── data/
    └── timetable.txt

🧩 How to Run

1️⃣ Open terminal in project folder
2️⃣ Compile:

cd src
javac Main.java model/Subject.java service/TimetableManager.java

3️⃣ Run:

java Main

📸 Sample Output

====== SMART STUDENT TIMETABLE ======
1. Add Subject
2. View Timetable (by day)
3. Save & Exit
Choose: 1
Enter subject name: Maths
Enter day (Mon–Sun): Monday
Enter start time (HH:MM): 09:00
Enter end time (HH:MM): 10:00
✅ Subject added successfully!

🧰 Future Enhancements

. Add GUI using Java Swing
. Store data in MySQL database
. Export timetable as PDF
. Integrate notification/reminder feature

👨‍💻 Author

Nikhil Prakash A T
M.Com Student | Java Developer | Tech Enthusiast