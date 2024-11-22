import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add a new student");
            System.out.println("2. Edit an existing student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Student student = new Student();
                    student.accept(sc);
                    student.calculatePercentage();
                    students.add(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter student ID to edit: ");
                    int editId = sc.nextInt();
                    sc.nextLine(); // Consume the newline
                    boolean foundEdit = false;
                    for (Student s : students) {
                        if (s.studentId == editId) {
                            s.editDetails(sc);
                            System.out.println("Student details updated successfully.");
                            foundEdit = true;
                            break;
                        }
                    }
                    if (!foundEdit) {
                        System.out.println("Student ID not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();
                    boolean foundSearch = false;
                    for (Student s : students) {
                        if (s.studentId == searchId) {
                            s.displayStudentDetails();
                            foundSearch = true;
                            break;
                        }
                    }
                    if (!foundSearch) {
                        System.out.println("Student ID not found.");
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        for (Student s : students) {
                            s.displayStudentDetails();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
