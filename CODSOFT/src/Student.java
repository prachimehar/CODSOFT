import java.util.HashMap;
import java.util.Scanner;

public class Student {
    int studentId;
    String name;
    int age;
    String grade;
    HashMap<String, Integer> marks;
    double percentage;

    public Student() {
        this.marks = new HashMap<>();
    }

    void accept(Scanner sc) {
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter student ID: ");
        studentId = sc.nextInt();
        System.out.print("Enter age: ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter grade: ");
        grade = sc.nextLine();

        System.out.println("Enter marks for the subjects (enter -1 to stop): ");
        while (true) {
            System.out.print("Enter subject name: ");
            String subject = sc.nextLine();
            if (subject.equalsIgnoreCase("-1")) {
                break;
            }
            System.out.print("Enter marks for " + subject + ": ");
            int mark = sc.nextInt();
            sc.nextLine();
            marks.put(subject, mark);
        }
    }

    void calculatePercentage() {
        int totalMarks = 0;
        for (int mark : marks.values()) {
            totalMarks += mark;
        }
        percentage = (double) totalMarks / marks.size();
    }

    void displayStudentDetails() {
        System.out.println("\n--- Student Details ---\n");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("Marks: ");
        for (String subject : marks.keySet()) {
            System.out.println("  " + subject + ": " + marks.get(subject));
        }
        System.out.printf("Percentage: %.2f%%\n", percentage);
    }

    void editDetails(Scanner sc) {
        System.out.println("\n--- Edit Student Details ---");
        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = sc.nextLine();
        if (!newName.isEmpty()) {
            name = newName;
        }
        System.out.print("Enter new age (enter -1 to keep current): ");
        int newAge = sc.nextInt();
        if (newAge != -1) {
            age = newAge;
        }
        sc.nextLine();
        System.out.print("Enter new grade (leave blank to keep current): ");
        String newGrade = sc.nextLine();
        if (!newGrade.isEmpty()) {
            grade = newGrade;
        }

        System.out.println("Enter marks for the subjects (leave subject name blank to stop): ");
        while (true) {
            System.out.print("Enter subject name to update or add: ");
            String subject = sc.nextLine();
            if (subject.isEmpty()) {
                break;
            }
            System.out.print("Enter marks for " + subject + ": ");
            int mark = sc.nextInt();
            sc.nextLine();
            marks.put(subject, mark);
        }
        calculatePercentage();
    }
}
