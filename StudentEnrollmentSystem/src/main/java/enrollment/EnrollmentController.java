package enrollment;

public class EnrollmentController {
    private EnrollmentManager enrollmentManager = new EnrollmentManager();

    public void addCourse(String courseId, String courseName) {
        Course course = new Course(courseId, courseName);
        enrollmentManager.addCourse(course);
    }

    public void addStudent(String studentId, String studentName) {
        Student student = new Student(studentId, studentName);
        enrollmentManager.addStudent(student);
    }

    public void enrollStudent(String studentId, String courseId) {
        Student student = enrollmentManager.getStudents().stream()
            .filter(s -> s.getStudentId().equals(studentId)).findFirst().orElse(null);
        Course course = enrollmentManager.getCourses().stream()
            .filter(c -> c.getCourseId().equals(courseId)).findFirst().orElse(null);

        if (student != null && course != null) {
            enrollmentManager.enrollStudent(student, course);
        } else {
            System.out.println("Invalid student or course ID.");
        }
    }

    public void displayEnrollments() {
        for (Enrollment enrollment : enrollmentManager.getEnrollments()) {
            System.out.println("Student: " + enrollment.getStudent().getStudentName() + 
                               " enrolled in Course: " + enrollment.getCourse().getCourseName());
        }
    }
}
