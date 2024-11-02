function addCourse() {
    const courseName = document.getElementById("courseName").value;
    const courseId = document.getElementById("courseId").value;

    if (courseName && courseId) {
            fetch('/addCourse', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ courseName: courseName, courseId: courseId })
        });
        loadCourses();
        document.getElementById("courseName").value = ' ';
        document.getElementById("courseId").value = ' ';
    } else {
        alert("Please enter both Course Name and Course ID.");
    }
}
function enrollStudent() {
    const studentName = document.getElementById("studentName").value;
    const studentId = document.getElementById("studentId").value;
    const courseId = document.getElementById("courseSelect").value;

    if (studentName && studentId && courseId) {
            fetch('/enrollStudent', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ studentName: studentName, studentId: studentId, courseId: courseId })
        });

        loadEnrollments();
        document.getElementById("studentName").value = '';
        document.getElementById("studentId").value = '';
    } else {
        alert("Please complete all fields.");
    }
}
function loadCourses() {
    const response =fetch('/getCourses');
    const courses = response.json();

    const courseSelect = document.getElementById("courseSelect");
    const courseList = document.getElementById("courseList");

    courseSelect.innerHTML = '<option value="" disabled selected>Select Course</option>';
    courseList.innerHTML = '';

    courses.forEach(course => {
        const option = document.createElement("option");
        option.value = course.courseId;
        option.textContent = course.courseName;
        courseSelect.appendChild(option);
        const li = document.createElement("li");
        li.textContent = `${course.courseName} (ID: ${course.courseId})`;
        courseList.appendChild(li);
    });
}
function loadEnrollments() {
    const response = fetch('/getEnrollments');
    const enrollments =  response.json();
    const enrollmentList = document.getElementById("enrollmentList");
    enrollmentList.innerHTML = '';
    enrollments.forEach(enrollment => {
        const li = document.createElement("li");
        li.textContent = `${enrollment.studentName} (ID: ${enrollment.studentId}) enrolled in ${enrollment.courseName}`;
        enrollmentList.appendChild(li);
    });
}
// Load courses and enrollments on page load
loadCourses();
loadEnrollments();
