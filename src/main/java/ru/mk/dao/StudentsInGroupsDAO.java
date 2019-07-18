package ru.mk.dao;

import ru.mk.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsInGroupsDAO {
    private static StudentsInGroupsDAO ourInstance = new StudentsInGroupsDAO();
    private ConnectionManager connectionManager;
    private StudentsInGroupsDAO() {
        connectionManager = ConnectionManager.getInstance();
    }
    public static StudentsInGroupsDAO getInstance() {
        return ourInstance;
    }

    /**
     * Так и не понял как затолкать номер группы в метод
     *
     */

    public List<Student> getStudentByGroup(String groupNumber) throws SQLException {
        Connection connection = connectionManager.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM students JOIN groups ON webproject.students.groupName = groupNumber";
        ResultSet rs = statement.executeQuery(query);
        List<Student> studentsInGroupsList = new ArrayList<>();
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
        }
        rs.close();
        connectionManager.destroy(connection, statement);
        return studentsInGroupsList;
    }
}
