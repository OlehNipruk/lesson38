package org.example;
public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "John Smith", 20);
        student.save();
        Student retrievedStudent = Student.getById(1);
        System.out.println("Retrieved student: " + retrievedStudent.getName() + ", " + retrievedStudent.getAge() + " years old.");
    }
}
