package ru.mk.dao;

import ru.mk.models.Group;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO {
    private ConnectionManager connectionManager = ConnectionManager.getInstance();

    public List<Group> getGroupsList() throws SQLException {
        Connection connection = connectionManager.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM groups";
        ResultSet rs = statement.executeQuery(query);
        List<Group> groups = new ArrayList<>();
        while (rs.next()) {
            Group group = new Group();
            long id = rs.getLong("id");
            String groupNumber = rs.getString("groupNumber");
            String groupName= rs.getString("groupName");
            group.setId(id);
            group.setNumber(groupNumber);
            group.setName(groupName);
            groups.add(group);
        }
        rs.close();
        connectionManager.destroy(connection, statement);
        return groups;
    }
}
