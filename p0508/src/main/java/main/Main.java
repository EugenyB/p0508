package main;

import main.dao.StudentDao;
import main.tables.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    // CRUD
    // C - Create
    // R - Read (Retrieve)
    // U - Update
    // D - Delete

    private Connection connection;

    private StudentDao studentDao;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Properties properties = new Properties();
        properties.setProperty("user","student");
        properties.setProperty("password","123");
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/p0508", properties);){
            this.connection = connection;
            studentDao = new StudentDao(connection);
            //            showData();
            //addStudent();
            loop: while (true) {
                switch (menu()) {
                    case 1 : showData(); break;
                    case 2 : addStudent(); break;
                    case 3 : deleteStudent(); break;
                    case 4 : updateStudent(); break;
                    case 0 : break loop;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void updateStudent() throws SQLException {
        System.out.println("name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        try (PreparedStatement ps = connection.prepareStatement("update student set age = ? where name = ?")) {
            ps.setInt(1, age);
            //ps.setString(2, name);
            ps.executeUpdate();
        }
    }

    private void deleteStudent() throws SQLException {
        System.out.println("id:");
        int id = new Scanner(System.in).nextInt();
        PreparedStatement ps = connection.prepareStatement("delete from student where id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }

    private int menu() {
        System.out.println("""
                ------------------
                1. Show data
                2. Add student
                3. Delete student
                4. Update student
                0. Exit
                """);
        return new Scanner(System.in).nextInt();
    }

    private void addStudent() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("name:");
        String name = in.nextLine();
        System.out.println("age:");
        int age = in.nextInt();
        Student s = new Student(0, name, age);
        studentDao.addStudent(s);
    }

    private void showData() throws SQLException {
        List<Student> students = studentDao.getStudentsFromDB();

        for (Student student : students) {
            System.out.println(student);
        }
    }


}
