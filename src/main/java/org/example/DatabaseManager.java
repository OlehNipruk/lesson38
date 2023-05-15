package org.example;

import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/robot_homework";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "ITNovizna2023";

    public static void saveStudent(Student student) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getAge());
            statement.executeUpdate();
            System.out.println("Student saved successfully.");
        } catch (SQLException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }

    public static Student getStudentById(int id) {
        Student student = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "SELECT * FROM student WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                student = new Student(id, name, age);
            }
        } catch (SQLException e) {
            System.out.println("Error getting student: " + e.getMessage());
        }
        return student;
    }
}
