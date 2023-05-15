package org.example;
public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "John Smith", 20);
        DatabaseManager.saveStudent(student);
        Student retrievedStudent = DatabaseManager.getStudentById(1);
        if (retrievedStudent != null) {
            System.out.println("Retrieved student: " + retrievedStudent.getName() + ", " + retrievedStudent.getAge() + " years old.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
