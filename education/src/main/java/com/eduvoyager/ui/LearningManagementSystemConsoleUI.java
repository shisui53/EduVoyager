package com.eduvoyager.ui;

import java.util.Scanner;

import com.eduvoyager.entity.Course;
import com.eduvoyager.entity.Grade;
import com.eduvoyager.entity.User;
import com.eduvoyager.service.AssignmentService;
import com.eduvoyager.service.CourseService;
import com.eduvoyager.service.EnrollmentService;
import com.eduvoyager.service.GradeService;
import com.eduvoyager.service.UserService;

public class LearningManagementSystemConsoleUI {

	private UserService userService; // Inject UserService dependency
	private CourseService courseService; // Inject CourseService dependency
	private EnrollmentService enrollmentService; // Inject EnrollmentService dependency
	private AssignmentService assignmentService; // Inject AssignmentService dependency
	private GradeService gradeService; // Inject GradeService dependency

	private Scanner scanner;

	public LearningManagementSystemConsoleUI() {
		// Initialize services and other components
		setUserService(new UserService());
		setCourseService(new CourseService());
		enrollmentService = new EnrollmentService();
		setAssignmentService(new AssignmentService());
		setGradeService(new GradeService());

		scanner = new Scanner(System.in);

		// Start the main menu loop
		showMainMenu();
	}

	public void showMainMenu() {
		while (true) {
			System.out.println("Main Menu:");
			System.out.println("1. Create User");
			System.out.println("2. Create Course");
			System.out.println("3. Enroll Student in Course");
			System.out.println("4. Create Assignment");
			System.out.println("5. Record Grade");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline character

			switch (choice) {
			case 1:
				createUser();
				break;
			case 2:
				createCourse();
				break;
			case 3:
				enrollStudentInCourse();
				break;
			case 4:
				createAssignment();
				break;
			case 5:
				recordGrade();
				break;
			case 0:
				System.out.println("Exiting the program.");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please select a valid option.");
			}
		}
	}

	public void createUser() {
		// ... (Same as before)

		System.out.print("Enter username: ");
		String username = scanner.nextLine();

		System.out.print("Enter password: ");
		String password = scanner.nextLine();

		System.out.print("Enter role: ");
		String role = scanner.nextLine();

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);

		userService.createUser(user);

		System.out.println("User created successfully!");
	}

	public void createCourse() {
		// ... (Same as before)
	}

	public void enrollStudentInCourse() {
		System.out.print("Enter student ID: ");
		int studentId = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		System.out.print("Enter course ID: ");
		int courseId = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		enrollmentService.enrollStudentInCourse(studentId, courseId);

		System.out.println("Student enrolled in the course!");
	}

	public void createAssignment() {
		// ... (Similar to createCourse)

		System.out.print("Enter course name: ");
		String courseName = scanner.nextLine();

		System.out.print("Enter instructor ID: ");
		int instructorId = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		Course course = new Course();
		course.setCourseName(courseName);
		course.setInstructorId(instructorId);

		courseService.createCourse(course);

		System.out.println("Course created successfully!");
	}

	public void recordGrade() {
		// ... (Similar to enrollStudentInCourse)

		System.out.print("Enter student enrollment ID: ");
		int enrollmentId = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		System.out.print("Enter assignment ID: ");
		int assignmentId = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		System.out.print("Enter grade: ");
		double grade = scanner.nextDouble();
		scanner.nextLine(); // Consume newline character

		Grade gradeObj = new Grade();
		gradeObj.setEnrollment(enrollmentId);
		gradeObj.setAssignment(assignmentId);
		gradeObj.setGrade(grade);

		gradeService.recordGrade(gradeObj);

		System.out.println("Grade recorded successfully!");
	}

	// Other methods for additional menu options

	public static void main(String[] args) {
		new LearningManagementSystemConsoleUI();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public AssignmentService getAssignmentService() {
		return assignmentService;
	}

	public void setAssignmentService(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	public GradeService getGradeService() {
		return gradeService;
	}

	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

}
