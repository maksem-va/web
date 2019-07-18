package ru.mk.dao;

import ru.mk.models.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO {
    private static GroupDAO ourInstance = new GroupDAO();

    private ConnectionManager connectionManager;

    private GroupDAO() {
        connectionManager = ConnectionManager.getInstance();
    }

    public static GroupDAO getInstance() {
        return ourInstance;
    }


    public Group createGroup(Group group) {
        try {
            Connection connection = connectionManager.getConnection();
            String insert = "INSERT INTO webproject.groups (groupNumber, groupName) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, group.getNumber());
            preparedStatement.setString(2, group.getName());
            int row = preparedStatement.executeUpdate();
            if (row == 0) {
                throw new SQLException("Creating group failed, no rows affected.");
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    group.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating group failed, no ID obtained.");
                }
            }
            connectionManager.destroy(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    public Group getGroup(int groupId) {
        Group group = new Group();
        try {
            Connection connection = connectionManager.getConnection();
            String sql = "SELECT * FROM webproject.groups WHERE groupId = 23531/2";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, groupId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String groupNumber = rs.getString("groupNumber");
                String groupName = rs.getString("groupName");
                group.setId(groupId);
                group.setNumber(groupNumber);
                group.setName(groupName);
            }
            rs.close();
            connectionManager.destroy(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    public Group updateGroup(Group group) {
        try {
            Connection connection = connectionManager.getConnection();
            String update = "UPDATE webproject.groups SET groupNumber = ?, groupName = ? WHERE groupId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(update,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, group.getNumber());
            preparedStatement.setString(2, group.getName());
            int row = preparedStatement.executeUpdate();
            if (row == 0) {
                throw new SQLException("Updating group failed, no rows affected.");
            }
            connectionManager.destroy(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    public Group deleteGroup(Group group) {
        try {
            Connection connection = connectionManager.getConnection();
            String delete = "DELETE FROM webproject.groups WHERE groupId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(delete,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, group.getId());
            int row = preparedStatement.executeUpdate();
            if (row == 0) {
                throw new SQLException("Updating group failed, no rows affected.");
            }
            connectionManager.destroy(connection, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    public List<Group> getAllGroups() {
        List<Group> groups = new ArrayList<>();
        try {
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM webproject.groups";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Group group = new Group();
                int id = rs.getInt("groupId");
                String groupNumber = rs.getString("groupNumber");
                String groupName = rs.getString("groupName");
                group.setId(id);
                group.setNumber(groupNumber);
                group.setName(groupName);
                groups.add(group);
            }
            rs.close();
            connectionManager.destroy(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

}
