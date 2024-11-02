package enrollment;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentManager {
    private List<Course> courses = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Enrollment> enrollments = new ArrayList<>();

    public void addCourse(Course course) { courses.add(course); }
    public void addStudent(Student student) { students.add(student); }
    public void enrollStudent(Student student, Course course) {
        enrollments.add(new Enrollment(student, course));
    }

    public List<Course> getCourses() { return courses; }
    public List<Student> getStudents() { return students; }
    public List<Enrollment> getEnrollments() { return enrollments; }
}