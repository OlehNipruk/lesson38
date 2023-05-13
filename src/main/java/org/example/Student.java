package org.example;

import java.sql.*;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void save() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/robot_homework", "root", "ITNovizna2023");
            String query = "INSERT INTO student (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, age);
            statement.executeUpdate();
            conn.close();
            System.out.println("Student saved successfully.");
        } catch (SQLException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }

    public static Student getById(int id) {
        Student student = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/robot_homework", "root", "ITNovizna2023");
            String query = "SELECT * FROM student WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                student = new Student(id, name, age);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error getting student: " + e.getMessage());
        }
        return student;
    }
}