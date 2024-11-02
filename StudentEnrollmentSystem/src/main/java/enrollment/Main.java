package enrollment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EnrollmentController controller = new EnrollmentController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options: [1] Add Course [2] Add Student [3] Enroll [4] Display Enrollments [5] Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Course ID: ");
                    String courseId = scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    controller.addCourse(courseId, courseName);
                }
                case 2 -> {
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    controller.addStudent(studentId, studentName);
                }
                case 3 -> {
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Course ID: ");
                    String courseId = scanner.nextLine();
                    controller.enrollStudent(studentId, courseId);
                }
                case 4 -> controller.displayEnrollments();
                case 5 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }
}

