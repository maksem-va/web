package ru.mk.dao;

import ru.mk.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static StudentDAO ourInstance = new StudentDAO();
    private ConnectionManager connectionManager;
    private StudentDAO() {
        connectionManager = ConnectionManager.getInstance();
    }
    public static StudentDAO getInstance() {
        return ourInstance;
    }

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

//    public List<Student> getStudentByGroup(String group) throws SQLException {
//        Connection connection = connectionManager.getConnection();
//        String query = "SELECT * FROM students WHERE groupName = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(query,
//                PreparedStatement.RETURN_GENERATED_KEYS);
//        ResultSet rs = preparedStatement.executeQuery(query);
//        List<Student> students = new ArrayList<>();
//        while (rs.next()) {
//            Student student = new Student();
//            long id = rs.getLong("id");
//            String firstName = rs.getString("firstName");
//            String lastName= rs.getString("lastName");
//            String group = rs.getString("groupName");
//            student.setId(id);
//            student.setFirstName(firstName);
//            student.setLastName(lastName);
//            student.setGroup(group);
//        }
//        rs.close();
//        connectionManager.destroy(connection, preparedStatement);
//        return students;
//    }
}
