import java.util.*;

public class SchoolManagementSystem {

    static class Student {
        String name;
        int rollNo;
        String grade;

        public Student(String name, int rollNo, String grade) {
            this.name = name;
            this.rollNo = rollNo;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", rollNo=" + rollNo +
                    ", grade='" + grade + '\'' +
                    '}';
        }
    }

    static class Teacher {
        String name;
        String subject;

        public Teacher(String name, String subject) {
            this.name = name;
            this.subject = subject;
        }

        @Override
        public String toString() {
            return "Teacher{" +
                    "name='" + name + '\'' +
                    ", subject='" + subject + '\'' +
                    '}';
        }
    }

    static class Course {
        String courseName;
        String teacherName;

        public Course(String courseName, String teacherName) {
            this.courseName = courseName;
            this.teacherName = teacherName;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "courseName='" + courseName + '\'' +
                    ", teacherName='" + teacherName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        while (true) {
            System.out.println("\nSchool Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Add Course");
            System.out.println("4. View Students");
            System.out.println("5. View Teachers");
            System.out.println("6. View Courses");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student roll number: ");
                    int rollNo = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    students.add(new Student(studentName, rollNo, grade));
                    break;
                case 2:
                    System.out.print("Enter teacher name: ");
                    String teacherName = scanner.nextLine();
                    System.out.print("Enter teacher subject: ");
                    String subject = scanner.nextLine();
                    teachers.add(new Teacher(teacherName, subject));
                    break;
                case 3:
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter teacher name for this course: ");
                    String courseTeacher = scanner.nextLine();
                    courses.add(new Course(courseName, courseTeacher));
                    break;
                case 4:
                    System.out.println("List of Students:");
                    students.forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("List of Teachers:");
                    teachers.forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("List of Courses:");
                    courses.forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}