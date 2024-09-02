import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String course;

    public Student(String name, int rollNumber, String course) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
    }

    //function to get name of a student
    public String getName() {
        return name;
    }
    
    //function to get roll number of a student
    public int getRollNumber() {
        return rollNumber;
    }
    
    //function to get course of a student
    public String getCourse() {
        return course;
    }

    //returns a string about the students info
    public String info() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Course: " + course;
    }
}

class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("Students:");
            for (Student student : students) {
                System.out.println(student.info());
            }
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. View Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter course: ");
                    String course = scanner.nextLine();
                    Student newStudent = new Student(name, rollNumber, course);
                    studentManagement.addStudent(newStudent);
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int rollNumberToRemove = scanner.nextInt();
                    studentManagement.removeStudent(rollNumberToRemove);
                    break;

                case 3:
                    studentManagement.viewStudents();
                    break;

                case 4:
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}