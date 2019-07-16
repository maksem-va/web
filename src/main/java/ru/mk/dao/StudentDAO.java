package ru.mk.dao;

import ru.mk.models.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private ConnectionManager connectionManager = ConnectionManager.getInstance();

    public List<Student> getAllStudents() throws SQLException {
        Connection connection = connectionManager.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM students";
        ResultSet rs = statement.executeQuery(query);
        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            long id = rs.getLong("id");
            String firstName = rs.getString("firstName");
            String lastName= rs.getString("lastName");
            String group = rs.getString("groupName");
            student.setId(id);
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setGroup(group);
            students.add(student);
        }
        rs.close();
        connectionManager.destroy(connection, statement);
        return students;
    }
}
