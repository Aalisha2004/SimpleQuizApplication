import java.util.*;

public class StudentCourseRegistrationSystem {
    private static HashMap<String, Course> courseDatabase = new HashMap<>();
    private static HashMap<String, Student> studentDatabase = new HashMap<>();

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;
    int enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }

    public boolean isAvailable() {
        return enrolledStudents < capacity;
    }

    public void enroll() {
        if (isAvailable()) {
            enrolledStudents++;
        }
    }

    public void drop() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        }
    }

    public void displayCourseInfo() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Capacity: " + capacity);
        System.out.println("Schedule: " + schedule);
        System.out.println("Available Slots: " + (capacity - enrolledStudents));
        System.out.println();
    }
}

class Student {
    String studentID;
    String name;
    ArrayList<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (course.isAvailable()) {
            registeredCourses.add(course);
            course.enroll();
            System.out.println("Successfully registered for course: " + course.title);
        } else {
            System.out.println("Course " + course.title + " is full. Registration failed.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.drop();
            System.out.println("Successfully dropped course: " + course.title);
        } else {
            System.out.println("You are not registered for this course.");
        }
    }

    public void displayRegisteredCourses() {
        System.out.println("Courses registered by " + name + ":");
        for (Course course : registeredCourses) {
            System.out.println(course.title + " (" + course.courseCode + ")");
        }
        System.out.println();
    }
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        courseDatabase.put("CS101", new Course("CS101", "Introduction to Computer Science", "Basics of Computer Science", 3, "MWF 9-10 AM"));
        courseDatabase.put("CS102", new Course("CS102", "Data Structures", "Introduction to Data Structures", 2, "TTh 11-12 AM"));
        courseDatabase.put("CS103", new Course("CS103", "Algorithms", "Design and Analysis of Algorithms", 2, "MWF 2-3 PM"));

        studentDatabase.put("1001", new Student("1001", "Alice"));
        studentDatabase.put("1002", new Student("1002", "Bob"));

        while (true) {
            System.out.println("1. List Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");

            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.next();
                    Student student = studentDatabase.get(studentID);
                    if (student != null) {
                        System.out.print("Enter Course Code: ");
                        String courseCode = scanner.next();
                        Course course = courseDatabase.get(courseCode);
                        if (course != null) {
                            student.registerCourse(course);
                        } else {
                            System.out.println("Course not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.next();
                    student = studentDatabase.get(studentID);
                    if (student != null) {
                        System.out.print("Enter Course Code: ");
                        String courseCode = scanner.next();
                        Course course = courseDatabase.get(courseCode);
                        if (course != null) {
                            student.dropCourse(course);
                        } else {
                            System.out.println("Course not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.next();
                    student = studentDatabase.get(studentID);
                    if (student != null) {
                        student.displayRegisteredCourses();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void listCourses() {
        System.out.println("Available Courses:");
        for (Course course : courseDatabase.values()) {
            course.displayCourseInfo();
        }
    }
}