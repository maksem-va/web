package ru.mk.dao;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        GroupDAO groupDAO = new GroupDAO();

        try {
            studentDAO.getAllStudents().forEach(System.out::println);
            groupDAO.getGroupsList().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
