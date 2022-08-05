package main.dao;

import main.tables.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private Connection connection;

    public StudentDao(Connection connection) {
        this.connection = connection;
    }

    public List<Student> getStudentsFromDB() throws SQLException {
        List<Student> students = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement("select * from student");
            ResultSet resultSet = ps.executeQuery();
        ) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                students.add(new Student(id, name, age));
            }
        }
        return students;
    }

    public void addStudent(Student s) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into student (name, age) values (? , ?)");
        ps.setString(1, s.getName());
        ps.setInt(2, s.getAge());
        ps.executeUpdate();
        ps.close();
    }
}
